import java.util.Random;


public class DiceMain {
	static Random r = new Random();
	
	public static int roll() {
		//Simulates rolling a die by returning a random value (evenly distributed) between 1 and 6
		return r.nextInt(6) + 1;
	}
	
	public static boolean diceGame() {
		//simulates the dice portion of the game, returning true if the player is succesful and false if the player faults
		//x stores the initial rolls
		int x = roll();
		//this loop runs x times
		for (int i = 0; i < x; i++) {
			//Each time it rolls the die, and if it is the same as x then return true because the player is succesful
			if (roll() == x) {
				return true;
			}
		}
		//The player did not roll x in their allotted rolls so return false
		return false;
	}
	
	public static int wholeGame() {
		int innings = 0;
		boolean playing = true;
		boolean p1, p2;
		while (playing) {
			//This will  run continously until playing becomes false
			//Every time it runs innings increases by 1
			innings++;
			p1 = diceGame();
			p2 = diceGame();
			if ((p1 && !p2) || (!p1 && p2)) {
				//this is if one player has succeeded and the other has faulted.
				playing = false;
			}
			//if that doesnt occur, then the loop will run again until it does
		}
		return innings;
	}
	
	public static void main(String[] args) {
		int inning1 = 0;
		int inning2 = 0;
		int inning3 = 0;
		int inning10 = 0;
		int before4 = 0;
		long total = 0;
		for (int i = 0; i < 100000; i++) {
			int innings = wholeGame();
			total += innings;
			if (innings == 1) {
				inning1++;
				before4++;
			}
			if (innings == 2) {
				inning2++;
				before4++;
			}
			if (innings == 3) {
				inning3++;
				before4++;
			}
			if (innings == 10) {
				inning10++;
			}
		}
		double avg = total / 100000.0;
		System.out.println("The average value is: " + avg);
		System.out.println("The number of games that ended in the first inning: " + inning1);
		System.out.println("The number of games that ended in the second inning: " + inning2);
		System.out.println("The number of games that ended in the third inning: " + inning3);
		System.out.println("The number of games that ended in the tenth inning: " + inning10);
		System.out.println("The number of games that ended before the fourth inning: " + before4);
	}

}
