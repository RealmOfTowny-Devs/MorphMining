package me.morphie.MorphMining;

import org.bukkit.event.inventory.*;
import net.md_5.bungee.api.*;
import org.bukkit.entity.*;
import me.morphie.MorphMining.Archivist.*;
import me.morphie.MorphMining.Shop.*;
import me.morphie.MorphMining.MineLog.*;
import org.bukkit.event.*;
import org.bukkit.*;
import org.bukkit.ChatColor;

import java.util.*;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.*;

public class Station implements Listener
{
    private Main plugin;
    
    public Station(final Main plugin) {
        this.plugin = plugin;
    }
    
    @EventHandler
    public void onInventoryClick(final InventoryClickEvent event) {
        if (ChatColor.stripColor(event.getInventory().getName()).equalsIgnoreCase("Mining Station")) {
            final Player player = (Player)event.getWhoClicked();
            if (event.getCurrentItem() == null || !event.getCurrentItem().hasItemMeta()) {
                return;
            }
            switch (event.getCurrentItem().getType()) {
                case HOPPER: {
                    player.closeInventory();
                    new Archivist(this.plugin).openGUIArch(player);
                    break;
                }
                case BEACON: {
                    player.closeInventory();
                    new Shop(this.plugin).openGUIShop(player);
                    break;
                }
                case BOOK_AND_QUILL: {
                    player.closeInventory();
                    new LogMenu(this.plugin).openGUIMineLog(player);
                    break;
                }
                case PAPER: {
                    event.setCancelled(true);
                    break;
                }
            }
            if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(" ")) {
                event.setCancelled(true);
            }
        }
    }
    
    public void openGUIMining(final Player player) {
        final Inventory Menu = Bukkit.createInventory((InventoryHolder)null, 54, new StringBuilder().append(ChatColor.DARK_RED).append(ChatColor.BOLD).append("Mining Station").toString());
        final ItemStack credits = new ItemStack(Material.PAPER);
        final ItemMeta creditsMeta = credits.getItemMeta();
        final ArrayList<String> creditslore = new ArrayList<String>();
        creditslore.add(ChatColor.DARK_RED + "Version" + ChatColor.DARK_GRAY + ": " + ChatColor.GRAY + this.plugin.getDescription().getVersion());
        creditslore.add("");
        creditslore.add(ChatColor.RED + "Code Contributors" + ChatColor.DARK_GRAY + ":");
        creditslore.add(ChatColor.DARK_GRAY + "-" + ChatColor.GRAY + " Morphie");
        creditslore.add(ChatColor.DARK_GRAY + "-" + ChatColor.GRAY + " Atasu");
        creditslore.add("");
        creditslore.add(ChatColor.RED + "Bug Testers" + ChatColor.DARK_GRAY + ":");
        creditslore.add(ChatColor.DARK_GRAY + "-" + ChatColor.GRAY + " NotoriousRogue");
        creditslore.add(ChatColor.DARK_GRAY + "-" + ChatColor.GRAY + " xoStace");
        creditsMeta.setLore((List)creditslore);
        creditsMeta.setDisplayName(new StringBuilder().append(ChatColor.DARK_RED).append(ChatColor.BOLD).append("Credits").toString());
        credits.setItemMeta(creditsMeta);
        final ItemStack arch = new ItemStack(Material.HOPPER);
        final ItemMeta archMeta = arch.getItemMeta();
        final ArrayList<String> archlore = new ArrayList<String>();
        archlore.add("");
        archlore.add(ChatColor.GRAY + "Mining Master!");
        archlore.add("");
        archlore.add(ChatColor.GRAY + "The archivist analyzes");
        archlore.add(ChatColor.GRAY + "crates and relics!");
        archMeta.setLore((List)archlore);
        archMeta.setDisplayName(new StringBuilder().append(ChatColor.DARK_RED).append(ChatColor.BOLD).append("The Archivist").toString());
        arch.setItemMeta(archMeta);
        final ItemStack shop = new ItemStack(Material.BEACON);
        final ItemMeta shopMeta = shop.getItemMeta();
        final ArrayList<String> shoplore = new ArrayList<String>();
        shoplore.add("");
        shoplore.add(ChatColor.GRAY + "Buy and sell all");
        shoplore.add(ChatColor.GRAY + "your mining goods!");
        shopMeta.setLore((List)shoplore);
        shopMeta.setDisplayName(new StringBuilder().append(ChatColor.DARK_RED).append(ChatColor.BOLD).append("Miner's Shop").toString());
        shop.setItemMeta(shopMeta);
        final ItemStack log = new ItemStack(Material.BOOK_AND_QUILL);
        final ItemMeta logMeta = log.getItemMeta();
        final ArrayList<String> loglore = new ArrayList<String>();
        loglore.add("");
        loglore.add(ChatColor.GRAY + "What's an artifact?");
        loglore.add("");
        loglore.add(ChatColor.GRAY + "Information about artifacts,");
        loglore.add(ChatColor.GRAY + "relics, and more!");
        logMeta.setLore((List)loglore);
        logMeta.setDisplayName(new StringBuilder().append(ChatColor.DARK_RED).append(ChatColor.BOLD).append("Miner's Log").toString());
        log.setItemMeta(logMeta);
        final ItemStack redGlass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14);
        final ItemMeta redGlassMeta = redGlass.getItemMeta();
        final ArrayList<String> redGlasslore = new ArrayList<String>();
        redGlasslore.add(" ");
        redGlassMeta.setDisplayName(" ");
        redGlass.setItemMeta(redGlassMeta);
        for (int glass = 0; glass < 54; ++glass) {
            if (glass != 3 && glass != 4 && glass != 5 && glass != 12 && glass != 14 && glass != 18 && glass != 19 && glass != 20 && glass != 21 && glass != 22 && glass != 23 && glass != 24 && glass != 25 && glass != 26 && glass != 13 && glass != 27 && glass != 28 && glass != 29 && glass != 33 && glass != 34 && glass != 35 && glass != 36 && glass != 37 && glass != 38 && glass != 40 && glass != 42 && glass != 43 && glass != 44) {
                final ItemStack Glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)15);
                final ItemMeta GlassMeta = Glass.getItemMeta();
                GlassMeta.setDisplayName(" ");
                Glass.setItemMeta(GlassMeta);
                Menu.setItem(glass, Glass);
            }
        }
        Menu.setItem(3, redGlass);
        Menu.setItem(4, redGlass);
        Menu.setItem(5, redGlass);
        Menu.setItem(12, redGlass);
        Menu.setItem(14, redGlass);
        Menu.setItem(18, redGlass);
        Menu.setItem(19, redGlass);
        Menu.setItem(20, redGlass);
        Menu.setItem(21, redGlass);
        Menu.setItem(22, redGlass);
        Menu.setItem(23, redGlass);
        Menu.setItem(24, redGlass);
        Menu.setItem(25, redGlass);
        Menu.setItem(26, redGlass);
        Menu.setItem(27, redGlass);
        Menu.setItem(29, redGlass);
        Menu.setItem(33, redGlass);
        Menu.setItem(35, redGlass);
        Menu.setItem(36, redGlass);
        Menu.setItem(37, redGlass);
        Menu.setItem(38, redGlass);
        Menu.setItem(42, redGlass);
        Menu.setItem(43, redGlass);
        Menu.setItem(44, redGlass);
        Menu.setItem(13, arch);
        Menu.setItem(28, shop);
        Menu.setItem(34, log);
        Menu.setItem(40, credits);
        player.openInventory(Menu);
    }
}
