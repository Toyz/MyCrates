package com.toyz.MysteryCrates.BaseCommand;

import org.bukkit.command.*;

import com.toyz.MysteryCrates.BaseCommand.Commands.*;
import com.toyz.MysteryCrates.BaseCommand.Handler.IssueCommands;

public class BaseCommand implements CommandExecutor {
	static IssueCommands Info;
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		Info = new IssueCommands(sender, cmd.getName(), args, cmd);
		
		if(cmd.getName().equalsIgnoreCase("crate")){
			if(args.length >= 1){
				if(args[0].equalsIgnoreCase("give")){
					CrateGive.Fire(Info);
				}else if(args[0].equalsIgnoreCase("bal") || args[0].equalsIgnoreCase("balance")){
					//System.out.println(Info.getArg(0));
					CrateBal.Fire(Info);
				}else if(args[0].equalsIgnoreCase("reload")){
					//System.out.println(Info.getArg(0));
					CrateReload.Fire(Info);
				}else if(args[0].equalsIgnoreCase("open")){
					//System.out.println(Info.getArg(0));
					CrateOpen.Fire(Info);
				}else if(args[0].equalsIgnoreCase("help") || args[0].equalsIgnoreCase("?")){
					//System.out.println(Info.getArg(0));
					CrateHelp.Fire(Info);
				}
			}else{
                CrateOpen.Fire(Info);
            }
		}
		
		return false;
	}
	
	protected static void sendMessage(String Message){
		if(Info.isPlayer()){
			Info.getPlayer().sendMessage(Message);
		}
		if(Info.isConsole()){
			Info.getConsole().sendMessage(Message);
		}
	}
}
