package me.morphie.MorphMining.MineLog;

import org.bukkit.event.inventory.*;
import net.md_5.bungee.api.*;
import org.bukkit.entity.*;
import me.morphie.MorphMining.*;
import org.bukkit.event.*;
import org.bukkit.*;
import org.bukkit.ChatColor;

public class LogEvents implements Listener
{
    private Main plugin;
    
    public LogEvents(final Main plugin) {
        this.plugin = plugin;
    }
    
    @EventHandler
    public void onInventoryClick(final InventoryClickEvent event) {
        if (ChatColor.stripColor(event.getInventory().getName()).equalsIgnoreCase("Miner's Log")) {
            final Player player = (Player)event.getWhoClicked();
            if (event.getCurrentItem() == null || !event.getCurrentItem().hasItemMeta()) {
                return;
            }
            switch (event.getCurrentItem().getType()) {
                case GOLD_NUGGET: {
                    player.closeInventory();
                    new LogArtsMenu(this.plugin).openGUIArtsLog(player);
                    break;
                }
                case PISTON_BASE: {
                    event.setCancelled(true);
                    new LogCrateMenu(this.plugin).openGUICrateLog(player);
                    break;
                }
                case END_CRYSTAL: {
                    event.setCancelled(true);
                    break;
                }
                case BONE: {
                    event.setCancelled(true);
                    break;
                }
                case BARRIER: {
                    event.setCancelled(true);
                    break;
                }
                case ARROW: {
                    player.closeInventory();
                    new Station(this.plugin).openGUIMining(player);
                    break;
                }
            }
            if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(" ")) {
                event.setCancelled(true);
            }
        }
        else if (ChatColor.stripColor(event.getInventory().getName()).equalsIgnoreCase("Miner's Log: Artifacts")) {
            final Player player = (Player)event.getWhoClicked();
            if (event.getCurrentItem() == null || !event.getCurrentItem().hasItemMeta()) {
                return;
            }
            switch (event.getCurrentItem().getType()) {
                case GOLD_NUGGET: {
                    event.setCancelled(true);
                    break;
                }
                case BOOK: {
                    event.setCancelled(true);
                    break;
                }
                case ARROW: {
                    player.closeInventory();
                    new LogMenu(this.plugin).openGUIMineLog(player);
                    break;
                }
            }
            if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(" ")) {
                event.setCancelled(true);
            }
        }
        else if (ChatColor.stripColor(event.getInventory().getName()).equalsIgnoreCase("Miner's Log: Crates")) {
            final Player player = (Player)event.getWhoClicked();
            if (event.getCurrentItem() == null || !event.getCurrentItem().hasItemMeta()) {
                return;
            }
            switch (event.getCurrentItem().getType()) {
                case PISTON_BASE: {
                    event.setCancelled(true);
                    break;
                }
                case BOOK: {
                    event.setCancelled(true);
                    break;
                }
                case ARROW: {
                    player.closeInventory();
                    new LogMenu(this.plugin).openGUIMineLog(player);
                    break;
                }
            }
            if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(" ")) {
                event.setCancelled(true);
            }
        }
    }
}
