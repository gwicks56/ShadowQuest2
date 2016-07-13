/* 433-294 Object Oriented Software Development
 * RPG Game Engine
 * Sample Solution
 * Author: Geordie Wicks <gwicks> ID : 185828
 */


import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;




import java.util.ArrayList;

/** Represents the entire game world.
 * (Designed to be instantiated just once for the whole game).
 */
public class World
{
    private static final int PLAYER_START_X = 756, PLAYER_START_Y = 684;
    
    public Player player = null;
    private TiledMap map = null;
    private Camera camera = null;
    private ArrayList<Villager> villagers;
    protected ArrayList<Unit> units = null;
    protected ArrayList<Item> items = null;
    private ArrayList<Aggressive> aggressiveMonsters;
    private ArrayList<Passive> passiveMonsters;
    
    /** Map width, in pixels. */
    private int getMapWidth()
    {
        return map.getWidth() * getTileWidth();
    }

    /** Map height, in pixels. */
    private int getMapHeight()
    {
        return map.getHeight() * getTileHeight();
    }

    /** Tile width, in pixels. */
    private int getTileWidth()
    {
        return map.getTileWidth();
    }

    /** Tile height, in pixels. */
    private int getTileHeight()
    {
        return map.getTileHeight();
    }

    /** Create a new World object. */
    public World()
    throws SlickException
    {
        map = new TiledMap(ShadowQuest.ASSETS_PATH + "/map.tmx", ShadowQuest.ASSETS_PATH);
        player = new Player(ShadowQuest.ASSETS_PATH + "/units/player.png", PLAYER_START_X, PLAYER_START_Y);
        camera = new Camera(player, ShadowQuest.SCREEN_WIDTH, ShadowQuest.SCREEN_HEIGHT);
        
        
        
        villagers = new ArrayList<Villager>(3);
        initVillagers();
        items = new ArrayList<Item>();
        initItems();
        aggressiveMonsters = new ArrayList<Aggressive>();
        initAggressiveMonsters();
        passiveMonsters = new ArrayList<Passive>();
        initPassiveMonsters();
       
        
    }
    
    
    /** add the villagers */
    public void initVillagers() throws SlickException
   	{
   		villagers.add(new Prince(ShadowQuest.ASSETS_PATH + "/units/prince.png", 467, 679));
   		villagers.add(new Garth(ShadowQuest.ASSETS_PATH + "/units/peasant.png", 756, 870));
   		villagers.add(new Elvira(ShadowQuest.ASSETS_PATH + "/units/shaman.png", 738, 549));
   		
   	}
    
    /** Add the world items */
    
    public void initItems() throws SlickException
    {
    	items.add(new Sword(ShadowQuest.ASSETS_PATH + "/items/sword.png", 4791, 1253));
    	items.add(new Elixir(ShadowQuest.ASSETS_PATH + "/items/elixir.png", 1976, 402));
    	items.add(new Amulet(ShadowQuest.ASSETS_PATH + "/items/amulet.png", 965, 3563));
    	items.add(new Tome(ShadowQuest.ASSETS_PATH + "/items/book.png", 546, 6707));
    	
    }
    
