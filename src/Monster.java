/* 433-294 Object Oriented Software Development
 * Author: Geordie Wicks <gwicks> ID : 185828
 */

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;



public abstract class Monster extends Unit {

	protected boolean interacted = false;
	protected int attackRange;
	protected int targetRange;
	
	public Monster(String image_path, double x, double y)
	        throws SlickException
	    {
	        super(image_path, x,  y);
	      
	        this.xPos = x;
	        this.yPos = y;
	        this.dead = false;
	      
	      
	    }


	 public void render()
	    {
	        Image which_img;
	        which_img = this.img;
	        which_img.drawCentered((int) this.getxPos(), (int) this.getyPos());
	      
	    }
	 
	
	 
	 



}
