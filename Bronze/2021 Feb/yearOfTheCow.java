import java.util.*;
import java.io.*;
public class yearOfTheCow {
	public static void main(String[] args){		
		HashMap<String, Integer> cow = new HashMap<>();
		cow.put("Bessie", 0);
		
		HashMap<String, String> cowZodiac = new HashMap<>();
		cowZodiac.put("Bessie", "Ox");
		
		HashMap<String, Integer> zodiac = new HashMap<>();
		zodiac.put("Ox", 0);
	    zodiac.put("Tiger", 1);
	    zodiac.put("Rabbit", 2);
	    zodiac.put("Dragon", 3);
	    zodiac.put("Snake", 4);
	    zodiac.put("Horse", 5);
	    zodiac.put("Goat", 6);
	    zodiac.put("Monkey", 7);
	    zodiac.put("Rooster", 8);
	    zodiac.put("Dog", 9);
	    zodiac.put("Pig", 10);
	    zodiac.put("Rat", 11);
		
		Scanner in = new Scanner(System.in);
		int n = Integer.parseInt(in.nextLine());
		
		for(int i = 1; i < n+1; i++) {
			// grab the line and split it according to " " 
			String[] line = in.nextLine().split(" ");
			// line[0] = cow1 name
			// line[3] = previous/next
			// line[4] = zodiac
			// line[7] = cow2 name
			
//			System.out.println(Arrays.toString(line));
			
			// add the new cow into cowZodiac hashmap
			cowZodiac.put(line[0], line[4]);
		
			
			if(line[3].equals("previous")) {
//				System.out.println(zodiac.get(line[4]));					// 0-12 of cow1s zodiac
//				System.out.println(zodiac.get(cowZodiac.get(line[7])));		// 0-12 of cow2s zodiac
//				System.out.println(cow.get(line[7]));						// # of yrs cow2 was born before bessie
				
				// get # years cow1 was born before cow2 and add to # of years cow2 was born before bessie
				int diff = -1;
				if(zodiac.get(cowZodiac.get(line[7])) > zodiac.get(line[4])) {
					diff = cow.get(line[7]) - (zodiac.get(cowZodiac.get(line[7])) - zodiac.get(line[4]));// 
				}
				else {
					diff = cow.get(line[7]) - (12 - zodiac.get(line[4]) + zodiac.get(cowZodiac.get(line[7])));// 					
				}
//				System.out.println(diff );
				cow.put(line[0], diff);
			}
			else {
				// line[3] = next
//				System.out.println(zodiac.get(line[4]));					// 0-12 of cow1s zodiac
//				System.out.println(zodiac.get(cowZodiac.get(line[7])));		// 0-12 of cow2s zodiac
//				System.out.println(cow.get(line[7]));						// # of yrs cow2 was born before bessie
				
				// get # years cow1 was born after corn2 
				int diff = -1;
				if(zodiac.get(line[4]) - zodiac.get(cowZodiac.get(line[7])) + 12 > 12) {					
					diff = cow.get(line[7]) + zodiac.get(line[4]) - zodiac.get(cowZodiac.get(line[7]));// - cow.get(line[7]);
				}
				else {
					diff = cow.get(line[7]) + 12 + zodiac.get(line[4]) - zodiac.get(cowZodiac.get(line[7]));// 
				}
				
//				System.out.println(diff);
				cow.put(line[0], diff);
			}
			
//			System.out.println(cow);
//			System.out.println(cowZodiac);
//			System.out.println();
		}

		in.close();
	
		System.out.println(Math.abs(cow.get("Elsie")));
	}
	
}