    /** add the monsters */
    public void initAggressiveMonsters() throws SlickException
    {
    	aggressiveMonsters.add(new Bandit(ShadowQuest.ASSETS_PATH + "/units/bandit.png", 1889,2581));
    	aggressiveMonsters.add(new Bandit(ShadowQuest.ASSETS_PATH + "/units/bandit.png", 4502,6283));
    	aggressiveMonsters.add(new Bandit(ShadowQuest.ASSETS_PATH + "/units/bandit.png", 5248,6581));
    	aggressiveMonsters.add(new Bandit(ShadowQuest.ASSETS_PATH + "/units/bandit.png", 5345,6678));
    	aggressiveMonsters.add(new Bandit(ShadowQuest.ASSETS_PATH + "/units/bandit.png", 5940,3412));
    	aggressiveMonsters.add(new Bandit(ShadowQuest.ASSETS_PATH + "/units/bandit.png", 6335,3459));
    	aggressiveMonsters.add(new Bandit(ShadowQuest.ASSETS_PATH + "/units/bandit.png", 6669,260));
    	aggressiveMonsters.add(new Bandit(ShadowQuest.ASSETS_PATH + "/units/bandit.png", 6598,339));
    	aggressiveMonsters.add(new Bandit(ShadowQuest.ASSETS_PATH + "/units/bandit.png", 6598,528));
    	aggressiveMonsters.add(new Bandit(ShadowQuest.ASSETS_PATH + "/units/bandit.png", 6435,528));
    	aggressiveMonsters.add(new Bandit(ShadowQuest.ASSETS_PATH + "/units/bandit.png", 6435,678));
    	aggressiveMonsters.add(new Bandit(ShadowQuest.ASSETS_PATH + "/units/bandit.png", 5076,1082));
    	aggressiveMonsters.add(new Bandit(ShadowQuest.ASSETS_PATH + "/units/bandit.png", 5191,1187));
    	aggressiveMonsters.add(new Bandit(ShadowQuest.ASSETS_PATH + "/units/bandit.png", 4940,1175));
    	aggressiveMonsters.add(new Bandit(ShadowQuest.ASSETS_PATH + "/units/bandit.png", 4760,1039));
    	aggressiveMonsters.add(new Bandit(ShadowQuest.ASSETS_PATH + "/units/bandit.png", 4883,889));
    	aggressiveMonsters.add(new Bandit(ShadowQuest.ASSETS_PATH + "/units/bandit.png", 4427,553));
    	aggressiveMonsters.add(new Bandit(ShadowQuest.ASSETS_PATH + "/units/bandit.png", 3559,162));
    	aggressiveMonsters.add(new Bandit(ShadowQuest.ASSETS_PATH + "/units/bandit.png", 3779,1553));
    	aggressiveMonsters.add(new Bandit(ShadowQuest.ASSETS_PATH + "/units/bandit.png", 3573,1553));
    	aggressiveMonsters.add(new Bandit(ShadowQuest.ASSETS_PATH + "/units/bandit.png", 3534,2464));
    	aggressiveMonsters.add(new Bandit(ShadowQuest.ASSETS_PATH + "/units/bandit.png", 3635,2464));
    	aggressiveMonsters.add(new Bandit(ShadowQuest.ASSETS_PATH + "/units/bandit.png", 3402,2861));
    	aggressiveMonsters.add(new Bandit(ShadowQuest.ASSETS_PATH + "/units/bandit.png", 3151,2857));
    	aggressiveMonsters.add(new Bandit(ShadowQuest.ASSETS_PATH + "/units/bandit.png", 3005,2997));
    	aggressiveMonsters.add(new Bandit(ShadowQuest.ASSETS_PATH + "/units/bandit.png", 2763,2263));
    	aggressiveMonsters.add(new Bandit(ShadowQuest.ASSETS_PATH + "/units/bandit.png", 2648,2263));
    	aggressiveMonsters.add(new Bandit(ShadowQuest.ASSETS_PATH + "/units/bandit.png", 2621,1337));
    	aggressiveMonsters.add(new Bandit(ShadowQuest.ASSETS_PATH + "/units/bandit.png", 2907,1270));
    	aggressiveMonsters.add(new Bandit(ShadowQuest.ASSETS_PATH + "/units/bandit.png", 2331,598));
    	aggressiveMonsters.add(new Bandit(ShadowQuest.ASSETS_PATH + "/units/bandit.png", 2987,394));
    	aggressiveMonsters.add(new Bandit(ShadowQuest.ASSETS_PATH + "/units/bandit.png", 1979,394));
    	aggressiveMonsters.add(new Bandit(ShadowQuest.ASSETS_PATH + "/units/bandit.png", 2045,693));
    	aggressiveMonsters.add(new Bandit(ShadowQuest.ASSETS_PATH + "/units/bandit.png", 2069,1028));
    	
    	
    	aggressiveMonsters.add(new Zombie(ShadowQuest.ASSETS_PATH + "/units/zombie.png", 681,3201));
    	aggressiveMonsters.add(new Zombie(ShadowQuest.ASSETS_PATH + "/units/zombie.png", 691,4360));
    	aggressiveMonsters.add(new Zombie(ShadowQuest.ASSETS_PATH + "/units/zombie.png", 2166,2650));
    	aggressiveMonsters.add(new Zombie(ShadowQuest.ASSETS_PATH + "/units/zombie.png", 2122,2725));
    	aggressiveMonsters.add(new Zombie(ShadowQuest.ASSETS_PATH + "/units/zombie.png", 2284,2962));
    	aggressiveMonsters.add(new Zombie(ShadowQuest.ASSETS_PATH + "/units/zombie.png", 2072,4515));
    	aggressiveMonsters.add(new Zombie(ShadowQuest.ASSETS_PATH + "/units/zombie.png", 2006,4568));
    	aggressiveMonsters.add(new Zombie(ShadowQuest.ASSETS_PATH + "/units/zombie.png", 2385,4629));
    	aggressiveMonsters.add(new Zombie(ShadowQuest.ASSETS_PATH + "/units/zombie.png", 2446,4590));
    	aggressiveMonsters.add(new Zombie(ShadowQuest.ASSETS_PATH + "/units/zombie.png", 2517,4532));
    	aggressiveMonsters.add(new Zombie(ShadowQuest.ASSETS_PATH + "/units/zombie.png", 4157,6730));
    	aggressiveMonsters.add(new Zombie(ShadowQuest.ASSETS_PATH + "/units/zombie.png", 4247,6620));
    	aggressiveMonsters.add(new Zombie(ShadowQuest.ASSETS_PATH + "/units/zombie.png", 4137,6519));
    	aggressiveMonsters.add(new Zombie(ShadowQuest.ASSETS_PATH + "/units/zombie.png", 4234,6449));
    	aggressiveMonsters.add(new Zombie(ShadowQuest.ASSETS_PATH + "/units/zombie.png", 5879,4994));
    	aggressiveMonsters.add(new Zombie(ShadowQuest.ASSETS_PATH + "/units/zombie.png", 5954,4928));
    	aggressiveMonsters.add(new Zombie(ShadowQuest.ASSETS_PATH + "/units/zombie.png", 6016,4866));
    	aggressiveMonsters.add(new Zombie(ShadowQuest.ASSETS_PATH + "/units/zombie.png", 5860,4277));
    	aggressiveMonsters.add(new Zombie(ShadowQuest.ASSETS_PATH + "/units/zombie.png", 5772,4277));
    	aggressiveMonsters.add(new Zombie(ShadowQuest.ASSETS_PATH + "/units/zombie.png", 5715,4277));
    	aggressiveMonsters.add(new Zombie(ShadowQuest.ASSETS_PATH + "/units/zombie.png", 5653,4277));
    	aggressiveMonsters.add(new Zombie(ShadowQuest.ASSETS_PATH + "/units/zombie.png", 5787,797));
    	aggressiveMonsters.add(new Zombie(ShadowQuest.ASSETS_PATH + "/units/zombie.png", 5668,720));
    	aggressiveMonsters.add(new Zombie(ShadowQuest.ASSETS_PATH + "/units/zombie.png", 5813,454));
    	aggressiveMonsters.add(new Zombie(ShadowQuest.ASSETS_PATH + "/units/zombie.png", 5236,917));
    	aggressiveMonsters.add(new Zombie(ShadowQuest.ASSETS_PATH + "/units/zombie.png", 5048,1062));
    	aggressiveMonsters.add(new Zombie(ShadowQuest.ASSETS_PATH + "/units/zombie.png", 4845,996));
    	aggressiveMonsters.add(new Zombie(ShadowQuest.ASSETS_PATH + "/units/zombie.png", 4496,575));
    	aggressiveMonsters.add(new Zombie(ShadowQuest.ASSETS_PATH + "/units/zombie.png", 3457,273));
    	aggressiveMonsters.add(new Zombie(ShadowQuest.ASSETS_PATH + "/units/zombie.png", 3506,779));
    	aggressiveMonsters.add(new Zombie(ShadowQuest.ASSETS_PATH + "/units/zombie.png", 3624,1192));
    	aggressiveMonsters.add(new Zombie(ShadowQuest.ASSETS_PATH + "/units/zombie.png", 2931,1396));
    	aggressiveMonsters.add(new Zombie(ShadowQuest.ASSETS_PATH + "/units/zombie.png", 2715,1326));
    	aggressiveMonsters.add(new Zombie(ShadowQuest.ASSETS_PATH + "/units/zombie.png", 2442,1374));
    	aggressiveMonsters.add(new Zombie(ShadowQuest.ASSETS_PATH + "/units/zombie.png", 2579,1159));
    	aggressiveMonsters.add(new Zombie(ShadowQuest.ASSETS_PATH + "/units/zombie.png", 2799,1269));
    	aggressiveMonsters.add(new Zombie(ShadowQuest.ASSETS_PATH + "/units/zombie.png", 2768,739));
    	aggressiveMonsters.add(new Zombie(ShadowQuest.ASSETS_PATH + "/units/zombie.png", 2099,956));
    	
    	
    	
    	aggressiveMonsters.add(new Skeleton(ShadowQuest.ASSETS_PATH + "/units/skeleton.png", 1255,2924));
    	aggressiveMonsters.add(new Skeleton(ShadowQuest.ASSETS_PATH + "/units/skeleton.png", 2545,4708));
    	aggressiveMonsters.add(new Skeleton(ShadowQuest.ASSETS_PATH + "/units/skeleton.png", 4189,6585));
    	aggressiveMonsters.add(new Skeleton(ShadowQuest.ASSETS_PATH + "/units/skeleton.png", 5720,622));
    	aggressiveMonsters.add(new Skeleton(ShadowQuest.ASSETS_PATH + "/units/skeleton.png", 5649,767));
    	aggressiveMonsters.add(new Skeleton(ShadowQuest.ASSETS_PATH + "/units/skeleton.png", 5291,312));
    	aggressiveMonsters.add(new Skeleton(ShadowQuest.ASSETS_PATH + "/units/skeleton.png", 5256,852));
    	aggressiveMonsters.add(new Skeleton(ShadowQuest.ASSETS_PATH + "/units/skeleton.png", 4790,976));
    	aggressiveMonsters.add(new Skeleton(ShadowQuest.ASSETS_PATH + "/units/skeleton.png", 4648,401));
    	aggressiveMonsters.add(new Skeleton(ShadowQuest.ASSETS_PATH + "/units/skeleton.png", 3628,1181));
    	aggressiveMonsters.add(new Skeleton(ShadowQuest.ASSETS_PATH + "/units/skeleton.png", 3771,1181));
    	aggressiveMonsters.add(new Skeleton(ShadowQuest.ASSETS_PATH + "/units/skeleton.png", 3182,2892));
    	aggressiveMonsters.add(new Skeleton(ShadowQuest.ASSETS_PATH + "/units/skeleton.png", 3116,3033));
    	aggressiveMonsters.add(new Skeleton(ShadowQuest.ASSETS_PATH + "/units/skeleton.png", 2803,2901));
    	aggressiveMonsters.add(new Skeleton(ShadowQuest.ASSETS_PATH + "/units/skeleton.png", 2850,2426));
    	aggressiveMonsters.add(new Skeleton(ShadowQuest.ASSETS_PATH + "/units/skeleton.png", 2005,1524));
    	aggressiveMonsters.add(new Skeleton(ShadowQuest.ASSETS_PATH + "/units/skeleton.png", 2132,1427));
    	aggressiveMonsters.add(new Skeleton(ShadowQuest.ASSETS_PATH + "/units/skeleton.png", 2242,1343));
    	aggressiveMonsters.add(new Skeleton(ShadowQuest.ASSETS_PATH + "/units/skeleton.png", 2428,771));
    	aggressiveMonsters.add(new Skeleton(ShadowQuest.ASSETS_PATH + "/units/skeleton.png", 2427,907));
    	aggressiveMonsters.add(new Skeleton(ShadowQuest.ASSETS_PATH + "/units/skeleton.png", 2770,613));
    	aggressiveMonsters.add(new Skeleton(ShadowQuest.ASSETS_PATH + "/units/skeleton.png", 2915,477));
    	aggressiveMonsters.add(new Skeleton(ShadowQuest.ASSETS_PATH + "/units/skeleton.png", 1970,553));
    	aggressiveMonsters.add(new Skeleton(ShadowQuest.ASSETS_PATH + "/units/skeleton.png", 2143,1048));
    	
    	aggressiveMonsters.add(new Draelic(ShadowQuest.ASSETS_PATH + "/units/necromancer.png", 2069, 510));
    	
    	
    	
    }
    
