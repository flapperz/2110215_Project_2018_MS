package entity.monster;

import controller.View;
import entity.DamageableEntity;
import entity.IAttackable;
import entity.particle.DMarkParticle;
import entity.particle.ExplosionParticle;
import entity.particle.MarkParticle;
import entity.projectile.PlayerBullet;
import entity.projectile.WeaponProjectile;
import javafx.scene.image.Image;

public abstract class Monster extends DamageableEntity implements IAttackable{
	protected final int NORMAL = 0;
	protected final int MARK = 1;
	protected final int DMARK = 2;
	protected int state = NORMAL;
	
	public Monster(Image[] images, double x, double y, int maxHp) {
		super(images, x, y, maxHp);
		this.width = 65;
		this.height = 65;
	}
	
	@Override
	public void update() {
		move();
		processMark();
		subUpdate();
	}
	
	protected abstract void subUpdate();

	
	protected void processMark() {
		if(hp < 300 && state == NORMAL) {
			state = MARK;
		}
		if(state == MARK) {
			(new MarkParticle(x,y)).create();
		} else if (state == DMARK) {
			(new DMarkParticle(x,y)).create();
		}
	}

	@Override
	public int getZ() {
		return 2;
	}
	
	@Override
	public void attackedBy(IAttackable e) {
		if(e instanceof PlayerBullet) {
			damaged(e.attack(this));
		} else if (e instanceof WeaponProjectile && state == MARK) {
			damaged(e.attack(this));
			state = DMARK;
		}
		
	}
	
	@Override
	public void onDestroy() {
		View.getInstance().shake();
		(new ExplosionParticle(x,y)).create();
	}

	


}
