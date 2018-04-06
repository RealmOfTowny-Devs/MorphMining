package me.morphie.MorphMining;

import org.bukkit.inventory.*;
import org.bukkit.event.player.*;
import org.bukkit.*;
import org.bukkit.ChatColor;

import net.md_5.bungee.api.*;
import me.morphie.MorphMining.Shop.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;
import org.bukkit.event.block.*;
import org.bukkit.enchantments.*;
import java.util.*;
import me.morphie.MorphMining.Items.*;
import org.bukkit.block.*;

public class Mining implements Listener
{
    private Main plugin;
    
    public Mining(final Main plugin) {
        this.plugin = plugin;
    }
    
    private void dropArt(final World world, final Location loc, final ItemStack artifact) {
        loc.setY(loc.getY());
        world.dropItem(loc, artifact);
    }
    
    @EventHandler
    public void onArtClick(final PlayerInteractEvent event) {
        final Player player = event.getPlayer();
        if (event.getAction() == null) {
            return;
        }
        if (event.getItem() == null) {
            return;
        }
        if ((event.getAction().equals((Object)Action.RIGHT_CLICK_AIR) || event.getAction().equals((Object)Action.RIGHT_CLICK_BLOCK)) && event.getItem().getType().equals((Object)Material.GOLD_NUGGET) && event.getItem().hasItemMeta()) {
            final ItemStack item2 = event.getItem();
            if (item2.getItemMeta().getDisplayName().equals(new StringBuilder().append(ChatColor.DARK_PURPLE).append(ChatColor.BOLD).append("Mythic Artifact").toString()) || item2.getItemMeta().getDisplayName().equals(new StringBuilder().append(ChatColor.GOLD).append(ChatColor.BOLD).append("Legendary Artifact").toString()) || item2.getItemMeta().getDisplayName().equals(new StringBuilder().append(ChatColor.AQUA).append(ChatColor.BOLD).append("Rare Artifact").toString()) || item2.getItemMeta().getDisplayName().equals(new StringBuilder().append(ChatColor.GRAY).append(ChatColor.BOLD).append("Common Artifact").toString())) {
                new Shop(this.plugin).openGUIShop(player);
            }
        }
    }
    
