package ca.sharkmenard.bush;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;

public class DataRegister {
	
	private ArrayList<String> dataList;
	
	public DataRegister() {
		dataList = new ArrayList<String>(Main.getInstance().getDataConfiguration().getStringList("data"));
		register();
	}
	
	private void register() {
		for (int i = 0; i < dataList.size(); i++) {
			String[] strList = dataList.get(i).split(":");
			String bushtype = strList[4];
			Bush bush;
			switch (bushtype) {
			case "xp":
				bush = Bush.Xp;
				break;
			case "diamond":
				bush = Bush.Diamond;
				break;
			default:
				bush = null;
				break;
			}
			Location loc = new Location(Bukkit.getWorld(strList[0]), Double.parseDouble(strList[1]), Double.parseDouble(strList[2]), Double.parseDouble(strList[3]));
			BushData newData = new BushData(bush, loc, Integer.parseInt(strList[5]), true);
			
		}
	}

	
	
}
