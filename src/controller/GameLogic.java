package controller;

import java.util.Collections;
import java.util.List;

import entity.DamageableEntity;
import entity.Entity;
import entity.IAttackable;
import entity.monster.Boss;
import entity.monster.Bowling;
import entity.monster.BowlingXL;
import entity.monster.GunnerBowling;
import gui.GUI;
import javafx.scene.canvas.GraphicsContext;
import map.BackGround;

public class GameLogic {
	
	private static final GameLogic instance = new GameLogic();
	private int frame;
	private int killCount;
	
	private BackGround bg;
	
	private GameLogic() {
		bg = new BackGround();
		
	}
	
	public void mainUpdate(GraphicsContext gc) {
		bg.update();
		
		if(frame == 10) {
			(new Bowling(500,500)).create();
			(new BowlingXL(500,500)).create();
			(new GunnerBowling(500,500)).create();
			Boss boss = new Boss(500,500);
			boss.create();
			SharedEntity.getInstance().setBoss(boss);
		}
		
		View.getInstance().update();
		
		updateEntity();
		updateDamageAttack();
		updateDraw(gc);
		frame++;
	}
	
	public void updateEntity() {
		for (Entity e: SharedEntity.getInstance().getEntities()) {
			e.update();
		}
	}
	
	public void updateDamageAttack() {
		for (DamageableEntity victim: SharedEntity.getInstance().getDamageableEntities()) {
			for (IAttackable attacker: SharedEntity.getInstance().getIAttackables()) {
				if(victim.isCollideWith((Entity)attacker)) {
					victim.attackedBy(attacker);
				}
			}
		}
	}
	
	public void updateDraw(GraphicsContext gc) {
		List<IDrawable> drawList = SharedEntity.getInstance().getDrawables();
		drawList.add(GUI.getInstance());
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
	
	//getGameL
	
	public static GameLogic getInstance() {
		return instance;
	}

	public int getFrame() {
		return frame;
	}

	public int getKillCount() {
		return killCount;
	}

	public void setKillCount(int killCount) {
		this.killCount = killCount;
	}
	
	


	
	
}
