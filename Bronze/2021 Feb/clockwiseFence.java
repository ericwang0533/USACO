import java.util.*;
import java.io.*;

public class clockwiseFence {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.nextLine();
		
		for(int i = 0; i < n; i++) {
			char[] charArr = in.nextLine().toCharArray();
			
			// store the num of turns
			int turns = 0;
			for(int j = 1; j < charArr.length; j++) {
				if(charArr[j] != charArr[j-1]) {
					if(isCW(charArr[j-1], charArr[j])) {
						// current turn is going clockwise
						turns++;
					}
					else {
						// current turn is going counterclockwiser
						turns--;
					}
				}
			}
			
			// if turns > 0 CW
			// if turns < 0 CCW
			String ans = turns > 0 ? "CW" : "CCW";
			System.out.println(ans);
		}
		
		in.close();
	}
	
	public static boolean isCW(char first, char second) {
		// if a pair of chars are N + E, E + S, S + W, W + N
		// it would be going clockwise
		if((first == 'N' && second == 'E') || (first == 'E' && second == 'S') || (first == 'S' && second == 'W') || (first == 'W' && second == 'N')) {
			return true;
		}
		return false;
	}
}