    public void initPassiveMonsters() throws SlickException
    {
    	passiveMonsters.add(new Passive(ShadowQuest.ASSETS_PATH + "/units/dreadbat.png", 1431,864));
    	passiveMonsters.add(new Passive(ShadowQuest.ASSETS_PATH + "/units/dreadbat.png", 1154,1321));
    	passiveMonsters.add(new Passive(ShadowQuest.ASSETS_PATH + "/units/dreadbat.png", 807,2315));
    	passiveMonsters.add(new Passive(ShadowQuest.ASSETS_PATH + "/units/dreadbat.png", 833,2657));
    	passiveMonsters.add(new Passive(ShadowQuest.ASSETS_PATH + "/units/dreadbat.png", 1090,3200));
    	passiveMonsters.add(new Passive(ShadowQuest.ASSETS_PATH + "/units/dreadbat.png", 676,3187));
    	passiveMonsters.add(new Passive(ShadowQuest.ASSETS_PATH + "/units/dreadbat.png", 836,3966));
    	passiveMonsters.add(new Passive(ShadowQuest.ASSETS_PATH + "/units/dreadbat.png", 653,4367));
    	passiveMonsters.add(new Passive(ShadowQuest.ASSETS_PATH + "/units/dreadbat.png", 1343,2731));
    	passiveMonsters.add(new Passive(ShadowQuest.ASSETS_PATH + "/units/dreadbat.png", 1835,3017));
    	passiveMonsters.add(new Passive(ShadowQuest.ASSETS_PATH + "/units/dreadbat.png", 1657,3954));
    	passiveMonsters.add(new Passive(ShadowQuest.ASSETS_PATH + "/units/dreadbat.png", 1054,5337));
    	passiveMonsters.add(new Passive(ShadowQuest.ASSETS_PATH + "/units/dreadbat.png", 801,5921));
    	passiveMonsters.add(new Passive(ShadowQuest.ASSETS_PATH + "/units/dreadbat.png", 560,6682));
    	passiveMonsters.add(new Passive(ShadowQuest.ASSETS_PATH + "/units/dreadbat.png", 1275,5696));
    	passiveMonsters.add(new Passive(ShadowQuest.ASSETS_PATH + "/units/dreadbat.png", 1671,5991));
    	passiveMonsters.add(new Passive(ShadowQuest.ASSETS_PATH + "/units/dreadbat.png", 2248,6298));
    	passiveMonsters.add(new Passive(ShadowQuest.ASSETS_PATH + "/units/dreadbat.png", 2952,6373));
    	passiveMonsters.add(new Passive(ShadowQuest.ASSETS_PATH + "/units/dreadbat.png", 3864,6695));
    	passiveMonsters.add(new Passive(ShadowQuest.ASSETS_PATH + "/units/dreadbat.png", 4554,6443));
    	passiveMonsters.add(new Passive(ShadowQuest.ASSETS_PATH + "/units/dreadbat.png", 4683,6228));
    	passiveMonsters.add(new Passive(ShadowQuest.ASSETS_PATH + "/units/dreadbat.png", 5312,6606));
    	passiveMonsters.add(new Passive(ShadowQuest.ASSETS_PATH + "/units/dreadbat.png", 5484,5946));
    	passiveMonsters.add(new Passive(ShadowQuest.ASSETS_PATH + "/units/dreadbat.png", 6371,5634));
    	passiveMonsters.add(new Passive(ShadowQuest.ASSETS_PATH + "/units/dreadbat.png", 5473,3544));
    	passiveMonsters.add(new Passive(ShadowQuest.ASSETS_PATH + "/units/dreadbat.png", 5944,3339));
    	passiveMonsters.add(new Passive(ShadowQuest.ASSETS_PATH + "/units/dreadbat.png", 6301,3414));
    	passiveMonsters.add(new Passive(ShadowQuest.ASSETS_PATH + "/units/dreadbat.png", 6388,1994));
    	passiveMonsters.add(new Passive(ShadowQuest.ASSETS_PATH + "/units/dreadbat.png", 6410,1584));
    	passiveMonsters.add(new Passive(ShadowQuest.ASSETS_PATH + "/units/dreadbat.png", 5314,274));
    }

