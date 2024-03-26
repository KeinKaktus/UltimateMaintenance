package de.kaktus.main.commands;

import de.kaktus.main.util.Construct;
import de.kaktus.main.util.FileManager;
import de.kaktus.main.util.Messages;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MainCMD implements CommandExecutor {

    public static FileManager fm;

    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        if (!(s instanceof Player)){
            return true;
        }
        Player p = (Player)s;
        Construct construct = new Construct();
        fm = new FileManager();
        if (p.hasPermission("maintenance.cmd")){
            if (!Messages.isActive){
                fm.cfg.set("is active", true);
                fm.savecfg();
                p.sendMessage(Messages.active.replaceAll("&", "§"));
                for (Player all : Bukkit.getOnlinePlayers()){
                    if (!all.hasPermission("maintenance.bypass")){
                        all.kickPlayer(Messages.kickMsg.replaceAll("&", "§"));
                    }
                }
            }else{
                fm.cfg.set("is active", false);
                fm.savecfg();
                p.sendMessage(Messages.deactivate.replaceAll("&", "§"));
            }
        }else{
            p.sendMessage(Messages.noPerm.replaceAll("&", "§"));
        }
        return false;
    }
}
