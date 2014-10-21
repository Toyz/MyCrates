package com.toyz.MysteryCrates.BaseCommand.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import com.toyz.MysteryCrates.MysteryCrates;
import com.toyz.MysteryCrates.BaseCommand.BaseCommand;
import com.toyz.MysteryCrates.BaseCommand.Handler.IssueCommands;
import com.toyz.MysteryCrates.Models.Rewards;
import com.toyz.MysteryCrates.Util.Messages;
import com.toyz.MysteryCrates.Util.UserAddon;

public class CrateOpen extends BaseCommand {
	private static IssueCommands _cmd = null;
	private static String _Permission = "crate.open";
	private static int _minArgs = 1;
	private static String _invaidUsage = "Invalid Args - usage:";
	
	public static Boolean Fire(IssueCommands info){
		_cmd = info;
		if(_cmd.isPlayer()){
			Trigger();
		}else{
			sendMessage(Messages.Format("You can only run this frm in-game"));
		}
		return true;
	}
	
	private static void Trigger(){
		if(_cmd.isPlayer()){
			if(!_cmd.getPlayer().hasPermission(_Permission)){
				sendMessage(Messages.Format("&4You do not have permission to use this command"));
				return;
			}
		}
		
		Rewards reward = UserAddon.getRandomRewards(MysteryCrates.UserRewards);
		
		int Balance = MysteryCrates.UserTokens.getConfig().getInt(_cmd.getPlayer().getUniqueId().toString());
		
		if(Balance < MysteryCrates.plugin.getConfig().getInt("cost")){
			sendMessage(Messages.Format("&4You cannot open a crate"));
			return;
		}
		
		Balance = Balance - MysteryCrates.plugin.getConfig().getInt("cost");
		MysteryCrates.UserTokens.getConfig().set(_cmd.getPlayer().getUniqueId().toString(), Balance);
		
		for (String cmd : reward.getCommands()){
			 if (cmd.indexOf('/') == 0) {
				 cmd = cmd.substring(1);
			 }
			 
			 cmd = cmd.replace("%player", _cmd.getPlayer().getName());
			 Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), ChatColor.translateAlternateColorCodes('&', cmd));
		 }
	}
}
