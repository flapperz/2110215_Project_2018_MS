package gui;

import constants.Const;
import controller.IDrawable;
import controller.SharedEntity;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class GUI implements IDrawable{
	private int playerHp;
	private final double BAR_L = 300;
	private final double BAR_H = 25;
	private final int pX = 100;
	private final int pY = 800;
	private final double SPEED = 5;
	private double curL;
	private double desL;
	
	private final double BOSS_BAR_L = 1000;
	private final double BOSS_BAR_H = 10;
	private final int bX = 100;
	private final int bY = 100;
	private double bdesL;
	
	
	
	private static GUI instance = new GUI();
	
	private GUI() {
		playerHp = Const.MAX_HP;
		curL = 0;
	}
	
	@Override
	public int getZ() {
		return 9999;
	}

	@Override
	public boolean isVisible() {
		return true;
	}

	@Override
	public void draw(GraphicsContext gc) {
		desL = (SharedEntity.getInstance().getPlayer().getHp() / (double)Const.MAX_HP)*BAR_L;
		if (curL < desL-SPEED) {
			curL += SPEED;
		} else if (curL > desL+SPEED) {
			curL -= SPEED;
		} else {
			curL = desL;
		}
		
		gc.setFill(Color.BLACK);
		gc.fillRect(pX, pY, BAR_L, BAR_H);
		gc.setFill(Color.color(0.705, 1, 0.07));
		gc.fillRect(pX, pY, curL, BAR_H);
		
		if (SharedEntity.getInstance().getBoss() != null) {
			bdesL = (SharedEntity.getInstance().getBoss().getHp() / (double)Const.BOSS_MAX_HP)*BOSS_BAR_L;

			
			gc.setFill(Color.BLACK);
			gc.fillRect(bX, bY, BOSS_BAR_L, BOSS_BAR_H);
			gc.setFill(Color.color(0.705, 1, 0.07));
			gc.fillRect(bX, bY, bdesL, BOSS_BAR_H);
		}
		
		
	}

	public static GUI getInstance() {
		return instance;
	}

	@Override
	public String toString() {
		return "GUI [playerHp=" + playerHp + ", BAR_L=" + BAR_L + ", BAR_H=" + BAR_H + ", X=" + pX + ", Y=" + pY
				+ ", SPEED=" + SPEED + ", curL=" + curL + ", desL=" + desL + "]";
	}
	
	
	
	

}
