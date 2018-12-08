package gui;

import controller.IDrawable;
import javafx.scene.canvas.GraphicsContext;

public abstract class GUI implements IDrawable{

	@Override
	public int getZ() {
		return 9999;
	}

	@Override
	public boolean isVisible() {
		return true;
	}
	

}
