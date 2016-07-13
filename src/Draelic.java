import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.openal.Audio;
import org.newdawn.slick.openal.AudioLoader;
import org.newdawn.slick.util.ResourceLoader;

import java.io.IOException;



public class Draelic extends Aggressive{
	
	public Audio sound;

	public Draelic(String image_path, double x, double y)
	        throws SlickException
	    {
	        super(image_path, x,  y);
	        this.maxHP = 140;
	        this.maxDamage = 30;
	        this.cooldown = 400;
	        this.xPos = x;
	        this.yPos = y;
	        this.dead = false;
	        health = getMaxHP();
	        this.attackRange = 50;
	        this.targetRange = 150;
	        name = "Draelic The Horrible";
	        this.coolDownTimer = this.cooldown;
	        
      	try{

sound = AudioLoader.getAudio("WAV", ResourceLoader.getResourceAsStream("assets/sounds/laugh2.wav"));

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
