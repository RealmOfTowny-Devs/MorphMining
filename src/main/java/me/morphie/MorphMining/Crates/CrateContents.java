package me.morphie.MorphMining.Crates;

import org.bukkit.event.*;
import me.morphie.MorphMining.*;
import org.bukkit.entity.*;
import org.bukkit.*;
import org.bukkit.ChatColor;
import org.bukkit.enchantments.*;
import java.util.*;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.*;

public class CrateContents implements Listener
{
    private Main plugin;
    
    public CrateContents(final Main plugin) {
        this.plugin = plugin;
    }
    
    public void openGUIRocks(final Player player) {
        final Inventory CrateRocks = Bukkit.createInventory((InventoryHolder)null, 9, new StringBuilder().append(ChatColor.GRAY).append(ChatColor.BOLD).append("Pile Of Rocks").append(ChatColor.DARK_GRAY).append(":").append(ChatColor.DARK_RED).append(" Possible Winnings!").toString());
        final ItemStack Common = new ItemStack(Material.GOLD_NUGGET, 3);
        final ItemMeta CommonMeta = Common.getItemMeta();
        CommonMeta.addEnchant(Enchantment.DURABILITY, 1, true);
        CommonMeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
        CommonMeta.setDisplayName(new StringBuilder().append(ChatColor.GRAY).append(ChatColor.BOLD).append("Common Artifact").toString());
        final ArrayList<String> CommonLore = new ArrayList<String>();
        CommonLore.add("");
        CommonLore.add(ChatColor.DARK_RED + "BMCMines");
        CommonLore.add(new StringBuilder().append(ChatColor.RED).append(ChatColor.ITALIC).append("Right click to open the mining market!").toString());
        CommonMeta.setLore((List)CommonLore);
        Common.setItemMeta(CommonMeta);
        final ItemStack Rare = new ItemStack(Material.GOLD_NUGGET, 1);
        final ItemMeta RareMeta = Rare.getItemMeta();
        RareMeta.addEnchant(Enchantment.DURABILITY, 1, true);
        RareMeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
        RareMeta.setDisplayName(new StringBuilder().append(ChatColor.AQUA).append(ChatColor.BOLD).append("Rare Artifact").toString());
        final ArrayList<String> RareLore = new ArrayList<String>();
        RareLore.add("");
        RareLore.add(ChatColor.DARK_RED + "BMCMines");
        RareLore.add(new StringBuilder().append(ChatColor.RED).append(ChatColor.ITALIC).append("Right click to open the mining market!").toString());
        RareMeta.setLore((List)RareLore);
        Rare.setItemMeta(RareMeta);
        final ItemStack Coal = new ItemStack(Material.COAL_BLOCK, 4);
        final ItemStack Redstone = new ItemStack(Material.REDSTONE_BLOCK, 4);
        final ItemStack Lapis = new ItemStack(Material.LAPIS_BLOCK, 2);
        final ItemStack Andesite = new ItemStack(Material.STONE, 16, (short)5);
        CrateRocks.setItem(0, Common);
        CrateRocks.setItem(1, Rare);
        CrateRocks.setItem(2, Coal);
        CrateRocks.setItem(3, Redstone);
        CrateRocks.setItem(4, Lapis);
        CrateRocks.setItem(5, Andesite);
        player.openInventory(CrateRocks);
    }
    
    public void openGUIIron(final Player player) {
        final Inventory CrateIron = Bukkit.createInventory((InventoryHolder)null, 9, new StringBuilder().append(ChatColor.YELLOW).append(ChatColor.BOLD).append("Ironed Out").append(ChatColor.DARK_GRAY).append(":").append(ChatColor.DARK_RED).append(" Possible Winnings!").toString());
        final ItemStack Rare = new ItemStack(Material.GOLD_NUGGET, 3);
        final ItemMeta RareMeta = Rare.getItemMeta();
        RareMeta.addEnchant(Enchantment.DURABILITY, 1, true);
        RareMeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
        RareMeta.setDisplayName(new StringBuilder().append(ChatColor.AQUA).append(ChatColor.BOLD).append("Rare Artifact").toString());
        final ArrayList<String> RareLore = new ArrayList<String>();
        RareLore.add("");
        RareLore.add(ChatColor.DARK_RED + "BMCMines");
        RareLore.add(new StringBuilder().append(ChatColor.RED).append(ChatColor.ITALIC).append("Right click to open the mining market!").toString());
        RareMeta.setLore((List)RareLore);
        Rare.setItemMeta(RareMeta);
        final ItemStack Legendary = new ItemStack(Material.GOLD_NUGGET);
        final ItemMeta LegendaryMeta = Legendary.getItemMeta();
        LegendaryMeta.addEnchant(Enchantment.DURABILITY, 1, true);
        LegendaryMeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
        LegendaryMeta.setDisplayName(new StringBuilder().append(ChatColor.GOLD).append(ChatColor.BOLD).append("Legendary Artifact").toString());
        final ArrayList<String> LegendaryLore = new ArrayList<String>();
        LegendaryLore.add("");
        LegendaryLore.add(ChatColor.DARK_RED + "BMCMines");
        LegendaryLore.add(new StringBuilder().append(ChatColor.RED).append(ChatColor.ITALIC).append("Right click to open the mining market!").toString());
        LegendaryMeta.setLore((List)LegendaryLore);
        Legendary.setItemMeta(LegendaryMeta);
        final ItemStack unBook = new ItemStack(Material.ENCHANTED_BOOK);
        final ItemMeta unBookMeta = unBook.getItemMeta();
        unBookMeta.addEnchant(Enchantment.DURABILITY, 3, true);
        unBook.setItemMeta(unBookMeta);
        final ItemStack Iron = new ItemStack(Material.IRON_BLOCK, 2);
        final ItemStack Gold = new ItemStack(Material.GOLD_BLOCK, 2);
        final ItemStack Quartz = new ItemStack(Material.QUARTZ_ORE, 6);
        final ItemStack Shulker = new ItemStack(Material.RED_SHULKER_BOX);
        CrateIron.setItem(0, Rare);
        CrateIron.setItem(1, Legendary);
        CrateIron.setItem(2, unBook);
        CrateIron.setItem(3, Iron);
        CrateIron.setItem(4, Gold);
        CrateIron.setItem(5, Quartz);
        CrateIron.setItem(6, Shulker);
        player.openInventory(CrateIron);
    }
    
