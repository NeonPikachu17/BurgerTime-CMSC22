package application;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class AboutTheGame{
	private StackPane pane;
	private Scene scene;
	private Stage stage;
	private GraphicsContext gc;
	private Canvas canvas;

	public static final int WINDOW_WIDTH = 850;
	public static final int WINDOW_HEIGHT = 850;

	//final Image arrow_keys = new Image("images/arrowkeys.png", 225, 170, false, false);
	final Image logo = new Image("images/BTLogo.PNG", 500, 171, false, false);

	AboutTheGame(Stage stage){
		this.pane = new StackPane();
		this.stage = stage;
		this.scene = new Scene(pane, AboutTheGame.WINDOW_WIDTH, AboutTheGame.WINDOW_HEIGHT);
		this.canvas = new Canvas(AboutTheGame.WINDOW_WIDTH, AboutTheGame.WINDOW_HEIGHT);
		this.gc = canvas.getGraphicsContext2D();
		this.setProperties();
	}

	private void setProperties(){
		
		this.gc.setFill(Color.BLACK);
		this.gc.fillRect(0, 0, 850, 850);

		this.gc.setFill(Color.GRAY);
		Font txtFont1 = Font.font("Times New Roman", FontWeight.BOLD, 50);
		this.gc.setFont(txtFont1);
		this.gc.fillText("About the Game", 270, 150);

		this.gc.setFill(Color.WHITE);
		Font txtFont2 = Font.font("Comic Sans", 13);
		this.gc.setFont(txtFont2);
		//source: http://www.pixelatedarcade.com/games/burgertime
		this.gc.fillText("The original BurgerTime (ƒo�[ƒK�[ƒ^ƒCƒ€, or Baagaataimu in Japan) was released in 1982 as an arcade game by Data East. \n"
				+ "The player controls Chef Pepper, with the goal of completing the assembly of burgers with different ingredients\n"
				+ " on the screen, while constantly avoiding enemies in pursuit.\n\n"
				+ "The game was originally titled 'Hamburger' in Japan, but was changed to BurgerTime outside of"
				+ " Japan to avoid trademark issues.", 70, 270);
		
		Button mmbtn = new Button("Back To Main Menu");
		addEventHandler(stage, mmbtn);
		
		pane.getChildren().add(this.canvas);
		pane.getChildren().add(mmbtn);
		
	}
	
	protected void addEventHandler(Stage stage,Button btn) {
		btn.setOnMouseClicked(new EventHandler<MouseEvent>() {

			public void handle(MouseEvent arg0) {
				StartUpScreen start = new StartUpScreen();
				start.setStage(stage);
				stage.setScene(start.getScene());
				stage.show();
			}
		});
	}

	Scene getScene(){
		return this.scene;
	}

}