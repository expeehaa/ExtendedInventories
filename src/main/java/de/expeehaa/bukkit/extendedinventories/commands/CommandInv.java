package de.expeehaa.bukkit.extendedinventories.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandInv implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String lbl, String[] args) {
		
		if(!sender.hasPermission("extendedinventories.saveinventories")){
			sender.sendMessage(ChatColor.RED + "You do not have permission to execute this command!");
			return true;
		}
		
		Player p = null;
		if(sender instanceof Player) p = (Player) sender;
		
		if(args.length == 0){
			
		}
		
		return true;
	}

}
