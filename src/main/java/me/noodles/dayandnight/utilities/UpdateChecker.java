package me.noodles.dayandnight.utilities;

import me.noodles.dayandnight.DayAndNight;
import org.bukkit.Bukkit;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;
import java.util.function.Consumer;

public final class UpdateChecker {
    private final String URL = "https://api.spigotmc.org/legacy/update.php?resource=";

    private final DayAndNight plugin;
    private final int resourceId;

    public UpdateChecker(DayAndNight plugin, int resourceId) {
        this.resourceId = resourceId;
        this.plugin = plugin;
    }

    public void getLatestVersion(final Consumer<String> consumer) {
        Bukkit.getScheduler().runTaskAsynchronously(getPlugin(), () -> {
            try (InputStream inputStream = new URL(URL + getResourceId()).openStream(); Scanner scanner = new Scanner(inputStream)) {
                if (scanner.hasNext()) {
                    consumer.accept(scanner.next());
                }
            } catch (IOException exception) {
                getPlugin().getLogger().info("Cannot look for updates: " + exception.getMessage());
            }
        });
    }

    private DayAndNight getPlugin() {
        return plugin;
    }

    private int getResourceId() {
        return resourceId;
    }

}
