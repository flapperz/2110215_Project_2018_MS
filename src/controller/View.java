package controller;

import entity.Rectangle;

public class View extends Rectangle implements IUpdatable{
	
	private static final View instance = new View();
	private boolean shaked = false;
	
	private View() {
		super(600,0,1200,900);
	}
	
	public void shake() {
		shaked = true;
		System.out.println(shaked);
		shaked = false;
	}

	@Override
	public void update() {
		x = SharedEntity.getInstance().getPlayer().getX() - 600 + 46; 
		y = SharedEntity.getInstance().getPlayer().getY() - 450 + 90;
		if (x < 0) { x = 0; } 
		else if (x > 1200) { x = 1200; }
		
		if(y > 0) { y = 0; }		
	}

	//Getter-Setter
	
	public static View getInstance() {
		return instance;
	}

	public boolean isShaked() {
		return shaked;
	}

	
	
}
