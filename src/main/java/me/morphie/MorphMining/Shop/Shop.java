package me.morphie.MorphMining.Shop;

import org.bukkit.event.*;
import me.morphie.MorphMining.*;
import org.bukkit.entity.*;
import net.md_5.bungee.api.*;
import org.bukkit.*;
import org.bukkit.ChatColor;

import java.util.*;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.*;

public class Shop implements Listener
{
    private Main plugin;
    
    public Shop(final Main plugin) {
        this.plugin = plugin;
    }
    
    public void openGUIShop(final Player player) {
        final Inventory Shop = Bukkit.createInventory((InventoryHolder)null, 54, new StringBuilder().append(ChatColor.DARK_RED).append(ChatColor.BOLD).append("Mining Shop").toString());
        final ItemStack Info = new ItemStack(Material.BOOK);
        final ItemMeta InfoMeta = Info.getItemMeta();
        final ArrayList<String> Infolore = new ArrayList<String>();
        Infolore.add(ChatColor.GRAY + "Drop loot in then close!");
        InfoMeta.setLore((List)Infolore);
        InfoMeta.setDisplayName(new StringBuilder().append(ChatColor.RED).append(ChatColor.BOLD).append("Information").toString());
        Info.setItemMeta(InfoMeta);
        Shop.setItem(48, Info);
        final ItemStack Back = new ItemStack(Material.ARROW);
        final ItemMeta BackMeta = Back.getItemMeta();
        final ArrayList<String> Backlore = new ArrayList<String>();
        Backlore.add(ChatColor.GRAY + "Click to go back!");
        BackMeta.setLore((List)Backlore);
        BackMeta.setDisplayName(new StringBuilder().append(ChatColor.RED).append(ChatColor.BOLD).append("Back").toString());
        Back.setItemMeta(BackMeta);
        Shop.setItem(50, Back);
        final ItemStack Prices = new ItemStack(Material.PAPER);
        final ItemMeta PricesMeta = Prices.getItemMeta();
        final ArrayList<String> Priceslore = new ArrayList<String>();
        Priceslore.add(" ");
        Priceslore.add(ChatColor.RED + "Common" + ChatColor.DARK_GRAY + ": " + ChatColor.GRAY + this.plugin.getConfig().getDouble("ArtifactPrice.Common"));
        Priceslore.add(ChatColor.RED + "Rare" + ChatColor.DARK_GRAY + ": " + ChatColor.GRAY + this.plugin.getConfig().getDouble("ArtifactPrice.Rare"));
        Priceslore.add(ChatColor.RED + "Legendary" + ChatColor.DARK_GRAY + ": " + ChatColor.GRAY + this.plugin.getConfig().getDouble("ArtifactPrice.Legendary"));
        Priceslore.add(ChatColor.RED + "Mythic" + ChatColor.DARK_GRAY + ": " + ChatColor.GRAY + this.plugin.getConfig().getDouble("ArtifactPrice.Mythic"));
        PricesMeta.setLore((List)Priceslore);
        PricesMeta.setDisplayName(new StringBuilder().append(ChatColor.DARK_RED).append(ChatColor.BOLD).append("Prices").append(ChatColor.DARK_GRAY).append(":").toString());
        Prices.setItemMeta(PricesMeta);
        Shop.setItem(4, Prices);
        for (int x = 0; x < 54; ++x) {
            if (x != 48 && x != 50 && (x < 10 || x >= 17) && (x < 19 || x >= 26) && (x < 28 || x >= 35) && (x < 37 || x >= 44) && x != 4) {
                final ItemStack glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)15);
                final ItemMeta glassMeta = glass.getItemMeta();
                glassMeta.setDisplayName(" ");
                glass.setItemMeta(glassMeta);
                Shop.setItem(x, glass);
            }
        }
        player.openInventory(Shop);
    }
}
