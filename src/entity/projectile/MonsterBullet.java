package entity.projectile;

import controller.SharedEntity;
import entity.Entity;
import resource.Sprites;

public class MonsterBullet extends Projectile{

	public MonsterBullet(double x, double y) {
		super(Sprites.fx_mBullet, x, y, SharedEntity.getInstance().getPlayer().getX(), SharedEntity.getInstance().getPlayer().getY(), 1.6);
	}

	@Override
	public int attack(Entity e) {
		destroy();
		return 70;
	}
	
}
