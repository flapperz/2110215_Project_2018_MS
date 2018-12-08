package entity.monster;

import entity.DamageableEntity;
import entity.IAttackable;
import javafx.scene.image.Image;

public abstract class Monster extends DamageableEntity implements IAttackable{
	
	public Monster(Image[] images, double x, double y, int maxHp, int atk) {
		super(images, x, y, maxHp);
	}
	
	@Override
	public void update() {
	}

	@Override
	public int getZ() {
		return 0;
	}



}
