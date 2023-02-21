import java.util.*;
import java.io.*;
public class udderedButNotHerd {
	public static void main(String[] args) {


		// char letterA = 'a';
		// char letterB = 'b';
		// System.out.println(letterA-96);
		// System.out.println(letterB-96);
	

		String hello = "hello";
		System.out.println(hello.substring(1)); 
		String ell = "llooooooo";
		System.out.println(hello.indexOf(ell));
		
		Scanner in = new Scanner(System.in);
		String cowphabet = in.nextLine();
		String hum = in.nextLine();
		
		int counter = 1;
		for(int i = 1; i < hum.length(); i++) {
			String curr = hum.substring(i, i+1);	// current character
			String prev = hum.substring(i-1, i);	// previous character
			if(cowphabet.indexOf(curr) <= cowphabet.indexOf(prev)) {
				// if the index of the current character is less than the index of the previous character
				counter++;
			}
		}
		
		System.out.println(counter);
	}
}
