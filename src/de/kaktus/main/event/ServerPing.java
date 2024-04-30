package de.kaktus.main.event;

import de.kaktus.main.util.Messages;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public class ServerPing implements Listener {


    @EventHandler
    public void onPing(ServerListPingEvent e){
        if (Messages.isActive){
            if (Messages.mainMOTDActive){
                e.setMotd(Messages.motd.replaceAll("&", "§"));
            }
        }else{
            if (Messages.defaultMOTDActive){
                e.setMotd(Messages.defaultMOTD.replaceAll("&", "§"));
            }
        }
    }
}
