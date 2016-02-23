package de.expeehaa.bukkit.extendedinventories;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class InventorySave {
	
	public String creator;
	
	public ItemStack[] items;
	
	public ItemStack[] armor;
	
	public InventorySave(String creator, ItemStack[] items, ItemStack[] armor) {
		this.creator = creator;
		this.items = items;
		this.armor = armor;
	}
	
	
	public void replacePlayerInventory(Player p){
		try {
			p.getInventory().setContents(items);
			p.getInventory().setArmorContents(armor);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static InventorySave getInventorySave(Player p, String creator){
		if(p == null) return null;
		
		ItemStack[] content = p.getInventory().getContents();
		ItemStack[] armorcontent = p.getInventory().getArmorContents();
		
		InventorySave invsave = new InventorySave(creator, content, armorcontent);
		return invsave;
	}
}
