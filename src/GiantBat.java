/* 433-294 Object Oriented Software Development
 * Author: Geordie Wicks <gwicks> ID : 185828
 */


import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


public class GiantBat extends Passive {

	public GiantBat(String image_path, double x, double y)
	        throws SlickException
	    {
	        super(image_path, x,  y);
	        this.maxHP = 1;
	        this.maxDamage = 0;
	        this.cooldown = 0;
	        this.xPos = x;
	        this.yPos = y;
	        this.dead = false;
	      
	    }
	
	 public void render()
	    {
	        Image which_img;
	        which_img = this.face_left ? this.img_flipped : this.img;
	        which_img.drawCentered((int) xPos, (int) yPos);
	    }


}
