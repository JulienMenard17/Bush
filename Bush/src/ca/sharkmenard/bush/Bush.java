package ca.sharkmenard.bush;

import org.bukkit.inventory.ItemStack;

public enum Bush {
	Xp(),
	Diamond();
	
	Bush() {
	}
	
	public ItemStack getItemStack() {
		switch(this){
		case Xp:
			return new BushXp().getItemStack();
		case Diamond:
			return new BushDiamond().getItemStack();
		default:
			return null;
		}
	}
	
	public int getTime() {
		switch(this){
		case Xp:
			return new BushXp().getTime();
		case Diamond:
			return new BushDiamond().getTime();
		default:
			return 0;
		}
	}
	
	public ItemStack getBlock() {
		switch(this){
		case Xp:
			return new BushXp().getBlock();
		case Diamond:
			return new BushDiamond().getBlock();
		default:
			return null;
		}
	}
	
	public String toString() {
		switch (this) {
		case Xp:
			return "xp";
		case Diamond:
			return "diamond";
		default:
			return null;
		}
	}
}
