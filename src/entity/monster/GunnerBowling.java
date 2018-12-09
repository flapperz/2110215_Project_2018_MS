package entity.monster;

import controller.SharedEntity;
import entity.projectile.MonsterBullet;
import resource.Sprites;

public class GunnerBowling extends Bowling{
	
	public GunnerBowling(double x, double y) {
		super(x, y);
		sprite.setSprite(Sprites.m_mob2R);
		hp = 500;
		width = 70;
		height = 70;
		speedX = 4;
		speedY = 4;
	}


	@Override
	protected void subUpdate() {
		if(walkTick > 200 && walkTick%20 == 1) {
			(new MonsterBullet(x,y)).create();
		}
		
		spriteUpdate();
		if(walkTick > 0) {
			walkTick--;
			
		} else {
			walkTick = MAXWALK;
			destinationX = SharedEntity.getInstance().getPlayer().getX() + (Math.random()-0.5)*1000;
			destinationY = SharedEntity.getInstance().getPlayer().getY() + (Math.random()-0.8)*1000;
		}
	}
	
	
	protected void spriteUpdate() {
		sprite.setSprite(facing == LEFT ? Sprites.m_mob2L : Sprites.m_mob2R);
	}
}
