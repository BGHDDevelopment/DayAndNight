package me.noodles.dayandnight.utilities;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import java.util.Arrays;

/**
 * Author:  Kim (Thinkverse) Hallberg <work@hallberg.kim>
 * Created: 2020-04-11 03:46
 */
public class Common {
    public static String NO_PERMISSION = "&cYou don't have permission to use this command!";
    public static String TIME_CHANGED = "&aTime set to {time}!";

    public static void tell(final CommandSender sender, final String... messages) {
        Arrays.stream(messages).map(Common::translate).forEach(sender::sendMessage);
    }

    private static String translate(final String value) {
        return ChatColor.translateAlternateColorCodes('&', value);
    }

}
