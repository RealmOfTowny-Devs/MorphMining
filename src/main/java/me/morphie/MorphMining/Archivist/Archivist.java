package me.morphie.MorphMining.Archivist;

import org.bukkit.event.inventory.*;
import org.bukkit.entity.*;
import me.morphie.MorphMining.Crates.*;
import me.morphie.MorphMining.*;
import org.bukkit.event.*;
import org.bukkit.*;
import java.util.*;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.*;

public class Archivist implements Listener
{
    private Main plugin;
    
    public Archivist(final Main plugin) {
        this.plugin = plugin;
    }
    
    @EventHandler
    public void onInventoryClick(final InventoryClickEvent event) {
        if (ChatColor.stripColor(event.getInventory().getName()).equalsIgnoreCase("Archivist")) {
            final Player player = (Player)event.getWhoClicked();
            event.setCancelled(true);
            if (event.getCurrentItem() == null || !event.getCurrentItem().hasItemMeta()) {
                return;
            }
            switch (event.getCurrentItem().getType()) {
                case END_CRYSTAL: {
                    event.setCancelled(true);
                    break;
                }
                case PISTON_BASE: {
                    player.closeInventory();
                    new CratesMenu(this.plugin).openGUICrate(player);
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
    }
    
    public void openGUIArch(final Player player) {
        final Inventory Arch = Bukkit.createInventory((InventoryHolder)null, 54, new StringBuilder().append(ChatColor.DARK_RED).append(ChatColor.BOLD).append("Archivist").toString());
        final ItemStack Relic = new ItemStack(Material.END_CRYSTAL);
        final ItemMeta RelicMeta = Relic.getItemMeta();
        final ArrayList<String> Reliclore = new ArrayList<String>();
        Reliclore.add(" ");
        Reliclore.add(ChatColor.GRAY + "Give the archivist");
        Reliclore.add(ChatColor.GRAY + "unidentified relics here!");
        Reliclore.add(" ");
        Reliclore.add(new StringBuilder().append(ChatColor.DARK_RED).append(ChatColor.ITALIC).append("Coming Soon!").toString());
        RelicMeta.setLore((List)Reliclore);
        RelicMeta.setDisplayName(new StringBuilder().append(ChatColor.DARK_RED).append(ChatColor.BOLD).append("Relic Analyzer").toString());
        Relic.setItemMeta(RelicMeta);
        Arch.setItem(20, Relic);
        final ItemStack Crate = new ItemStack(Material.PISTON_BASE);
        final ItemMeta CrateMeta = Crate.getItemMeta();
        final ArrayList<String> Cratelore = new ArrayList<String>();
        Cratelore.add("");
        Cratelore.add(ChatColor.GRAY + "Give the archivist");
        Cratelore.add(ChatColor.GRAY + "unopened crates here!");
        CrateMeta.setLore((List)Cratelore);
        CrateMeta.setDisplayName(new StringBuilder().append(ChatColor.DARK_RED).append(ChatColor.BOLD).append("Crate Analyzer").toString());
        Crate.setItemMeta(CrateMeta);
        Arch.setItem(24, Crate);
        final ItemStack Info = new ItemStack(Material.BOOK);
        final ItemMeta InfoMeta = Info.getItemMeta();
        final ArrayList<String> Infolore = new ArrayList<String>();
        Infolore.add(ChatColor.GRAY + "The archivist identifies relics");
        Infolore.add(ChatColor.GRAY + "and opens crates!");
        InfoMeta.setLore((List)Infolore);
        InfoMeta.setDisplayName(new StringBuilder().append(ChatColor.RED).append(ChatColor.BOLD).append("Information").toString());
        Info.setItemMeta(InfoMeta);
        Arch.setItem(48, Info);
        final ItemStack Back = new ItemStack(Material.ARROW);
        final ItemMeta BackMeta = Back.getItemMeta();
        final ArrayList<String> Backlore = new ArrayList<String>();
        Backlore.add(ChatColor.GRAY + "Click to go back!");
        BackMeta.setLore((List)Backlore);
        BackMeta.setDisplayName(new StringBuilder().append(ChatColor.RED).append(ChatColor.BOLD).append("Back").toString());
        Back.setItemMeta(BackMeta);
        Arch.setItem(50, Back);
        final ItemStack redGlass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14);
        final ItemMeta redGlassMeta = redGlass.getItemMeta();
        final ArrayList<String> redGlasslore = new ArrayList<String>();
        redGlasslore.add(" ");
        redGlassMeta.setDisplayName(" ");
        redGlass.setItemMeta(redGlassMeta);
        Arch.setItem(10, redGlass);
        Arch.setItem(11, redGlass);
        Arch.setItem(12, redGlass);
        Arch.setItem(14, redGlass);
        Arch.setItem(15, redGlass);
        Arch.setItem(16, redGlass);
        Arch.setItem(19, redGlass);
        Arch.setItem(21, redGlass);
        Arch.setItem(23, redGlass);
        Arch.setItem(25, redGlass);
        Arch.setItem(28, redGlass);
        Arch.setItem(29, redGlass);
        Arch.setItem(30, redGlass);
        Arch.setItem(32, redGlass);
        Arch.setItem(33, redGlass);
        Arch.setItem(34, redGlass);
        for (int glass = 0; glass < 54; ++glass) {
            if ((glass < 10 || glass >= 13) && (glass < 14 || glass >= 17) && (glass < 19 || glass >= 22) && (glass < 23 || glass >= 26) && (glass < 28 || glass >= 31) && (glass < 32 || glass >= 35) && glass != 48 && glass != 50) {
                final ItemStack Glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)15);
                final ItemMeta GlassMeta = Glass.getItemMeta();
                GlassMeta.setDisplayName(" ");
                Glass.setItemMeta(GlassMeta);
                Arch.setItem(glass, Glass);
            }
        }
        player.openInventory(Arch);
    }
}
