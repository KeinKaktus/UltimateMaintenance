package de.kaktus.main.event;

import de.kaktus.main.util.Messages;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

public class Login implements Listener {

    @EventHandler
    public void onLogin(PlayerLoginEvent e){
        Player p = e.getPlayer();

        if (Messages.isActive){
            if (!p.hasPermission("maintenance.bypass")){
                e.disallow(PlayerLoginEvent.Result.KICK_OTHER, Messages.kickMsg.replaceAll("&", "§"));
            }
        }
    }
}
