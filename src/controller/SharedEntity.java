package controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import entity.Entity;
import entity.Monster;

public class SharedEntity {
	
	private static final SharedEntity instance = new SharedEntity();
	
	private List<Entity> entities = new CopyOnWriteArrayList<>();
	
	public List<IDrawable> getDrawable() {
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
	
	public List<Monster> getMonsters() {
		List<Monster> list = new ArrayList<>();
		for (Entity e: entities) {
			if (e instanceof Monster) {
				list.add((Monster) e);
			}
		}
		return list;
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
	
	public static SharedEntity getInstance() {
		return instance;
	}
}
