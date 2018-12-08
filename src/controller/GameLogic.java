package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import entity.PlaceHoldEnt;
import javafx.scene.canvas.GraphicsContext;
import resource.Sprites;

public class GameLogic {
	
	private static final GameLogic instance = new GameLogic();
	
	
	private GameLogic() {
	}

	public static GameLogic getInstance() {
		return instance;
	}
	
	public void update() {
		
	}
	
	public void draw(GraphicsContext gc) {
		List<IDrawable> drawList = SharedEntity.getInstance().getDrawable();
		Collections.sort(drawList, (IDrawable o1, IDrawable o2) -> {
			if (o1.getZ() > o2.getZ())
				return 1;
			return -1;
		});
		for(IDrawable element : drawList) {
			element.draw(gc);
		}
		
	}
	
	
}
