package globalVariable;

import javafx.scene.Scene;
import main.Main;
import scene.*;

public class Scenes {
	private static int CurrentScene = Const.SCENE_LOADING;
	
	private static Scene loadingScene = new LoadingScene();
	private static Scene startScene;
	private static Scene gameScene;
	
	
	public static void loadResource() {
		startScene = new StartScene();
		gameScene = new GameScene();
	}
	
	public static void setMainScene(Scene scene) {
		Main.getStage().setScene(scene);
	}
	
	//Scene getter

	public static Scene getLoadingScene() {
		return loadingScene;
	}

	public static Scene getStartScene() {
		return startScene;
	}

	public static Scene getGameScene() {
		return gameScene;
	}
	
	
}
