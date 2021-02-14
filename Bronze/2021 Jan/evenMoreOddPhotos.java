import java.util.*;
import java.io.*;
public class evenMoreOddPhotos {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int even = 0;
		int odd = 0;
		
		// store number of odds and number of evens
		for(int i = 0; i < n; i++) {
			if(in.nextInt()%2 == 0) {
				even++;
			}
			else {
				odd++;
			}
		}
		
//		System.out.println(even + " | " + odd);
		
		int counter = 0;
		while(even != 0 || odd != 0) {
//			System.out.println(counter + ": " + even + " | " + odd);
			if(counter%2 == 0) {
				// we need an even
				if(even > 0) {
					// if we have an even
					even--;
					counter++;
				}
				else {
					// we dont have an even
					if(odd >= 2) {
						// two odds also make an even
						odd-=2;
						counter++;
					}
					else {
						// we dont have 2 odds, decrement by 1 and break
//						System.out.println("decrementer");
						counter-=1;
						break;
					}
				}
			}
			else {
				// we need an odd
				if(odd > 0) {
					odd--;
					counter++;
				}
				else {
					// no amount of evens can make an odd so break
					break;
				}
			}
		}
		
		System.out.println(counter);
	}
}
