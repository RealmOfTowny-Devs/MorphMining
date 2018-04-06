package me.morphie.MorphMining.Items;

import org.bukkit.event.*;
import me.morphie.MorphMining.*;
import org.bukkit.*;
import org.bukkit.ChatColor;
import org.bukkit.enchantments.*;
import org.bukkit.inventory.*;
import net.md_5.bungee.api.*;
import java.util.*;
import org.bukkit.inventory.meta.*;

public class Artifacts implements Listener
{
    private Main plugin;
    
    public Artifacts(final Main plugin) {
        this.plugin = plugin;
    }
    
    public static ItemStack Arts(final String s, final Integer i) {
        if (s.equals("CommonArt")) {
            final ItemStack Common = new ItemStack(Material.GOLD_NUGGET, (int)i);
            final ItemMeta CommonMeta = Common.getItemMeta();
            CommonMeta.addEnchant(Enchantment.DURABILITY, 1, true);
            CommonMeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
            CommonMeta.setDisplayName(new StringBuilder().append(ChatColor.GRAY).append(ChatColor.BOLD).append("Common Artifact").toString());
            final ArrayList<String> CommonLore = new ArrayList<String>();
            CommonLore.add("");
            CommonLore.add(ChatColor.DARK_RED + "MorphMining");
            CommonLore.add(ChatColor.GRAY + "Right-Click to open miner's shop!");
            CommonMeta.setLore((List)CommonLore);
            Common.setItemMeta(CommonMeta);
            return Common;
        }
        if (s.equals("RareArt")) {
            final ItemStack Rare = new ItemStack(Material.GOLD_NUGGET, (int)i);
            final ItemMeta RareMeta = Rare.getItemMeta();
            RareMeta.addEnchant(Enchantment.DURABILITY, 1, true);
            RareMeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
            RareMeta.setDisplayName(new StringBuilder().append(ChatColor.AQUA).append(ChatColor.BOLD).append("Rare Artifact").toString());
            final ArrayList<String> RareLore = new ArrayList<String>();
            RareLore.add("");
            RareLore.add(ChatColor.DARK_RED + "MorphMining");
            RareLore.add(ChatColor.GRAY + "Right-Click to open miner's shop!");
            RareMeta.setLore((List)RareLore);
            Rare.setItemMeta(RareMeta);
            return Rare;
        }
        if (s.equals("LegendaryArt")) {
            final ItemStack Legendary = new ItemStack(Material.GOLD_NUGGET, (int)i);
            final ItemMeta LegendaryMeta = Legendary.getItemMeta();
            LegendaryMeta.addEnchant(Enchantment.DURABILITY, 1, true);
            LegendaryMeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
            LegendaryMeta.setDisplayName(new StringBuilder().append(ChatColor.GOLD).append(ChatColor.BOLD).append("Legendary Artifact").toString());
            final ArrayList<String> LegendaryLore = new ArrayList<String>();
            LegendaryLore.add("");
            LegendaryLore.add(ChatColor.DARK_RED + "MorphMining");
            LegendaryLore.add(ChatColor.GRAY + "Right-Click to open miner's shop!");
            LegendaryMeta.setLore((List)LegendaryLore);
            Legendary.setItemMeta(LegendaryMeta);
            return Legendary;
        }
        if (s.equals("MythicArt")) {
            final ItemStack Mythic = new ItemStack(Material.GOLD_NUGGET, (int)i);
            final ItemMeta MythicMeta = Mythic.getItemMeta();
            MythicMeta.addEnchant(Enchantment.DURABILITY, 1, true);
            MythicMeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
            MythicMeta.setDisplayName(new StringBuilder().append(ChatColor.DARK_PURPLE).append(ChatColor.BOLD).append("Mythic Artifact").toString());
            final ArrayList<String> MythicLore = new ArrayList<String>();
            MythicLore.add("");
            MythicLore.add(ChatColor.DARK_RED + "MorphMining");
            MythicLore.add(ChatColor.GRAY + "Right-Click to open miner's shop!");
            MythicMeta.setLore((List)MythicLore);
            Mythic.setItemMeta(MythicMeta);
            return Mythic;
        }
        return null;
    }
}
