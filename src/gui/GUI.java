package gui;

import constants.Const;
import controller.IDrawable;
import controller.SharedEntity;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class GUI implements IDrawable{
	private int playerHp;
	private final double BAR_L = 300;
	private final double BAR_H = 50;
	private final int X = 100;
	private final int Y = 800;
	private final double SPEED = 5;
	private double curL;
	private double desL;
	
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
		gc.fillRect(X, Y, BAR_L, BAR_H);
		gc.setFill(Color.color(0.705, 1, 0.07));
		gc.fillRect(X, Y, curL, BAR_H);
		
		
	}

	public static GUI getInstance() {
		return instance;
	}

	@Override
	public String toString() {
		return "GUI [playerHp=" + playerHp + ", BAR_L=" + BAR_L + ", BAR_H=" + BAR_H + ", X=" + X + ", Y=" + Y
				+ ", SPEED=" + SPEED + ", curL=" + curL + ", desL=" + desL + "]";
	}
	
	
	
	

}
