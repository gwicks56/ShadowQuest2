/* 433-294 Object Oriented Software Development
 * Author: Geordie Wicks <gwicks> ID : 185828
 */
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


public class Prince extends Villager{

	public Prince(String image_path, double x, double y)
	        throws SlickException
	    {
	        super(image_path, x, y);
	        name= "Prince";
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
	
	
	/** Set up dialogue */
	public void interact(Player player)
	{
		
		
			
		if (player.hasItem("elixir") != null)
		{
			setDialogue("The elixir! My father is cured! Thankyou!");
		}
		else
		{
			setDialogue("Please seek out the Elixir of Life to cure the king.");
		}
		
	}
}
