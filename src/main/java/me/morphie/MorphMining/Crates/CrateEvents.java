package me.morphie.MorphMining.Crates;

import me.morphie.MorphMining.*;
import org.bukkit.event.player.*;
import net.md_5.bungee.api.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;
import org.bukkit.event.block.*;
import org.bukkit.block.*;
import me.morphie.MorphMining.Archivist.*;
import org.bukkit.event.inventory.*;
import org.bukkit.*;
import org.bukkit.ChatColor;
import org.bukkit.inventory.*;

public class CrateEvents implements Listener
{
    private Main plugin;
    public CrateRewards craterewards;
    
    public CrateEvents(final Main plugin) {
        this.craterewards = new CrateRewards(this.plugin);
        this.plugin = plugin;
    }
    
    @EventHandler
    public void onCrateRight(final PlayerInteractEvent event) {
        final Player player = event.getPlayer();
        if (event.getAction() == null) {
            return;
        }
        if (event.getItem() == null) {
            return;
        }
        if ((event.getAction().equals((Object)Action.RIGHT_CLICK_AIR) || event.getAction().equals((Object)Action.RIGHT_CLICK_BLOCK)) && event.getItem().getType().equals((Object)Material.PISTON_BASE) && event.getItem().hasItemMeta()) {
            final ItemStack item = event.getItem();
            if (item.getItemMeta().getDisplayName().equals(new StringBuilder().append(ChatColor.GRAY).append(ChatColor.BOLD).append("Pile Of Rocks").toString()) || item.getItemMeta().getDisplayName().equals(new StringBuilder().append(ChatColor.YELLOW).append(ChatColor.BOLD).append("Ironed Out").toString()) || item.getItemMeta().getDisplayName().equals(new StringBuilder().append(ChatColor.DARK_PURPLE).append(ChatColor.BOLD).append("Miner's Dream").toString())) {
                new CratesMenu(this.plugin).openGUICrate(player);
            }
        }
    }
    
    @EventHandler
    public void onCrateLeft(final PlayerInteractEvent event) {
        final Player player = event.getPlayer();
        if (event.getAction() == null) {
            return;
        }
        if (event.getItem() == null) {
            return;
        }
        if ((event.getAction().equals((Object)Action.LEFT_CLICK_AIR) || event.getAction().equals((Object)Action.LEFT_CLICK_BLOCK)) && event.getItem().getType().equals((Object)Material.PISTON_BASE) && event.getItem().hasItemMeta()) {
            final ItemStack item = event.getItem();
            if (item.getItemMeta().getDisplayName().equals(new StringBuilder().append(ChatColor.GRAY).append(ChatColor.BOLD).append("Pile Of Rocks").toString())) {
                new CrateContents(this.plugin).openGUIRocks(player);
            }
            else if (item.getItemMeta().getDisplayName().equals(new StringBuilder().append(ChatColor.YELLOW).append(ChatColor.BOLD).append("Ironed Out").toString())) {
                new CrateContents(this.plugin).openGUIIron(player);
            }
            else if (item.getItemMeta().getDisplayName().equals(new StringBuilder().append(ChatColor.DARK_PURPLE).append(ChatColor.BOLD).append("Miner's Dream").toString())) {
                new CrateContents(this.plugin).openGUIDream(player);
            }
        }
    }
    
    @EventHandler
    public void onCratePlace(final BlockPlaceEvent event) {
        final Player p = event.getPlayer();
        final Block b = event.getBlockPlaced();
        if (b.getType().equals((Object)Material.PISTON_BASE)) {
            final ItemStack i = event.getItemInHand();
            if (i.getItemMeta().getDisplayName().equals(new StringBuilder().append(ChatColor.GRAY).append(ChatColor.BOLD).append("Pile Of Rocks").toString()) || i.getItemMeta().getDisplayName().equals(new StringBuilder().append(ChatColor.YELLOW).append(ChatColor.BOLD).append("Ironed Out").toString()) || i.getItemMeta().getDisplayName().equals(new StringBuilder().append(ChatColor.YELLOW).append(ChatColor.BOLD).append("Ironed Out").toString()) || i.getItemMeta().getDisplayName().equals(new StringBuilder().append(ChatColor.DARK_PURPLE).append(ChatColor.BOLD).append("Miner's Dream").toString())) {
                event.setCancelled(true);
            }
        }
    }
    
