package com.toyz.MysteryCrates;

import java.util.List;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import com.toyz.MysteryCrates.BaseCommand.BaseCommand;
import com.toyz.MysteryCrates.Models.Rewards;
import com.toyz.MysteryCrates.Util.ConfigAccessor;
import com.toyz.MysteryCrates.Util.CreateRewards;

public class MysteryCrates extends JavaPlugin {
	public static ConfigAccessor UserTokens = null;
	
	public static Logger logger = null;
	public static ConsoleCommandSender console = null;
	public static MysteryCrates plugin = null;
	public static List<Rewards> UserRewards = null;
	
	//Enable plugin
	public void onEnable() {
		console = Bukkit.getServer().getConsoleSender();
		logger = this.getLogger();
		plugin = this;
		
		//save our config
		this.saveDefaultConfig();
		UserTokens = new ConfigAccessor(this, "Balance.yml");
		UserTokens.saveDefaultConfig();
		
		//Load are rewards
		UserRewards = CreateRewards.Build();
		
		//Load Our Commands
		getCommand("crate").setExecutor(new BaseCommand());
		
		//Start the auto saving
				Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable(){
					@Override
					public void run() {
						MysteryCrates.UserTokens.saveConfig();
					}
				}, 800L, 800L);
	}
	
	//Disable Plugin
	public void onDisable() {
		UserTokens.saveConfig();
		this.saveConfig();
	}
}
