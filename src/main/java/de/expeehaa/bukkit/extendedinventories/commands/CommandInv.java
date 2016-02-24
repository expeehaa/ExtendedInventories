package de.expeehaa.bukkit.extendedinventories.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.expeehaa.bukkit.extendedinventories.Configuration;
import de.expeehaa.bukkit.extendedinventories.ExtendedInventories;
import de.expeehaa.bukkit.extendedinventories.InventorySave;

public class CommandInv implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String lbl, String[] args) {
		
		if(!sender.hasPermission("extendedinventories.saveinventories")){
			sender.sendMessage(ChatColor.RED + "You do not have permission to execute this command!");
			return true;
		}
		
		Player p = null;
		if(sender instanceof Player) p = (Player) sender;
		
		if(args.length < 1){
			sender.sendMessage(ChatColor.RED + "This command needs at least one argument!");
			return true;
		}
		
		switch (args[0]) {
		case "save":
			if(args.length == 1){
				if(p == null) {
					sender.sendMessage(ChatColor.RED + "You have to be a player to save your inventory!");
					return true;
				}
				else {
					int playerinvs = 0;
					
					for (InventorySave is : ExtendedInventories.config.getInventorysaves()) {
						if(is.creator.equals(p.getUniqueId())) playerinvs++;
					}
					
					if(!p.isOp() && playerinvs >= ExtendedInventories.config.getMaxPlayerSavedInventories()){
						sender.sendMessage(ChatColor.RED + "You have reached the limit of saved inventories!");
						return true;
					}
					
					InventorySave is = InventorySave.getInventorySave(p, p.getName());
					ExtendedInventories.config.getInventorysaves().add(is);
				}
				
			}
			break;

		default:
			sender.sendMessage(ChatColor.RED + "Unknown argument!");
			return true;
		}
		
		return true;
	}

}
