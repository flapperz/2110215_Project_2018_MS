package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import constants.Const;
import entity.Entity;
import entity.PlaceHoldEnt;
import entity.player.Player;
import gui.BackGround;
import javafx.scene.canvas.GraphicsContext;
import resource.Sprites;

public class GameLogic {
	
	private static final GameLogic instance = new GameLogic();
	private int frame;
	private BackGround bg;
	
	private GameLogic() {
		create(new Player(Const.WINDOW_WIDTH-46,Const.GROUND_POS-180));
		bg = new BackGround();
	}

	
	public void mainUpdate(GraphicsContext gc) {
		bg.update();
		draw(gc);
		
		frame++;
	}
	
	public void draw(GraphicsContext gc) {
		List<IDrawable> drawList = SharedEntity.getInstance().getDrawable();
		Collections.sort(drawList, (IDrawable o1, IDrawable o2) -> {
			if (o1.getZ() > o2.getZ())
				return 1;
			return -1;
		});
		
		bg.draw(gc);
		
		for(IDrawable element : drawList) {
			element.draw(gc);
		}
	}
	
	public void create(Entity e) {
		SharedEntity.getInstance().add(e);
	}
	
	public static GameLogic getInstance() {
		return instance;
	}


	public int getFrame() {
		return frame;
	}
	
	
	
}
