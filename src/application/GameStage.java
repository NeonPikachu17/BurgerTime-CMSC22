package application;

import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GameStage {
	private GridPane pane;
	private Scene scene;
	public static Stage stage;
	private Group root;
	private Canvas canvas;
	private GraphicsContext gc;
	public int[][] map;
	private ArrayList<ImageView> gameboard;
	
	public GameStage(){
		this.stage = StartUpScreen.stage;
		this.pane = new GridPane();
		this.pane.setPadding(new Insets(10,10,10,10));
		this.scene = new Scene(pane, 850, 850);
		this.canvas = new Canvas(850,850);
		this.gc = canvas.getGraphicsContext2D();
		this.map = new int[][] {
				{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
				{0,0,2,0,0,0,2,0,0,0,2,0,0,2,0,0},
				{0,0,2,0,0,0,2,0,0,0,2,0,0,2,0,0},
				{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
				{2,0,0,0,2,0,0,0,2,0,0,2,0,0,0,2},
				{2,0,0,0,2,0,0,0,2,0,0,2,0,0,0,2},
				{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
				{0,0,2,0,0,0,0,0,0,0,0,0,0,2,0,0},	
				{0,0,2,0,0,0,0,0,0,0,0,0,0,2,0,0},
				{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
				{2,0,0,0,2,0,0,0,2,0,0,2,0,0,0,2},
				{2,0,0,0,2,0,0,0,2,0,0,2,0,0,0,2},
				{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
			}; 
		this.setProperties();
			
	}
	
	public void setProperties() {
		this.gc.setFill(Color.BLACK);
		this.gc.fillRect(0,0,850,850);		
	}
	
	public Scene getScene() {
		return this.scene;
	}
}
