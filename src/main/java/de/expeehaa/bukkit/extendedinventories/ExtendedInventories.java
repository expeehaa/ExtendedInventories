package de.expeehaa.bukkit.extendedinventories;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.plugin.java.JavaPlugin;

public class ExtendedInventories extends JavaPlugin {
	
	public static ExtendedInventories instance;
	
	public static Configuration config;
	
	private List<InventorySave> inventorysaves = new ArrayList<InventorySave>();
	
	/**
	 * @return the inventorysaves
	 */
	public List<InventorySave> getInventorysaves() {
		return inventorysaves;
	}
	
	/**
	 * @param inventorysaves the inventorysaves to set
	 */
	public void setInventorysaves(List<InventorySave> inventorysaves) {
		this.inventorysaves = inventorysaves;
	}


	//called when plugin is being enabled
	@Override
	public void onEnable() {
		instance = this;
		config = new Configuration();
		reloadInvSaves(false);
		
	}
	
	
	
	
	@SuppressWarnings("unchecked")
	private void reloadInvSaves(boolean save){
		
		if (save) {
			this.getConfig().set("inventories", getInventorysaves());
		}
		
		if (this.getConfig().contains("inventories") && this.getConfig().isList("inventories")) {
			try {
				setInventorysaves((List<InventorySave>) this.getConfig().getList("inventories"));
			} catch (Exception e) {
				this.getLogger().severe("The following problems occured while trying to load saved inventories!\n" + e.getMessage());
			}
		}
	}
}
