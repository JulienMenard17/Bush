package ca.sharkmenard.bush;

public class BushInstance {
	
	private BushData bushData;
	private int timer;
	
	public BushInstance(BushData bushData) {
		this.bushData = bushData;
		if(bushData.getPhase() == 0)
		this.timer = 0;
		if(bushData.getPhase() == 1)
			this.timer = bushData.getBushType().getTime() / 2;
		if(bushData.getPhase() == 2)
			this.timer = bushData.getBushType().getTime();
	}
	
	public int getTimer() {
		return timer;
	}
	
	public BushData getBushData() {
		return bushData;
	}
	
	public int addTimer(){
		timer++;
		return timer;
	}
	
	public void setTimer(int i) {
		timer = i;
	}
	

}
