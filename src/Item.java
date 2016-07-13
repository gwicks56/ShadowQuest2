/* 433-294 Object Oriented Software Development
 * Author: Geordie Wicks <gwicks> ID : 185828
 */


import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


public abstract class Item extends Entity{
	
	
	protected double xPos, yPos;
	protected boolean picked_up = false;
	protected Image img1;
	

	public Item(String image_path, double x, double y) 
		throws SlickException
		{
	            
	        super(image_path, x,  y);
				
	           
	            this.xPos = x;
	            this.yPos = y;
	            this.picked_up = false;
	            
	        }
	
	public void render()
    {
        Image which_img;
        which_img = this.img;
        which_img.drawCentered((int) this.xPos, (int) this.yPos);
    }
	
	public void render(String image_path, int x, int y)
	throws SlickException
	{
		img1 = new Image(image_path);
		int xPos1 = x;
		int yPos1 = y;
		img1.drawCentered(xPos1,yPos1);
		
	}
	
	//get item xPos
	
	public double getItemX(){
		return xPos;
	}
	//get item ypos
	public double getItemY(){
		return yPos;
	}
	




}


