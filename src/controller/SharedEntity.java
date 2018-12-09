package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import constants.Const;
import entity.DamageableEntity;
import entity.Entity;
import entity.IAttackable;
import entity.monster.Boss;
import entity.monster.Monster;
import entity.particle.Particle;
import entity.player.Player;
import entity.player.Weapon;
import entity.projectile.Projectile;

public class SharedEntity {
	
	private static final SharedEntity instance = new SharedEntity();
	
	private List<Entity> entities = new CopyOnWriteArrayList<>();
	private Player player = new Player(Const.WINDOW_WIDTH-46,Const.GROUND_POS-180);
	private Weapon weapon = new Weapon();
	private Boss boss;
	
	private SharedEntity() {
		entities.add(player);
		entities.add(weapon);
	}
	
	public void add(Entity e) {
		entities.add(e);
		
	}
	
	public void remove(Entity e) {
		entities.remove(e);
	}
	
	public void clear() {
		entities.clear();
	}
	
	//Getter
	
	public List<IDrawable> getDrawables() {
		List<IDrawable> list = new ArrayList<>();
		for (Entity e: entities) {
				list.add((IDrawable)e);
		}
		return list;
	}
	
	public List<Entity> getEntities() {
		List<Entity> list = new ArrayList<>();
		for (Entity e: entities) {
				list.add(e);
		}
		return list;
	}
	
	public List<Particle> getParticles() {
		List<Particle> list = new ArrayList<>();
		for (Entity e: entities) {
			if (e instanceof Particle) {
				list.add((Particle) e);
			}
		}
		return list;
	}
	
	public List<Projectile> getProjectiles() {
		List<Projectile> list = new ArrayList<>();
		for (Entity e: entities) {
			if (e instanceof Projectile) {
				list.add((Projectile) e);
			}
		}
		return list;
	}
	
	public List<Monster> getMonsters() {
		List<Monster> list = new ArrayList<>();
		for (Entity e: entities) {
			if (e instanceof Monster) {
				list.add((Monster) e);
			}
		}
		return list;
	}
	
	public List<DamageableEntity> getDamageableEntities() {
		List<DamageableEntity> list = new ArrayList<>();
		for (Entity e: entities) {
			if (e instanceof DamageableEntity) {
				list.add((DamageableEntity) e);
			}
		}
		return list;
	}
	
	public List<IAttackable> getIAttackables() {
		List<IAttackable> list = new ArrayList<>();
		for (Entity e: entities) {
			if (e instanceof IAttackable) {
				list.add((IAttackable) e);
			}
		}
		return list;
	}
	
	public static SharedEntity getInstance() {
		return instance;
	}

	public Player getPlayer() {
		return player;
	}
	
	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}
	
	public Weapon getWeapon() {
		return weapon;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Boss getBoss() {
		return boss;
	}

	public void setBoss(Boss boss) {
		this.boss = boss;
	}
	
	
}
