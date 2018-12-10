package entity.monster;

import constants.Const;
import controller.GameLogic;
import controller.SharedEntity;
import controller.View;
import entity.Entity;
import entity.particle.ExplosionParticle;
import entity.projectile.MonsterBullet;
import resource.Sprites;
import resource.scene.GameScene;
import resource.scene.Scenes;

public class Boss extends Monster {
	private final int MAXWALK = 300;
	private int walkTick = 0;
	private int bossState = 0;
	
	public Boss(double x, double y) {
		super(Sprites.m_boss, x, y, Const.BOSS_MAX_HP, 5000);
		this.width = 100;
		this.height = 200;
		this.speedX = 1.2;
		this.speedY = 1.2;
	}


	@Override
	public int attack(Entity e) {
		return 200;
	}

	@Override
	protected void subUpdate() {
		if (bossState == 0) {

			if(walkTick > 200 && walkTick%20 == 1) {
				MonsterBullet mb = new MonsterBullet(x,y);
				mb.setSpeed(18);
				mb.create();
			}
			
			if(walkTick > 0) {
				walkTick--;
				
			} else {
				walkTick = MAXWALK;
				destinationX = SharedEntity.getInstance().getPlayer().getX() + (Math.random()-0.5)*2000;
				destinationY = SharedEntity.getInstance().getPlayer().getY() - (Math.random())*100;
			}
			if (hp < Const.BOSS_MAX_HP/2) {
				bossState = 1;
				(new ExplosionParticle(x,y)).create();
				View.getInstance().shake();
				speedX = 6;
				speedY = 6;
			}
		} else if (bossState == 1) {
			
			if ((walkTick == 220 || walkTick == 290 || walkTick == 240 || walkTick == 200) && SharedEntity.getInstance().getMonsters().size() < 12) {
				double r = Math.random();
				if(r < 0.9) {
					(new Bowling(x,y)).create();
				} else if (r < 0.95) {
					(new GunnerBowling(x,y)).create();
				} else {
					(new BowlingXL(x,y)).create();
				}
			}
			
			if(walkTick > 0) {
				walkTick--;
				
			} else {
				walkTick = MAXWALK;
				destinationX = 1200 + (Math.random()-0.5)*400;
				destinationY =  -(Math.random()-0.5)*400;
			}
			
		}
		
	}
	
	@Override
	public void onDestroy() {
		GameLogic.getInstance().setKillCount(GameLogic.getInstance().getKillCount() + 1);
		((GameScene)Scenes.getGameScene()).stopMainTimeline();
		((GameScene) Scenes.getGameScene()).playWinAnim();
	}
	
	

}
