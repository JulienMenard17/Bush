package ca.sharkmenard.bush;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class BushXp{
	private ItemStack item;
	private ItemMeta meta;
	private ItemStack block;
	private int time;
	
	public BushXp() {
		ItemStack item;
		ItemMeta meta;
		item = new ItemStack(Material.LEAVES);
		meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.DARK_PURPLE + "BushXp");
		meta.addEnchant(Enchantment.DURABILITY, 1, false);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(meta);
		this.item = item;
		this.meta = meta;
		
		ItemStack block = new ItemStack(Material.FENCE);
		this.block = block;
		time = 10;
		
	}
	
	public ItemStack getItemStack() {
		return item;
	}
	
	public ItemMeta getItemMeta() {
		return meta;
	}
	
	public ItemStack getBlock() {
		return this.block;
	}
	
	public int getTime() {
		return this.time;
	}
	
	
	

}
