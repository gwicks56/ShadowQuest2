/* 433-294 Object Oriented Software Development
 * Author: Geordie Wicks <gwicks> ID : 185828
 */


import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Animation;
import java.awt.List;
import java.util.ArrayList;

/** The character which the user plays as.
 */
public class Player extends Unit
{
 

    // Pixels per millisecond
    private static final double SPEED = 0.25;
    private static final int playerRestartX = 738;
    private static final int playerRestartY = 549;
	protected ArrayList<Item> player_items = null;
	private double width = 25, height = 25;
	protected Image panel = null;
	private double attackRange = 50;

 

    /** Creates a new Player.
     * @param image_path Path of player's image file.
     * @param x The Player's starting x location in pixels.
     * @param y The Player's starting y location in pixels.
     */
    public Player(String image_path, double x, double y)
        throws SlickException
    {
        super(image_path, x,  y);
        this.maxHP = 100;
        this.maxDamage = 26;
        this.health = maxHP;
        this.cooldown = 600;
        this.coolDownTimer = this.cooldown;
        this.xPos = x;
        this.yPos = y;
        this.dead = false;
        player_items = new ArrayList<Item>();
        panel = new Image("assets/panel.png");
      
    }

    /** Move the player in a given direction.
     * Prevents the player from moving outside the map space, and also updates
     * the direction the player is facing.
     * @param world The world the player is on (to check blocking).
     * @param dir_x The player's movement in the x axis (-1, 0 or 1).
     * @param dir_y The player's movement in the y axis (-1, 0 or 1).
     * @param delta Time passed since last frame (milliseconds).
     */
    
    public void update(World world, int dir_x, int dir_y, boolean interact, boolean attack, int delta)
    {
    	
      	if(this.getHealth() <= 0)
    	{
    		this.die(world);
    		return;
    	}
    	
    	if(this.coolDownTimer > 0)
    	{
    		this.coolDownTimer -= delta;
    	}
    	else
		{
			this.coolDownTimer = this.cooldown;
		}
    	
    	boolean a = attack;
    	
    	    	
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
            
         scanForMonster(world, a); 
         scanForPassiveMonster(world, a);

        
    }
   

    /** Draw the player to the screen at the correct place.
     * @param g The current Graphics context.
     * @param cam_x Camera x position in pixels.
     * @param cam_y Camera y position in pixels.
     */
    public void render(Graphics g)
    {
        Image which_img;
       
        which_img = this.face_left ? this.img_flipped : this.img;
        which_img.drawCentered((int) xPos, (int) yPos);
        
        
        
        for (Item item : player_items)
        	g.drawString("Player has :" + item, 300, 500);
        
        
    }
    /** Player restart settings */
    public void init()
    {
    	this.xPos = playerRestartX;
    	this.yPos = playerRestartY;
    	this.health = maxHP;
    }
    /** Handle player death */
    public void die(World world)
    {
    	this.init();
    }
    
    /** get list of player items */
    public ArrayList<Item> getInventory(){
    	return player_items;
    }
    
  
    /** Set player items */
    public void setInventory(Item item, World world){
    	player_items.add(item);
    
    	
    }
    /** get individual items */
    public void getItem(Item item, World world)
    {
    	setInventory(item, world);
    }
    /** Scan for items within pickup range */
    public void scanForItem(World world, Player player){
    	for (Item item : world.getItems())
    	{
    		if(item.picked_up != true)
    		{
    		
    		if (getDistance(item, player) <= interactDistance)
    		{
    			if(!player_items.contains(item))
    			{
    				setInventory(item, world);
    				item.picked_up = true;
    				if(item.name == "amulet")
    				{
    					increaseMaxHp();
    				}
    				else if(item.name == "book")
    				{
    					increaseDamage();
    				}
    				else if(item.name == "sword")
    				{
    					decreaseCoolDown();
    				}
    			}
 
    		}
    	}
    	}
    }
    /** Scan for monsters to attack */
    public void scanForMonster(World world, Boolean attack)
    {
    	double x, y, distance, monsterX, monsterY;
    	
    	for(Monster m : world.getAggressiveMonsters())
    	{
    		x= this.xPos;
    		y= this.yPos;
    		
    		boolean a = attack;
    		monsterX = m.getxPos();
    		monsterY = m.getyPos();
    		
    		double distX = x - monsterX;
    		double distY = y - monsterY;
    		
    		distance = Math.sqrt(distX * distX + distY * distY);
    		
    		if((distance < attackRange) && (a == true))
    		{
    			this.attack(m);
    		}
    		
    	}
    }
    /** Scan for monsters to attack */
    public void scanForPassiveMonster(World world, Boolean attack)
    {
    	double x, y, distance, monsterX, monsterY;
    	
    	for(Monster m : world.getPassiveMonsters())
    	{
    		x= this.xPos;
    		y= this.yPos;
    		
    		boolean a = attack;
    		monsterX = m.getxPos();
    		monsterY = m.getyPos();
    		
    		double distX = x - monsterX;
    		double distY = y - monsterY;
    		
    		distance = Math.sqrt(distX * distX + distY * distY);
    		
    		if((distance < attackRange) && (a == true))
    		{
    			this.attack(m);
    		}
    		
    	}
    }
    
   
    /** increase max health for picking up amulet */
    public void increaseMaxHp(){
    	
    	
    	this.maxHP = 180 ;
    	
    }
    /** Increase max damage after picking up sword */
    public void increaseDamage(){
    	this.maxDamage = this.maxDamage + 30;
    }
    /** Decrease cooldown after Tome */
    public void decreaseCoolDown(){
    	this.cooldown = this.cooldown - 300;
    }
    /** Check whether player has item */
    public Item hasItem(String name)
	{
		for (Item item : player_items)
		{
			if (item.getName().equals(name))
				return item;
		}
		return null;
	}
    
}

