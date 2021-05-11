package ca.sharkmenard.bush;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	private static Main m;
	private File dataFile;
	private FileConfiguration data;
	private DataHandler dataHandler;
	private BushSetup bushSetup;
	private BushRunnable bushRunnable;
	private DataRegister dataRegister;

	
	@Override
	public void onEnable() {
		m = this;
		createDataConfig();
		dataHandler = new DataHandler();
		bushRunnable = new BushRunnable();
		dataRegister = new DataRegister();
		Bukkit.getPluginManager().registerEvents(bushSetup = new BushSetup(), (Plugin)this);
		getCommand("givebush").setExecutor(new CommandExecutor());
	}
	
	@Override
	public void onDisable() {
		dataCompiler();
	}
	
	
	public static Main getInstance() {
		return m;
	}
	
	public FileConfiguration getDataConfiguration() {
		return this.data;
	}
	
	public void createDataConfig() {
		dataFile = new File(getDataFolder(), "data.yml");
		if(!dataFile.exists()) {
			dataFile.getParentFile().mkdirs();
			saveResource("data.yml", false);
		}

		data = new YamlConfiguration();
		try {
			data.load(dataFile);
		} catch (IOException | InvalidConfigurationException e ) {
			e.printStackTrace();
		}
	}
	
	public void saveData() {
	    try {
	            data.save(dataFile);
	        } catch (IOException e) {
	            this.getLogger().warning("Unable to save " + "data.yml"); // shouldn't really happen, but save throws the exception
	        }
	}
	
	public DataHandler getDataHandler() {
		return this.dataHandler;
	}
	
	public BushRunnable getBushRunnable() {
		return this.bushRunnable;
	}
	
	public String locToStr(Location loc) {
		String locToStr = loc.getWorld() + ":" + loc.getBlockX() + ":" + loc.getBlockY() + ":"+ loc.getBlockZ();
		return locToStr;
	}
	

	private ArrayList<String> dataList;
	private String dataStr;
	
	public void dataCompiler() {
		dataList = new ArrayList<String>();
		for(BushData bushData : getDataHandler().getDataList()) {
			for(Entity entity : bushData.getLocation().getChunk().getEntities()) {
				for(UUID id : bushData.getUUIDList()) {
					if(entity.getUniqueId().equals(id)) {
						entity.remove();
					}
				}
			}
			
			dataStr = bushData.getLocation().getWorld().getName() + ":" + bushData.getLocation().getX() + ":" +  bushData.getLocation().getBlockY() + ":" + bushData.getLocation().getZ() + ":" + bushData.getBushType().toString() + ":" + bushData.getPhase();
			dataList.add(dataStr);
		}
		Main.getInstance().getDataConfiguration().set("data", dataList);
		Main.getInstance().saveData();
	}
}
