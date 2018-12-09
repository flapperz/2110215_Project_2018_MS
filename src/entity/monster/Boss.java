package entity.monster;

import constants.Const;
import controller.SharedEntity;
import controller.View;
import entity.Entity;
import entity.particle.ExplosionParticle;
import entity.projectile.MonsterBullet;
import javafx.scene.image.Image;
import resource.Sprites;

public class Boss extends Monster {
	private final int MAXWALK = 300;
	private int walkTick = 0;
	private int state = 0;
	
	public Boss(double x, double y) {
		super(Sprites.m_boss, x, y, Const.BOSS_MAX_HP);
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
		if (state == 0) {

			if(walkTick > 200 && walkTick%20 == 1) {
				(new MonsterBullet(x,y)).create();
			}
			
			if(walkTick > 0) {
				walkTick--;
				
			} else {
				walkTick = MAXWALK;
				destinationX = SharedEntity.getInstance().getPlayer().getX() + (Math.random()-0.5)*2000;
				destinationY = SharedEntity.getInstance().getPlayer().getY() - (Math.random())*100;
			}
			if (hp < Const.BOSS_MAX_HP/2) {
				state = 1;
				(new ExplosionParticle(x,y)).create();
				View.getInstance().shake();
				speedX = 10;
				speedY = 10;
			}
		} else if (state == 1) {
			
			if (walkTick == 220) {
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
				destinationY = -600 - (Math.random())*500;
			}
			
		}
		
	}
	
	

}
