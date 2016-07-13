/* 433-294 Object Oriented Software Development
 * Author: Geordie Wicks <gwicks> ID : 185828
 */


import java.io.IOException;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.openal.Audio;
import org.newdawn.slick.openal.AudioLoader;
import org.newdawn.slick.util.ResourceLoader;

public class Skeleton extends Aggressive{
	
	public Audio sound;

	public Skeleton(String image_path, double x, double y)
	        throws SlickException
	    {
	        super(image_path, x,  y);
	        this.maxHP = 100;
	        this.maxDamage = 16;
	        this.cooldown = 500;
	        this.xPos = x;
	        this.yPos = y;
	        this.dead = false;
	        this.attackRange = 50;
	        this.targetRange = 150;
	        name = "skeleton";
	        health = getMaxHP();
	        
try{

	sound = AudioLoader.getAudio("WAV", ResourceLoader.getResourceAsStream("assets/sounds/Chains.wav"));

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
