package ca.sharkmenard.bush;

import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.entity.Entity;

public class DataCompiler {
	
	private ArrayList<String> dataList;
	private String data;
	
	public DataCompiler() {
		dataList = new ArrayList<String>();
		for(BushData bushData : Main.getInstance().getDataHandler().getDataList()) {
			for(Entity entity : bushData.getLocation().getChunk().getEntities()) {
				for(UUID id : bushData.getUUIDList()) {
					if(entity.getUniqueId().equals(id)) {
						entity.remove();
					}
				}
			}
			
			data = bushData.getLocation().getWorld().getName() + ":" + bushData.getLocation().getX() + ":" +  bushData.getLocation().getBlockY() + ":" + bushData.getLocation().getZ() + ":" + bushData.getBushType().toString() + ":" + bushData.getPhase();
			dataList.add(data);
		}
		Main.getInstance().getDataConfiguration().set("data", dataList);
		Main.getInstance().saveData();
	}

}
