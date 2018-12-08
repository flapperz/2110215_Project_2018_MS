package entity;

import javafx.scene.image.Image;

public abstract class Monster extends Entity implements IAttackable{

	public Monster(Image[] images, double x, double y, double width, double height) {
		super(images, x, y, width, height);
	}

	@Override
	public void update() {
	}

	@Override
	public int getZ() {
		return 0;
	}



}
