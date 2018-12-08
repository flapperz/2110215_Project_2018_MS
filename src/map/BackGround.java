package map;

import constants.Const;
import controller.GameLogic;
import controller.IDrawable;
import controller.IUpdatable;
import controller.View;
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
		backPos = (GameLogic.getInstance().getFrame()*Const.BACK_CITY_SPEED)%3600;
		frontPos = (GameLogic.getInstance().getFrame()*Const.FRONT_CITY_SPEED)%3600;
	}

	@Override
	public void draw(GraphicsContext gc) {
		gc.clearRect(0, 0, Const.WINDOW_WIDTH, Const.WINDOW_HEIGHT);
		
		gc.drawImage(Sprites.bg_sky[0],
				-300,-450);
		
		gc.drawImage(Sprites.bg_backCity[0],backPos,0,Const.STAGE_WIDTH,Const.WINDOW_HEIGHT,
				-View.getInstance().getX(),-View.getInstance().getY(),Const.STAGE_WIDTH,Const.WINDOW_HEIGHT);

		gc.drawImage(Sprites.bg_frontCity[0],frontPos,50,Const.STAGE_WIDTH,Const.WINDOW_HEIGHT,
				-View.getInstance().getX(),-View.getInstance().getY(),Const.STAGE_WIDTH,Const.WINDOW_HEIGHT);

		gc.drawImage(Sprites.bg_train[0],0,0,Const.STAGE_WIDTH,900,-View.getInstance().getX(),-View.getInstance().getY(),Const.STAGE_WIDTH,Const.WINDOW_HEIGHT);
	}

	@Override
	public boolean isVisible() {
		return true;
	}

}
