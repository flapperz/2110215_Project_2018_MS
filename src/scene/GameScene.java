package scene;

import constants.Const;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.StackPane;

public class GameScene extends Scene{

	public GameScene() {
		super(new StackPane(), Const.WINDOW_WIDHT, Const.WINDOW_HEIGHT);
		StackPane root = (StackPane)getRoot();
		
		Canvas canvas = new Canvas(Const.WINDOW_WIDHT, Const.WINDOW_HEIGHT);
		root.getChildren().add(canvas);
	
	}
	
}
