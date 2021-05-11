package ca.sharkmenard.bush;

import org.bukkit.inventory.ItemStack;

public class BushGenerator {
	
	private ItemStack itemStack;
	
	public BushGenerator(Bush bush) {
		this(bush, 1);
		
	}
	public BushGenerator(Bush bush, int amount) {
		ItemStack itemStack = new ItemStack(bush.getItemStack());
		itemStack.setAmount(amount);
		this.itemStack = itemStack;
	}
	
	public ItemStack getItemStack() {
		return itemStack;
	}

}
