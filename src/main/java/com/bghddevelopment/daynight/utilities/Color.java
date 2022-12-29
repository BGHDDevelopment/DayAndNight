package com.bghddevelopment.daynight.utilities;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import java.util.Arrays;

public class Color {
    public static String TIME_CHANGED = "&aTime set to {time}!";
    public static void tell(final CommandSender sender, final String... messages) {
        Arrays.stream(messages).map(Color::translate).forEach(sender::sendMessage);
    }
    public static String translate(final String value) {
        return ChatColor.translateAlternateColorCodes('&', value);
    }

}
