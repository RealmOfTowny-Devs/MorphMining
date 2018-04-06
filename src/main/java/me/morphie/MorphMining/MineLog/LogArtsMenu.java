package me.morphie.MorphMining.MineLog;

import org.bukkit.event.*;
import me.morphie.MorphMining.*;
import org.bukkit.entity.*;
import net.md_5.bungee.api.*;
import org.bukkit.*;
import org.bukkit.ChatColor;
import org.bukkit.enchantments.*;
import java.util.*;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.*;

public class LogArtsMenu implements Listener
{
    private Main plugin;
    
    public LogArtsMenu(final Main plugin) {
        this.plugin = plugin;
    }
    
    public void openGUIArtsLog(final Player player) {
        final Inventory ArtsLog = Bukkit.createInventory((InventoryHolder)null, 36, new StringBuilder().append(ChatColor.DARK_RED).append(ChatColor.BOLD).append("Miner's Log").append(ChatColor.DARK_GRAY).append(":").append(ChatColor.RED).append(" Artifacts").toString());
        final ItemStack Common = new ItemStack(Material.GOLD_NUGGET);
        final ItemMeta CommonMeta = Common.getItemMeta();
        CommonMeta.addEnchant(Enchantment.DURABILITY, 1, true);
        CommonMeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
        final ArrayList<String> Commonlore = new ArrayList<String>();
        Commonlore.add(" ");
        Commonlore.add(ChatColor.RED + "Found In" + ChatColor.DARK_GRAY + ":" + ChatColor.GRAY + " COAL ORE");
        Commonlore.add(ChatColor.RED + "Drop Chance" + ChatColor.DARK_GRAY + ":" + ChatColor.GRAY + " 20%");
        Commonlore.add(ChatColor.RED + "Sell Price" + ChatColor.DARK_GRAY + ":" + ChatColor.GRAY + " $50");
        CommonMeta.setDisplayName(new StringBuilder().append(ChatColor.GRAY).append(ChatColor.BOLD).append("Common Artifact").toString());
        CommonMeta.setLore((List)Commonlore);
        Common.setItemMeta(CommonMeta);
        ArtsLog.setItem(10, Common);
        final ItemStack Rare = new ItemStack(Material.GOLD_NUGGET);
        final ItemMeta RareMeta = Rare.getItemMeta();
        RareMeta.addEnchant(Enchantment.DURABILITY, 1, true);
        RareMeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
        final ArrayList<String> Rarelore = new ArrayList<String>();
        Rarelore.add(" ");
        Rarelore.add(ChatColor.RED + "Found In" + ChatColor.DARK_GRAY + ":" + ChatColor.GRAY + " REDSTONE ORE");
        Rarelore.add(ChatColor.RED + "Drop Chance" + ChatColor.DARK_GRAY + ":" + ChatColor.GRAY + " 15%");
        Rarelore.add(ChatColor.RED + "Sell Price" + ChatColor.DARK_GRAY + ":" + ChatColor.GRAY + " $250");
        RareMeta.setDisplayName(new StringBuilder().append(ChatColor.AQUA).append(ChatColor.BOLD).append("Rare Artifact").toString());
        RareMeta.setLore((List)Rarelore);
        Rare.setItemMeta(RareMeta);
        ArtsLog.setItem(12, Rare);
        final ItemStack Legend = new ItemStack(Material.GOLD_NUGGET);
        final ItemMeta LegendMeta = Legend.getItemMeta();
        LegendMeta.addEnchant(Enchantment.DURABILITY, 1, true);
        LegendMeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
        final ArrayList<String> Legendlore = new ArrayList<String>();
        Legendlore.add(" ");
        Legendlore.add(ChatColor.RED + "Found In" + ChatColor.DARK_GRAY + ":" + ChatColor.GRAY + " LAPIS ORE");
        Legendlore.add(ChatColor.RED + "Drop Chance" + ChatColor.DARK_GRAY + ":" + ChatColor.GRAY + " 5%");
        Legendlore.add(ChatColor.RED + "Sell Price" + ChatColor.DARK_GRAY + ":" + ChatColor.GRAY + " $750");
        LegendMeta.setDisplayName(new StringBuilder().append(ChatColor.GOLD).append(ChatColor.BOLD).append("Legendary Artifact").toString());
        LegendMeta.setLore((List)Legendlore);
        Legend.setItemMeta(LegendMeta);
        ArtsLog.setItem(14, Legend);
        final ItemStack Mythic = new ItemStack(Material.GOLD_NUGGET);
        final ItemMeta MythicMeta = Mythic.getItemMeta();
        MythicMeta.addEnchant(Enchantment.DURABILITY, 1, true);
        MythicMeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
        final ArrayList<String> Mythiclore = new ArrayList<String>();
        Mythiclore.add(" ");
        Mythiclore.add(ChatColor.RED + "Found In" + ChatColor.DARK_GRAY + ":" + ChatColor.GRAY + " DIAMOND ORE, EMERALD ORE");
        Mythiclore.add(ChatColor.RED + "Drop Chance" + ChatColor.DARK_GRAY + ":" + ChatColor.GRAY + " 3%");
        Mythiclore.add(ChatColor.RED + "Sell Price" + ChatColor.DARK_GRAY + ":" + ChatColor.GRAY + " $2500");
        MythicMeta.setDisplayName(new StringBuilder().append(ChatColor.DARK_PURPLE).append(ChatColor.BOLD).append("Mythic Artifact").toString());
        MythicMeta.setLore((List)Mythiclore);
        Mythic.setItemMeta(MythicMeta);
        ArtsLog.setItem(16, Mythic);
        final ItemStack Info = new ItemStack(Material.BOOK);
        final ItemMeta InfoMeta = Info.getItemMeta();
        final ArrayList<String> Infolore = new ArrayList<String>();
        Infolore.add(ChatColor.GRAY + "Hover over an artifact to");
        Infolore.add(ChatColor.GRAY + "view all of its information!");
        InfoMeta.setDisplayName(new StringBuilder().append(ChatColor.RED).append(ChatColor.BOLD).append("Information").toString());
        InfoMeta.setLore((List)Infolore);
        Info.setItemMeta(InfoMeta);
        ArtsLog.setItem(30, Info);
        final ItemStack Back = new ItemStack(Material.ARROW);
        final ItemMeta BackMeta = Back.getItemMeta();
        final ArrayList<String> Backlore = new ArrayList<String>();
        Backlore.add(ChatColor.GRAY + "Click to go back!");
        BackMeta.setLore((List)Backlore);
        BackMeta.setDisplayName(new StringBuilder().append(ChatColor.RED).append(ChatColor.BOLD).append("Back").toString());
        Back.setItemMeta(BackMeta);
        ArtsLog.setItem(32, Back);
        final ItemStack redGlass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14);
        final ItemMeta redGlassMeta = redGlass.getItemMeta();
        final ArrayList<String> redGlasslore = new ArrayList<String>();
        redGlasslore.add(" ");
        redGlassMeta.setDisplayName(" ");
        redGlass.setItemMeta(redGlassMeta);
        ArtsLog.setItem(0, redGlass);
        ArtsLog.setItem(8, redGlass);
        ArtsLog.setItem(27, redGlass);
        ArtsLog.setItem(35, redGlass);
        for (int x = 0; x < 36; ++x) {
            if (x != 0 && x != 8 && x != 27 && x != 35 && x != 32 && x != 30 && x != 16 && x != 14 && x != 12 && x != 10) {
                final ItemStack glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)15);
                final ItemMeta glassMeta = glass.getItemMeta();
                glassMeta.setDisplayName(" ");
                glass.setItemMeta(glassMeta);
                ArtsLog.setItem(x, glass);
            }
        }
        player.openInventory(ArtsLog);
    }
}
