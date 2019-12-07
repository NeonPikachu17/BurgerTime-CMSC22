package application;

import javafx.event.EventHandler;
import javafx.scene.Group;
//import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
//import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
//import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Instructions{
	private Pane pane;
	private Scene scene;
	private Stage stage;
	private GraphicsContext gc;
	private Canvas canvas;

	public static final int WINDOW_WIDTH = 850;
	public static final int WINDOW_HEIGHT = 850;

	final Image arrow_keys = new Image("images/arrowkeys.png", 225, 170, false, false);
	final Image bonus = new Image("images/bonus.PNG", 225, 170, false, false);

	Instructions(Stage stage){
		this.pane = new Pane();
		this.stage = stage;
		this.scene = new Scene(pane, Instructions.WINDOW_WIDTH, Instructions.WINDOW_HEIGHT);
		this.canvas = new Canvas(Instructions.WINDOW_WIDTH, Instructions.WINDOW_HEIGHT);
		this.gc = canvas.getGraphicsContext2D();
		this.setProperties();
	}

	private void setProperties(){
		
		this.gc.setFill(Color.BLACK);
		this.gc.fillRect(0, 0, 850, 850);

		this.gc.setFill(Color.GRAY);
		Font txtFont1 = Font.font("Times New Roman", FontWeight.BOLD, 50);
		this.gc.setFont(txtFont1);
		this.gc.fillText("How To Play", 270, 150);

		this.gc.setFill(Color.WHITE);
		Font txtFont2 = Font.font("Comic Sans", 13);
		this.gc.setFont(txtFont2);
		this.gc.fillText("Use the arrow keys to move your chef around\nand avoid the hotdogs, eggs, and pickle slices\nthat are chasing you. The objective is to drop\nall of the burger pieces into the bases at the\nbottom of the screen. Use the SPACEBAR to\nthrow pepper at the bad guys to temporarily\nstun them.", 50, 380);

		this.gc.fillText("Food icons to pick up for \nextra points:\n", 445, 380);
		this.gc.fillText("\nFrench fries = 1500 pts\nCoffee = 1000 pts\nIce cream = 500 pts", 445, 395);
		this.gc.fillText("Killing combo:", 655, 380);
		this.gc.fillText("# of enemies | points", 655, 395);
		this.gc.fillText("\t      1      |   500 ", 655, 410);
		this.gc.fillText("\t      2      |  1000 ", 655, 425);
		this.gc.fillText("\t      3      |  2000 ", 655, 440);
		this.gc.fillText("\t      6      | 16000 ", 655, 455);
		this.gc.drawImage(arrow_keys, 60, 200);
		this.gc.drawImage(bonus, 500, 200);
		Button mmbtn = new Button("Back To Main Menu");
		mmbtn.setTranslateX(340);
		mmbtn.setTranslateY(650);
		addEventHandler(stage, mmbtn);
		
		pane.getChildren().add(this.canvas);
		pane.getChildren().add(mmbtn);
		
	}
	
	private void addEventHandler(Stage stage,Button btn) {
		btn.setOnMouseClicked(new EventHandler<MouseEvent>() {
			
			public void handle(MouseEvent arg0) {
				StartUpScreen start = new StartUpScreen();
				start.setStage(stage);
				stage.setScene(start.getScene());
				stage.show();
			}
		});
	}

//	public void setStage(Stage stage){
//		this.pane = new StackPane();
//		this.gc.drawImage(arrow_keys, 60, 180);
//		this.gc.drawImage(bonus, 500, 180);
//		
//		this.stage = stage;
//		this.stage.setTitle("Burger Time");
//		this.stage.setScene(this.scene);
//		this.stage.show();
//	}
	
	Scene getScene() {
		return this.scene;
	}

}
