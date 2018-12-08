package gui;

import controller.GameLogic;
import controller.IDrawable;
import controller.IUpdatable;
import controller.View;
import globalVariable.Const;
import javafx.scene.canvas.GraphicsContext;
import resource.Sprites;

public class BackGround implements IDrawable,IUpdatable{
	private double backPos;
	private double frontPos;
	
	
	
	@Override
	public int getZ() {
		return -9999;
	}
	
	@Override
	public void update() {
		System.out.println(backPos);
		backPos = (GameLogic.getInstance().getFrame()*Const.BACK_CITY_SPEED)%3600;
		frontPos = (GameLogic.getInstance().getFrame()*Const.FRONT_CITY_SPEED)%3600;
	}

	@Override
	public void draw(GraphicsContext gc) {
		gc.clearRect(0, 0, Const.WINDOW_WIDTH, Const.WINDOW_HEIGHT);
		
		gc.drawImage(Sprites.bg_sky[0],
				-View.getInstance().getX(),-View.getInstance().getY(),Const.WINDOW_WIDTH,Const.WINDOW_HEIGHT);
		
		gc.drawImage(Sprites.bg_backCity[0],backPos,0,Const.WINDOW_WIDTH,Const.WINDOW_HEIGHT,
				-View.getInstance().getX(),-View.getInstance().getY(),Const.WINDOW_WIDTH,Const.WINDOW_HEIGHT);

		gc.drawImage(Sprites.bg_frontCity[0],frontPos,50,Const.WINDOW_WIDTH,Const.WINDOW_HEIGHT,
				-View.getInstance().getX(),-View.getInstance().getY(),Const.WINDOW_WIDTH,Const.WINDOW_HEIGHT);

		gc.drawImage(Sprites.bg_train[0],600,0,1200,900,-View.getInstance().getX(),-View.getInstance().getY(),1200,900);
	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return false;
	}

}
