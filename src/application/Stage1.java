package application;

import java.util.ArrayList;

import javafx.animation.AnimationTimer;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import application.Element;

public class Stage1 {
	private Scene scene;
	private Stage stage;
	private Group root;
	private Canvas canvas;
	private GraphicsContext gc;
	private Canvas canvas2;
	private GraphicsContext gc2;
	
	private GridPane map;
	public AnimationTimer gametimer;

	private Element platform;
	private Element stairs;
	private Element upperBunLeft;
	private Element upperBunMid;
	private Element upperBunRight;
	private Element lettuceLeft;
	private Element lettuceMid;
	private Rectangle2D screenBounds;
	private Element lettuceRight;
	private Element cheeseLeft;
	private Element cheeseMid;
	private Element cheeseRight;
	private Element lowerBunLeft;
	private Element lowerBunMid;
	private Element lowerBunRight;
	private Element tomatoLeft;
	private Element tomatoMid;
	private Element tomatoRight;
	private Element pattyLeft;
	private Element pattyMid;
	private Element pattyRight;
	private int[][] mapMatrix;
	private ArrayList<ImageView> elements;
//	private Chef chefP;

	public final static int CELL_HEIGHT = 30;
	public final static int CELL_WIDTH = 40;
	public final static int MAP_NUM_ROWS = 15;
	public final static int MAP_NUM_COLS = 17;
	public final static int WINDOW_WIDTH = 800;
	public final static int WINDOW_HEIGHT = 800;
	public final static int MAP_WIDTH = 600;
	public final static int MAP_HEIGHT = 600;

	Stage1(){
		this.mapMatrix = new int[][] {
				{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 4, 5, 1},//1
				{2, 0, 0, 0, 2, 0, 0, 0, 2, 0, 0, 0, 2, 0, 0, 0, 2},//2
				{1, 3, 4, 5, 1, 1, 1, 1, 1, 3, 4, 5, 1, 1, 1, 1, 1},//3
				{0, 0, 2, 0, 0, 0, 2, 0, 0, 0, 2, 0, 0, 0, 2, 0, 0},//4
				{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 9, 10, 11, 1},//5
				{2, 0, 0, 0, 2, 0, 0, 0, 2, 0, 0, 0, 2, 0, 0, 0, 2},//6
				{1, 9, 10, 11, 1, 3, 4, 5, 1, 1, 1, 1, 1, 1, 1, 1, 1},//7
				{0, 0, 2, 0, 0, 0, 2, 0, 0, 0, 2, 0, 0, 0, 2, 0, 0},//8
				{1, 18, 19, 20, 1, 18, 19, 20, 1, 1, 1, 1, 1, 9, 10, 11, 1},//9
				{2, 0, 0, 0, 2, 0, 0, 0, 2, 0, 0, 0, 2, 0, 0, 0, 2},//10
				{1, 1, 1, 1, 1, 6, 7, 8, 1, 6, 7, 8, 1, 1, 1, 1, 1},//11
				{0, 0, 2, 0, 0, 0, 2, 0 ,0, 0, 2, 0, 0, 0, 2, 0, 0},//12
				{1, 1, 1, 1, 1, 15, 16, 17, 1, 15, 16, 17, 1, 12, 13, 14, 1},//13
				{2, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 2, 0, 0, 0, 2},//14
				{1, 12, 13, 14, 1, 12, 13, 14, 1, 12, 13, 14, 1, 1, 1, 1, 1},//15
			};

			this.root = new Group();
			this.scene = new Scene(root, Stage1.WINDOW_WIDTH, Stage1.WINDOW_HEIGHT, Color.BLACK);
			this.canvas = new Canvas(Stage1.WINDOW_WIDTH, Stage1.WINDOW_HEIGHT);
			this.gc = canvas.getGraphicsContext2D();
//			this.canvas2 = new Canvas(Stage1.WINDOW_WIDTH, Stage1.WINDOW_HEIGHT);
//			this.gc2 = canvas2.getGraphicsContext2D();
			this.map = new GridPane();
			System.out.println(this.map.getBoundsInParent());
//			this.map.toFront();
//			this.chefP = new Chef("CheffyPepito",150,250);
			this.map.setGridLinesVisible(true);

			this.platform = new Element(0, 0, Element.PLATFORM);		
			this.stairs = new Element(0, 0, Element.STAIRS);
			this.upperBunLeft = new Element(0, 0, Element.UBL);
			this.upperBunMid = new Element(0, 0, Element.UBM);
			this.upperBunRight = new Element(0, 0, Element.UBR);
			this.lettuceLeft = new Element(0, 0, Element.LETTLEFT);
			this.lettuceMid = new Element(0, 0, Element.LETTRIGHT);
			this.lettuceRight = new Element(0, 0, Element.LETTMID);
			this.cheeseLeft = new Element(0, 0, Element.CHIZLEFT);
			this.cheeseMid = new Element(0, 0, Element.CHIZMID);
			this.cheeseRight = new Element(0, 0, Element.CHIZRIGHT);
			this.lowerBunLeft = new Element(0, 0, Element.LBL);
			this.lowerBunMid = new Element(0, 0, Element.LBM);
			this.lowerBunRight = new Element(0, 0, Element.LBR);
			this.tomatoLeft = new Element(0, 0, Element.TOMLEFT);
			this.tomatoMid = new Element(0, 0, Element.TOMMID);
			this.tomatoRight = new Element(0, 0, Element.TOMRIGHT);
			this.pattyLeft = new Element(0, 0, Element.PATTYLEFT);
			this.pattyMid = new Element(0, 0, Element.PATTYMID);
			this.pattyRight = new Element(0, 0, Element.PATTYRIGHT);

			this.elements = new ArrayList<ImageView>();
			

	}
	
