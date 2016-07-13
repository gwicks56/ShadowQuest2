/* 433-294 Object Oriented Software Development
 * Author: Geordie Wicks <gwicks> ID : 185828
 */


import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


public abstract class Entity {
	
	protected int interactDistance = 50;
	protected String name;
	protected double xPos; 
	protected double yPos;
	protected Image img = null;
	protected Image img_flipped = null;

	
	
	/** Constructor */

	public Entity(String image_path, double x, double y) 
					throws SlickException
	{
	        
	            img = new Image(image_path);
	            this.xPos = x;
	            this.yPos = y;
	            
	}
	
	/** Get xPos */
	
	public double getxPos(){
		return xPos;
	}
	/** set xPos */
	public void setxPos(double x){
		this.xPos = x;
	}
	/** get ypos */
	public double getyPos(){
		return yPos;
	}
	/** set yPos */
	public void setyPos(double y){
		this.yPos = y;
	}
	
	
	/** Get entity name */
	protected String getName(){
		return name;
	}
	
	
	
	public void setImage(Image i){
		img = i;
	}
	public Image getImage(){
		return img;
	}
	
	
	/** Get distance between entity and player */
	public double getDistance(Entity entity1, Player player)
	{
		 
			
				double x1, y1, x2, y2, distance;
				
				
				x1= entity1.getxPos();
				y1= entity1.getyPos();
				
				x2 = player.getxPos();
				y2 = player.getyPos();
				
				
				
				
				double distX = x2 - x1;
				double distY = y2- y1;
				
				distance = Math.sqrt(distX * distX + distY * distY);
				
				return distance;
				
			
	}
	
	

	}


