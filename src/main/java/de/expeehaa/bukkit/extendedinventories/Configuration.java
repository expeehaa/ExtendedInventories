package de.expeehaa.bukkit.extendedinventories;

import org.bukkit.configuration.file.FileConfiguration;

public class Configuration {
	
	public FileConfiguration config;
	
	//Fields saved in config.yml
	private int maxPlayerSavedInventories = 5;
	
	private boolean saverestrictionForOP = false;
	
	private boolean writeToFileOnConfigChanges = false;
	
	//Constructor
	public Configuration() {
		config = ExtendedInventories.instance.getConfig();
		reloadCfg();
	}

	//reloads the configuration
	public void reloadCfg(){
		ExtendedInventories.instance.reloadConfig();
		
		//set default values
		config.addDefault("config.maxPlayerSavedInventories", 5);
		config.addDefault("config.saverestrictionForOP", false);
		config.addDefault("config.writeToFileOnConfigChanges", false);
		
		//get values
		setMaxPlayerSavedInventories(config.getInt("config.maxPlayerSavedInventories"));
		setSaverestrictionForOP(config.getBoolean("config.saverestrictionForOP"));
		setWriteToFileOnConfigChanges(config.getBoolean("config.writeToFileOnConfigChanges"));
	}
	
	public void saveConfigToFile(){
		ExtendedInventories.instance.reloadConfig();
		
		//save values from fields
		config.set("config.maxPlayerSavedInventories", getMaxPlayerSavedInventories());
		config.set("config.saverestrictionForOP", isSaverestrictionForOP());
		config.set("config.writeToFileOnConfigChanges", isWriteToFileOnConfigChanges());
	}

	/**
	 * @return the maxPlayerSavedInventories
	 */
	public int getMaxPlayerSavedInventories() {
		return maxPlayerSavedInventories;
	}
	/**
	 * @param maxPlayerSavedInventories the maxPlayerSavedInventories to set
	 */
	public void setMaxPlayerSavedInventories(int maxPlayerSavedInventories) {
		this.maxPlayerSavedInventories = maxPlayerSavedInventories;
	}

	/**
	 * @return the saverestrictionForOP
	 */
	public boolean isSaverestrictionForOP() {
		return saverestrictionForOP;
	}
	 /**
	  * @param saverestrictionForOP the saverestrictionForOP to set
	 */
	public void setSaverestrictionForOP(boolean saverestrictionForOP) {
		this.saverestrictionForOP = saverestrictionForOP;
	}

	
	/**
	 * @return the writeToFileOnConfigChanges
	 */
	public boolean isWriteToFileOnConfigChanges() {
		return writeToFileOnConfigChanges;
	}

	/**
	 * @param writeToFileOnConfigChanges the writeToFileOnConfigChanges to set
	 */
	public void setWriteToFileOnConfigChanges(boolean writeToFileOnConfigChanges) {
		this.writeToFileOnConfigChanges = writeToFileOnConfigChanges;
	}

	
}
