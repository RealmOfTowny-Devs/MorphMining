package me.morphie.MorphMining.Items;

import org.bukkit.event.*;
import me.morphie.MorphMining.*;
import org.bukkit.inventory.*;
import org.bukkit.*;
import org.bukkit.ChatColor;

import net.md_5.bungee.api.*;
import java.util.*;
import org.bukkit.inventory.meta.*;

public class Crates implements Listener
{
    private Main plugin;
    
    public Crates(final Main plugin) {
        this.plugin = plugin;
    }
    
    public static ItemStack Crate(final String s, final Integer i) {
        if (s.equals("RockCrate")) {
            final ItemStack Rock = new ItemStack(Material.PISTON_BASE, (int)i);
            final ItemMeta RockMeta = Rock.getItemMeta();
            RockMeta.setDisplayName(new StringBuilder().append(ChatColor.GRAY).append(ChatColor.BOLD).append("Pile Of Rocks").toString());
            final ArrayList<String> RockLore = new ArrayList<String>();
            RockLore.add("");
            RockLore.add(ChatColor.DARK_RED + "MorphMining");
            RockLore.add(ChatColor.GRAY + "Right-Click to open analyzation menu!");
            RockLore.add(ChatColor.GRAY + "Left-Click to view possible winnings!");
            RockMeta.setLore((List)RockLore);
            Rock.setItemMeta(RockMeta);
            return Rock;
        }
        if (s.equals("IronCrate")) {
            final ItemStack Iron = new ItemStack(Material.PISTON_BASE, (int)i);
            final ItemMeta IronMeta = Iron.getItemMeta();
            IronMeta.setDisplayName(new StringBuilder().append(ChatColor.YELLOW).append(ChatColor.BOLD).append("Ironed Out").toString());
            final ArrayList<String> IronLore = new ArrayList<String>();
            IronLore.add("");
            IronLore.add(ChatColor.DARK_RED + "MorphMining");
            IronLore.add(ChatColor.GRAY + "Right-Click to open analyzation menu!");
            IronLore.add(ChatColor.GRAY + "Left-Click to view possible winnings!");
            IronMeta.setLore((List)IronLore);
            Iron.setItemMeta(IronMeta);
            return Iron;
        }
        if (s.equals("DreamCrate")) {
            final ItemStack Dream = new ItemStack(Material.PISTON_BASE, (int)i);
            final ItemMeta DreamMeta = Dream.getItemMeta();
            DreamMeta.setDisplayName(new StringBuilder().append(ChatColor.DARK_PURPLE).append(ChatColor.BOLD).append("Miner's Dream").toString());
            final ArrayList<String> DreamLore = new ArrayList<String>();
            DreamLore.add("");
            DreamLore.add(ChatColor.DARK_RED + "MorphMining");
            DreamLore.add(ChatColor.GRAY + "Right-Click to open analyzation menu!");
            DreamLore.add(ChatColor.GRAY + "Left-Click to view possible winnings!");
            DreamMeta.setLore((List)DreamLore);
            Dream.setItemMeta(DreamMeta);
            return Dream;
        }
        return null;
    }
}
