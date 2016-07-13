/* 433-294 Object Oriented Software Development
 * Author: Geordie Wicks <gwicks> ID : 185828
 */

import java.io.IOException;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.openal.Audio;
import org.newdawn.slick.openal.AudioLoader;
import org.newdawn.slick.util.ResourceLoader;


public class Bandit extends Aggressive{

	protected double xPos; 
	protected double yPos;
	protected boolean interacted = false;
	public Audio sound;

	
	
	/** Constructor */
	public Bandit(String image_path, double x, double y)
	        throws SlickException
	    {
	        super(image_path, x,  y);
	        this.maxHP = 40;
	        this.maxDamage = 8;
	        this.cooldown = 200;
	        this.coolDownTimer = this.cooldown;
	        this.xPos = x;
	        this.yPos = y;
	        this.dead = false;
	        this.name = "bandit";
	        health = getMaxHP();
	        this.attackRange = 50;
	        this.targetRange = 150;
	        
        	try{
/** Sound effect */
sound = AudioLoader.getAudio("WAV", ResourceLoader.getResourceAsStream("assets/sounds/Zombie.wav"));

} catch (IOException e) {

e.printStackTrace();

	}     
}
	public void playsound(){
		 sound.playAsSoundEffect(1.0f,  1.0f,  false);
	 }
	
	
	
	
/** render */

	public void render()
    {
        Image which_img;
        which_img = this.img;
        which_img.drawCentered((int) this.getxPos(), (int) this.getyPos());
      
    }
	 
	


	 


}
