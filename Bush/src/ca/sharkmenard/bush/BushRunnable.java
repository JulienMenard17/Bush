package ca.sharkmenard.bush;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

public class BushRunnable {
	
	private ArrayList<BushInstance> instances = new ArrayList<BushInstance>();
	private ArrayList<BushInstance> removeInstances = new ArrayList<BushInstance>();
	private ArrayList<BushInstance> breakRemoveInstances = new ArrayList<BushInstance>();

	public BushRunnable() {
		for(BushData bushData : Main.getInstance().getDataHandler().getDataList()) {
			if(bushData.getPhase() == 0) {
				BushInstance instance = new BushInstance(bushData);
				instances.add(instance);
			}else if(bushData.getPhase() == 1) {
				BushInstance instance = new BushInstance(bushData);
				instance.setTimer(bushData.getBushType().getTime() / 2);
				instances.add(instance);
			}
		}
		Bukkit.getServer().getScheduler().runTaskTimer((Plugin)Main.getInstance(), new Runnable() {
			
			@Override
			public void run() {
				for(BushInstance instance : instances) {
					int time = instance.addTimer();
					if(time == instance.getBushData().getBushType().getTime() / 2) {
						instance.getBushData().updatePhase();
					}
					if(time == instance.getBushData().getBushType().getTime()) {
						instance.getBushData().updatePhase();
						removeInstances.add(instance);
					}
				}
				for(BushInstance instance : removeInstances) {
					instances.remove(instance);
				}
				for(BushInstance instance2 : breakRemoveInstances) {
					instances.remove(instance2);
					instance2.getBushData().setPhase(0);
					new EntityGeneration(instance2.getBushData());
				}
				removeInstances.clear();
			}
		}, 0L, 20L
		);
	}
	
	public ArrayList<BushInstance> getInstances() {
		return instances;
	}
	
	public void addInstance(BushInstance instance) {
		instances.add(instance);
		
	}
	
	public void removeInstance(BushData bush) {
		for (BushInstance bushInstance : instances) {
			if(bushInstance.getBushData().equals(bush)) {
				removeInstance(bushInstance);
			}
		}
		
	}
	
	public void removeInstance(BushInstance instance) {
		breakRemoveInstances.add(instance);
	}
	
}
