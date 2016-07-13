import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


public class Elvira extends Villager {
	
	

	public Elvira(String image_path, double x, double y)
	        throws SlickException
	    {
	        super(image_path, x, y);
	        name= "Elivra";
	        health = getMaxHP();
	      
	    }
	
	public void render()
    {
        Image which_img;
        which_img = this.img;
        which_img.drawCentered((int) this.xPos, (int) this.yPos);
    }
	
	public void die(World world)
	{
		
	}
	
	public void interact(Player target)
	{
		
			
			// Player is on full health, do nothing
			 if (target.getHealth() == target.getMaxHP())
			{
				setDialogue("Return to me if you ever need healing.");
			}
			 //Player is injured, heal to full health
			else
			{
				target.restoreHealth();
				setDialogue("You're looking much healthier now.");
			}
		
		
	}
	

}
