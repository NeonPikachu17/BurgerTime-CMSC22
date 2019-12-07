package application;

import java.util.ArrayList;

import application.GameStage;
import application.Chef;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GameTimer extends AnimationTimer {
	
	public GraphicsContext gc;
	private Scene theScene;
	private GridPane gridpane;
	private Chef chefP;
	public Rectangle2D mapBounds;
	public static Stage stage;
	
	//  Boolean Values
	private boolean isBounded;
	private boolean isGameOver;
	private Group foreground;
//	private Canvas canvas;
	
	// Loading of Images
	public final static Image CHEFFS_IMAGE = new Image("images/ChefPeterPepperF.png",Chef.CHEF_WIDTH,Chef.CHEF_WIDTH,false,false);
	public final static Image CHEFF_IMAGE = new Image("images/ChefPeterPepperF.gif",Chef.CHEF_WIDTH,Chef.CHEF_WIDTH,false,false);
	public final static Image CHEFL_IMAGE = new Image("images/ChefPeterPepperL.gif",Chef.CHEF_WIDTH,Chef.CHEF_WIDTH,false,false);
	public final static Image CHEFR_IMAGE = new Image("images/ChefPeterPepperR.gif",Chef.CHEF_WIDTH,Chef.CHEF_WIDTH,false,false);
	public final static Image CHEFB_IMAGE = new Image("images/ChefPeterPepperB.gif",Chef.CHEF_WIDTH,Chef.CHEF_WIDTH,false,false);
	public final static Image CHEFBS_IMAGE = new Image("images/ChefPeterPepperB.png",Chef.CHEF_WIDTH,Chef.CHEF_WIDTH,false,false);
	
	GameTimer(GraphicsContext gc, Scene theScene, Stage stage, Bounds mapBounds){
		this.theScene = theScene;
		this.gc = gc;
		this.foreground = new Group();
		this.mapBounds = new Rectangle2D(60, 70, 720,450);
		this.chefP = new Chef("CheffyPepito",150,250);
//		this.chefP.toFront();
//		this.mapBounds = new Rectangle2D(0,0,600,600);
		this.isBounded = true;
		this.isGameOver = false;
		//call method to handle mouse click event
		this.handleKeyPressEvent();	
	}
	
	@Override
	public void handle(long currentNanoTime) {
		this.gc.clearRect(0, 0, Stage1.WINDOW_WIDTH,Stage1.WINDOW_HEIGHT);
		this.chefP.render(this.gc);
		if(this.chefP.getX() + this.chefP.getDX() >= 70 && this.chefP.getX() + this.chefP.getDX() <= 720 && this.chefP.getY() + this.chefP.getDY() >= 70 && this.chefP.getY() + this.chefP.getDY() <= 450)
			this.chefP.move();
		
	}
	
	//method that will listen and handle the key press events
	private void handleKeyPressEvent() {
		theScene.setOnKeyPressed(new EventHandler<KeyEvent>(){
			public void handle(KeyEvent e){
            	KeyCode code = e.getCode();
        		moveMyShip(code);                      		
			}
		});
		
		theScene.setOnKeyReleased(new EventHandler<KeyEvent>(){
            public void handle(KeyEvent e){
	            	KeyCode code = e.getCode();
	                if(code != KeyCode.SPACE) stopMyShip(code);
	            }
	        });
    }
	
	public void fixBounds(Chef sprite) {
		sprite.setDX(0);
		sprite.setDY(0);
		sprite.move();
	}
	
	//method that will move the ship depending on the key pressed
	private void moveMyShip(KeyCode ke) {
		
		if(ke==KeyCode.DOWN) {
			this.chefP.loadImage(CHEFB_IMAGE);
			if(this.chefP.getDY() + this.chefP.getY() > 70)
				this.chefP.setDY(5);
			else this.chefP.setDY(0);
			System.out.println(this.chefP.getY());
		}
		
		if(ke==KeyCode.LEFT) {
			this.chefP.loadImage(CHEFL_IMAGE);
			this.chefP.setDX(-5);
		}

		if(ke==KeyCode.UP) {
			this.chefP.loadImage(CHEFB_IMAGE);
			this.chefP.setDY(-5); 
		}
	
		if(ke==KeyCode.RIGHT) {
			this.chefP.loadImage(CHEFR_IMAGE);
			this.chefP.setDX(5);
		}
			
		
		System.out.println(ke+" key pressed.");
   	}
	
	//method that will stop the ship's movement; set the ship's DX and DY to 0
	private void stopMyShip(KeyCode code){
		System.out.println("Stopped");
		this.chefP.loadImage(CHEFFS_IMAGE);
		this.chefP.setDX(0);
		this.chefP.setDY(0);
	}

	
}
