package application;//package_NameHere

import java.nio.file.Paths;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
//import F;//input class here
import javafx.util.Duration;

/*
 Player 1
 Ready
 
 5 - Pepper 4 - Lives
 */

public class Start_Holder {
	private StackPane pane;
	private Scene scene;
	private GraphicsContext gc;
	private Canvas canvas;

	Start_Holder(){
		this.pane = new StackPane();
		this.scene = new Scene(pane, 850,850);
		this.canvas = new Canvas(850, 850);
		this.gc = canvas.getGraphicsContext2D();
		this.setProperties();
		PauseTransition pause = new PauseTransition(Duration.seconds(1.5));
		pause.setOnFinished(new EventHandler<ActionEvent>() {
			
			public void handle(ActionEvent arg0) {
				
				GameStage map = new GameStage();
				StartUpScreen.stage.setScene(map.getScene());
			}
		});
		pause.play();
	}
	
	private void setProperties(){
		this.gc.setFill(Color.BLACK);						
		this.gc.fillRect(0,0,850,850);
		Font theFont = Font.font("Comic Sans",FontWeight.BOLD,30);
		this.gc.setFont(theFont);											
		
		this.gc.setFill(Color.BLUE);							
		this.gc.fillText("Player 1\n\n\tReady!\n\n5 - Pepper Shots \t4 - Lives", 850*0.3, 850*0.3);						//add a hello world to location x=60,y=50
		
		pane.getChildren().add(this.canvas);
	}
	
	Scene getScene(){
		return this.scene;
	}
	
	
	
}