package main;

import javafx.application.Application;
import javafx.stage.Stage;
import scene.*;

public class Main extends Application{
	
	private static Stage stage;
	
	public static void main(String [] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		setStage(primaryStage);
		stage.setTitle("Magic Slinger");
		stage.setScene(Scenes.getLoadingScene());
		//stage.setResizable(false);
		
		stage.show();
		
	}
	
	@Override
	public void stop() throws Exception{
		((LoadingScene)Scenes.getLoadingScene()).getLoadThread().interrupt();
	}

//Getter-Setter

	public static Stage getStage() {
		return stage;
	}

	public static void setStage(Stage stage) {
		Main.stage = stage;
	}
	
	
	
	
}
