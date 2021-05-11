package ca.sharkmenard.bush;

import java.util.ArrayList;

import org.bukkit.inventory.ItemStack;

public class BushLists {
	
	ArrayList<ItemStack> itemList;
	ArrayList<ItemStack> blockList;
	ArrayList<Bush> bushList;
	
	public BushLists() {
		itemList = new ArrayList<ItemStack>();
		blockList = new ArrayList<ItemStack>();
		bushList = new ArrayList<Bush>();
		setupLists(Bush.Xp);
		setupLists(Bush.Diamond);
	}
	
	private void setupLists(Bush bush) {
		bushList.add(bush);
		itemList.add(bush.getItemStack());
		blockList.add(bush.getBlock());
	}
	
	public ArrayList<ItemStack> getBlockList() {
		return blockList;
	}
	
	public ArrayList<ItemStack> getItemList() {
		return itemList;
	}
	
	public ArrayList<Bush> getBushList() {
		return bushList;
	}
	

}
