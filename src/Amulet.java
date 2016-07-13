/* 433-294 Object Oriented Software Development
 * Author: Geordie Wicks <gwicks> ID : 185828
 */

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


public class Amulet extends Item {
	
	protected int hpIncrease = 80;

	 public Amulet(String image_path, double x, double y)
		        throws SlickException
		    {
		        super(image_path, x,  y);
		      
		        this.xPos = x;
		        this.yPos = y;
		        this.picked_up = false;
		        this.name = "amulet";
		      
		    }
	 
	 public void render()
	    {
		 
	        Image which_img;
	        which_img = this.img;
	        which_img.drawCentered((int) this.xPos, (int) this.yPos);
	    
	    }
	 

}

