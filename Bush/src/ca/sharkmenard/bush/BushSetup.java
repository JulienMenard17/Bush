package ca.sharkmenard.bush;

import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;



public class BushSetup implements Listener {
	
	private ArrayList<UUID> uuid = new ArrayList<UUID>();
	
	@EventHandler
	public void bushPlaced(BlockPlaceEvent e) {
		if(e.isCancelled()) {
			return;
		}
		Player p = e.getPlayer();
		if(e.getBlock() != null) {
			if(e.getItemInHand() != null && e.getItemInHand().hasItemMeta()) {
				ItemStack item = new ItemStack(e.getItemInHand());
				item.setAmount(1);
				BushLists bushLists = new BushLists();
				for(ItemStack items : bushLists.getItemList()) {
						if(item.equals(items)) {
							if(e.getBlock().getType().equals(items.getType())) {
								e.getBlock().setType(bushLists.getBlockList().get(bushLists.getItemList().indexOf(items)).getType());
							BushData bush = new BushData(bushLists.getBushList().get(bushLists.getItemList().indexOf(items)), e.getBlock().getLocation());
							}
						}
					}
					
				}
				
			}
	}
	
	@EventHandler
	public void changingPhase(PlayerInteractEvent e) {
		if(e.getPlayer() != null && e.getClickedBlock() != null || e.getAction() != null) {
			if(e.getAction().equals(Action.RIGHT_CLICK_BLOCK)  && e.getClickedBlock().getType().equals(Material.FENCE)) {
				for(BushData bush : Main.getInstance().getDataHandler().getDataList()) {
					if(bush.getLocation().equals(e.getClickedBlock().getLocation())) {
						if(bush.getPhase() == 2) {
							bush.updatePhase();
						}


					}
				}
			}
		}
	}
	@EventHandler
	public void breakingBush(BlockBreakEvent e) {
		if(e.getPlayer() != null || e.getBlock() != null) {
			if(e.getBlock().getType().equals(Material.FENCE)) {
				ArrayList<BushData> removeList = new ArrayList<BushData>();
				for(BushData bush : Main.getInstance().getDataHandler().getDataList()) {
					if(bush.getLocation().equals(e.getBlock().getLocation())) {
						removeList.add(bush);
						e.setCancelled(true);
						e.getBlock().setType(Material.AIR);
						if(!e.getPlayer().getGameMode().equals(GameMode.CREATIVE))
						e.getBlock().getWorld().dropItem(e.getBlock().getLocation(), bush.getBushType().getItemStack());
					}
				}
				for(BushData bush : removeList) {
					bush.remove();
					Main.getInstance().getBushRunnable().removeInstance(bush);
				}
			}
		}
	}	
}
