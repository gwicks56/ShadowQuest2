/* 433-294 Object Oriented Software Development
 * Author: Geordie Wicks <gwicks> ID : 185828
 */

import org.newdawn.slick.SlickException;
import org.newdawn.slick.openal.Audio;


public abstract class Aggressive extends Monster {
	public Audio sound;

	public Aggressive(String image_path, double x, double y)
	        throws SlickException
	    {
	        super(image_path, x,  y);
	       
	       
	        xPos = x;
	        yPos = y;
	        dead = false;
	        SPEED = 0.25;
	     }

	public void playsound(){
		 sound.playAsSoundEffect(1.0f,  1.0f,  false);
	 }
	
	public void update(int delta, World world)
	{
		if(this.health <= 0)
		{
			this.die(world);
		}
		
		if(this.coolDownTimer > 0)
		{
			this.coolDownTimer -= delta;
		}
		else
		{
			
			this.coolDownTimer = this.cooldown;
		}
		
		/**Scan for player to chase */
		Unit player = scanForPlayer(world);
		{
			if(player != null)
			{
				double distanceX = player.getxPos() - this.getxPos();
				double distanceY = player.getyPos()- this.getyPos();
				
				double distance = Math.sqrt(distanceX * distanceX + distanceY * distanceY);
				
				if(distance <= attackRange)
				{
					this.attack(player);
				}
				
				else if(distance <= targetRange)
				{
				
					double dx = (distanceX/distance) * SPEED * delta;
					double dy = (distanceY/distance) * SPEED * delta;
				
					double moveX = this.getxPos() + dx;
					double moveY = this.getyPos() + dy;
					this.setxPos(moveX);
					this.setyPos(moveY);
					this.playsound();
				
					
				}
			}
		}
	}
	/** Chase and attack plaer */
	public void move(Double moveXto, double moveYto, World world, int delta)
	{
		double x, y, distance;
		double aggressiveX, aggressiveY;
		
		Player player = world.getPlayer();
		
		x= player.getxPos();
		y= player.getyPos();
		
		aggressiveX = this.xPos;
		aggressiveY = this.yPos;
		
		double distX = aggressiveX - x;
		double distY = aggressiveY - y;
		
		distance = Math.sqrt(distX * distX + distY * distY);
		
		if(distance < targetRange)
		{
			double dx = (distX/distance) * SPEED * delta;
			double dy = (distY/distance) * SPEED * delta;
			
			double moveX = aggressiveX + dx;
			double moveY = aggressiveY + dy;
			
			this.setxPos(moveX);
			this.setyPos(moveY);
			
			
		}
	} 
	
	public Player scanForPlayer(World world)
	{
		double x, y, distance;
		double aggressiveX, aggressiveY;
		
		Player player = world.getPlayer();
		
		x= player.getxPos();
		y= player.getyPos();
		
		aggressiveX = this.xPos;
		aggressiveY = this.yPos;
		
		double distX = aggressiveX - x;
		double distY = aggressiveY - y;
		
		distance = Math.sqrt(distX * distX + distY * distY);
		
		
		if(distance < targetRange)
		{
			return player;
			
			
			
			
		}
		return null;
		
	}
	

}