    /** Update the game state for a frame.
     * @param dir_x The player's movement in the x axis (-1, 0 or 1).
     * @param dir_y The player's movement in the y axis (-1, 0 or 1).
     * 
     * @param delta Time passed since last frame (milliseconds).
     */
    public void update(int dir_x, int dir_y, boolean interact, boolean attack, int delta)
    throws SlickException
    {
    	
        player.update(this, dir_x, dir_y, interact, attack, delta);
        camera.update();
        
     /** Update each villager */
     		for (Villager v : villagers)
     		{
     			v.update(delta, this, interact);
     		}
     		
     	/** Update passive and aggressive monsters */
     		for(Aggressive m : aggressiveMonsters)
     		{
     			if(m.dead == false)
     			{
     				m.update(delta, this);
     			}
     		}
     		for(Passive m : passiveMonsters)
     		{
     			if((m.dead == false) && (onCamera(m) == true))
     			{
     				m.update(delta,  this);
     				
     			}
     		}
        
        
    }

    /** Render the entire screen, so it reflects the current game state.
     * @param g The Slick graphics object, used for drawing.
     */
    public void render(Graphics g)
    throws SlickException
    {
        /* Render the relevant section of the map */
        int x = -(camera.getMinX() % getTileWidth());
        int y = -(camera.getMinY() % getTileHeight());
        int sx = camera.getMinX() / getTileWidth();
        int sy = camera.getMinY()/ getTileHeight();
        int w = (camera.getMaxX() / getTileWidth()) - (camera.getMinX() / getTileWidth()) + 1;
        int h = (camera.getMaxY() / getTileHeight()) - (camera.getMinY() / getTileHeight()) + 1;
        map.render(x, y, sx, sy, w, h);
        
       
        // Translate the Graphics object
        g.translate(-camera.getMinX(), -camera.getMinY());

        // Render the player
        player.render(g);
       
       /** render villagers */
        
        for(Villager entry : villagers)
        {
        	if(onCamera(entry) == true)
        	{
        		entry.render();
        		entry.renderHealthandTalk(g);
        	}
        }		
        		
        /** Render the aggressive monsters */
        for(Aggressive entry : aggressiveMonsters)
        {
        	if((entry.dead == false) && (onCamera(entry) == true))
        		{	entry.renderHealthandTalk(g);
        			entry.render();
        		}
        }
        /** Render the passive monsters */
        for(Passive entry : passiveMonsters)
        {
        	if((entry.dead == false) && (onCamera(entry) == true))
        		{	entry.renderHealthandTalk(g);
        			entry.render();
        		}
        	
            
        }


        for(Item entry : items)
        	if((entry.picked_up != true) && (onCamera(entry) == true))
        		{
        		entry.render();
        		}
        
      
    /** render the status panel */   
       renderPanel(g);
    /** Scan for items in range */   
       player.scanForItem(this, player);
       
    }
    
