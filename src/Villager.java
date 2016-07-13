/* 433-294 Object Oriented Software Development
 * Author: Geordie Wicks <gwicks> ID : 185828
 */


import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;


public abstract class Villager extends Unit {

	
	 
		protected double xPos; 
		protected double yPos;
		protected boolean interacted = false;
		
		public int interactDist = 50;
		
		protected boolean interacting = false;
		/** The maximum time a dialogue box will last (ms) */
		protected int dialogueLife = 4000;
		/** The time until the dialogue box disappears (ms) */
		protected int dialogueTimer = 0;
		/** The string to be spoken upon interaction */
		protected String dialogueText = "";

		/** The height of the dialogue bar for interaction */
		protected int dialogueBarHeight = 16;
		/** The width of the dialogue bar for interaction */
		protected int dialogueBarWidth;
		
		
		public Villager(String image_path, double x, double y)
		        throws SlickException
		    {
		        super(image_path, x,  y);
		        this.maxHP = 1;
		        this.maxDamage = 0;
		        this.cooldown = 0;
		        this.xPos = x;
		        this.yPos = y;
		        this.dead = false;
		      
		    }
	
	
		 public void render()
		    {
		        Image which_img;
		        which_img = this.img;
		        which_img.drawCentered((int) this.xPos, (int) this.yPos);
		    }
		 
		 public void die(World world)
			{
				
			}
		 
		 
			/** Update the villager's state for a frame.
			 * 
			 * @param delta Time passed since last frame (milliseconds).
			 * @param gps The GameplayState, which acts as a facade. 
			 */
		 public void update(int delta, World world, boolean interact)
			{
			 
			 	boolean i = interact;
				// Handle villager death
				if (this.health < 0)
				{
					this.die(world);
					return;
				}
				// Decrease the cooldown timer if necessary
				if (this.coolDownTimer > 0)
				{
					this.coolDownTimer -= delta;
				}
				// Decrease the cooldown timer if necessary
				if (this.dialogueTimer > 0)
				{
					this.dialogueTimer -= delta;
				}
				else
				{
					this.dialogueText = "";
				}

				// Check for interaction
				if ((getDistance(this, world.getPlayer()) < interactDist) && (i == true))
				{
					if (!this.interacting)
					{
						this.interact(world.getPlayer());
					}
				}
				else
				{
					if (this.interacting)
					{
						this.interacting = false;
					}
				}
			}
			
			public void renderHealthandTalk(Graphics g)
		
			{
				super.renderHealthandTalk(g);
				if (!dialogueText.isEmpty())
				{
					this.renderDialogueBox(g);
				}
			}   
		 
		 public void renderDialogueBox(Graphics g)
			{
				// Colors for drawing
				Color VALUE = new Color(1.0f, 1.0f, 1.0f); // White
				Color BAR_BG = new Color(0.0f, 0.0f, 0.0f, 0.8f); // Black, transp

				// Set the width of the health bar based on the unit's name
				this.dialogueBarWidth = Math.max(70, g.getFont().getWidth(this.getDialogueText()) + 6);

				// Draw the health bar
				float barX = (float) this.getxPos() - dialogueBarWidth / 2;
				float barY = (float) this.getyPos() - this.getHeight() / 2 - healthBarHeight
						- dialogueBarHeight - 5;

				g.setColor(BAR_BG);
				g.fillRect(barX, barY, dialogueBarWidth, dialogueBarHeight);

				// Draw name text (in white)
				g.setColor(VALUE);
				float textX = barX + (dialogueBarWidth - g.getFont().getWidth(this.getDialogueText())) / 2;
				float textY = barY + (dialogueBarHeight - g.getFont().getHeight(this.getDialogueText()))
						/ 2;
				g.drawString(this.getDialogueText(), textX, textY);
			}
		 
		 public void setDialogue(String text)
			{
				this.dialogueText = text;
				this.dialogueTimer = this.dialogueLife;
				this.interacting = true;
			}
		 
		 public abstract void interact(Player player);
	
			/**
			 * @return the interacting
			 */
			public boolean isInteracting()
			{
				return interacting;
			}

			/**
			 * @return the dialogueLife
			 */
			public int getDialogueLife()
			{
				return dialogueLife;
			}

			/**
			 * @return the dialogueTimer
			 */
			public int getDialogueTimer()
			{
				return dialogueTimer;
			}

			/**
			 * @return the dialogueText
			 */
			public String getDialogueText()
			{
				return dialogueText;
			}

			/**
			 * @return the dialogueBarHeight
			 */
			public int getDialogueBarHeight()
			{
				return dialogueBarHeight;
			}

			/**
			 * @return the dialogueBarWidth
			 */
			public int getDialogueBarWidth()
			{
				return dialogueBarWidth;
			}

	
	
	
}
