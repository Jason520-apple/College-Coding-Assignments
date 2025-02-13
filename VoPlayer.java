/*Jason Vo
 * OCCC Fall 2024
 * 11/27/24
 */
public class VoPlayer extends Player {
	
	
	public VoPlayer(String name) {
		super(name);
	}
	
	
	public VoPlayer () {
		super("Vo");
	}
	
	

	@Override
	public int[] makeMove(int pile1Count, int pile2Count) {

		//implement a polite player. Your player will take 1 piece of fruit from the pile with the most fruit. This is a
		//satisfactory implementation, however, it may not be the best at out competing other players.

		//compare the piles with most fruit
		if (pile1Count > pile2Count) {
			//take 1 from pile 1
			int array[] = {1, 1};
			
			//return the array
			return array;
		}
		else {
			//take 1 from pile 2 if pile 2 has more fruit
			int array[] = {2, 1};
			
			//return the array
			return array;
		}
		
	}

	
}
