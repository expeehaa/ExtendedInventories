package de.expeehaa.bukkit.extendedinventories;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.plugin.java.JavaPlugin;

public class ExtendedInventories extends JavaPlugin {
	
	public static ExtendedInventories instance;
	
	public List<InventorySave> inventorysaves = new ArrayList<InventorySave>();
	
	@Override
	public void onEnable() {
		instance = this;
		reloadCfg();
		
		
	}
	
	
	@SuppressWarnings("unchecked")
	private void reloadCfg(){
		this.reloadConfig();
		
		this.getConfig().addDefault("config.maxPlayerSavedInventories", 5);
		this.getConfig().addDefault("config.restrictionForOP", false);
		
		if(this.getConfig().contains("inventories") && this.getConfig().isList("inventories")){
			try {
				inventorysaves = (List<InventorySave>) this.getConfig().getList("inventories");
			} catch (Exception e) {
				this.getLogger().severe("The following problems occured while trying to load saved inventories!\n" + e.getMessage());
			}
		}
	}
}
