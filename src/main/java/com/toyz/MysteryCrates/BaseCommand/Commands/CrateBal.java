package com.toyz.MysteryCrates.BaseCommand.Commands;

import com.toyz.MysteryCrates.MysteryCrates;
import com.toyz.MysteryCrates.BaseCommand.BaseCommand;
import com.toyz.MysteryCrates.BaseCommand.Handler.IssueCommands;
import com.toyz.MysteryCrates.Util.Messages;

public class CrateBal extends BaseCommand {
	private static IssueCommands _cmd = null;
	private static String _Permission = "crate.balance";
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
		
		String balance = MysteryCrates.UserTokens.getConfig().getString(_cmd.getPlayer().getUniqueId().toString());
		sendMessage(Messages.Format("Current crate balance is &2" + balance));
	}
}
