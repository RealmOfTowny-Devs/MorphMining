package me.morphie.MorphMining;

import org.bukkit.plugin.java.*;
import org.bukkit.event.*;

import java.util.logging.*;
import net.milkbowl.vault.economy.*;
import net.milkbowl.vault.permission.*;
import me.ryanhamshire.GriefPrevention.*;
import com.sk89q.worldguard.bukkit.*;
import me.morphie.MorphMining.Archivist.*;
import me.morphie.MorphMining.Crates.*;
import me.morphie.MorphMining.MineLog.*;
import me.morphie.MorphMining.Shop.*;
import java.io.*;
import org.bukkit.plugin.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;
import org.bukkit.ChatColor;

public class Main extends JavaPlugin implements Listener
{
    public static Logger log;
    public static Economy econ;
    public static Permission perms;
    public static GriefPrevention griefpreventionPlugin;
    public static WorldGuardPlugin worldguardPlugin;
    private Archivist arch;
    private CratesMenu crates;
    private CrateEvents crateevents;
    private CrateRewards craterewards;
    private Dev dev;
    private LogEvents logevents;
    private LogMenu logmenu;
    private Mining mining;
    private Shop shop;
    private ShopEvents shopevents;
    private Station station;
    
    static {
        Main.log = Logger.getLogger("Minecraft");
        Main.econ = null;
        Main.perms = null;
        Main.griefpreventionPlugin = null;
        Main.worldguardPlugin = null;
    }
    
    public void onEnable() {
        this.setupPluginDependencies();
        this.arch = new Archivist(this);
        this.crates = new CratesMenu(this);
        this.crateevents = new CrateEvents(this);
        this.craterewards = new CrateRewards(this);
        this.dev = new Dev(this);
        this.logevents = new LogEvents(this);
        this.logmenu = new LogMenu(this);
        this.mining = new Mining(this);
        this.shop = new Shop(this);
        this.shopevents = new ShopEvents(this);
        this.station = new Station(this);
        this.getServer().getConsoleSender().sendMessage(ChatColor.DARK_RED + "MorphMining" + ChatColor.DARK_GRAY + " >> " + ChatColor.GREEN + "Plugin Enabled");
        this.getServer().getPluginManager().registerEvents((Listener)this, (Plugin)this);
        this.getServer().getPluginManager().registerEvents((Listener)this.arch, (Plugin)this);
        this.getServer().getPluginManager().registerEvents((Listener)this.crates, (Plugin)this);
        this.getServer().getPluginManager().registerEvents((Listener)this.craterewards, (Plugin)this);
        this.getServer().getPluginManager().registerEvents((Listener)this.crateevents, (Plugin)this);
        this.getServer().getPluginManager().registerEvents((Listener)this.logevents, (Plugin)this);
        this.getServer().getPluginManager().registerEvents((Listener)this.logmenu, (Plugin)this);
        this.getServer().getPluginManager().registerEvents((Listener)this.dev, (Plugin)this);
        this.getServer().getPluginManager().registerEvents((Listener)this.mining, (Plugin)this);
        this.getServer().getPluginManager().registerEvents((Listener)this.shopevents, (Plugin)this);
        this.getServer().getPluginManager().registerEvents((Listener)this.station, (Plugin)this);
        this.createConfig();
        if (!this.setupEconomy()) {
            this.getLogger().severe(String.format("[%s] - Disabled due to no Vault dependency found!", this.getDescription().getName()));
            this.getServer().getPluginManager().disablePlugin((Plugin)this);
            return;
        }
        this.setupPermissions();
    }
    
    public void onDisable() {
        this.getServer().getConsoleSender().sendMessage(ChatColor.DARK_RED + "MorphMining" + ChatColor.DARK_GRAY + " >> " + ChatColor.RED + "Plugin Disabled");
    }
    
