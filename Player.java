/*Jason Vo
 * Assignment 3
 * 11/6/24
 * 
 * This is a player class that acts as a blueprint for player objects for the dice rolling game. 
 * It will have the properties/attributes of: name, health, maxHealth. It has an instance of the Dice class. 
 * It will have the methods/actions of rolling dice, an attack function which you decide the player's strategy.
 */
public class Player {

	//creating private variables that are encapsulated and can only be changed via setters and seen with getters
	
	private String name;
	private int health;
	private int maxHealth;
	
	//instance of/creating dice
	private Dice dice;
	
	
	//Constructor that accepts data entry and updates variables above to store user input
	public Player (String name, int health, Dice dice) {
		this.name = name;
		this.health = health;
		this.maxHealth = health;
		
		this.dice = dice;
		
	}
	
	
	//methods, getters
	public String getName () {
		return name;
	}
	
	public int getHealth () {
		return health;
	}
	
	
	public int getMaxHealth () {
		return maxHealth;
	}
	
	//getDice, returns the internal dice variable
	public Dice getDice () {
		return this.dice;
	}
	
	//takeDamage	
	public void takeDamage (int damage) {
		
		this.health -= damage;
		
			
	}
	
	
	//attack, the starting roll is passed here, then subsequent dice.roll values are added to it. the strategy will be roll as long as it is <= 16
	public int attack (int startingRoll) {
		
		//variable that will be returned after
		int attackValue = startingRoll;
		
		//dice strategy
		attackValue += dice.roll();
		
		//if, and only if attackValue <= 16 then it will roll again
		if (attackValue <= 16) {
			attackValue += dice.roll();
		}
		
		
		return attackValue;
	}
	
	
	//getHealthPercentageString
	public String getHealthPercentageString () {
		return String.format("%d%%", this.health);
	}
	
	
	//toString to return starting stats instead of memory location when ProgramLauncher calls it (player1 or player2)
	public String toString () {
		return name + ", Health: " + health + "/" + maxHealth ;
	}
	
}