    @EventHandler
    public void onBlockBreak(final BlockBreakEvent event) {
        final Player p = event.getPlayer();
        final Block b = event.getBlock();
        final ItemStack i = event.getPlayer().getItemInHand();
        if (this.plugin.getServer().getPluginManager().getPlugin("WorldGuard") != null) {
            if (Main.worldguardPlugin.canBuild(p, b.getRelative(0, -1, 0)) && !i.containsEnchantment(Enchantment.SILK_TOUCH) && (i.getType() == Material.DIAMOND_PICKAXE || i.getType() == Material.GOLD_PICKAXE || i.getType() == Material.IRON_PICKAXE || i.getType() == Material.STONE_PICKAXE || i.getType() == Material.WOOD_PICKAXE)) {
                if (b.getType().equals((Object)Material.DIAMOND_ORE) || b.getType().equals((Object)Material.EMERALD_ORE)) {
                    final Random randMythic = new Random();
                    final int m = randMythic.nextInt(100);
                    final Random randDream = new Random();
                    final int md = randDream.nextInt(100);
                    if (m > 95) {
                        this.dropArt(p.getWorld(), b.getLocation(), Artifacts.Arts("MythicArt", 1));
                        if (md > 93) {
                            this.dropArt(p.getWorld(), b.getLocation(), Crates.Crate("DreamCrate", 1));
                            p.sendMessage(new StringBuilder().append(ChatColor.DARK_RED).append(ChatColor.BOLD).append("Mining").append(ChatColor.DARK_GRAY).append(ChatColor.BOLD).append(" >> ").append(ChatColor.GRAY).append("You got a ").append(ChatColor.DARK_RED).append("Miner's Dream Crate ").append(ChatColor.GRAY).append("with your").append(ChatColor.DARK_PURPLE).append(" Mythic ").append(ChatColor.GRAY).append("Artifact!").toString());
                        }
                        else {
                            p.sendMessage(new StringBuilder().append(ChatColor.DARK_RED).append(ChatColor.BOLD).append("Mining").append(ChatColor.DARK_GRAY).append(ChatColor.BOLD).append(" >> ").append(ChatColor.GRAY).append("You got a").append(ChatColor.DARK_PURPLE).append(" Mythic ").append(ChatColor.GRAY).append("Artifact!").toString());
                        }
                    }
                }
                else if (b.getType() == Material.LAPIS_ORE) {
                    final Random randLegend = new Random();
                    final int l = randLegend.nextInt(100);
                    final Random randIron = new Random();
                    final int io = randIron.nextInt(100);
                    if (l > 85) {
                        this.dropArt(p.getWorld(), b.getLocation(), Artifacts.Arts("LegendaryArt", 1));
                        if (io > 90) {
                            this.dropArt(p.getWorld(), b.getLocation(), Crates.Crate("IronCrate", 1));
                            p.sendMessage(new StringBuilder().append(ChatColor.DARK_RED).append(ChatColor.BOLD).append("Mining").append(ChatColor.DARK_GRAY).append(ChatColor.BOLD).append(" >> ").append(ChatColor.GRAY).append("You got a ").append(ChatColor.YELLOW).append("Ironed Crate ").append(ChatColor.GRAY).append("with your").append(ChatColor.GOLD).append(" Legendary ").append(ChatColor.GRAY).append("Artifact!").toString());
                        }
                        else {
                            p.sendMessage(new StringBuilder().append(ChatColor.DARK_RED).append(ChatColor.BOLD).append("Mining").append(ChatColor.DARK_GRAY).append(ChatColor.BOLD).append(" >> ").append(ChatColor.GRAY).append("You got a").append(ChatColor.GOLD).append(" Legendary ").append(ChatColor.GRAY).append("Artifact!").toString());
                        }
                    }
                }
                else if (b.getType() == Material.REDSTONE_ORE || b.getType() == Material.GLOWING_REDSTONE_ORE) {
                    final Random randRare = new Random();
                    final int r = randRare.nextInt(100);
                    final Random randRock = new Random();
                    final int por = randRock.nextInt(100);
                    if (r > 78) {
                        this.dropArt(p.getWorld(), b.getLocation(), Artifacts.Arts("RareArt", 1));
                        if (por > 80) {
                            this.dropArt(p.getWorld(), b.getLocation(), Crates.Crate("RockCrate", 1));
                            p.sendMessage(new StringBuilder().append(ChatColor.DARK_RED).append(ChatColor.BOLD).append("Mining").append(ChatColor.DARK_GRAY).append(ChatColor.BOLD).append(" >> ").append(ChatColor.GRAY).append("You got a Rock Crate with your").append(ChatColor.AQUA).append(" Rare ").append(ChatColor.GRAY).append("Artifact!").toString());
                        }
                        else {
                            p.sendMessage(new StringBuilder().append(ChatColor.DARK_RED).append(ChatColor.BOLD).append("Mining").append(ChatColor.DARK_GRAY).append(ChatColor.BOLD).append(" >> ").append(ChatColor.GRAY).append("You got a").append(ChatColor.AQUA).append(" Rare ").append(ChatColor.GRAY).append("Artifact!").toString());
                        }
                    }
                }
                else if (b.getType() == Material.COAL_ORE) {
                    final Random randCommon = new Random();
                    final int c = randCommon.nextInt(100);
                    final Random randRock = new Random();
                    final int por = randRock.nextInt(100);
                    if (c > 80) {
                        this.dropArt(p.getWorld(), b.getLocation(), Artifacts.Arts("CommonArt", 1));
                        if (por > 90) {
                            this.dropArt(p.getWorld(), b.getLocation(), Crates.Crate("RockCrate", 1));
                            p.sendMessage(new StringBuilder().append(ChatColor.DARK_RED).append(ChatColor.BOLD).append("Mining").append(ChatColor.DARK_GRAY).append(ChatColor.BOLD).append(" >> ").append(ChatColor.GRAY).append("You got a Rocks Crate with your Common Artifact!").toString());
                        }
                        else {
                            p.sendMessage(new StringBuilder().append(ChatColor.DARK_RED).append(ChatColor.BOLD).append("Mining").append(ChatColor.DARK_GRAY).append(ChatColor.BOLD).append(" >> ").append(ChatColor.GRAY).append("You got a Common Artifact!").toString());
                        }
                    }
                }
            }
        }
        else if (this.plugin.getServer().getPluginManager().getPlugin("GriefPrevention") != null) {
            if (Main.griefpreventionPlugin.allowBreak(p, b, b.getLocation()) == null && !i.containsEnchantment(Enchantment.SILK_TOUCH) && (i.getType() == Material.DIAMOND_PICKAXE || i.getType() == Material.GOLD_PICKAXE || i.getType() == Material.IRON_PICKAXE || i.getType() == Material.STONE_PICKAXE || i.getType() == Material.WOOD_PICKAXE)) {
                if (b.getType().equals((Object)Material.DIAMOND_ORE) || b.getType().equals((Object)Material.EMERALD_ORE)) {
                    final Random randMythic = new Random();
                    final int m = randMythic.nextInt(100);
                    final Random randDream = new Random();
                    final int md = randDream.nextInt(100);
                    if (m > 95) {
                        this.dropArt(p.getWorld(), b.getLocation(), Artifacts.Arts("MythicArt", 1));
                        if (md > 93) {
                            this.dropArt(p.getWorld(), b.getLocation(), Crates.Crate("DreamCrate", 1));
                            p.sendMessage(new StringBuilder().append(ChatColor.DARK_RED).append(ChatColor.BOLD).append("Mining").append(ChatColor.DARK_GRAY).append(ChatColor.BOLD).append(" >> ").append(ChatColor.GRAY).append("You got a ").append(ChatColor.DARK_RED).append("Miner's Dream Crate ").append(ChatColor.GRAY).append("with your").append(ChatColor.DARK_PURPLE).append(" Mythic ").append(ChatColor.GRAY).append("Artifact!").toString());
                        }
                        else {
                            p.sendMessage(new StringBuilder().append(ChatColor.DARK_RED).append(ChatColor.BOLD).append("Mining").append(ChatColor.DARK_GRAY).append(ChatColor.BOLD).append(" >> ").append(ChatColor.GRAY).append("You got a").append(ChatColor.DARK_PURPLE).append(" Mythic ").append(ChatColor.GRAY).append("Artifact!").toString());
                        }
                    }
                }
                else if (b.getType() == Material.LAPIS_ORE) {
                    final Random randLegend = new Random();
                    final int l = randLegend.nextInt(100);
                    final Random randIron = new Random();
                    final int io = randIron.nextInt(100);
                    if (l > 85) {
                        this.dropArt(p.getWorld(), b.getLocation(), Artifacts.Arts("LegendaryArt", 1));
                        if (io > 90) {
                            this.dropArt(p.getWorld(), b.getLocation(), Crates.Crate("IronCrate", 1));
                            p.sendMessage(new StringBuilder().append(ChatColor.DARK_RED).append(ChatColor.BOLD).append("Mining").append(ChatColor.DARK_GRAY).append(ChatColor.BOLD).append(" >> ").append(ChatColor.GRAY).append("You got a ").append(ChatColor.YELLOW).append("Ironed Crate ").append(ChatColor.GRAY).append("with your").append(ChatColor.GOLD).append(" Legendary ").append(ChatColor.GRAY).append("Artifact!").toString());
                        }
                        else {
                            p.sendMessage(new StringBuilder().append(ChatColor.DARK_RED).append(ChatColor.BOLD).append("Mining").append(ChatColor.DARK_GRAY).append(ChatColor.BOLD).append(" >> ").append(ChatColor.GRAY).append("You got a").append(ChatColor.GOLD).append(" Legendary ").append(ChatColor.GRAY).append("Artifact!").toString());
                        }
                    }
                }
                else if (b.getType() == Material.REDSTONE_ORE || b.getType() == Material.GLOWING_REDSTONE_ORE) {
                    final Random randRare = new Random();
                    final int r = randRare.nextInt(100);
                    final Random randRock = new Random();
                    final int por = randRock.nextInt(100);
                    if (r > 78) {
                        this.dropArt(p.getWorld(), b.getLocation(), Artifacts.Arts("RareArt", 1));
                        if (por > 80) {
                            this.dropArt(p.getWorld(), b.getLocation(), Crates.Crate("RockCrate", 1));
                            p.sendMessage(new StringBuilder().append(ChatColor.DARK_RED).append(ChatColor.BOLD).append("Mining").append(ChatColor.DARK_GRAY).append(ChatColor.BOLD).append(" >> ").append(ChatColor.GRAY).append("You got a Rock Crate with your").append(ChatColor.AQUA).append(" Rare ").append(ChatColor.GRAY).append("Artifact!").toString());
                        }
                        else {
                            p.sendMessage(new StringBuilder().append(ChatColor.DARK_RED).append(ChatColor.BOLD).append("Mining").append(ChatColor.DARK_GRAY).append(ChatColor.BOLD).append(" >> ").append(ChatColor.GRAY).append("You got a").append(ChatColor.AQUA).append(" Rare ").append(ChatColor.GRAY).append("Artifact!").toString());
                        }
                    }
                }
                else if (b.getType() == Material.COAL_ORE) {
                    final Random randCommon = new Random();
                    final int c = randCommon.nextInt(100);
                    final Random randRock = new Random();
                    final int por = randRock.nextInt(100);
                    if (c > 80) {
                        this.dropArt(p.getWorld(), b.getLocation(), Artifacts.Arts("CommonArt", 1));
                        if (por > 90) {
                            this.dropArt(p.getWorld(), b.getLocation(), Crates.Crate("RockCrate", 1));
                            p.sendMessage(new StringBuilder().append(ChatColor.DARK_RED).append(ChatColor.BOLD).append("Mining").append(ChatColor.DARK_GRAY).append(ChatColor.BOLD).append(" >> ").append(ChatColor.GRAY).append("You got a Rocks Crate with your Common Artifact!").toString());
                        }
                        else {
                            p.sendMessage(new StringBuilder().append(ChatColor.DARK_RED).append(ChatColor.BOLD).append("Mining").append(ChatColor.DARK_GRAY).append(ChatColor.BOLD).append(" >> ").append(ChatColor.GRAY).append("You got a Common Artifact!").toString());
                        }
                    }
                }
            }
        }
        else if (!i.containsEnchantment(Enchantment.SILK_TOUCH) && (i.getType() == Material.DIAMOND_PICKAXE || i.getType() == Material.GOLD_PICKAXE || i.getType() == Material.IRON_PICKAXE || i.getType() == Material.STONE_PICKAXE || i.getType() == Material.WOOD_PICKAXE)) {
            if (b.getType().equals((Object)Material.DIAMOND_ORE) || b.getType().equals((Object)Material.EMERALD_ORE)) {
                final Random randMythic = new Random();
                final int m = randMythic.nextInt(100);
                final Random randDream = new Random();
                final int md = randDream.nextInt(100);
                if (m > 95) {
                    this.dropArt(p.getWorld(), b.getLocation(), Artifacts.Arts("MythicArt", 1));
                    if (md > 93) {
                        this.dropArt(p.getWorld(), b.getLocation(), Crates.Crate("DreamCrate", 1));
                        p.sendMessage(new StringBuilder().append(ChatColor.DARK_RED).append(ChatColor.BOLD).append("Mining").append(ChatColor.DARK_GRAY).append(ChatColor.BOLD).append(" >> ").append(ChatColor.GRAY).append("You got a ").append(ChatColor.DARK_RED).append("Miner's Dream Crate ").append(ChatColor.GRAY).append("with your").append(ChatColor.DARK_PURPLE).append(" Mythic ").append(ChatColor.GRAY).append("Artifact!").toString());
                    }
                    else {
                        p.sendMessage(new StringBuilder().append(ChatColor.DARK_RED).append(ChatColor.BOLD).append("Mining").append(ChatColor.DARK_GRAY).append(ChatColor.BOLD).append(" >> ").append(ChatColor.GRAY).append("You got a").append(ChatColor.DARK_PURPLE).append(" Mythic ").append(ChatColor.GRAY).append("Artifact!").toString());
                    }
                }
            }
            else if (b.getType() == Material.LAPIS_ORE) {
                final Random randLegend = new Random();
                final int l = randLegend.nextInt(100);
                final Random randIron = new Random();
                final int io = randIron.nextInt(100);
                if (l > 85) {
                    this.dropArt(p.getWorld(), b.getLocation(), Artifacts.Arts("LegendaryArt", 1));
                    if (io > 90) {
                        this.dropArt(p.getWorld(), b.getLocation(), Crates.Crate("IronCrate", 1));
                        p.sendMessage(new StringBuilder().append(ChatColor.DARK_RED).append(ChatColor.BOLD).append("Mining").append(ChatColor.DARK_GRAY).append(ChatColor.BOLD).append(" >> ").append(ChatColor.GRAY).append("You got a ").append(ChatColor.YELLOW).append("Ironed Crate ").append(ChatColor.GRAY).append("with your").append(ChatColor.GOLD).append(" Legendary ").append(ChatColor.GRAY).append("Artifact!").toString());
                    }
                    else {
                        p.sendMessage(new StringBuilder().append(ChatColor.DARK_RED).append(ChatColor.BOLD).append("Mining").append(ChatColor.DARK_GRAY).append(ChatColor.BOLD).append(" >> ").append(ChatColor.GRAY).append("You got a").append(ChatColor.GOLD).append(" Legendary ").append(ChatColor.GRAY).append("Artifact!").toString());
                    }
                }
            }
            else if (b.getType() == Material.REDSTONE_ORE || b.getType() == Material.GLOWING_REDSTONE_ORE) {
                final Random randRare = new Random();
                final int r = randRare.nextInt(100);
                final Random randRock = new Random();
                final int por = randRock.nextInt(100);
                if (r > 78) {
                    this.dropArt(p.getWorld(), b.getLocation(), Artifacts.Arts("RareArt", 1));
                    if (por > 80) {
                        this.dropArt(p.getWorld(), b.getLocation(), Crates.Crate("RockCrate", 1));
                        p.sendMessage(new StringBuilder().append(ChatColor.DARK_RED).append(ChatColor.BOLD).append("Mining").append(ChatColor.DARK_GRAY).append(ChatColor.BOLD).append(" >> ").append(ChatColor.GRAY).append("You got a Rock Crate with your").append(ChatColor.AQUA).append(" Rare ").append(ChatColor.GRAY).append("Artifact!").toString());
                    }
                    else {
                        p.sendMessage(new StringBuilder().append(ChatColor.DARK_RED).append(ChatColor.BOLD).append("Mining").append(ChatColor.DARK_GRAY).append(ChatColor.BOLD).append(" >> ").append(ChatColor.GRAY).append("You got a").append(ChatColor.AQUA).append(" Rare ").append(ChatColor.GRAY).append("Artifact!").toString());
                    }
                }
            }
            else if (b.getType() == Material.COAL_ORE) {
                final Random randCommon = new Random();
                final int c = randCommon.nextInt(100);
                final Random randRock = new Random();
                final int por = randRock.nextInt(100);
                if (c > 80) {
                    this.dropArt(p.getWorld(), b.getLocation(), Artifacts.Arts("CommonArt", 1));
                    if (por > 90) {
                        this.dropArt(p.getWorld(), b.getLocation(), Crates.Crate("RockCrate", 1));
                        p.sendMessage(new StringBuilder().append(ChatColor.DARK_RED).append(ChatColor.BOLD).append("Mining").append(ChatColor.DARK_GRAY).append(ChatColor.BOLD).append(" >> ").append(ChatColor.GRAY).append("You got a Rocks Crate with your Common Artifact!").toString());
                    }
                    else {
                        p.sendMessage(new StringBuilder().append(ChatColor.DARK_RED).append(ChatColor.BOLD).append("Mining").append(ChatColor.DARK_GRAY).append(ChatColor.BOLD).append(" >> ").append(ChatColor.GRAY).append("You got a Common Artifact!").toString());
                    }
                }
            }
        }
    }
}
