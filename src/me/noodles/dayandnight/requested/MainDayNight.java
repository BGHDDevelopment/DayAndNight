package me.noodles.dayandnight.requested;

import org.bukkit.plugin.java.*;
import org.bukkit.event.*;
import org.bukkit.plugin.*;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MainDayNight extends JavaPlugin implements Listener
{
    public static MainDayNight plugin;
    public static Plugin plugin2;
    private UpdateChecker checker;
    String DownloaderType;
    String GsonEntry;
    String SpigotHost;
    
    public void onEnable() {
        MainDayNight.plugin = this;
        final PluginDescriptionFile VarUtilType = this.getDescription();
        this.getLogger().info("DayAndNight V" + VarUtilType.getVersion() + " starting...");
        this.saveDefaultConfig();
        this.reloadConfig();
        registerEvents((Plugin)this, new UpdateJoinEvent());
        registerEvents(this, this);
        this.getLogger().info("DayAndNight V" + VarUtilType.getVersion() + " started!");
        this.setEnabled(true);
        this.getLogger().info("DayAndNight V" + VarUtilType.getVersion() + " checking for updates...");
        this.checker = new UpdateChecker(this);
        if (this.checker.isConnected()) {
            if (this.checker.hasUpdate()) {
                getServer().getConsoleSender().sendMessage("------------------------");
                getServer().getConsoleSender().sendMessage("DayAndNight is outdated!");
                getServer().getConsoleSender().sendMessage("Newest version: " + this.checker.getLatestVersion());
                getServer().getConsoleSender().sendMessage("Your version: " + MainDayNight.plugin.getDescription().getVersion());
                getServer().getConsoleSender().sendMessage("Please Update Here: https://www.spigotmc.org/resources/45988");
                getServer().getConsoleSender().sendMessage("------------------------");
            }
            else {
                getServer().getConsoleSender().sendMessage("------------------------");
                getServer().getConsoleSender().sendMessage("DayAndNight is up to date!");
                getServer().getConsoleSender().sendMessage("------------------------");            }
        }
    }
    
    public static void registerEvents(final Plugin plugin, final Listener... listeners) {
        for (final Listener listener : listeners) {
            Bukkit.getServer().getPluginManager().registerEvents(listener, plugin);
        }
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes"})
	public static MainDayNight getPlugin() {
        return (MainDayNight)getPlugin((Class)MainDayNight.class);
    }
    
    public static Plugin getPlugin2() {
        return (Plugin)MainDayNight.plugin;
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (cmd.getName().equalsIgnoreCase("day")) {
            if (p.hasPermission("dayandnight.day")) {
                p.getWorld().setTime(0L);
                p.sendMessage(ChatColor.GREEN + "Time set to Day!");
            }
            else {
                p.sendMessage(ChatColor.RED + "You don't have permssion to use this command!");
            }
        }
        if (cmd.getName().equalsIgnoreCase("night")) {
            if (p.hasPermission("dayandnight.night")) {
                p.getWorld().setTime(13000L);
                p.sendMessage(ChatColor.GREEN + "Time set to Night!");
            }
            else {
            	p.sendMessage(ChatColor.RED + "You don't have permssion to use this command!");
            }
        }
		return true;
    }
    
}
