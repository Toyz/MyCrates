package com.toyz.MysteryCrates.Models;

import java.util.List;

public class Rewards {
	private List<String> Commands = null;
	
	public Rewards(List<String> cmds){
		this.Commands = cmds;
	}
	
	public List<String> getCommands() {
		return Commands;
	}
}
