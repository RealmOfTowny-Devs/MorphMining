package me.morphie.MorphMining.Crates;

import org.bukkit.event.*;
import me.morphie.MorphMining.*;
import org.bukkit.inventory.*;
import org.bukkit.entity.*;
import java.util.*;
import me.morphie.MorphMining.Items.*;
import org.bukkit.*;
import org.bukkit.enchantments.*;
import org.bukkit.inventory.meta.*;

public class CrateRewards implements Listener
{
    private Main plugin;
    
    public CrateRewards(final Main plugin) {
        this.plugin = plugin;
    }
    
    private void dropReward(final World world, final Location loc, final ItemStack reward) {
        loc.setY(loc.getY() + 2.0);
        world.dropItem(loc, reward);
    }
    
    public void giveCrateReward(final Player p, final String s) {
        if (s.equals("Rocks")) {
            final Random randRocks = new Random();
            final int r = randRocks.nextInt(6);
            if (r == 1) {
                this.dropReward(p.getWorld(), p.getLocation(), Artifacts.Arts("CommonArt", 3));
            }
            else if (r == 2) {
                this.dropReward(p.getWorld(), p.getLocation(), Artifacts.Arts("RareArt", 3));
            }
            else if (r == 3) {
                final ItemStack Coal = new ItemStack(Material.COAL_BLOCK, 4);
                this.dropReward(p.getWorld(), p.getLocation(), Coal);
            }
            else if (r == 4) {
                final ItemStack Redstone = new ItemStack(Material.REDSTONE_BLOCK, 4);
                this.dropReward(p.getWorld(), p.getLocation(), Redstone);
            }
            else if (r == 5) {
                final ItemStack Lapis = new ItemStack(Material.LAPIS_BLOCK, 2);
                this.dropReward(p.getWorld(), p.getLocation(), Lapis);
            }
            else {
                final ItemStack Andesite = new ItemStack(Material.STONE, 16, (short)5);
                this.dropReward(p.getWorld(), p.getLocation(), Andesite);
            }
        }
        else if (s.equals("Iron")) {
            final Random randIron = new Random();
            final int i = randIron.nextInt(7);
            if (i == 1) {
                this.dropReward(p.getWorld(), p.getLocation(), Artifacts.Arts("RareArt", 3));
            }
            else if (i == 2) {
                this.dropReward(p.getWorld(), p.getLocation(), Artifacts.Arts("LegendaryArt", 1));
            }
            else if (i == 3) {
                final ItemStack unBook = new ItemStack(Material.ENCHANTED_BOOK);
                final EnchantmentStorageMeta unBookMeta = (EnchantmentStorageMeta)unBook.getItemMeta();
                unBookMeta.addStoredEnchant(Enchantment.DURABILITY, 3, true);
                unBook.setItemMeta((ItemMeta)unBookMeta);
                this.dropReward(p.getWorld(), p.getLocation(), unBook);
            }
            else if (i == 4) {
                final ItemStack Iron = new ItemStack(Material.IRON_BLOCK, 2);
                this.dropReward(p.getWorld(), p.getLocation(), Iron);
            }
            else if (i == 5) {
                final ItemStack Gold = new ItemStack(Material.GOLD_BLOCK, 2);
                this.dropReward(p.getWorld(), p.getLocation(), Gold);
            }
            else if (i == 6) {
                final ItemStack Quartz = new ItemStack(Material.QUARTZ_ORE, 6);
                this.dropReward(p.getWorld(), p.getLocation(), Quartz);
            }
            else {
                final ItemStack Shulker = new ItemStack(Material.RED_SHULKER_BOX);
                this.dropReward(p.getWorld(), p.getLocation(), Shulker);
            }
        }
        else if (s.equals("Dream")) {
            final Random randIron = new Random();
            final int i = randIron.nextInt(7);
            if (i == 1) {
                this.dropReward(p.getWorld(), p.getLocation(), Artifacts.Arts("LegendaryArt", 3));
            }
            else if (i == 2) {
                this.dropReward(p.getWorld(), p.getLocation(), Artifacts.Arts("MythicArt", 1));
            }
            else if (i == 3) {
                final ItemStack mendBook = new ItemStack(Material.ENCHANTED_BOOK);
                final EnchantmentStorageMeta mendMeta = (EnchantmentStorageMeta)mendBook.getItemMeta();
                mendMeta.addStoredEnchant(Enchantment.MENDING, 1, true);
                mendBook.setItemMeta((ItemMeta)mendMeta);
                this.dropReward(p.getWorld(), p.getLocation(), mendBook);
            }
            else if (i == 4) {
                final ItemStack effBook = new ItemStack(Material.ENCHANTED_BOOK);
                final EnchantmentStorageMeta effMeta = (EnchantmentStorageMeta)effBook.getItemMeta();
                effMeta.addStoredEnchant(Enchantment.DIG_SPEED, 5, true);
                effBook.setItemMeta((ItemMeta)effMeta);
                this.dropReward(p.getWorld(), p.getLocation(), effBook);
            }
            else if (i == 5) {
                final ItemStack Diamond = new ItemStack(Material.DIAMOND_BLOCK, 1);
                this.dropReward(p.getWorld(), p.getLocation(), Diamond);
            }
            else if (i == 6) {
                final ItemStack Emerald = new ItemStack(Material.EMERALD_BLOCK, 2);
                this.dropReward(p.getWorld(), p.getLocation(), Emerald);
            }
            else {
                final ItemStack Beacon = new ItemStack(Material.BEACON, 1);
                this.dropReward(p.getWorld(), p.getLocation(), Beacon);
            }
        }
    }
}
