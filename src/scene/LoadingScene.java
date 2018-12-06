package scene;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import constants.*;

public class LoadingScene extends Scene{


	public LoadingScene() {
		super(new StackPane(), Const.WINDOW_WIDHT, Const.WINDOW_HEIGHT);
		StackPane root = (StackPane)getRoot();
		
		//Place Holder
		
		Text loading = new Text(20,20,"LOADING");
		root.getChildren().add(loading);
		root.setStyle("-fx-background-color: #FFFFFF;");
	}

}
