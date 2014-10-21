package com.toyz.MysteryCrates.BaseCommand.Commands;

import com.toyz.MysteryCrates.MysteryCrates;
import com.toyz.MysteryCrates.BaseCommand.BaseCommand;
import com.toyz.MysteryCrates.BaseCommand.Handler.IssueCommands;
import com.toyz.MysteryCrates.Util.CreateRewards;
import com.toyz.MysteryCrates.Util.Messages;

public class CrateReload extends BaseCommand{
	private static IssueCommands _cmd = null;
	private static String _Permission = "crate.reload";
	private static int _minArgs = 1;
	private static String _invaidUsage = "Invalid Args - usage:";
	
	public static Boolean Fire(IssueCommands info){
		_cmd = info;
		Trigger();
		return true;
	}
	
	private static void Trigger(){
		if(_cmd.isPlayer()){
			if(!_cmd.getPlayer().hasPermission(_Permission)){
				sendMessage(Messages.Format("&4You do not have permission to use this command"));
				return;
			}
		}
		
		MysteryCrates.plugin.saveConfig();
		MysteryCrates.plugin.reloadConfig();
		MysteryCrates.UserTokens.saveConfig();
		MysteryCrates.UserTokens.reloadConfig();
		MysteryCrates.UserRewards = CreateRewards.Build();
		sendMessage(Messages.Format("&4All Configs has been reloaded"));

	}
}
