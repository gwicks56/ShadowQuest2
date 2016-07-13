/* 433-294 Object Oriented Software Development
 * Author: Geordie Wicks <gwicks> ID : 185828
 */

import java.io.IOException;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.openal.Audio;
import org.newdawn.slick.openal.AudioLoader;
import org.newdawn.slick.util.ResourceLoader;


public class Passive extends Monster {
	
	
	private int attackTimer = 5000;
	private int timeSinceAttack = attackTimer;
	int randomDir;
	public Audio sound;
	
/** Constuctor */
	public Passive(String image_path, double x, double y)
	        throws SlickException
	    {
	        super(image_path, x,  y);
	       
	        this.maxHP = 40;
	        this.maxDamage = 0;
	        this.cooldown = 3000;
	        this.xPos = x;
	        this.yPos = y;
	        this.dead = false;
	        this.coolDownTimer = this.cooldown;
	        this.name = "dreadbat";
	        health = getMaxHP();
	        SPEED = 0.2;
	        this.width = 60;
	        this.height = 60;
	        
	        try{

	        	sound = AudioLoader.getAudio("WAV", ResourceLoader.getResourceAsStream("assets/sounds/flapping.wav"));

	        } catch (IOException e) {

	        e.printStackTrace();
	       
	        }
	      
	    }
	/** Update passive monster */
	public void update(int delta, World world)
	{
		
		if(this.coolDownTimer > 0)
		{
			this.coolDownTimer -= delta;
		}
		else
		{
			this.coolDownTimer = this.cooldown;
			 this.playsound();
		}
		
		int randomDir =1;
		
		/** random check */
		if(attacked == false)
		{
		
			if(this.coolDownTimer <1)
			{
				randomDir = (int)(Math.random() * 9);
				this.setRandom(randomDir);
			}
		
			move(world, delta, randomDir);
		
		}
		
		/** attacked check, change movement */
		else if(attacked == true)
		{
			
			timeSinceAttack -= delta;
			if(timeSinceAttack <= 0)
			{
				attacked = false;
				timeSinceAttack = attackTimer;
			}
			moveAway(world, delta);
		}
		
		
		/** check health */
		if(this.health <= 0)
		{
			this.die(world);
		}
		
			
	}
	
	/** Movement for random and attacked */
	public void move(World world, int delta, int randdir)
	{
		int dir_x = 0, dir_y = 0;

		/** Set up random direction */
		
		if(randomDir == 1)
		{
			dir_x = 0;
			dir_y = 1;
		}
		else if(randomDir == 2)
		{
			dir_x = 0;
			dir_y = -1;
		}
		else if(randomDir == 3)
		{
			dir_x = 1;
			dir_y = 0;
		}
		else if(randomDir == 4)
		{
			dir_x = -1;
			dir_y = 0;
		}
		else if(randomDir == 5)
		{
			dir_x = 1;
			dir_y = 1;
		}
		else if(randomDir == 6)
		{
			dir_x = -1;
			dir_y = 1;
		}
		else if(randomDir == 7)
		{
			dir_x = -1;
			dir_y = -1;
		}
		else if(randomDir == 8)
		{
			dir_x = 1;
			dir_y = -1;
		}
		else//(randomDir == 9)
		{
			dir_x = 0;
			dir_y = 0;
		}
		
		double new_x = this.getxPos() + dir_x * delta * SPEED;
		double new_y = this.getyPos() + dir_y * delta * SPEED;
		
		

        // Move in x first
        double x_sign = Math.signum(dir_x);
        if(!world.terrainBlocks(new_x + x_sign * width / 2, this.yPos + height / 2) 
                && !world.terrainBlocks(new_x + x_sign * width / 2, this.yPos - height / 2)) {
        	this.setxPos(new_x);
        }
        
        // Then move in y
        double y_sign = Math.signum(dir_y);
        if(!world.terrainBlocks(this.xPos + width / 2, new_y + y_sign * height / 2) 
                && !world.terrainBlocks(this.xPos - width / 2, new_y + y_sign * height / 2)){
        	this.setyPos(new_y);
        }
       
    
		
	}
	/** If attacked run from player */
	public void moveAway(World world, int delta)
	{
		
		Player player = world.getPlayer();
		double distanceX = player.getxPos() - this.getxPos();
		double distanceY = player.getyPos()- this.getyPos();
		
		double distance = Math.sqrt(distanceX * distanceX + distanceY * distanceY);
		
		
		
		
			double dx = (distanceX/distance) * SPEED * delta;
			double dy = (distanceY/distance) * SPEED * delta;
		
			double new_x = this.getxPos() - dx;
			double new_y = this.getyPos() - dy;
			
			double signX = (new_x - this.getxPos());
			double signY = (new_y - this.getyPos());
			 // Move in x first
	        double x_sign = Math.signum(signX);
	        if(!world.terrainBlocks(new_x + x_sign * width / 2, this.yPos + height / 2) 
	                && !world.terrainBlocks(new_x + x_sign * width / 2, this.yPos - height / 2)) {
	        	this.setxPos(new_x);
	        }
	        
	        // Then move in y
	        double y_sign = Math.signum(signY);
	        if(!world.terrainBlocks(this.xPos + width / 2, new_y + y_sign * height / 2) 
	                && !world.terrainBlocks(this.xPos - width / 2, new_y + y_sign * height / 2)){
	        	this.setyPos(new_y);
	        }
	}
		
		
	public void render()
    {
        Image which_img;
        which_img = this.face_left ? this.img_flipped : this.img;
        which_img.drawCentered((int) this.getxPos(), (int) this.getyPos());
    }
	
	/*play sound effect */
	
	public void playsound(){
		 sound.playAsSoundEffect(1.0f,  1.0f,  false);
	 }
	
	/** Check */
	public int getRandom(){
		return randomDir;
	}
	
	/** Set random */
	public void setRandom(int x)
	{
		randomDir = x;
	}
	
	/** Get timer */
	public int getTimeSinceAttack()
	{
		return timeSinceAttack;
	}

}