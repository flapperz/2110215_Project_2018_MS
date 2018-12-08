package controller;

import entity.Rectangle;

public class View extends Rectangle{
	
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

	//Getter-Setter
	
	public static View getInstance() {
		return instance;
	}

	public boolean isShaked() {
		return shaked;
	}
	
	
}
