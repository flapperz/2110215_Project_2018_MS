package entity.player;

import controller.SharedEntity;
import controller.View;
import entity.Entity;
import entity.monster.Monster;
import entity.projectile.PlayerBullet;
import entity.projectile.WeaponProjectile;
import exception.CharacterOutBoundException;
import input.Input;
import javafx.scene.canvas.GraphicsContext;
import resource.Sprites;

public class Weapon extends Entity{
	private final double DIS = 100;
	
	private int fireCD = 0;
	
	private final int NORMAL = 0;
	private final int FIRE = 1;
	private final int ATTACH = 2;
	private int state = NORMAL;
	
	private Monster attach;
	

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
		if (state == NORMAL) {
			double dx = (Input.getMouseX() + View.getInstance().getX()) - SharedEntity.getInstance().getPlayer().getX();
			double dy = (Input.getMouseY()  + View.getInstance().getY()) - SharedEntity.getInstance().getPlayer().getY();
			
			double r = Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
			x = (dx / r) * DIS + SharedEntity.getInstance().getPlayer().getX();
			y = (dy / r) * DIS + SharedEntity.getInstance().getPlayer().getY();
		} else if (state == ATTACH) {
			double dx = attach.getX() - SharedEntity.getInstance().getPlayer().getX();
			double dy = attach.getY() - SharedEntity.getInstance().getPlayer().getY();
			
			double r = Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
			x = (dx / r) * DIS + attach.getX();
			y = (dy / r) * DIS + attach.getY();
			
		}
	}

	private void processFire() {
		if(Input.isLeftMouseActive() && fireCD == 0 && (state == NORMAL || state == ATTACH)) {
			fireCD = 5;
			(new PlayerBullet(x,y)).create();
		} else if (Input.isRightMouseTrigger()) { //nested if else due to machanism of trigger can only be check once
			if (state == NORMAL) {
				state = FIRE;
				visible = false;
				(new WeaponProjectile(x,y)).create();
			} else if (state == ATTACH) {
				try {
					SharedEntity.getInstance().getPlayer().setX(x);
					SharedEntity.getInstance().getPlayer().setY(y);
					attach.destroy();
					state = NORMAL;
				} catch (CharacterOutBoundException e) {
					System.out.println("done");
					state = NORMAL;
					attach.destroy();
				}
			}
		}
		if(fireCD > 0) {
			fireCD--;
		}
	}
	
	@Override
	public void onDestroy() {
		
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
	
	public Monster getAttach() {
		return attach;
	}

	public void setAttach(Monster attach) {
		this.attach = attach;
	}


		
	

}
