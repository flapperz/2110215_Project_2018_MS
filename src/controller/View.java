package controller;

import entity.Rectangle;

public class View extends Rectangle implements IUpdatable{
	
	private static final View instance = new View();
	private int speed = 30;
	
	private boolean shaked = false;
	private final int MAXSHAKETICK = 20;
	private int shakeTick = 0;
	
	private double desX;
	private double desY;
	private double ct = 0, tt = 10; // tt = interval of shaking
	private double tx = 0;
	private double ty = 0;
	
	private View() {
		super(600,0,1200,900);
	}
	
	public void processShake() {
		if (ct < tt) {
			ct ++;
		} else {
			tx = (Math.random()-1)*40; 
			ty = (Math.random()-1)*40;
		}
		x = x+tx;
		y = y+ty;
	}

	@Override
	public void update() {
		double px = SharedEntity.getInstance().getPlayer().getX();
		double py = SharedEntity.getInstance().getPlayer().getY();
//		if (SharedEntity.getInstance().getWeapon().getState() == 0) {
//			speed = 100;
//			desX = (SharedEntity.getInstance().getWeapon().getX() - px)*2 + px - 600; 
//			desY = (SharedEntity.getInstance().getWeapon().getY() - py)*2 + py - 450;
//		} else {
//			speed = 10;
//			desX = px - 600; 
//			desY = py - 450;
//		}
		desX = px - 600; 
		desY = py - 450;
		
		if (x < desX - speed) {
			x += speed;
		} else if (x > desX + speed) {
			x -= speed;
		} else {
			x = desX;
		}
		
		if (y < desY - speed) {
			y += speed;
		} else if (y > desY + speed) {
			y -= speed;
		} else {
			y = desY;
		}
		if (shakeTick > 0) {
			shakeTick--;
			processShake();
		}
		
		
		if (x < 0) { 
			x = 0;
		} else if (x > 1200) {
			x = 1200;
		}
		
		if(y > 0) { 
			y = 0;
		}		
	}
	
	public void shake() {
		shakeTick = MAXSHAKETICK;
	}

	//Getter-Setter
	
	public static View getInstance() {
		return instance;
	}
	
	public void setShaked(boolean isShaked) {	
		this.shaked = isShaked;
	}
	
	public boolean isShaked() {
		return shaked;
	}

	
	
}
