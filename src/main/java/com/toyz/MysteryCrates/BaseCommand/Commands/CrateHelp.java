package com.toyz.MysteryCrates.BaseCommand.Commands;

import com.toyz.MysteryCrates.MysteryCrates;
import com.toyz.MysteryCrates.BaseCommand.BaseCommand;
import com.toyz.MysteryCrates.BaseCommand.Handler.IssueCommands;
import com.toyz.MysteryCrates.Util.Messages;

public class CrateHelp extends BaseCommand {
	private static IssueCommands _cmd = null;
	private static String _Permission = "crate.help";
	private static int _minArgs = 1;
	private static String _invaidUsage = "Invalid Args - usage:";
	
	public static Boolean Fire(IssueCommands info){
		_cmd = info;
		if(_cmd.isPlayer()){
			Trigger();
		}else{
			sendMessage(Messages.Format("You can only run this from in-game"));
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
		
		sendMessage(Messages.Format("&2/crate give username amount&f - Username is player and Amount is the number"));
		sendMessage(Messages.Format("&2/crate bal&f - Shows the users balance"));
		sendMessage(Messages.Format("&2/crate open&f - Opens up the users crate"));
		sendMessage(Messages.Format("&2/crate help&f - Shows this help menu"));
		sendMessage(Messages.Format("&2/crate reload&f - This allows you to reload the plugin"));
	}
}
