package me.morphie.MorphMining.MineLog;

import org.bukkit.event.*;
import me.morphie.MorphMining.*;
import org.bukkit.entity.*;
import org.bukkit.*;
import org.bukkit.ChatColor;

import java.util.*;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.*;

public class LogCrateMenu implements Listener
{
    private Main plugin;
    
    public LogCrateMenu(final Main plugin) {
        this.plugin = plugin;
    }
    
    public void openGUICrateLog(final Player player) {
        final Inventory CratesLog = Bukkit.createInventory((InventoryHolder)null, 36, new StringBuilder().append(ChatColor.DARK_RED).append(ChatColor.BOLD).append("Miner's Log").append(ChatColor.DARK_GRAY).append(":").append(ChatColor.RED).append(" Crates").toString());
        final ItemStack Rock = new ItemStack(Material.PISTON_BASE);
        final ItemMeta RockMeta = Rock.getItemMeta();
        final ArrayList<String> Rocklore = new ArrayList<String>();
        Rocklore.add(" ");
        Rocklore.add(ChatColor.RED + "Found In" + ChatColor.DARK_GRAY + ":" + ChatColor.GRAY + " COAL ORE, REDSTONE ORE");
        Rocklore.add(ChatColor.RED + "Drop Chance" + ChatColor.DARK_GRAY + ":" + ChatColor.GRAY + " 15%");
        Rocklore.add(ChatColor.RED + "Open Cost" + ChatColor.DARK_GRAY + ":" + ChatColor.GRAY + " $10");
        RockMeta.setDisplayName(new StringBuilder().append(ChatColor.GRAY).append(ChatColor.BOLD).append("Pile Of Rocks").toString());
        RockMeta.setLore((List)Rocklore);
        Rock.setItemMeta(RockMeta);
        CratesLog.setItem(11, Rock);
        final ItemStack Iron = new ItemStack(Material.PISTON_BASE);
        final ItemMeta IronMeta = Iron.getItemMeta();
        final ArrayList<String> Ironlore = new ArrayList<String>();
        Ironlore.add(" ");
        Ironlore.add(ChatColor.RED + "Found In" + ChatColor.DARK_GRAY + ":" + ChatColor.GRAY + " LAPIS ORE");
        Ironlore.add(ChatColor.RED + "Drop Chance" + ChatColor.DARK_GRAY + ":" + ChatColor.GRAY + " 10%");
        Ironlore.add(ChatColor.RED + "Open Cost" + ChatColor.DARK_GRAY + ":" + ChatColor.GRAY + " $20");
        IronMeta.setDisplayName(new StringBuilder().append(ChatColor.YELLOW).append(ChatColor.BOLD).append("Ironed Out").toString());
        IronMeta.setLore((List)Ironlore);
        Iron.setItemMeta(IronMeta);
        CratesLog.setItem(13, Iron);
        final ItemStack Dream = new ItemStack(Material.PISTON_BASE);
        final ItemMeta DreamMeta = Dream.getItemMeta();
        final ArrayList<String> Dreamlore = new ArrayList<String>();
        Dreamlore.add(" ");
        Dreamlore.add(ChatColor.RED + "Found In" + ChatColor.DARK_GRAY + ":" + ChatColor.GRAY + " DIAMOND ORE, EMERALD ORE");
        Dreamlore.add(ChatColor.RED + "Drop Chance" + ChatColor.DARK_GRAY + ":" + ChatColor.GRAY + " 7%");
        Dreamlore.add(ChatColor.RED + "Open Cost" + ChatColor.DARK_GRAY + ":" + ChatColor.GRAY + " $30");
        DreamMeta.setDisplayName(new StringBuilder().append(ChatColor.DARK_PURPLE).append(ChatColor.BOLD).append("Miner's Dream").toString());
        DreamMeta.setLore((List)Dreamlore);
        Dream.setItemMeta(DreamMeta);
        CratesLog.setItem(15, Dream);
        final ItemStack Info = new ItemStack(Material.BOOK);
        final ItemMeta InfoMeta = Info.getItemMeta();
        final ArrayList<String> Infolore = new ArrayList<String>();
        Infolore.add(ChatColor.GRAY + "Hover over a crate to");
        Infolore.add(ChatColor.GRAY + "view all of its information!");
        InfoMeta.setDisplayName(new StringBuilder().append(ChatColor.RED).append(ChatColor.BOLD).append("Information").toString());
        InfoMeta.setLore((List)Infolore);
        Info.setItemMeta(InfoMeta);
        CratesLog.setItem(30, Info);
        final ItemStack Back = new ItemStack(Material.ARROW);
        final ItemMeta BackMeta = Back.getItemMeta();
        final ArrayList<String> Backlore = new ArrayList<String>();
        Backlore.add(ChatColor.GRAY + "Click to go back!");
        BackMeta.setLore((List)Backlore);
        BackMeta.setDisplayName(new StringBuilder().append(ChatColor.RED).append(ChatColor.BOLD).append("Back").toString());
        Back.setItemMeta(BackMeta);
        CratesLog.setItem(32, Back);
        final ItemStack redGlass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14);
        final ItemMeta redGlassMeta = redGlass.getItemMeta();
        final ArrayList<String> redGlasslore = new ArrayList<String>();
        redGlasslore.add(" ");
        redGlassMeta.setDisplayName(" ");
        redGlass.setItemMeta(redGlassMeta);
        CratesLog.setItem(0, redGlass);
        CratesLog.setItem(8, redGlass);
        CratesLog.setItem(27, redGlass);
        CratesLog.setItem(35, redGlass);
        for (int x = 0; x < 36; ++x) {
            if (x != 0 && x != 8 && x != 27 && x != 35 && x != 32 && x != 30 && x != 11 && x != 13 && x != 15) {
                final ItemStack glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)15);
                final ItemMeta glassMeta = glass.getItemMeta();
                glassMeta.setDisplayName(" ");
                glass.setItemMeta(glassMeta);
                CratesLog.setItem(x, glass);
            }
        }
        player.openInventory(CratesLog);
    }
}
