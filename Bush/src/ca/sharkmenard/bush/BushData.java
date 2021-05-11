package ca.sharkmenard.bush;

import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.Location;

public class BushData {
	
	private Location loc;
	private Bush bushType;
	private ArrayList<UUID> uuidList;
	private int phase;

	public BushData(Bush bushType, Location loc) {
		this(bushType, loc, 0, new ArrayList<UUID>());
	}
	
	public BushData(Bush bushType, Location loc, int phase) {
		this(bushType, loc, phase, new ArrayList<UUID>());
	}
	
	public BushData(Bush bushType, Location loc, ArrayList<UUID> uuidList) {
		this(bushType, loc, 0, uuidList);
	}
	
	public BushData(Bush bushType, Location loc, int phase, ArrayList<UUID> uuidList) {
		this.bushType = bushType;
		this.loc = loc;
		this.uuidList = uuidList;
		this.phase = phase;
		Main.getInstance().getDataHandler().newData(this);
		updatePhase(false);
	}
	public BushData(Bush bushType, Location loc, int phase, boolean reinstall) {
		this.bushType = bushType;
		this.loc = loc;
		this.phase = phase;
		this.uuidList = new ArrayList<UUID>();
		if(reinstall) {
		Main.getInstance().getDataHandler().newData(this);
		reInstall();
		}
		
	}
	
	public Location getLocation() {
		return loc;
	}
	
	public Bush getBushType() {
		return bushType;
	}
	
	public ArrayList<UUID> getUUIDList() {
		return uuidList;
	}
	
	public int getPhase() {
		return phase;
	}

	public void setUUIDList(ArrayList<UUID> uuidList) {
		this.uuidList = uuidList;
	}
	
	public void setPhase(int phase) {
		this.phase = phase;
	}
	
	public void updatePhase() {
		updatePhase(true);
	}
	
	private void updatePhase(boolean nextPhase) {
		if(nextPhase) {
			if(this.getPhase() == 2) {
				this.setPhase(0);
			}else {
				this.setPhase(this.getPhase() + 1);
			}
		}
		if(this.getPhase() == 0) {
			Main.getInstance().getBushRunnable().addInstance(new BushInstance(this));
		}
		new EntityGeneration(this);
	}
	
	public void reInstall() {
		if(this.getPhase() != 2) {
			Main.getInstance().getBushRunnable().addInstance(new BushInstance(this));
		}
		new EntityGeneration(this);

	}
	
	public void remove() {
		setPhase(0);
		new EntityGeneration(this);
		Main.getInstance().getDataHandler().deleteData(this);
	}


}
