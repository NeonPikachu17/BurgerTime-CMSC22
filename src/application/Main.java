package application;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		StartUpScreen theGameStage = new StartUpScreen();
		theGameStage.setStage(stage);
	}
}