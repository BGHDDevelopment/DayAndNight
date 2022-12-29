package com.bghddevelopment.daynight.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;
import com.bghddevelopment.daynight.DayAndNight;
import com.bghddevelopment.daynight.utilities.Color;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandAlias("day")
@Description("Day Command.")
@CommandPermission("dayandnight.day")
@Conditions("noconsole")
public class NewDayCommand extends BaseCommand {

    @Dependency
    private DayAndNight plugin;

    @Default
    public void onDefault(CommandSender sender, String[] args) {
        Player player = (Player) sender;
        player.getWorld().setTime(0L);
        Color.tell(player, Color.TIME_CHANGED.replace("{time}", "Day"));
    }
}
