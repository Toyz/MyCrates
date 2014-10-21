package com.toyz.MysteryCrates.Util;

import org.bukkit.ChatColor;

import com.toyz.MysteryCrates.MysteryCrates;

public class Messages {
	public static String Format(String Message){
		Message = MysteryCrates.plugin.getConfig().getString("prefix") + " " + Message;
		Message = ChatColor.translateAlternateColorCodes('&', Message);
		
		return Message;
	}
}
