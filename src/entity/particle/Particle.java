package entity.particle;

import entity.Entity;
import javafx.scene.image.Image;

public abstract class Particle extends Entity{
	private int age;
	
	protected Particle(Image[] images, double x, double y, int age) {
		super(images, x, y, 0, 0);
		this.age = age;
	}
	
	
	@Override
	public int getZ() {
		return 100;
	}

	@Override
	public void update() {
		age--;
		if(age == 0) {
			destroy();
		}
		move();
	}

	@Override
	public void onDestroy() {
		
	}

}