     /** Determines whether a particular map coordinate blocks movement.
     * @param x Map x coordinate (in pixels).
     * @param y Map y coordinate (in pixels).
     * @return true if the coordinate blocks movement.
     */
    public boolean terrainBlocks(double x, double y)
    {
        // Check we are within the bounds of the map
        if (x < 0 || y < 0 || x > getMapWidth() || y > getMapHeight()) {
            return true;
        }
        
        // Check the tile properties
        int tile_x = (int) x / getTileWidth();
        int tile_y = (int) y / getTileHeight();
        int tileid = map.getTileId(tile_x, tile_y, 0);
        String block = map.getTileProperty(tileid, "block", "0");
        return !block.equals("0");
    }
    
    

        /** Renders the player's status panel.
         * @param g The current Slick graphics context.
         */
        public void renderPanel(Graphics g)
        throws SlickException
        {
            // Panel colors
            Color LABEL = new Color(0.9f, 0.9f, 0.4f);          // Gold
            Color VALUE = new Color(1.0f, 1.0f, 1.0f);          // White
            Color BAR_BG = new Color(0.0f, 0.0f, 0.0f, 0.8f);   // Black, transp
            Color BAR = new Color(0.8f, 0.0f, 0.0f, 0.8f);      // Red, transp

            // Variables for layout
            String text;                // Text to display
            int text_x, text_y;         // Coordinates to draw text
            int bar_x, bar_y;           // Coordinates to draw rectangles
            int bar_width, bar_height;  // Size of rectangle to draw
            int hp_bar_width;           // Size of red (HP) rectangle
            int inv_x, inv_y;           // Coordinates to draw inventory item

            float health_percent;       // Player's health, as a percentage

            // Panel background image
            player.panel.draw(camera.getMinX(), camera.getMaxY() - ShadowQuest.PANELHEIGHT);

            // Display the player's health
            text_x = camera.getMinX() + 15;
            text_y = camera.getMaxY() - ShadowQuest.PANELHEIGHT + 25;
            g.setColor(LABEL);
            g.drawString("Health:", text_x, text_y);
            text = " " + (int)player.getHealth() + "/" + (int)player.getMaxHP();                                 // TODO: HP / Max-HP

            bar_x =camera.getMinX() + 90;
            bar_y = camera.getMaxY() - ShadowQuest.PANELHEIGHT + 20;
            bar_width = 90;
            bar_height = 30;
            health_percent = (float)player.getHealth()/(float)player.getMaxHP();                         // TODO: HP / Max-HP
            hp_bar_width = (int) (bar_width * health_percent);
            text_x = bar_x + (bar_width - g.getFont().getWidth(text)) / 2;
            g.setColor(BAR_BG);
            g.fillRect(bar_x, bar_y, bar_width, bar_height);
            g.setColor(BAR);
            g.fillRect(bar_x, bar_y, hp_bar_width, bar_height);
            g.setColor(VALUE);
            g.drawString(text, text_x, text_y);

            // Display the player's damage and cooldown
            text_x = camera.getMinX()+  200;
            g.setColor(LABEL);
            g.drawString("Damage:", text_x, text_y);
            text_x += 80;
            text = "" + (int)player.getMaxDamage();                                    
            g.setColor(VALUE);
            g.drawString(text, text_x, text_y);
            text_x += 40;
            g.setColor(LABEL);
            g.drawString("Rate:", text_x, text_y);
            text_x += 55;
            text = "" + player.getCooldown();                                   
            g.setColor(VALUE);
            g.drawString(text, text_x, text_y);

            // Display the player's inventory
            g.setColor(LABEL);
            g.drawString("Items:", camera.getMinX() + 420, text_y);
            bar_x = camera.getMinX() + 490;
            bar_y = camera.getMaxY() - ShadowQuest.PANELHEIGHT + 10;
            bar_width = 288;
            bar_height = bar_height + 20;
            g.setColor(BAR_BG);
            g.fillRect(bar_x, bar_y, bar_width, bar_height);

            inv_x = camera.getMinX() + 510;
            inv_y = camera.getMaxY() - 35;
            // for (each item in the player's inventory)  

            for(Item entry : player.player_items)
            	
            {
            		entry.render(ShadowQuest.ASSETS_PATH + "/items/" + entry.name +".png",inv_x, inv_y);
            		inv_x += 72;
            }	
            
                
            
        }
        /** Detect whether entity is on camera to speed rendering */
        
