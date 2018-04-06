package me.morphie.MorphMining.MineLog;

import org.bukkit.event.*;
import me.morphie.MorphMining.*;
import org.bukkit.entity.*;
import net.md_5.bungee.api.*;
import org.bukkit.*;
import org.bukkit.ChatColor;

import java.util.*;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.*;

public class LogMenu implements Listener
{
    private Main plugin;
    
    public LogMenu(final Main plugin) {
        this.plugin = plugin;
    }
    
    public void openGUIMineLog(final Player player) {
        final Inventory MineLog = Bukkit.createInventory((InventoryHolder)null, 27, new StringBuilder().append(ChatColor.DARK_RED).append(ChatColor.BOLD).append("Miner's Log").toString());
        final ItemStack Art = new ItemStack(Material.GOLD_NUGGET);
        final ItemMeta ArtMeta = Art.getItemMeta();
        final ArrayList<String> Artlore = new ArrayList<String>();
        Artlore.add(ChatColor.GRAY + "Everything Artifacts!");
        ArtMeta.setDisplayName(new StringBuilder().append(ChatColor.DARK_RED).append(ChatColor.BOLD).append("Artifacts").toString());
        ArtMeta.setLore((List)Artlore);
        Art.setItemMeta(ArtMeta);
        MineLog.setItem(10, Art);
        final ItemStack Crate = new ItemStack(Material.PISTON_BASE);
        final ItemMeta CrateMeta = Crate.getItemMeta();
        final ArrayList<String> Cratelore = new ArrayList<String>();
        Cratelore.add(ChatColor.GRAY + "Everything Crates!");
        CrateMeta.setDisplayName(new StringBuilder().append(ChatColor.DARK_RED).append(ChatColor.BOLD).append("Crates").toString());
        CrateMeta.setLore((List)Cratelore);
        Crate.setItemMeta(CrateMeta);
        MineLog.setItem(11, Crate);
        final ItemStack Relic = new ItemStack(Material.END_CRYSTAL);
        final ItemMeta RelicMeta = Relic.getItemMeta();
        final ArrayList<String> Reliclore = new ArrayList<String>();
        Reliclore.add(ChatColor.GRAY + "Everything Relics!");
        Reliclore.add(new StringBuilder().append(ChatColor.DARK_RED).append(ChatColor.ITALIC).append("Coming Soon!").toString());
        RelicMeta.setDisplayName(new StringBuilder().append(ChatColor.DARK_RED).append(ChatColor.BOLD).append("Relics").toString());
        RelicMeta.setLore((List)Reliclore);
        Relic.setItemMeta(RelicMeta);
        MineLog.setItem(12, Relic);
        final ItemStack Fossil = new ItemStack(Material.BONE);
        final ItemMeta FossilMeta = Fossil.getItemMeta();
        final ArrayList<String> Fossillore = new ArrayList<String>();
        Fossillore.add(ChatColor.GRAY + "Everything Fossils!");
        Fossillore.add(new StringBuilder().append(ChatColor.DARK_RED).append(ChatColor.ITALIC).append("Coming Soon!").toString());
        FossilMeta.setDisplayName(new StringBuilder().append(ChatColor.DARK_RED).append(ChatColor.BOLD).append("Fossils").toString());
        FossilMeta.setLore((List)Fossillore);
        Fossil.setItemMeta(FossilMeta);
        MineLog.setItem(13, Fossil);
        final ItemStack Barrier = new ItemStack(Material.BARRIER);
        final ItemMeta BarrierMeta = Barrier.getItemMeta();
        BarrierMeta.setDisplayName(new StringBuilder().append(ChatColor.DARK_GRAY).append(ChatColor.BOLD).append("[").append(ChatColor.RED).append(ChatColor.BOLD).append("!").append(ChatColor.DARK_GRAY).append(ChatColor.BOLD).append("]").append(ChatColor.DARK_RED).append(ChatColor.ITALIC).append(" Coming soon!").toString());
        Barrier.setItemMeta(BarrierMeta);
        MineLog.setItem(14, Barrier);
        final ItemStack Back = new ItemStack(Material.ARROW);
        final ItemMeta BackMeta = Back.getItemMeta();
        final ArrayList<String> Backlore = new ArrayList<String>();
        Backlore.add(ChatColor.GRAY + "Click to go back!");
        BackMeta.setLore((List)Backlore);
        BackMeta.setDisplayName(new StringBuilder().append(ChatColor.RED).append(ChatColor.BOLD).append("Back").toString());
        Back.setItemMeta(BackMeta);
        MineLog.setItem(16, Back);
        final ItemStack redGlass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14);
        final ItemMeta redGlassMeta = redGlass.getItemMeta();
        final ArrayList<String> redGlasslore = new ArrayList<String>();
        redGlasslore.add(" ");
        redGlassMeta.setDisplayName(" ");
        redGlass.setItemMeta(redGlassMeta);
        MineLog.setItem(6, redGlass);
        MineLog.setItem(7, redGlass);
        MineLog.setItem(8, redGlass);
        MineLog.setItem(15, redGlass);
        MineLog.setItem(17, redGlass);
        MineLog.setItem(24, redGlass);
        MineLog.setItem(25, redGlass);
        MineLog.setItem(26, redGlass);
        for (int x = 0; x < 27; ++x) {
            if ((x < 6 || x >= 9) && (x < 10 || x >= 18) && (x < 24 || x >= 27)) {
                final ItemStack glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)15);
                final ItemMeta glassMeta = glass.getItemMeta();
                glassMeta.setDisplayName(" ");
                glass.setItemMeta(glassMeta);
                MineLog.setItem(x, glass);
            }
        }
        player.openInventory(MineLog);
    }
}
