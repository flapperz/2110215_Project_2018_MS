package entity;

import entity.particle.HitParticle;
import javafx.scene.image.Image;

public abstract class DamageableEntity extends Entity {
	
	protected int hp;
	protected int maxHp;
	
	public DamageableEntity(Image[] images, double x, double y, double w, double h, int maxHp) {
		super(images, x, y, w, h);
		this.maxHp = maxHp;
		this.hp =maxHp;
	}
	
	public DamageableEntity(Image[] images, double x, double y, int maxHp) {
		super(images, x, y, 0, 0);
		this.maxHp = maxHp;
		this.hp = maxHp;
	}
	
	public abstract void attackedBy(IAttackable e);
	
	protected void damaged(int atk) {
		hp -= atk;
		if (hp <= 0) {
			hp = 0;
			this.destroy();
		}
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getMaxHp() {
		return maxHp;
	}

	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}
	
	
	
}
