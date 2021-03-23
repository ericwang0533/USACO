import java.util.*;
import java.io.*;
public class hoofPaperScissors {
	public static void main(String[] args) throws IOException{
		Scanner in = new Scanner(new File("hps.in"));
		PrintWriter out = new PrintWriter(new FileWriter(new File("hps.out")));
//		Scanner in = new Scanner(System.in);
//		PrintWriter out = new PrintWriter(System.out);

		// n = num of games
		int n = in.nextInt();
		
		// store games won by first cow
		int firstWins = 0;
		// store games won by second cow
		int secondWins = 0;
		
		// loop through the n games
		for(int i = 0; i < n; i++) {
			// grab input choices from the cows
			int first = in.nextInt();
			int second = in.nextInt();
			
			// if equal its a tie, so just move to the next game
			if(first == second) {
				continue;
			} 
			else {
				// pretend 1 = hoof (rock) & 2 == paper & 3 == scissors
				// doesnt matter what 1, 2, 3 equal; outcome will be the same
				// except firstWins and secondWins might be inverted (second > first)
				if(first == 1 && second == 2) {
					// hoof loses to paper
					secondWins++;
				}
				else if(first == 2 && second == 3) {
					// paper loses to scissors
					secondWins++;
				}
				else if(first == 3 && second == 1) {
					// scissors loses to hoof (rock)
					secondWins++;
				}
				else {
					// everything else means firstCow wins
					// we already made sure it cant be a tie here
					firstWins++;
				}
			}
			
		}
		
//		out.println(firstWins);
//		out.println(secondWins);	
		
		// in the case that its inverted, just output max of both
		out.println(Math.max(firstWins, secondWins));
		
		out.close();
		
	}
}
