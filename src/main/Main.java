package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import scene.*;

public class Main extends Application{
	
	private static Stage stage;
	private static Scene scene;
	
	public static void main(String [] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		stage = primaryStage;
		scene = new GameScene();
		stage.setTitle("Magic Slinger");
		stage.setScene(scene);
		
		stage.show();
	}
	
}
