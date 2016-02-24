package de.expeehaa.bukkit.extendedinventories;

import java.util.UUID;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class InventorySave {
	
	public UUID creator;
	
	public String name;
	
	public ItemStack[] items;
	
	public ItemStack[] armor;
	
	public InventorySave(UUID creator, String name, ItemStack[] items, ItemStack[] armor) {
		this.creator = creator;
		this.name = name;
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
	
	public static InventorySave getInventorySave(Player p, String name){
		if(p == null) return null;
		
		ItemStack[] content = p.getInventory().getContents();
		ItemStack[] armorcontent = p.getInventory().getArmorContents();
		
		InventorySave invsave = new InventorySave(p.getUniqueId(), name, content, armorcontent);
		return invsave;
	}
}
