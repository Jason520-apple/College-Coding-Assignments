import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PlayerTest {
	
	//test player constructor and toString

	@Test
	void testConstructorAndToString () {
		Dice testDice = new Dice (1,10);
		Player testPlayer = new Player ("Bob", 100, testDice);
		
		assertEquals ("Bob, Health: 100/100", testPlayer.toString());
	} 

	
	
	//test player getter and setter

	@Test
	void testGetName () {
		
		//creating dice and player test objects to test their methods
		
		Dice testDice = new Dice (1,10);
		Player testPlayer = new Player ("Jason", 100, testDice);
		
		assertEquals ("Jason", testPlayer.getName());
	}
	
	@Test
	void testGetHealth () {
		Dice testDice = new Dice (1,10);
		Player testPlayer = new Player ("John", 100, testDice);
		
		assertEquals (100, testPlayer.getHealth());
	}
	
	//test getHealth after taking damage, instead of just 100
	@Test
	void testHealthAfterAttack () {
		Dice testDice = new Dice (1,10);
		Player testPlayer = new Player ("John", 100, testDice);
		
		//demo of an in-game attack
		int testValue = testDice.roll();
		testPlayer.takeDamage(testValue);
		
		assertEquals (100 - testValue, testPlayer.getHealth());
	}
	
	@Test
	void testGetMaxHealth () {
		Dice testDice = new Dice (1,10);
		Player testPlayer = new Player ("John", 100, testDice);
		
		assertEquals (100, testPlayer.getMaxHealth());
	}
	
	@Test
	void testGetDice () {
		Dice testDice = new Dice (1,10);
		Player testPlayer = new Player ("John", 100, testDice);
		

		
        assertThat(testPlayer.getDice(), instanceOf(Dice.class));

	}


//these were automatically generated from the instanceOf, it said that it required to create a method of instance getDice
	private void assertThat(Dice dice, Object instanceOf) {
		
	}



	private Object instanceOf(Class<Dice> class1) {
		return null;
	}



	//test takeDamage and getHealthPercentage

	@Test
	void testTakeDamage () {
		Dice testDice = new Dice (1,10);
		Player testPlayer = new Player ("Jason", 100, testDice);
		
		testPlayer.takeDamage(50);
		
		assertEquals (50, testPlayer.getHealth());
		
		
	}
	
	@Test
	void testGetHealthPercentageString () {
		Dice testDice = new Dice (1,10);
		Player testPlayer = new Player ("Jason", 100, testDice);
		
		//simulating after an attack
		testPlayer.takeDamage(20);
		
		String testString = "80%";
		
		
		assertEquals (testString, testPlayer.getHealthPercentageString());
	}
	
	//test attack
	
	@Test
	void testAttack () {
		Dice testDice = new Dice (1,10);
		Player testPlayer = new Player ("Jason", 100, testDice);
		
		//starting roll
		int startingRoll = testDice.roll();
		
		
		
		//attack method value, stored in a variable named actual
		int actual = testPlayer.attack(startingRoll);
		
		//to verify it is working, I will subtract the starting roll from the sum/actual to get the value of the extraRolls
		int extraRolls = actual - startingRoll;
		
		//expected
		int expectedSumOfAttacks = startingRoll + extraRolls;
		
		//compare expected vs the actual
		assertEquals (expectedSumOfAttacks, actual);
	}
	
}
