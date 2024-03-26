package de.kaktus.main.util;

import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class FileManager {

    public File file = new File("plugins/UltimateMaintenance", "config.yml");
    public YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);

    public void getConfig(){
        if (cfg.getString("is active") == null){
            cfg.set("is active", Messages.isActive);
        }else{
            Messages.isActive = cfg.getBoolean("is active");
        }
        if (cfg.getString("No Permission") == null){
            cfg.set("No Permission", Messages.noPerm);
        }else{
            Messages.noPerm = cfg.getString("No Permission");
        }
        if (cfg.getString("Active") == null){
            cfg.set("Active", Messages.active);
        }else{
            Messages.active = cfg.getString("Active");
        }
        if (cfg.getString("Deactivated") == null){
            cfg.set("Deactivated", Messages.deactivate);
        }else{
            Messages.deactivate = cfg.getString("Deactivated");
        }
        if (cfg.getString("MOTD") == null){
            cfg.set("MOTD", Messages.motd);
        }else{
            Messages.motd = cfg.getString("MOTD");
        }
        if (cfg.getString("Kick Message") == null){
            cfg.set("Kick Message", Messages.kickMsg);
        }else{
            Messages.kickMsg = cfg.getString("Kick Message");
        }
        savecfg();
    }

    public void savecfg(){
        try {
            cfg.save(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
