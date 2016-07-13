import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


public class Garth extends Villager {

	public Garth(String image_path, double x, double y)
	        throws SlickException
	    {
	        super(image_path, x, y);
	        name = "Garth";
	        health = getMaxHP();
	      
	    }
	
	 public void render()
	    {
	        Image which_img;
	        which_img = this.img;
	        which_img.drawCentered((int) this.xPos, (int) this.yPos);
	    }
	 
	/** public void die(World world)
		{
			
		}
	 */
	 public void interact(Player player)
		{
			
				// Give amulet quest
				if (player.hasItem("amulet") == null)
				{
					setDialogue("Find the Amulet of Vitality, across the river to the west.");
				}
				// Give sword quest
				else if (player.hasItem("sword") == null)
				{
					setDialogue("Find the Sword of Strength - cross the river and back, on the east side.");
				}
				// Give tome quest
				else if (player.hasItem("book") == null)
				{
					setDialogue("Find the Tome of Agility, in the Land of Shadows.");
				}
				// Out of quests
				else
				{
					setDialogue("You have found all the treasure I know of.");
				}
	 
	 
		}}
