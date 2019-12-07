package application;

import java.util.ArrayList;
import java.util.Random;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Chef extends Sprite{
	private String name;
	private int pepperShot;
	private int lives;
	private boolean alive;
	
	public final static Image CHEF_IMAGE = new Image("images/ChefPeterPepperF.png",Chef.CHEF_WIDTH,Chef.CHEF_HEIGHT,false,false);
	protected final static int CHEF_WIDTH = 30;
	private final static int CHEF_HEIGHT = 50;

	public Chef(String name, int x, int y){
		super(x,y);
		this.name = name;
		Random r = new Random();
		this.pepperShot = 5;
		this.lives = 3;
		this.alive = true;
		this.loadImage(Chef.CHEF_IMAGE);
	}
	//getters
	public int getLives() {
		return this.lives;
	}
	
	public int getPepperShot() {
		return this.pepperShot;
	}
	
	public void firePepperShot() {
		this.pepperShot--;
	}

	public boolean isAlive(){
		if(this.alive) return true;
		return false;
	} 
	public String getName(){
		return this.name;
	}

	public void die(){
    	this.alive = false;
    }
	

	
}