package com.bghddevelopment.daynight.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;
import com.bghddevelopment.daynight.DayAndNight;
import com.bghddevelopment.daynight.utilities.Color;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandAlias("night")
@Description("Night Command.")
@CommandPermission("dayandnight.night")
@Conditions("noconsole")
public class NewNightCommand extends BaseCommand {

    @Dependency
    private DayAndNight plugin;

    @Default
    public void onDefault(CommandSender sender, String[] args) {
        Player player = (Player) sender;
        player.getWorld().setTime(13000L);
        Color.tell(player, Color.TIME_CHANGED.replace("{time}", "Night"));
    }
}
