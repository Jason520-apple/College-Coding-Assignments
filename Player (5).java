/*Jason Vo
 * OCCC Fall 2024
 * 11/27/24
 * 
 * TODO(student): fill in the implementation for these functions.
 * 
 */
public abstract class Player {
	
	
	private String name;
	private int numberOfWins;
	private int numberOfGames;
	
	
	public Player(String name) {
		/*
		 * TODO(student): initialize name 
		 * initialize games statistics to 0. 
		 */
		
		this.name = name;
		this.numberOfWins = 0;
		this.numberOfGames = 0;
	}
	
	public abstract int[] makeMove(int pile1Count, int pile2Count);
	//the child class has to implement this
		
	public void addGame(boolean win) {
		/**
		 * TODO(student):
		 * add a game to the player's stats. if it is a win, 
		 * add to the numberOfWins and numberOfGames statistic. 
		 * If it was not a win, only add to numberOfGames. 
		 */
		if(win == true) {
			numberOfWins++;
			numberOfGames++;
		}
		else {
			numberOfGames++;
		}
		
		
	}
	
	/**
	 * TODO(student): create getters for all class variables.
	 */
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumberOfWins() {
		return numberOfWins;
	}

	public void setNumberOfWins(int numberOfWins) {
		this.numberOfWins = numberOfWins;
	}

	public int getNumberOfGames() {
		return numberOfGames;
	}

	public void setNumberOfGames(int numberOfGames) {
		this.numberOfGames = numberOfGames;
	}
	
	
	public void resetStats() {
		
		 // TODO(student): reset number of games and wins to 0.

		numberOfGames = 0;
		numberOfWins = 0;
		
	}
	
	

	public String getWinPercentageString() {
		/*
		 * TODO(student): Return a string that is the win percentage for the player
		 * with only 2 decimal points. Use your implementation from
		 * assignment 3 as inspiration. 
		 */
		
		//if the numberOfGames played is equal to 0, then just return 0% to avoid a division by zero error
		if (numberOfGames == 0) {
			return "0.00% or NA";
		}
		else {
			return String.format("%.2f", (numberOfWins / numberOfGames));
		}
	}
	
	public String toString() {
		/* 
		 * TODO(student):
		 * return string that presents class information, for example:
		 * "* Player: John, Win Percentage: 60.00%"
		 */
		
		//call the getWinPercentageString
		return "Player: " + name + ", Win Percentage: " + getWinPercentageString();
	}

}
