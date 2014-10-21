package com.toyz.MysteryCrates.Util;

import java.util.*;

import org.bukkit.configuration.ConfigurationSection;

import com.toyz.MysteryCrates.MysteryCrates;
import com.toyz.MysteryCrates.Models.Rewards;

public class CreateRewards {
	public static List<Rewards> Build(){
		List<Rewards> rwd = new ArrayList<Rewards>();
		
		ConfigurationSection rew = MysteryCrates.plugin.getConfig().getConfigurationSection("rewards"); 
		for(String key : rew.getKeys(false)){
			ConfigurationSection r = rew.getConfigurationSection(key);
			
			rwd.add(new Rewards(r.getStringList("commands")));
		}
		
		return rwd;
	}
}
