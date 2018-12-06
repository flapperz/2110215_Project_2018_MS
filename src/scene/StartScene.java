package scene;

import constants.Const;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;

public class StartScene extends Scene{
	public StartScene() {
		super(new StackPane(),Const.WINDOW_HEIGHT,Const.WINDOW_WIDHT);
		StackPane root = (StackPane)getRoot();
	}
}
