package de.kaktus.main;

import de.kaktus.main.commands.MainCMD;
import de.kaktus.main.event.Login;
import de.kaktus.main.event.ServerPing;
import de.kaktus.main.util.FileManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private static Main instance;
    public static FileManager fm;

    @Override
    public void onEnable() {
        instance = this;
        fm = new FileManager();
        fm.savecfg();
        fm.getConfig();
        getCommand("maintenance").setExecutor(new MainCMD());
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new Login(), this);
        pm.registerEvents(new ServerPing(), this);

        Bukkit.getConsoleSender().sendMessage("§aUltimateMaintenance Plugin load successfully!");
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage("§cUltimateMaintenance Plugin disabled successfully!");
    }

    public static Main getInstance() {
        return instance;
    }
}
