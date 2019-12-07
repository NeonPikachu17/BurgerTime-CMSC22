package application;

public class Element extends Sprite2{
	private String name;

	//setting values
	public final static String PLATFORM_IMG = "images/platform.png";
	public final static String STAIRS_IMG = "images/stairs.png";
	public final static String UBL_IMG = "images/upperBunLeft.png";
	public final static String UBM_IMG = "images/upperBunMid.png";
	public final static String UBR_IMG = "images/upperBunRight.png";
	public final static String LETTLEFT_IMG = "images/lettuceLeft.png";
	public final static String LETTMID_IMG = "images/lettuceMid.png";
	public final static String LETTRIGHT_IMG = "images/lettuceRight.png";
	public final static String CHIZLEFT_IMG = "images/cheeseLeft.png";
	public final static String CHIZMID_IMG = "images/cheeseMid.png";
	public final static String CHIZRIGHT_IMG = "images/cheeseRight.png";
	public final static String LBL_IMG = "images/lowerBunLeft.png";
	public final static String LBM_IMG = "images/lowerBunMid.png";
	public final static String LBR_IMG = "images/lowerBunRight.png";
	public final static String TOMLEFT_IMG = "images/tomatoLeft.png";
	public final static String TOMMID_IMG = "images/tomatoMid.png";
	public final static String TOMRIGHT_IMG = "images/tomatoRight.png";
	public final static String PATTYLEFT_IMG = "images/pattyLeft.png";
	public final static String PATTYMID_IMG = "images/pattyMid.png";
	public final static String PATTYRIGHT_IMG = "images/pattyRight.png";
	
	public final static String PLATFORM = "platform";
	public final static String STAIRS = "stairs";
	public final static String UBL = "upperBunLeft";
	public final static String UBM = "upperBunMid";
	public final static String UBR = "upperBunRight";
	public final static String LETTLEFT = "lettuceLeft";
	public final static String LETTMID = "lettuceMid";
	public final static String LETTRIGHT = "lettuceRight";
	public final static String CHIZLEFT = "cheeseLeft";
	public final static String CHIZMID = "cheeseMid";
	public final static String CHIZRIGHT = "cheeseRight";
	public final static String LBL = "lowerBunLeft";
	public final static String LBM = "lowerBunMid";
	public final static String LBR = "lowerBunRight";
	public final static String TOMLEFT = "tomatoLeft";
	public final static String TOMMID = "tomatoMid";
	public final static String TOMRIGHT = "tomatoRight";
	public final static String PATTYLEFT = "pattyLeft";
	public final static String PATTYMID = "pattyMid";
	public final static String PATTYRIGHT = "pattyRight";
	
	public Element (double xPos, double yPos, String name){
		super(xPos, yPos);
		this.name = name;

		if (this.name.equals(Element.PLATFORM)){
			this.loadImage(Element.PLATFORM_IMG, 10, 1);
		}
		else if(this.name.equals(Element.STAIRS)){
			this.loadImage(Element.STAIRS_IMG, 6, 5);
		}
		else if(this.name.equals(Element.UBL)){
			this.loadImage(Element.UBL_IMG, Stage1.CELL_WIDTH, 20);
		}
		else if(this.name.equals(Element.UBM)){
			this.loadImage(Element.UBM_IMG, Stage1.CELL_WIDTH, 20);
		}
		else if(this.name.equals(Element.UBR)){
			this.loadImage(Element.UBR_IMG, Stage1.CELL_WIDTH, 20);
		}
		else if(this.name.equals(Element.LETTLEFT)){
			this.loadImage(Element.LETTLEFT_IMG, Stage1.CELL_WIDTH, 20);
		}
		else if(this.name.equals(Element.LETTMID)){
			this.loadImage(Element.LETTMID_IMG, Stage1.CELL_WIDTH, 20);
		}
		else if(this.name.equals(Element.LETTRIGHT)){
			this.loadImage(Element.LETTRIGHT_IMG, Stage1.CELL_WIDTH, 20);
		}
		else if(this.name.equals(Element.CHIZLEFT)){
			this.loadImage(Element.CHIZLEFT_IMG, Stage1.CELL_WIDTH, 20);
		}
		else if(this.name.equals(Element.CHIZMID)){
			this.loadImage(Element.CHIZMID_IMG, Stage1.CELL_WIDTH, 20);
		}
		else if(this.name.equals(Element.CHIZRIGHT)){
			this.loadImage(Element.CHIZRIGHT_IMG, Stage1.CELL_WIDTH, 20);
		}
		else if(this.name.equals(Element.LBL)){
			this.loadImage(Element.LBL_IMG, Stage1.CELL_WIDTH, 20);
		}
		else if(this.name.equals(Element.LBM)){
			this.loadImage(Element.LBM_IMG, Stage1.CELL_WIDTH, 20);
		}
		else if(this.name.equals(Element.LBR)){
			this.loadImage(Element.LBR_IMG, Stage1.CELL_WIDTH, 20);
		}
		else if(this.name.equals(Element.TOMLEFT)){
			this.loadImage(Element.TOMLEFT_IMG, Stage1.CELL_WIDTH, 20);
		}
		else if(this.name.equals(Element.TOMMID)){
			this.loadImage(Element.TOMMID_IMG, Stage1.CELL_WIDTH, 20);
		}
		else if(this.name.equals(Element.TOMRIGHT)){
			this.loadImage(Element.TOMRIGHT_IMG, Stage1.CELL_WIDTH, 20);
		}
		else if(this.name.equals(Element.PATTYLEFT)){
			this.loadImage(Element.PATTYLEFT_IMG, Stage1.CELL_WIDTH, 20);
		}
		else if(this.name.equals(Element.PATTYMID)){
			this.loadImage(Element.PATTYMID_IMG, Stage1.CELL_WIDTH, 20);
		}
		else if(this.name.equals(Element.PATTYRIGHT)){
			this.loadImage(Element.PATTYRIGHT_IMG, Stage1.CELL_WIDTH, 20);
		}
	}

	protected String getName(){
		return this.name;
	}
}