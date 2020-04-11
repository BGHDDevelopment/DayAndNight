package me.noodles.dayandnight.commands;

import me.noodles.dayandnight.utilities.Common;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import java.util.Collections;
import java.util.List;

/**
 * Author:  Kim (Thinkverse) Hallberg <work@hallberg.kim>
 * Created: 2020-04-11 03:44
 */
public final class DayCommand implements TabExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            final Player player = (Player) sender;

            if (player.hasPermission("dayandnight.day")) {
                player.getWorld().setTime(0L);

                Common.tell(player, Common.TIME_CHANGED.replace("{time}", "Day"));
            } else {
                Common.tell(player, Common.NO_PERMISSION);
            }

            return true;
        }

        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        return Collections.emptyList();
    }

}