    public void openGUIDream(final Player player) {
        final Inventory CrateDream = Bukkit.createInventory((InventoryHolder)null, 9, new StringBuilder().append(ChatColor.DARK_RED).append(ChatColor.BOLD).append("A Miner's Dream").append(ChatColor.DARK_GRAY).append(":").append(ChatColor.DARK_RED).append(" Possible Winnings!").toString());
        final ItemStack Legendary = new ItemStack(Material.GOLD_NUGGET, 3);
        final ItemMeta LegendaryMeta = Legendary.getItemMeta();
        LegendaryMeta.addEnchant(Enchantment.DURABILITY, 1, true);
        LegendaryMeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
        LegendaryMeta.setDisplayName(new StringBuilder().append(ChatColor.GOLD).append(ChatColor.BOLD).append("Legendary Artifact").toString());
        final ArrayList<String> LegendaryLore = new ArrayList<String>();
        LegendaryLore.add("");
        LegendaryLore.add(ChatColor.DARK_RED + "BMCMines");
        LegendaryLore.add(new StringBuilder().append(ChatColor.RED).append(ChatColor.ITALIC).append("Right click to open the mining market!").toString());
        LegendaryMeta.setLore((List)LegendaryLore);
        Legendary.setItemMeta(LegendaryMeta);
        final ItemStack Mythic = new ItemStack(Material.GOLD_NUGGET);
        final ItemMeta MythicMeta = Mythic.getItemMeta();
        MythicMeta.addEnchant(Enchantment.DURABILITY, 1, true);
        MythicMeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
        MythicMeta.setDisplayName(new StringBuilder().append(ChatColor.DARK_PURPLE).append(ChatColor.BOLD).append("Mythic Artifact").toString());
        final ArrayList<String> MythicLore = new ArrayList<String>();
        MythicLore.add("");
        MythicLore.add(ChatColor.DARK_RED + "BMCMines");
        MythicLore.add(new StringBuilder().append(ChatColor.RED).append(ChatColor.ITALIC).append("Right click to open the mining market!").toString());
        MythicMeta.setLore((List)MythicLore);
        Mythic.setItemMeta(MythicMeta);
        final ItemStack mendBook = new ItemStack(Material.ENCHANTED_BOOK);
        final ItemMeta mendBookMeta = mendBook.getItemMeta();
        mendBookMeta.addEnchant(Enchantment.MENDING, 1, true);
        mendBook.setItemMeta(mendBookMeta);
        final ItemStack effBook = new ItemStack(Material.ENCHANTED_BOOK);
        final ItemMeta effBookMeta = effBook.getItemMeta();
        effBookMeta.addEnchant(Enchantment.DIG_SPEED, 5, true);
        effBook.setItemMeta(effBookMeta);
        final ItemStack Diamond = new ItemStack(Material.DIAMOND_BLOCK, 1);
        final ItemStack Emerald = new ItemStack(Material.EMERALD_BLOCK, 2);
        final ItemStack Beacon = new ItemStack(Material.BEACON, 1);
        CrateDream.setItem(0, Legendary);
        CrateDream.setItem(1, Mythic);
        CrateDream.setItem(2, mendBook);
        CrateDream.setItem(3, effBook);
        CrateDream.setItem(4, Diamond);
        CrateDream.setItem(5, Emerald);
        CrateDream.setItem(6, Beacon);
        player.openInventory(CrateDream);
    }
}
