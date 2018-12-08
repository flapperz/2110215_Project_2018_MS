package entity;

import javafx.scene.image.Image;

public abstract class DamageableEntity extends Entity {
	
	protected int hp;
	protected int maxHp;
	
	public DamageableEntity(Image[] images, double x, double y, double width, double height, int maxHp, int atk) {
		super(images, x, y, width, height);
		this.maxHp = maxHp;
		this.hp =maxHp;
	}
	
	public void damaged(IAttackable e) {
		hp = -e.attack();
		if(hp < 0) {
			hp = 0;
			this.destroy();
		}
	}
	
}
