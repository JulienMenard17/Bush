package ca.sharkmenard.bush;

import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

public class EntityGeneration {
	
	
	public EntityGeneration(BushData bushData) {
		if(bushData.getPhase() == 0) {
			if(!bushData.getUUIDList().isEmpty() || bushData.getUUIDList().size() != 0) {
				for ( UUID uuid : bushData.getUUIDList()) {
					for(Entity ent : bushData.getLocation().getWorld().getNearbyEntities(bushData.getLocation(), 2, 2, 2)) {
						if(ent.getUniqueId().equals(uuid)) ent.remove();
					}
				}
				bushData.setUUIDList(new ArrayList<UUID>());
			}
		}else if(bushData.getPhase() == 1) {
			if(bushData.getUUIDList().isEmpty() || bushData.getUUIDList().size() == 0) {
				for ( UUID uuid : bushData.getUUIDList()) {
					for(Entity ent : bushData.getLocation().getWorld().getNearbyEntities(bushData.getLocation(), 2, 2, 2)) {
						if(ent.getUniqueId().equals(uuid)) ent.remove();
					}
				}
				ArrayList<UUID> id = new ArrayList<UUID>();
				Location loc = new Location(bushData.getLocation().getWorld(), bushData.getLocation().getX(), bushData.getLocation().getY(), bushData.getLocation().getZ());

				loc.setX(loc.getX() + 0.5);
				loc.setZ(loc.getZ() + 0.5);
				
				loc.setY(loc.getY() - 0.8);
				ArmorStand armor3 = (ArmorStand) bushData.getLocation().getWorld().spawnEntity(loc, EntityType.ARMOR_STAND);
				loc.setY(loc.getY() + 0.4);
				ArmorStand armor2 = (ArmorStand) bushData.getLocation().getWorld().spawnEntity(loc, EntityType.ARMOR_STAND);
				loc.setY(loc.getY() + 0.4);
				ArmorStand armor1 = (ArmorStand) bushData.getLocation().getWorld().spawnEntity(loc, EntityType.ARMOR_STAND);
				
				armor1.setHelmet(bushData.getBushType().getItemStack());
				armor1.setVisible(false);
				armor1.setGravity(false);
				armor1.setCanPickupItems(false);
				armor1.setMarker(true);
				armor1.setSmall(true);
				
				armor2.setHelmet(bushData.getBushType().getItemStack());
				armor2.setVisible(false);
				armor2.setGravity(false);
				armor2.setCanPickupItems(false);
				armor2.setMarker(true);
				armor2.setSmall(true);

				armor3.setHelmet(bushData.getBushType().getItemStack());
				armor3.setVisible(false);
				armor3.setGravity(false);
				armor3.setCanPickupItems(false);
				armor3.setMarker(true);
				armor3.setSmall(true);
				
				id.add(armor1.getUniqueId());
				id.add(armor2.getUniqueId());
				id.add(armor3.getUniqueId());
				
				bushData.setUUIDList(id);
				
			}
			
		}else if(bushData.getPhase() == 2){
			if(!bushData.getUUIDList().isEmpty() || bushData.getUUIDList().size() != 0) {
				for ( UUID uuid : bushData.getUUIDList()) {
					for(Entity ent : bushData.getLocation().getWorld().getNearbyEntities(bushData.getLocation(), 2, 2, 2)) {
						if(ent.getUniqueId().equals(uuid)) ent.remove();
					}
				}
			}
				ArrayList<UUID> id = new ArrayList<UUID>();
				Location loc = new Location(bushData.getLocation().getWorld(), bushData.getLocation().getX(), bushData.getLocation().getY(), bushData.getLocation().getZ());
				loc.setX(loc.getX() + 0.5);
				loc.setZ(loc.getZ() + 0.5);
				
				loc.setY(loc.getY() - 1.4);
				ArmorStand armor2 = (ArmorStand) bushData.getLocation().getWorld().spawnEntity(loc, EntityType.ARMOR_STAND);
				loc.setY(loc.getY() + 0.6);
				ArmorStand armor1 = (ArmorStand) bushData.getLocation().getWorld().spawnEntity(loc, EntityType.ARMOR_STAND);
				
				armor1.setHelmet(bushData.getBushType().getItemStack());
				armor1.setVisible(false);
				armor1.setGravity(false);
				armor1.setCanPickupItems(false);
				armor1.setMarker(true);

				
				armor2.setHelmet(bushData.getBushType().getItemStack());
				armor2.setVisible(false);
				armor2.setGravity(false);
				armor2.setCanPickupItems(false);
				armor2.setMarker(true);
				
				id.add(armor1.getUniqueId());
				id.add(armor2.getUniqueId());

				bushData.setUUIDList(id);
				
		}
	}

}
