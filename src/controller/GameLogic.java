package controller;

import java.util.Collections;
import java.util.List;


import entity.Entity;
import entity.monster.Monster;
import entity.particle.Particle;
import entity.projectile.Projectile;
import javafx.scene.canvas.GraphicsContext;
import map.BackGround;

public class GameLogic {
	
	private static final GameLogic instance = new GameLogic();
	private int frame;
	
	private BackGround bg;
	
	private GameLogic() {
		bg = new BackGround();
		
	}

	
	public void mainUpdate(GraphicsContext gc) {
		bg.update();
		View.getInstance().update();
		for (Entity e: SharedEntity.getInstance().getEntities()) {
			e.update();
		}
		
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
		
		for (IDrawable element : drawList) {
			if (element.isVisible()) {
				element.draw(gc);
			}
		}
	}
	
	public void create(Entity e) {
		SharedEntity.getInstance().add(e);
	}
	
	//getGameL
	
	public static GameLogic getInstance() {
		return instance;
	}

	public int getFrame() {
		return frame;
	}


	
	
}
