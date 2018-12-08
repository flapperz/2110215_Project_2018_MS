package entity.player;

import controller.SharedEntity;
import controller.View;
import entity.Entity;
import entity.projectile.PlayerBullet;
import entity.projectile.WeaponProjectile;
import input.Input;
import javafx.scene.canvas.GraphicsContext;
import resource.Sprites;

public class Weapon extends Entity{
	private final double DIS = 100;
	
	private int fireCD = 0;
	private boolean isFired = false;
	
	
	public Weapon() {
		super(Sprites.p_weapon);
	}
	
	@Override
	public int getZ() {
		return 2;
	}

	@Override
	public void update() {
		processPos();
		processFire();
	}
	
	private void processPos() {
		double dx = (Input.getMouseX() + View.getInstance().getX()) - SharedEntity.getInstance().getPlayer().getX();
		double dy = (Input.getMouseY()  + View.getInstance().getY()) - SharedEntity.getInstance().getPlayer().getY();
		
		double r = Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
		x = (dx / r) * DIS + SharedEntity.getInstance().getPlayer().getX();
		y = (dy / r) * DIS + SharedEntity.getInstance().getPlayer().getY();
		
	}

	private void processFire() {
		if(Input.isLeftMouseActive() && fireCD == 0 && !isFired) {
			fireCD = 5;
			(new PlayerBullet(x,y)).create();
		} else {
			if(fireCD > 0) {
				fireCD -= 1;
			}
		}
		if(Input.isRightMouseTrigger() && !isFired) {
			isFired = true;
			visible = false;
			(new WeaponProjectile(x,y)).create();
		}
	}
	
	@Override
	public void onDestroy() {
		
	}

	public boolean isFired() {
		return isFired;
	}

	public void setFired(boolean isFired) {
		this.isFired = isFired;
	}
		
	

}