    private void createConfig() {
        try {
            if (!this.getDataFolder().exists()) {
                this.getDataFolder().mkdirs();
            }
            final File file = new File(this.getDataFolder(), "config.yml");
            if (!file.exists()) {
                this.getLogger().info("Config.yml not found, creating!");
                this.getConfig().options().copyDefaults(true);
                this.saveDefaultConfig();
            }
            else {
                this.getLogger().info("Config.yml found, loading!");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private boolean setupEconomy() {
        if (this.getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        final RegisteredServiceProvider<Economy> rsp = (RegisteredServiceProvider<Economy>)this.getServer().getServicesManager().getRegistration((Class)Economy.class);
        if (rsp == null) {
            return false;
        }
        Main.econ = (Economy)rsp.getProvider();
        return Main.econ != null;
    }
    
    private boolean setupPermissions() {
        final RegisteredServiceProvider<Permission> rsp = (RegisteredServiceProvider<Permission>)this.getServer().getServicesManager().getRegistration((Class)Permission.class);
        Main.perms = (Permission)rsp.getProvider();
        return Main.perms != null;
    }
    
    private void setupPluginDependencies() {
        try {
            this.setupWorldGuard();
        }
        catch (Exception e) {
            Main.log.warning("[MorphMining] Failed to load WorldGuard");
            e.printStackTrace();
        }
        try {
            this.setupGriefPrevention();
        }
        catch (Exception e) {
            Main.log.warning("[MorphMining] Failed to load GriefPrevention");
            e.printStackTrace();
        }
    }
    
    private void setupGriefPrevention() {
        final Plugin gp = this.getServer().getPluginManager().getPlugin("GriefPrevention");
        if (gp == null) {
            Main.log.info("[MorphMining] Couldn't hook into GriefPrevention, not depending!");
        }
        else {
            Main.griefpreventionPlugin = (GriefPrevention)gp;
            Main.log.info("[MorphMining] Hooked into GriefPrevention!");
        }
    }
    
    private void setupWorldGuard() {
        final Plugin wg = this.getServer().getPluginManager().getPlugin("WorldGuard");
        if (wg == null) {
            Main.log.info("[MorphMining] Couldn't hook into WorldGuard, not depending!");
        }
        else {
            Main.worldguardPlugin = (WorldGuardPlugin)wg;
            Main.log.info("[MorphMining] Hooked into WorldGuard!");
        }
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (cmd.getName().equalsIgnoreCase("mine")) {
            if (args.length == 0) {
                sender.sendMessage("");
                sender.sendMessage(new StringBuilder().append(ChatColor.DARK_GRAY).append(ChatColor.STRIKETHROUGH).append("]--------+").append(ChatColor.RESET).append(ChatColor.DARK_GRAY).append("[ ").append(ChatColor.DARK_RED).append(ChatColor.ITALIC).append("Morph Mining").append(ChatColor.DARK_GRAY).append(" ]").append(ChatColor.DARK_GRAY).append(ChatColor.STRIKETHROUGH).append("+--------[").toString());
                sender.sendMessage("");
                sender.sendMessage(ChatColor.RED + "/mine" + ChatColor.DARK_GRAY + " - " + ChatColor.GRAY + "To open this menu.");
                sender.sendMessage(ChatColor.RED + "/mine menu" + ChatColor.DARK_GRAY + " - " + ChatColor.GRAY + "To open the miners station.");
                sender.sendMessage(ChatColor.RED + "/mine shop" + ChatColor.DARK_GRAY + " - " + ChatColor.GRAY + "To open the mining shop.");
                sender.sendMessage(ChatColor.RED + "/mine log" + ChatColor.DARK_GRAY + " - " + ChatColor.GRAY + "To open the miners log.");
                if (Main.perms.has(sender, "morphmining.admin")) {
                    sender.sendMessage(ChatColor.RED + "/mine dev" + ChatColor.DARK_GRAY + " - " + ChatColor.GRAY + "To open the admin menu! (Perms Required)");
                    sender.sendMessage(ChatColor.RED + "/mine reload" + ChatColor.DARK_GRAY + " - " + ChatColor.GRAY + "To open the admin menu! (Perms Required)");
                }
                sender.sendMessage("");
                sender.sendMessage(new StringBuilder().append(ChatColor.DARK_GRAY).append(ChatColor.STRIKETHROUGH).append("]-------------+").append(ChatColor.RESET).append(ChatColor.DARK_GRAY).append("[").append(ChatColor.DARK_RED).append(ChatColor.BOLD).append("!").append(ChatColor.DARK_GRAY).append("]").append(ChatColor.DARK_GRAY).append(ChatColor.STRIKETHROUGH).append("+-------------[").toString());
                sender.sendMessage("");
                return true;
            }
            if (args[0].equalsIgnoreCase("menu")) {
                final Player player = (Player)sender;
                this.station.openGUIMining(player);
                return true;
            }
            if (args[0].equalsIgnoreCase("log")) {
                final Player player = (Player)sender;
                this.logmenu.openGUIMineLog(player);
                return true;
            }
            if (args[0].equalsIgnoreCase("shop")) {
                final Player player = (Player)sender;
                this.shop.openGUIShop(player);
                return true;
            }
            if (args[0].equalsIgnoreCase("crates")) {
                final Player player = (Player)sender;
                this.crates.openGUICrate(player);
                return true;
            }
            if (args[0].equalsIgnoreCase("dev")) {
                final Player player = (Player)sender;
                if (Main.perms.has(player, "morphmining.dev") || Main.perms.has(player, "morphmining.admin")) {
                    this.dev.openGUIDev(player);
                    return true;
                }
                player.sendMessage(new StringBuilder().append(ChatColor.DARK_GRAY).append(ChatColor.BOLD).append("[").append(ChatColor.RED).append(ChatColor.BOLD).append("!").append(ChatColor.DARK_GRAY).append(ChatColor.BOLD).append("]").append(ChatColor.RED).append(ChatColor.ITALIC).append(" You don't have permission to access this!").toString());
                return true;
            }
            else {
                if (!args[0].equalsIgnoreCase("reload")) {
                    sender.sendMessage(new StringBuilder().append(ChatColor.DARK_GRAY).append(ChatColor.BOLD).append("[").append(ChatColor.RED).append(ChatColor.BOLD).append("!").append(ChatColor.DARK_GRAY).append(ChatColor.BOLD).append("]").append(ChatColor.RED).append(" Invaild argument! Use /mine to view all commands.").toString());
                    return true;
                }
                if (!Main.perms.has(sender, "morphmining.reload") && !Main.perms.has(sender, "morphmining.admin")) {
                    sender.sendMessage(new StringBuilder().append(ChatColor.DARK_GRAY).append(ChatColor.BOLD).append("[").append(ChatColor.RED).append(ChatColor.BOLD).append("!").append(ChatColor.DARK_GRAY).append(ChatColor.BOLD).append("]").append(ChatColor.RED).append(ChatColor.ITALIC).append(" You don't have permission to do this!").toString());
                    return true;
                }
                final Plugin plugin = Bukkit.getServer().getPluginManager().getPlugin("MorphMining");
                if (plugin != null) {
                    this.reloadConfig();
                    sender.sendMessage(new StringBuilder().append(ChatColor.DARK_RED).append(ChatColor.BOLD).append("Mining").append(ChatColor.DARK_GRAY).append(ChatColor.BOLD).append(" >> ").append(ChatColor.GRAY).append("MorphMining has been successfully reloaded!").toString());
                    return true;
                }
            }
        }
        return false;
    }
}
