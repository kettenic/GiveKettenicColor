package me.kettenic.giveketteniccolor;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import java.util.UUID;

public final class GiveKettenicColor extends JavaPlugin implements Listener {


    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        Scoreboard board = Bukkit.getScoreboardManager().getMainScoreboard();
        Team team1 = board.getTeam("kettenic");
        Team team2 = board.getTeam("losers");
        if (team1 == null) {
            Bukkit.getScoreboardManager().getMainScoreboard().registerNewTeam("kettenic").setColor(ChatColor.DARK_AQUA);
            }
        if (team2 == null) {
            Bukkit.getScoreboardManager().getMainScoreboard().registerNewTeam("losers").setColor(ChatColor.YELLOW);
        }

    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        setPrefix(event.getPlayer());
    }

    private void setPrefix (Player p) {
            Scoreboard board = Bukkit.getScoreboardManager().getMainScoreboard();
            String team = "";
            String uuid = "283041bc-5bab-4398-bbf9-4fce9bf490e1";
            if (p.getUniqueId().equals(UUID.fromString(uuid))) {
                team = "kettenic";
            }
            else {
                team = "losers";
            }
            board.getTeam("" + team).addEntry(p.getPlayer().getName());
    }


    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
