package scene;

import globalVariable.Const;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.StackPane;

public class GameScene extends Scene {

	public GameScene() {
		super(new StackPane(), Const.WINDOW_WIDHT, Const.WINDOW_HEIGHT);
		StackPane root = (StackPane)getRoot();
		root.setStyle("-fx-background-color: #000000;");
		
		Canvas canvas = new Canvas(Const.WINDOW_WIDHT, Const.WINDOW_HEIGHT);
		root.getChildren().add(canvas);
	
	}
	
}
