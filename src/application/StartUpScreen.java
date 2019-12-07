package application;

import java.nio.file.Paths;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;

public class StartUpScreen {
	private BorderPane pane1;
	private StackPane pane;
	public static Stage stage;
	private Group root;
	private Scene scene;
	private GraphicsContext gc;
	private Canvas canvas;
	Image arrow;
	Image BTLogo;
	private int buttonYPos;
	private boolean isClicked;
	public static final String COPYRIGHT = "\u00a9";
	private static MediaPlayer BGMusic;
	// Constructor
	public StartUpScreen() {
		// Sets up the Scene and the Stage
		this.root = new Group();
		this.pane = new StackPane();
		this.scene = new Scene(root, 850, 850);
		this.canvas = new Canvas(900, 900);
		this.gc = canvas.getGraphicsContext2D();
		// Gets the image of the icon in the image folder
		this.arrow = new Image("images/arrow.png", 35, 30, false, false);
		this.BTLogo = new Image("images/BTLogo.png", 700, 200, false, false);
		// Sets the position of the arrow
		this.buttonYPos = 325;
		// For checking
		this.isClicked = false;
	}
	
	public void setStage(Stage stage) {
		// Creates Stage to add elements
		this.stage = stage;
		// So that the window cannot be resizable
		this.stage.setResizable(false);
		this.stage.sizeToScene();
		// Adds the items to the canvas
		this.addComponents();
		// Enables the movement of the arrow
		this.handleKeyPressEvent();
		this.root.getChildren().add(canvas);
		// Sets the title of the Program itself
		this.stage.setTitle("BurgerTime");
		this.stage.setScene(this.scene);
		this.stage.show();
	}
	
	public void addComponents() {
		// Changes the color of the screen
		this.gc.setFill(Color.BLACK);
		this.gc.fillRect(0, 0, 850, 850);
		this.gc.setFill(Color.GRAY);
		// Effects the font to be used
		Font font = Font.font("BurgerTime", FontWeight.BOLD, FontPosture.ITALIC, 90);
		this.gc.setFont(font);
		// place the text in a specified x & y position
		// Changes color of fill to white
		Font font2 = Font.font("Comic Sans", FontWeight.BOLD ,35);
		this.gc.setFont(font2);
		// Placement of the different texts on the screen
		this.gc.fillText("Play Now", 300, 350);
		this.gc.fillText("Instructions", 300, 400);
		this.gc.fillText("About the Game", 300, 450);
		this.gc.fillText((COPYRIGHT + "1982 DATA EAST USA. INC."), 200, 600);
		this.gc.fillText(("CREDITS GO TO NINTENDO"), 200, 650);
		this.gc.fillText(("\t OF AMERICA. INC."), 200, 700);
		
		// So that the arrow does not appear if the arrow key hasn't been pressed yet
		if(!isClicked) {
			setIsClicked();
			this.buttonYPos = 325;
			
		} else {
			if(this.buttonYPos < 325) {
				this.buttonYPos = 325;
			} else if(this.buttonYPos > 425) {
				this.buttonYPos = 425;
			}
			this.gc.drawImage(arrow, 250, this.buttonYPos);
		}
		this.gc.drawImage(BTLogo, 50, 150);
	}
	
	// Setter method
	public void setIsClicked() {
		this.isClicked = true;
	}
	
	private void setInstructions() {
		Instructions instructions = new Instructions(this.stage);
		stage.setScene(instructions.getScene());
		stage.show();
	}
	
	private void setAboutTheGame() {
		AboutTheGame about = new AboutTheGame(stage);
		stage.setScene(about.getScene());
	}
	
	private void setMusic(String musicFile) {
		PauseTransition pause = new PauseTransition(Duration.seconds(1.0));
//		PauseTransition pause2 = new PauseTransition(Duration.seconds(0.5));
		pause.setOnFinished(new EventHandler<ActionEvent>() {
			
			public void handle(ActionEvent arg0) {
				Media sound = new Media(Paths.get(musicFile).toUri().toString());
				BGMusic = new MediaPlayer(sound);
				BGMusic.setAutoPlay(true);
				BGMusic.setOnEndOfMedia(() -> {
				
				});
			}
		});
		pause.play();
	}
			
	private void setNewGame() {
		setMusic("src/music/GameStart.mp3");
		Stage1 stage1 = new Stage1();
		stage1.setStage(stage);
	}
	
	// Handles the keypress event
	private void handleKeyPressEvent() {
		this.scene.setOnKeyPressed(
    	        new EventHandler<KeyEvent>()
    	        {
					public void handle(KeyEvent e)
    	            {					
						if (e.getCode() == KeyCode.UP) {
							System.out.println("Up key pressed!");
							setDY(-50);
					    } else if (e.getCode() == KeyCode.DOWN) {
					    	System.out.println("Down key pressed!");
					    	setDY(50);
					    } else if (e.getCode() == KeyCode.ENTER) {
					    	
					    	if(getDY() == 375) {
					    		System.out.println("Enter Key Pressed");
					    		setInstructions();
					    	} else if(getDY() == 425) {
					    		setAboutTheGame();
					    	} else if(getDY() == 325){
					    		setNewGame();
					    	}
					    	
					    }
    	            }
    	        });
    }
	
	// Setter position of the arrow
	private void setDY(int dx){
		this.buttonYPos += dx;
		this.addComponents();
	}
	
	private int getDY() {
		return this.buttonYPos;
	}
	
	Scene getScene() {
		return this.scene;
	}
	
}
