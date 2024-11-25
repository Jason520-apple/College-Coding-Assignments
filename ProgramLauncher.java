/*
 * Author: Mel Wilson Reyes
 * 
 * Program Launcher for dice rolling game. 
 */

public class ProgramLauncher {
	
	
	public static String duelPlayers(Player player1, Player player2, Dice dice) {
		
		int currentRound = 0;
		int currentRoll;
		int p1Roll;
		int p1Attack;
		int p2Roll;
		int p2Attack;
		
		System.out.println("--------------------------------------------");
		
		System.out.println("Players and Starting Stats");
		System.out.println("\tPlayer 1: " + player1);
		System.out.println("\tPlayer 2: " + player2);
		System.out.println("--------------------------------------------");
		
		// While each player is alive and not 
		while(player1.getHealth() > 0 && player2.getHealth() > 0 && currentRound < 3) {
			
			// Increments round and prints it out.
			currentRound++;
			System.out.println("Round: " + currentRound);
			
			// Rolls dice for both players
			currentRoll = dice.roll();
			System.out.println("\tCurrent Roll is " + currentRoll + ".");
			System.out.println();
			
			// Both players roll dice, if they exceed 21, then get 0 attack points.
			p1Roll = player1.attack(currentRoll);
			p2Roll = player2.attack(currentRoll);
			
			p1Attack = (p1Roll <= 21) ? p1Roll : 0;
			p2Attack = (p2Roll <= 21) ? p2Roll : 0;
			
			// Players take damage with respect to opponents attack points. 
			player1.takeDamage(p2Attack);
			player2.takeDamage(p1Attack);
			
			// Print out what happened.
			System.out.println("\t" + player1.getName() + " rolls a " + p1Roll + " and attacks with " + p1Attack + " points. " 
								+ player2.getName() + " is at " + player2.getHealthPercentageString() + " health.");
			System.out.println("\t" + player2.getName() + " rolls a " + p2Roll + " and attacks with " + p2Attack + " points. " 
					+ player1.getName() + " is at " + player1.getHealthPercentageString() + " health.");

			
			// Print out current player stats. 
			System.out.println("\tPlayer 1: " + player1);
			System.out.println("\tPlayer 2: " + player2);
			
			System.out.println("--------------------------------------------");
		}
		
		// Determine who won and print results. 
		if (player1.getHealth() > player2.getHealth()) {
			System.out.println(player1.getName() + " wins!");
			
			return player1.getName();
			
		} else if(player2.getHealth() > player1.getHealth()) {
			System.out.println(player2.getName() + " wins!");
			
			return player2.getName();
		} else {
			System.out.println("Its a tie!");
		}
		
		return "Tie";
	}
	

	public static void main(String[] args) {
		
		// Create dice
		Dice dice = new Dice(1, 10);
		
		// Create players
		Player p1 = new Player("John", 100, dice);
		Player p2 = new Player("Stacy", 100, dice);
		
		// Duel players
		duelPlayers(p1, p2, dice);
		
		

	}

}
