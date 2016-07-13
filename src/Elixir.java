/* 433-294 Object Oriented Software Development
 * Author: Geordie Wicks <gwicks> ID : 185828
 */

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


public class Elixir extends Item {

	public Elixir(String image_path, double x, double y)
	        throws SlickException
	    {
	        super(image_path, x,  y);
	      
	        this.xPos = x;
	        this.yPos = y;
	        this.picked_up = false;
	        this.name = "elixir";
	      
	    }
	
	public void render()
    {
	 
        Image which_img;
        which_img = this.img;
        which_img.drawCentered((int) this.xPos, (int) this.yPos);
    
	 
    }

}
