package me.morphie.MorphMining;

import org.bukkit.entity.*;
import me.morphie.MorphMining.Items.*;
import org.bukkit.event.inventory.*;
import net.md_5.bungee.api.*;
import org.bukkit.event.*;
import org.bukkit.*;
import org.bukkit.ChatColor;

import java.util.*;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.*;

public class Dev implements Listener
{
    private Main plugin;
    
    public Dev(final Main plugin) {
        this.plugin = plugin;
    }
    
    public void giveArtifacts(final Player player, final String s) {
        if (s.equals("common")) {
            player.getInventory().addItem(new ItemStack[] { Artifacts.Arts("CommonArt", 1) });
        }
        else if (s.equals("rare")) {
            player.getInventory().addItem(new ItemStack[] { Artifacts.Arts("RareArt", 1) });
        }
        else if (s.equals("legendary")) {
            player.getInventory().addItem(new ItemStack[] { Artifacts.Arts("LegendaryArt", 1) });
        }
        else if (s.equals("mythic")) {
            player.getInventory().addItem(new ItemStack[] { Artifacts.Arts("MythicArt", 1) });
        }
    }
    
    public void giveCrates(final Player player, final String s) {
        if (s.equals("rock")) {
            player.getInventory().addItem(new ItemStack[] { Crates.Crate("RockCrate", 1) });
        }
        else if (s.equals("iron")) {
            player.getInventory().addItem(new ItemStack[] { Crates.Crate("IronCrate", 1) });
        }
        else if (s.equals("dream")) {
            player.getInventory().addItem(new ItemStack[] { Crates.Crate("DreamCrate", 1) });
        }
    }
    
    @EventHandler
    public void onInventoryClick(final InventoryClickEvent event) {
        if (ChatColor.stripColor(event.getInventory().getName()).equalsIgnoreCase("Mining Dev Menu")) {
            final Player player = (Player)event.getWhoClicked();
            if (event.getCurrentItem() == null || !event.getCurrentItem().hasItemMeta()) {
                return;
            }
            switch (event.getCurrentItem().getType()) {
                case GOLD_NUGGET: {
                    this.giveArtifacts(player, "common");
                    this.giveArtifacts(player, "rare");
                    this.giveArtifacts(player, "legendary");
                    this.giveArtifacts(player, "mythic");
                    event.setCancelled(true);
                    break;
                }
                case PISTON_BASE: {
                    this.giveCrates(player, "rock");
                    this.giveCrates(player, "iron");
                    this.giveCrates(player, "dream");
                    event.setCancelled(true);
                    break;
                }
            }
            if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(" ")) {
                event.setCancelled(true);
            }
        }
    }
    
    public void openGUIDev(final Player player) {
        final Inventory Dev = Bukkit.createInventory((InventoryHolder)null, 27, new StringBuilder().append(ChatColor.DARK_RED).append(ChatColor.BOLD).append("Mining Dev Menu").toString());
        final ItemStack Common = new ItemStack(Material.GOLD_NUGGET);
        final ItemMeta CommonMeta = Common.getItemMeta();
        final ArrayList<String> Commonlore = new ArrayList<String>();
        Commonlore.add(new StringBuilder().append(ChatColor.GRAY).append(ChatColor.ITALIC).append("Click to get all artifacts!").toString());
        CommonMeta.setLore((List)Commonlore);
        CommonMeta.setDisplayName(new StringBuilder().append(ChatColor.RED).append(ChatColor.BOLD).append("Artifacts").toString());
        Common.setItemMeta(CommonMeta);
        final ItemStack All = new ItemStack(Material.PISTON_BASE);
        final ItemMeta AllMeta = All.getItemMeta();
        final ArrayList<String> Alllore = new ArrayList<String>();
        Alllore.add(new StringBuilder().append(ChatColor.GRAY).append(ChatColor.ITALIC).append("Give all crates!").toString());
        AllMeta.setLore((List)Alllore);
        AllMeta.setDisplayName(new StringBuilder().append(ChatColor.RED).append(ChatColor.BOLD).append("Crates").toString());
        All.setItemMeta(AllMeta);
        Dev.setItem(11, Common);
        Dev.setItem(15, All);
        for (int x = 0; x < 27; ++x) {
            if (x != 11 && x != 15) {
                final ItemStack glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)15);
                final ItemMeta glassMeta = glass.getItemMeta();
                glassMeta.setDisplayName(" ");
                glass.setItemMeta(glassMeta);
                Dev.setItem(x, glass);
            }
        }
        player.openInventory(Dev);
    }
}
