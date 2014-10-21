package com.toyz.MysteryCrates.BaseCommand.Commands;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import com.toyz.MysteryCrates.MysteryCrates;
import com.toyz.MysteryCrates.BaseCommand.BaseCommand;
import com.toyz.MysteryCrates.BaseCommand.Handler.IssueCommands;
import com.toyz.MysteryCrates.Util.Messages;

public class CrateGive extends BaseCommand {
	private static IssueCommands _cmd = null;
	private static String _Permission = "crate.open";
	private static int _minArgs = 3;
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
		
		if(_cmd.getArgs().length < _minArgs){
			sendMessage(Messages.Format(_invaidUsage + " /crate give username amount"));
			return;
		}
		
		int giving = 0;
		try{
			giving = Integer.parseInt(_cmd.getArg(2));
		}catch (Exception e) {
			sendMessage(Messages.Format("Amount must be a number"));
			return;
		}
		
		if(giving <= 0){
			sendMessage(Messages.Format("Amount must be more then 0"));
			return;
		}
		
		Player Online = Bukkit.getPlayer(_cmd.getArg(1));
		
		if(Online == null){
			sendMessage(Messages.Format("Player must be online in order to give crates to"));
			return;
		}
		
		int Current = MysteryCrates.UserTokens.getConfig().getInt(Online.getUniqueId().toString());
		int NewAmount = Current + giving;
		
		MysteryCrates.UserTokens.getConfig().set(Online.getUniqueId().toString(), NewAmount);
		Online.sendMessage(Messages.Format("You were giving &2" + giving + " &fputting your balance to &2" + NewAmount));
	}
}
