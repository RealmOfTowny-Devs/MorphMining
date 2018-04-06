package me.morphie.MorphMining.Crates;

import org.bukkit.event.*;
import me.morphie.MorphMining.*;
import org.bukkit.entity.*;
import net.md_5.bungee.api.*;
import org.bukkit.*;
import org.bukkit.ChatColor;

import java.util.*;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.*;

public class CratesMenu implements Listener
{
    private Main plugin;
    
    public CratesMenu(final Main plugin) {
        this.plugin = plugin;
    }
    
    public void openGUICrate(final Player player) {
        final Inventory Crate = Bukkit.createInventory((InventoryHolder)null, 54, new StringBuilder().append(ChatColor.DARK_RED).append(ChatColor.BOLD).append("Crate Analyzer").toString());
        final ItemStack Info = new ItemStack(Material.BOOK);
        final ItemMeta InfoMeta = Info.getItemMeta();
        final ArrayList<String> Infolore = new ArrayList<String>();
        Infolore.add(ChatColor.GRAY + "Drop loot in then close!");
        InfoMeta.setLore((List)Infolore);
        InfoMeta.setDisplayName(new StringBuilder().append(ChatColor.RED).append(ChatColor.BOLD).append("Information").toString());
        Info.setItemMeta(InfoMeta);
        Crate.setItem(48, Info);
        final ItemStack Back = new ItemStack(Material.ARROW);
        final ItemMeta BackMeta = Back.getItemMeta();
        final ArrayList<String> Backlore = new ArrayList<String>();
        Backlore.add(ChatColor.GRAY + "Click to go back!");
        BackMeta.setLore((List)Backlore);
        BackMeta.setDisplayName(new StringBuilder().append(ChatColor.RED).append(ChatColor.BOLD).append("Back").toString());
        Back.setItemMeta(BackMeta);
        Crate.setItem(50, Back);
        final ItemStack Type = new ItemStack(Material.PAPER);
        final ItemMeta TypeMeta = Type.getItemMeta();
        final ArrayList<String> Typelore = new ArrayList<String>();
        Typelore.add(" ");
        Typelore.add(ChatColor.RED + "Pile Of Rocks" + ChatColor.DARK_GRAY + ": " + ChatColor.GRAY + this.plugin.getConfig().getDouble("CrateOpenCost.PileOfRocks"));
        Typelore.add(ChatColor.RED + "Ironed Out" + ChatColor.DARK_GRAY + ": " + ChatColor.GRAY + this.plugin.getConfig().getDouble("CrateOpenCost.IronedOut"));
        Typelore.add(ChatColor.RED + "Miner's Dream" + ChatColor.DARK_GRAY + ": " + ChatColor.GRAY + this.plugin.getConfig().getDouble("CrateOpenCost.MinersDream"));
        TypeMeta.setLore((List)Typelore);
        TypeMeta.setDisplayName(new StringBuilder().append(ChatColor.DARK_RED).append(ChatColor.BOLD).append("Crate Types & Costs To Open!").append(ChatColor.DARK_GRAY).append(":").toString());
        Type.setItemMeta(TypeMeta);
        Crate.setItem(4, Type);
        final ItemStack redGlass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14);
        final ItemMeta redGlassMeta = redGlass.getItemMeta();
        final ArrayList<String> redGlasslore = new ArrayList<String>();
        redGlasslore.add(" ");
        redGlassMeta.setDisplayName(" ");
        redGlass.setItemMeta(redGlassMeta);
        Crate.setItem(0, redGlass);
        Crate.setItem(8, redGlass);
        Crate.setItem(10, redGlass);
        Crate.setItem(11, redGlass);
        Crate.setItem(12, redGlass);
        Crate.setItem(14, redGlass);
        Crate.setItem(15, redGlass);
        Crate.setItem(16, redGlass);
        Crate.setItem(19, redGlass);
        Crate.setItem(21, redGlass);
        Crate.setItem(22, redGlass);
        Crate.setItem(23, redGlass);
        Crate.setItem(25, redGlass);
        Crate.setItem(28, redGlass);
        Crate.setItem(29, redGlass);
        Crate.setItem(30, redGlass);
        Crate.setItem(32, redGlass);
        Crate.setItem(33, redGlass);
        Crate.setItem(34, redGlass);
        Crate.setItem(39, redGlass);
        Crate.setItem(40, redGlass);
        Crate.setItem(41, redGlass);
        Crate.setItem(45, redGlass);
        Crate.setItem(53, redGlass);
        for (int x = 0; x < 54; ++x) {
            if (x != 0 && x != 4 && x != 8 && x != 45 && x != 48 && x != 50 && x != 53 && (x < 10 || x >= 13) && (x < 14 || x >= 17) && (x < 19 || x >= 26) && (x < 28 || x >= 35) && (x < 39 || x >= 42)) {
                final ItemStack glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)15);
                final ItemMeta glassMeta = glass.getItemMeta();
                glassMeta.setDisplayName(" ");
                glass.setItemMeta(glassMeta);
                Crate.setItem(x, glass);
            }
        }
        player.openInventory(Crate);
    }
}
