package scene;

import constants.Consts;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.StackPane;

public class GameScene extends Scene{

	public GameScene() {
		super(new StackPane(), Consts.WINDOW_WIDHT, Consts.WINDOW_HEIGHT);
		StackPane root = (StackPane)getRoot();
		
		Canvas canvas = new Canvas(Consts.WINDOW_WIDHT, Consts.WINDOW_HEIGHT);
		root.getChildren().add(canvas);
	
	}
	
}
