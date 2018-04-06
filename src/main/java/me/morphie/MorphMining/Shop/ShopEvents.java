package me.morphie.MorphMining.Shop;

import org.bukkit.entity.*;
import me.morphie.MorphMining.*;
import org.bukkit.event.*;
import org.bukkit.event.inventory.*;
import org.bukkit.inventory.*;
import org.bukkit.*;
import org.bukkit.ChatColor;

public class ShopEvents implements Listener
{
    private Main plugin;
    
    public ShopEvents(final Main plugin) {
        this.plugin = plugin;
    }
    
    @EventHandler
    public void onInventoryClick(final InventoryClickEvent event) {
        if (ChatColor.stripColor(event.getInventory().getName()).equalsIgnoreCase("Mining Shop")) {
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
                    new Station(this.plugin).openGUIMining(player);
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
    }
    
    @EventHandler
    public void onShopClose(final InventoryCloseEvent event) {
        if (ChatColor.stripColor(event.getInventory().getName()).equalsIgnoreCase("Mining Shop")) {
            final Inventory inv = event.getInventory();
            final Player player = (Player)event.getPlayer();
            int Artifacts = 0;
            int Money = 0;
            final double CommonPrice = this.plugin.getConfig().getDouble("ArtifactPrice.Common");
            final double RarePrice = this.plugin.getConfig().getDouble("ArtifactPrice.Rare");
            final double LegendaryPrice = this.plugin.getConfig().getDouble("ArtifactPrice.Legendary");
            final double MythicPrice = this.plugin.getConfig().getDouble("ArtifactPrice.Mythic");
            for (int i = 8; i <= 41; ++i) {
                final ItemStack item = inv.getItem(i);
                if (item != null) {
                    if (item.hasItemMeta()) {
                        int x = item.getAmount();
                        while (x > 0) {
                            --x;
                            if (item.getItemMeta().getDisplayName().contains(ChatColor.stripColor("Common Artifact"))) {
                                Main.econ.depositPlayer((OfflinePlayer)player, CommonPrice);
                                ++Artifacts;
                                Money += (int)CommonPrice;
                            }
                            else if (item.getItemMeta().getDisplayName().contains(ChatColor.stripColor("Rare Artifact"))) {
                                Main.econ.depositPlayer((OfflinePlayer)player, RarePrice);
                                ++Artifacts;
                                Money += (int)RarePrice;
                            }
                            else if (item.getItemMeta().getDisplayName().contains(ChatColor.stripColor("Legendary Artifact"))) {
                                Main.econ.depositPlayer((OfflinePlayer)player, LegendaryPrice);
                                ++Artifacts;
                                Money += (int)LegendaryPrice;
                            }
                            else {
                                if (!item.getItemMeta().getDisplayName().contains(ChatColor.stripColor("Mythic Artifact"))) {
                                    continue;
                                }
                                Main.econ.depositPlayer((OfflinePlayer)player, MythicPrice);
                                ++Artifacts;
                                Money += (int)MythicPrice;
                            }
                        }
                    }
                    else if (!item.hasItemMeta() || !item.getItemMeta().hasDisplayName() || !item.getItemMeta().getDisplayName().equals(new StringBuilder().append(ChatColor.RED).append(ChatColor.BOLD).append("Information").toString())) {
                        player.getInventory().addItem(new ItemStack[] { item });
                    }
                }
            }
            if (Money != 0 && Artifacts != 0) {
                player.sendMessage(ChatColor.DARK_RED + "Mining" + ChatColor.DARK_GRAY + ChatColor.BOLD + " >> " + ChatColor.GRAY + "You got " + ChatColor.RED + "$" + Money + ChatColor.GRAY + " from " + ChatColor.RED + Artifacts + ChatColor.GRAY + " artifacts!");
            }
        }
    }
}
