package ca.sharkmenard.bush;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class BushDiamond {
	
	
	private ItemStack item;
	private ItemMeta meta;
	private ItemStack block;
	private int time;
	
	public BushDiamond() {
		ItemStack item;
		ItemMeta meta;
		item = new ItemStack(Material.DIAMOND_ORE);
		meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.AQUA + "BushDiams");
		meta.addEnchant(Enchantment.DURABILITY, 1, false);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(meta);
		this.item = item;
		this.meta = meta;
		
		ItemStack block = new ItemStack(Material.FENCE);
		this.block = block;
		time = 5;
		
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