	public void setStage(Stage stage){
		this.stage = stage;

		this.createMap();
		this.setGridPaneProperties();
		this.addGridPaneConstraints();

		for(ImageView element: elements){
			this.map.getChildren().add(element);
		}

		this.root.getChildren().add(canvas);
		this.root.getChildren().add(map);
		this.map.toBack();
		System.out.println("Max X: " + this.map.getBoundsInParent().getMaxX());
		System.out.println("Max Y: " +this.map.getBoundsInParent().getMaxY());
		System.out.println("Min X: " + this.map.getBoundsInParent().getMinX());
		System.out.println("Min Y: " + this.map.getBoundsInParent().getMinY());
		this.stage.setScene(this.scene);
		this.gametimer = new GameTimer(this.gc,this.scene,GameStage.stage,this.map.getBoundsInParent());
//		this.root.getChildren().add(chefP);
		this.stage.setTitle("Burger Time Stage 1");
		this.gametimer.start();
		this.stage.show();
	}

	protected void createMap(){
		int i, j;

		for(i=0; i<Stage1.MAP_NUM_ROWS; i++){
			for(j=0; j<Stage1.MAP_NUM_COLS; j++){
				ImageView iv = new ImageView();
				if(mapMatrix[i][j] == 1){
					addToStage(this.platform, iv);
					System.out.println(this.platform.getX());
				}
				else if(mapMatrix[i][j] == 2){
					addToStage(this.stairs, iv);
				}
				else if(mapMatrix[i][j] == 3){
					addToStage(this.upperBunLeft, iv);
				}
				else if(mapMatrix[i][j] == 4){
					addToStage(this.upperBunMid, iv);
				}
				else if(mapMatrix[i][j] == 5){
					addToStage(this.upperBunRight, iv);
				}
				else if(mapMatrix[i][j] == 6){
					addToStage(this.lettuceLeft, iv);
				}
				else if(mapMatrix[i][j] == 7){
					addToStage(this.lettuceMid, iv);
				}
				else if(mapMatrix[i][j] == 8){
					addToStage(this.lettuceRight, iv);
				}
				else if(mapMatrix[i][j] == 9){
					addToStage(this.cheeseLeft, iv);
				}
				else if(mapMatrix[i][j] == 10){
					addToStage(this.cheeseMid, iv);
				}
				else if(mapMatrix[i][j] == 11){
					addToStage(this.cheeseRight, iv);
				}
				else if(mapMatrix[i][j] == 12){
					addToStage(this.lowerBunLeft, iv);
				}
				else if(mapMatrix[i][j] == 13){
					addToStage(this.lowerBunMid, iv);
				}
				else if(mapMatrix[i][j] == 14){
					addToStage(this.lowerBunRight, iv);
				}
				else if(mapMatrix[i][j] == 15){
					addToStage(this.tomatoLeft, iv);
				}
				else if(mapMatrix[i][j] == 16){
					addToStage(this.tomatoMid, iv);
				}
				else if(mapMatrix[i][j] == 17){
					addToStage(this.tomatoRight, iv);
				}
				else if(mapMatrix[i][j] == 18){
					addToStage(this.pattyLeft, iv);
				}
				else if(mapMatrix[i][j] == 19){
					addToStage(this.pattyMid, iv);
				}
				else if(mapMatrix[i][j] == 20){
					addToStage(this.pattyRight, iv);
				}

				iv.setPreserveRatio(true);
				iv.setFitWidth(Stage1.CELL_WIDTH);
				iv.setFitHeight(Stage1.CELL_HEIGHT);

				iv.setId(Integer.toString(i)+"-"+Integer.toString(j));

				this.elements.add(iv);
			}
		}
	}
	
	private void addToStage(Element elem, ImageView iv) {
		elem.render(iv);
	}
	
	private void setGridPaneProperties(){
		this.map.setPrefSize(Stage1.MAP_WIDTH, Stage1.MAP_HEIGHT);
		//set the map to x and y location; add border color to see the size of the gridpane/map  
	    //this.map.setStyle("-fx-border-color: red ;");
		this.map.setLayoutX(Stage1.WINDOW_WIDTH*0.08);
	    this.map.setLayoutY(Stage1.WINDOW_WIDTH*0.12);
	}
	
	//method to add row and column constraints of the grid pane
	private void addGridPaneConstraints(){
		
		//set number of rows
		for(int i=0;i<Stage1.MAP_NUM_ROWS;i++){
			RowConstraints row = new RowConstraints();
			row.setPercentHeight(5);
			this.map.getRowConstraints().add(row);
		}
	    
	     //set the number of columns and width of each column (in %); 3 cols, width = 30%;
		for(int i=0;i<Stage1.MAP_NUM_COLS;i++){
			ColumnConstraints col = new ColumnConstraints();
			col.setPercentWidth(7);
			this.map.getColumnConstraints().add(col);
		}	  
	          
		 //loop that will add the image views / land images to the gridpane
	     int counter=0;
	     for(int row=0;row<Stage1.MAP_NUM_ROWS;row++){
	    	 for(int col=0;col<Stage1.MAP_NUM_COLS;col++){
	    		 GridPane.setConstraints(elements.get(counter),col,row); 
	    		 counter++;
	    	 }
	     }   
	}
}