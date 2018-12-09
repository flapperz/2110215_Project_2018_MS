package controller;

import java.util.Collections;

import java.util.List;

import resource.scene.GameScene;
import background.BackGround;
import constants.Const;
import entity.DamageableEntity;
import entity.Entity;
import entity.IAttackable;
import entity.monster.Boss;
import entity.monster.Bowling;
import entity.monster.BowlingXL;
import entity.monster.GunnerBowling;
import entity.monster.Monster;
import entity.projectile.MonsterBullet;
import entity.projectile.Projectile;
import gui.GUI;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.media.AudioClip;
import resource.Sounds;
import resource.scene.Scenes;

public class GameLogic {
	
	private static final GameLogic instance = new GameLogic();
	private int frame;
	private int killCount;
	private int spawnTick = 0;
	private int state = 0;
	private int score = 0;
	
	private BackGround bg;
	
	private GameLogic() {
		bg = new BackGround();
		
	}
	
	public void mainUpdate(GraphicsContext gc) {
		bg.update();

		
		View.getInstance().update();
		
		monsterSpawn();
		updateEntity();
		updateDamageAttack();
		updateDraw(gc);
		frame++;
	}
	
	private void monsterSpawn() {
		if (state == 0) {
			if (spawnTick == 0 && SharedEntity.getInstance().getSize() < Const.MAX_ENTITY) {
				
				double r = Math.random();
				double sx = (Math.random() > 0.5) ? -100 : Const.STAGE_WIDTH+100;
				double sy = (Math.random()*1500-300);
				if (r < 0.7) {
					(new Bowling(sx, sy)).create();
				} else if (r < 0.9) {
					(new BowlingXL(sx, sy)).create();
				} else {
					(new GunnerBowling(sx, sy)).create();
				}
				spawnTick = 60 + (int)(Math.random()*360);
			} else if (spawnTick <= 0) {
				spawnTick = 1200;
			} else {
				spawnTick--;
			}
			
			if (killCount > Const.KILLTHRSH) {
				state = 1;
				((GameScene)Scenes.getGameScene()).getBgm().stop();
				((GameScene)Scenes.getGameScene()).setBgm(Sounds.bgm_boss);
				((GameScene)Scenes.getGameScene()).getBgm().play();
				if(SharedEntity.getInstance().getBoss() == null) {
					for (Monster m : SharedEntity.getInstance().getMonsters()) {
						m.destroy();
					}
					for (Projectile p : SharedEntity.getInstance().getProjectiles()) {
						if (p instanceof MonsterBullet) {
							p.destroy();
						}
					}
					Boss boss = new Boss(Const.STAGE_WIDTH/2, Const.WINDOW_HEIGHT/2-150);
					SharedEntity.getInstance().setBoss(boss);
					boss.create();
				}
			}
		}
	}
	
	private void updateEntity() {
		for (Entity e: SharedEntity.getInstance().getEntities()) {
			e.update();
		}
	}
	
	private void updateDamageAttack() {
		for (DamageableEntity victim: SharedEntity.getInstance().getDamageableEntities()) {
			for (IAttackable attacker: SharedEntity.getInstance().getIAttackables()) {
				if(victim.isCollideWith((Entity)attacker)) {
					victim.attackedBy(attacker);
				}
			}
		}
	}
	
	private void updateDraw(GraphicsContext gc) {
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
	
	public void reset() {
		instance.frame = 0;
		instance.frame = 0;
		instance.state = 0;
		instance.score = 0;
	}
	
	//getGameLogic
	
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

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
