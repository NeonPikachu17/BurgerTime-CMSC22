package application;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Sprite2 {
	protected Image img;
	protected double xPos, yPos, dx, dy;
	protected boolean visible;
	protected double width;
	protected double height;
	
	public Sprite2(double xPos, double yPos){
		this.xPos = xPos;
		this.yPos = yPos;
		this.visible = true;
	}
	
	//method to set the object's image
	protected void loadImage(String filename,int width, int height){
		try{
			this.img = new Image(filename,width,height,false,false);
	        this.setSize();
		} catch(Exception e){}
	}
	
	//method to set the image to the image view node
	void render(ImageView iv){	
		iv.setImage(this.img);
		//set x and y position of the image view
		iv.setLayoutX(this.xPos);
		iv.setLayoutY(this.yPos);
        
    }
	
	//method to set the object's width and height properties
	private void setSize(){
		this.width = this.img.getWidth();
	       this.height = this.img.getHeight();
	}
	
	public void setDX(double dx){
		this.dx = dx;
	}
	
	public void setDY(double dy){
		this.dy = dy;
	}
	
	//method to return the image
	Image getImage(){
		return this.img;
	}
	
	public double getX() {
    	return this.xPos;
	}

	public double getY() {
    	return this.yPos;
	}
	
	public double getDX(){
		return this.dx;
	}
	public double getDY(){
		return this.dy;
	}

}