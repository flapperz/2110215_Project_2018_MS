package entity.particle;

import controller.View;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class ScoreParticle extends Particle{
	private int value;

	public ScoreParticle(double x, double y, int value) {
		super(null, x, y, 20);
		this.value = value;
	}
	
	@Override
	public void draw(GraphicsContext gc) {
		gc.setFill(Color.WHITE);
		gc.setFont(new Font(20));
		gc.fillText(Integer.toString(value),x-View.getInstance().getX()
				,y-View.getInstance().getY());	
		
	}
	
	@Override
	public int getZ() {
		return 110;
	}
	

}
