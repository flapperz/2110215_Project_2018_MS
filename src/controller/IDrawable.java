package controller;

import javafx.scene.canvas.GraphicsContext;

public interface IDrawable {
	public int getZ(); //More Z get on top
	public void draw(GraphicsContext gc);
	public boolean isVisible();
	
}
