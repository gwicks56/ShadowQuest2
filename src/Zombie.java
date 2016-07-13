/* 433-294 Object Oriented Software Development
 * Author: Geordie Wicks <gwicks> ID : 185828
 */


import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.openal.Audio;
import org.newdawn.slick.openal.AudioLoader;
import org.newdawn.slick.util.ResourceLoader;

import java.io.IOException;


public class Zombie extends Aggressive{
	
	public Audio sound;

	public Zombie(String image_path, double x, double y)
	        throws SlickException
	    {
	        super(image_path, x,  y);
	        this.maxHP = 60;
	        this.maxDamage = 10;
	        this.cooldown = 800;
	        this.attackRange = 50;
	        this.targetRange = 150;
	        
	        this.coolDownTimer = this.cooldown;
	        this.xPos = x;
	        this.yPos = y;
	        this.dead = false;
	        this.name = "zombie";
	        health = getMaxHP();
	        
        	try{

sound = AudioLoader.getAudio("WAV", ResourceLoader.getResourceAsStream("assets/sounds/MonsterGrowl.wav"));

} catch (IOException e) {

e.printStackTrace();

}     
	        
	    }
	
	 public void render()
	    {
	        Image which_img;
	        which_img = this.face_left ? this.img_flipped : this.img;
	        which_img.drawCentered((int) this.getxPos(), (int) this.getyPos());
	    }
	 
	 public void playsound(){
		 sound.playAsSoundEffect(1.0f,  1.0f,  false);
	 }
	 
	 

}
