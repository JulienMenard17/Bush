package ca.sharkmenard.bush;

import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.configuration.file.FileConfiguration;

public class DataHandler {
	
	private FileConfiguration dataConfig;
	private ArrayList<UUID> idList;
	private ArrayList<BushData> dataList;
	
	public DataHandler() {
		getDataConfig();
		updateDataList();
	}
	
	public void getDataConfig() {
		 dataConfig = Main.getInstance().getDataConfiguration();
	}
	
	public void updateDataList() {
		idList = new ArrayList<UUID>();
		dataList = new ArrayList<BushData>();
	}
	
	public ArrayList<BushData> getDataList() {
		return this.dataList;
	}
	
	public void newData(BushData bushData) {
		dataList.add(bushData);
	}
	
	public ArrayList<UUID> getDataIds(BushData bushData) {
		return getBushData(bushData).getUUIDList();
	}
	
	public int getPhase(BushData bushData) {
		return getBushData(bushData).getPhase();
		
	}
	
	public BushData getBushData(BushData bushData) {
		return getDataList().get(getDataList().indexOf(bushData));
	}
	
	public void deleteData(BushData bushData) {
		dataList.remove(bushData);
	}
	
	
	
	
	
}
