/** 433-294 Object Oriented Software Development
 * Author: Geordie Wicks <gwicks> ID : 185828
 */



import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.openal.Audio;
import java.io.IOException;
import org.newdawn.slick.openal.AudioLoader;
import org.newdawn.slick.util.ResourceLoader;



public abstract class Unit extends Entity{
	

	
	protected float healthBarWidth;
	/** The height of the floating health bar */
	protected final float healthBarHeight = 20;
/** Unit's Max Health Points **/
	protected double maxHP;
	/** Unit's unique sound */
	protected Audio sound;
	/** Unit's current health */
	protected double health;
	/** Unit status */
	protected boolean dead;
	/** Units Max Energy  **/
	protected double maxDamage;
	/** Units Damage */
	protected double damage;
	/** Units cooldown time */
	protected int cooldown;
	/** the cooldown timer */
	protected int coolDownTimer;
	/** direction unit facing for image */
	protected boolean leftFace = false;
	/** Units speed */
	protected double SPEED;
	/** Units audio sound effect */
	private Audio wavEffect;
	/** Whether unit has been attacked */
	protected boolean attacked = false;
	
	
	
	
	
	protected Image img_flipped = null;

	 // In pixels
	 protected double x, y;
	 protected double width, height;
	 protected boolean face_left = false;
    
    /** Unit constructor */
    public Unit(String image_path, double x, double y)
            throws SlickException
        {
            
    		super(image_path, x,  y);
    		this.img_flipped = img.getFlippedCopy(true, false);
            this.xPos = x;
            this.yPos = y;
            this.dead = false;
            health = maxHP;
            try{
                wavEffect = AudioLoader.getAudio("WAV", ResourceLoader.getResourceAsStream("/assets/sounds/sword2.wav"));}
                catch (IOException e){
               	e.printStackTrace();
                }
           
        }
    
    public void update(World world, int dir_x, int dir_y, boolean interact, boolean attack, int delta)
    {
    	/**if(this.getHealth() <= 0)
    	{
    		this.die(world);
    		return;
    	}*/
    	
    	if(this.coolDownTimer > 0)
    	{
    		this.coolDownTimer -= delta;
    	}
    	else
		{
			this.coolDownTimer = this.cooldown;
		}
    	
    	// Update player facing based on X direction
        if (dir_x > 0)
            this.face_left = false;
        else if (dir_x < 0)
            this.face_left = true;

        // Move the player by dir_x, dir_y, as a multiple of delta * speed
        double new_x = this.xPos + dir_x * delta * SPEED;
        double new_y = this.yPos + dir_y * delta * SPEED;
        
        

        // Move in x first
        double x_sign = Math.signum(dir_x);
        if(!world.terrainBlocks(new_x + x_sign * width / 2, this.yPos + height / 2) 
                && !world.terrainBlocks(new_x + x_sign * width / 2, this.yPos - height / 2)) {
            this.xPos = new_x;
        }
        
        // Then move in y
        double y_sign = Math.signum(dir_y);
        if(!world.terrainBlocks(this.xPos + width / 2, new_y + y_sign * height / 2) 
                && !world.terrainBlocks(this.xPos - width / 2, new_y + y_sign * height / 2)){
            this.yPos = new_y;
        }
    }
   
	/** Give unit a target to attack and play sound */
	public void attack(Unit target)
	{
		if(coolDownTimer <= 0)
		{
			double  max, damage;
			max= this.getMaxDamage();
			damage = (int)(Math.random() * max);
			target.getsDamaged(damage);
			wavEffect.playAsSoundEffect(1.0f, 1.0f, false);
			
		}
		
		
	}
	/** Change status to dead */
	 public void die(World world)
	 {
		 this.dead = true;
	 }
	/** Lower health if damaged in combat */
	public void getsDamaged(double damage)
	{
		this.health -= damage;
		this.attacked = true;
	}
	
	public void renderHealthandTalk(Graphics g)
	{
		renderHealthBox(g);
	}
	
	public void renderHealthBox(Graphics g)
	{
		/** colors for boxes */
		
		Color VALUE = new Color(1.0f, 1.0f, 1.0f); // White
		Color BAR_BG = new Color(0.0f, 0.0f, 0.0f, 0.8f); // Black, 
		Color BAR = new Color(0.8f, 0.0f, 0.0f, 0.8f); // Red, 
	
		/** Set the width of the health bar based on the unit's name */
		this.healthBarWidth = Math.max(70, g.getFont().getWidth(this.getName()) + 6);
		
		
		/** Draw the health bar */
		float barX = (float) this.getxPos() - healthBarWidth / 2;
		float barY = (float) this.getyPos() - this.getHeight() / 2 - healthBarHeight + 5;

		g.setColor(BAR_BG);
		g.fillRect(barX, barY, healthBarWidth, healthBarHeight);
		g.setColor(BAR);
		g.fillRect(barX, barY, (healthBarWidth * ((float) getHealth() / (float)getMaxHP())),
				healthBarHeight); 

		/** Draw name */
		g.setColor(VALUE);
		float textX = barX + (healthBarWidth - g.getFont().getWidth(this.getName())) / 2;
		float textY = barY + (healthBarHeight - g.getFont().getHeight(this.getName())) / 2;
		g.drawString(this.getName(), textX, textY); 
	}
	
	
	
	
	/** Get Unit health */
	public double getHealth(){
		return health;
	}
	/** Get Unit Cool down Timer */
	public int getCoolDownTimer(){
		return coolDownTimer;
	}
	/** Get Unit cool down Time */
	public int getCooldown(){
		return cooldown;
	}
	
	public void setCoolDown(int x)
	{
		this.cooldown = x;
	}
	
	
	
	public void restoreHealth()
	{
		this.health  = this.maxHP;
	}
	
	
	
	/** Get Unit maximum damage */
	protected double getMaxDamage(){
		return maxDamage;
	}
	
	protected void setMaxDamage(double maxDamage){
		this.maxDamage = maxDamage;
	}
	
	public void setMaxHP(double maxHP){
		this.maxHP = maxHP;
	}
	
	/** Get Unit speed */
	public double getSpeed(){
		return SPEED;
	}
	public void setSpeed(double s){
		SPEED = s;
	}
	/** Get Unit maximum health */
	protected double getMaxHP(){
		return maxHP;
	}
	
	

	/** Get Unit health */
	protected String getName(){
		return name;
	}
	
		public void setImage(Image i){
		img = i;
	}
	/** Get Unit health */
	public Image getImage(){
		return img;
	}


	/** Get Unit width */
	public int getWidth(){
		return img.getWidth();
	}
	/** Get Unit height */
	public int getHeight(){
		return img.getHeight();
	}
	


	
	
}