    @EventHandler
    public void onInventoryClick(final InventoryClickEvent event) {
        if (ChatColor.stripColor(event.getInventory().getName()).equalsIgnoreCase("Crate Analyzer")) {
            final Player player = (Player)event.getWhoClicked();
            if (event.getCurrentItem() == null || !event.getCurrentItem().hasItemMeta()) {
                return;
            }
            switch (event.getCurrentItem().getType()) {
                case PAPER: {
                    event.setCancelled(true);
                    break;
                }
                case ARROW: {
                    player.closeInventory();
                    new Archivist(this.plugin).openGUIArch(player);
                    break;
                }
                case BOOK: {
                    event.setCancelled(true);
                    break;
                }
            }
            if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(" ")) {
                event.setCancelled(true);
            }
        }
        else if (ChatColor.stripColor(event.getInventory().getName()).equalsIgnoreCase("Pile Of Rocks")) {
            final Player player = (Player)event.getWhoClicked();
            event.setCancelled(true);
            if (event.getCurrentItem() == null || !event.getCurrentItem().hasItemMeta()) {
                return;
            }
            switch (event.getCurrentItem().getType()) {
            }
        }
        else if (ChatColor.stripColor(event.getInventory().getName()).equalsIgnoreCase("Ironed Out")) {
            final Player player = (Player)event.getWhoClicked();
            event.setCancelled(true);
            if (event.getCurrentItem() == null || !event.getCurrentItem().hasItemMeta()) {
                return;
            }
            switch (event.getCurrentItem().getType()) {
            }
        }
        else if (ChatColor.stripColor(event.getInventory().getName()).equalsIgnoreCase("A Miner's Dream")) {
            final Player player = (Player)event.getWhoClicked();
            event.setCancelled(true);
            if (event.getCurrentItem() == null || !event.getCurrentItem().hasItemMeta()) {
                return;
            }
            switch (event.getCurrentItem().getType()) {
                case GOLD_NUGGET: {}
                case ENCHANTED_BOOK: {}
                case DIAMOND_BLOCK: {}
            }
        }
    }
    
    @EventHandler
    public void onCrateClose(final InventoryCloseEvent event) {
        if (event.getInventory().getName().equals(new StringBuilder().append(ChatColor.DARK_RED).append(ChatColor.BOLD).append("Crate Analyzer").toString())) {
            final Inventory inv = event.getInventory();
            final Player player = (Player)event.getPlayer();
            final double bal = Main.econ.getBalance((OfflinePlayer)player);
            int Crates = 0;
            final double rockCharge = this.plugin.getConfig().getDouble("CrateOpenCost.PileOfRocks");
            final double ironCharge = this.plugin.getConfig().getDouble("CrateOpenCost.IronedOut");
            final double dreamCharge = this.plugin.getConfig().getDouble("CrateOpenCost.MinersDream");
            int totalCharge = 0;
            int cancel = 0;
            for (int i = 8; i <= 41; ++i) {
                final ItemStack item = inv.getItem(i);
                if (item != null) {
                    if (item.hasItemMeta()) {
                        int x = item.getAmount();
                        while (x > 0) {
                            --x;
                            if (item.getItemMeta().getDisplayName().contains(ChatColor.stripColor("Pile Of Rocks"))) {
                                if (bal > 10.0) {
                                    ++Crates;
                                    totalCharge += (int)rockCharge;
                                    Main.econ.withdrawPlayer((OfflinePlayer)player, rockCharge);
                                    this.craterewards.giveCrateReward(player, "Rocks");
                                }
                                else {
                                    if (item.getItemMeta().getDisplayName().contains(ChatColor.stripColor("Pile Of Rocks")) || item.getItemMeta().getDisplayName().contains(ChatColor.stripColor("Ironed Out")) || item.getItemMeta().getDisplayName().contains(ChatColor.stripColor("Miner's Dream"))) {
                                        player.getInventory().addItem(new ItemStack[] { item });
                                        ++cancel;
                                        break;
                                    }
                                    continue;
                                }
                            }
                            else if (item.getItemMeta().getDisplayName().contains(ChatColor.stripColor("Ironed Out"))) {
                                if (bal > 20.0) {
                                    ++Crates;
                                    totalCharge += (int)ironCharge;
                                    Main.econ.withdrawPlayer((OfflinePlayer)player, ironCharge);
                                    this.craterewards.giveCrateReward(player, "Iron");
                                }
                                else {
                                    if (item.getItemMeta().getDisplayName().contains(ChatColor.stripColor("Pile Of Rocks")) || item.getItemMeta().getDisplayName().contains(ChatColor.stripColor("Ironed Out")) || item.getItemMeta().getDisplayName().contains(ChatColor.stripColor("Miner's Dream"))) {
                                        player.getInventory().addItem(new ItemStack[] { item });
                                        ++cancel;
                                        break;
                                    }
                                    continue;
                                }
                            }
                            else {
                                if (!item.getItemMeta().getDisplayName().contains(ChatColor.stripColor("Miner's Dream"))) {
                                    continue;
                                }
                                if (bal > 20.0) {
                                    ++Crates;
                                    totalCharge += (int)dreamCharge;
                                    Main.econ.withdrawPlayer((OfflinePlayer)player, dreamCharge);
                                    this.craterewards.giveCrateReward(player, "Dream");
                                }
                                else {
                                    if (item.getItemMeta().getDisplayName().contains(ChatColor.stripColor("Pile Of Rocks")) || item.getItemMeta().getDisplayName().contains(ChatColor.stripColor("Ironed Out")) || item.getItemMeta().getDisplayName().contains(ChatColor.stripColor("Miner's Dream"))) {
                                        player.getInventory().addItem(new ItemStack[] { item });
                                        ++cancel;
                                        break;
                                    }
                                    continue;
                                }
                            }
                        }
                    }
                    else if (!item.hasItemMeta() || !item.getItemMeta().hasDisplayName() || !item.getItemMeta().getDisplayName().equals(new StringBuilder().append(ChatColor.RED).append(ChatColor.BOLD).append("Information").toString())) {
                        player.getInventory().addItem(new ItemStack[] { item });
                    }
                }
            }
            if (Crates != 0) {
                player.sendMessage(new StringBuilder().append(ChatColor.DARK_RED).append(ChatColor.BOLD).append("Mining").append(ChatColor.DARK_GRAY).append(ChatColor.BOLD).append(" >> ").append(ChatColor.GRAY).append("You opened ").append(ChatColor.RED).append(Crates).append(ChatColor.GRAY).append(" Crates at a price of").append(ChatColor.RED).append(" $").append(totalCharge).toString());
            }
            else if (cancel > 0) {
                player.sendMessage(new StringBuilder().append(ChatColor.DARK_GRAY).append(ChatColor.BOLD).append("[").append(ChatColor.RED).append(ChatColor.BOLD).append("!").append(ChatColor.DARK_GRAY).append(ChatColor.BOLD).append("]").append(ChatColor.RED).append(" Money required for crate analyzation!").toString());
            }
        }
    }
}
