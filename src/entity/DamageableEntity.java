package entity;

import javafx.scene.image.Image;

public abstract class DamageableEntity extends Entity {
	
	protected int hp;
	protected int maxHp;
	
	public DamageableEntity(Image[] images, double x, double y, int maxHp) {
		super(images, x, y, 0, 0);
		this.maxHp = maxHp;
		this.hp =maxHp;
	}
	
	public void damaged(IAttackable e) {
		hp -= e.attack();
		if (hp < 0) {
			hp = 0;
			this.destroy();
		}
	}
	
}