        public boolean onCamera(Entity entity)
        {
        	double entityX = entity.getxPos();
        	double entityY = entity.getyPos();
        	
        	double camXmin = camera.getMinX();
        	double camXmax = camera.getMaxX();
        	
        	double camYmin = camera.getMinY();
        	double camYmax  =camera.getMaxY();
        	
        	if((camXmin < entityX) && (entityX < camXmax)
        	&& (camYmin < entityY) && (entityY < camYmax))
        	{
        		return true;
        	}
        	else
        	{
        		return false;
        	}
        }
        
       /** Get the aggressive monsters */
    	public ArrayList<Aggressive> getAggressiveMonsters()
    	{
    		return aggressiveMonsters;
    	}
    	/** Get the Passive monsters */
    	
    	public ArrayList<Passive> getPassiveMonsters()
    	{
    		return passiveMonsters;
    	}

    	/**
    	 * @return the monsters
    	 */
    	
    	public ArrayList<Villager> getVillagers()
    	{
    		return villagers;
    	}

    	
    	/**
    	 * @return the worldItems
    	 */
    	
    	public ArrayList<Item> getItems()
    	{
    		return items;
    	}
    	
    	/** Get the player */
    	public Player getPlayer()
    	{
    		return player;
    	}
   
    
   
}

