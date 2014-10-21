package com.toyz.MysteryCrates.Util;

import java.util.List;
import java.util.Random;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.toyz.MysteryCrates.Models.Rewards;

public class UserAddon {
	public static Boolean HasNeededSlots(int Slots, Player player){
		int open = 0;
		for (ItemStack item : player.getInventory().getContents()) {
            if(item == null) {
            	open++;
            }
        }  
		System.out.println(open + " - " + Slots);
		return open >= Slots;
	}
	
	public static Rewards getRandomRewards(List<Rewards> array) {
	    int rnd = new Random().nextInt(array.size());
	    return array.get(rnd);
	}
}
