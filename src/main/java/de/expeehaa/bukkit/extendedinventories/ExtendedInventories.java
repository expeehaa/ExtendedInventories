package de.expeehaa.bukkit.extendedinventories;

import org.bukkit.plugin.java.JavaPlugin;

import de.expeehaa.bukkit.extendedinventories.commands.CommandInv;

public class ExtendedInventories extends JavaPlugin {
	
	public static ExtendedInventories instance;
	
	public static Configuration config;

	//called when plugin is being enabled
	@Override
	public void onEnable() {
		instance = this;
		config = new Configuration();
		config.reloadInvSaves();
		
		this.getCommand("inv").setExecutor(new CommandInv());
	}
}
