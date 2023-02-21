import java.util.*;
import java.io.*;

public class sleepyCow {
	public static void main (String []args)throws Exception{
		Scanner reader = new Scanner(System.in);
		int a = reader.nextInt();
		int b = reader.nextInt();
		int c = reader.nextInt();
		int small = Math.min(a, Math.min(b, c));
		int large = Math.max(c, Math.max(a, b));
		int med = 0;
		if(small == a){
			if(large == c){
				med = b;
			}
			else{
				med = c;
			}
		}
		else if(small == b){
			if(large == c){
				med = a;
			}
			else{
				med = c;
			}
		}
		else if(small == c){
			if(large == b){
				med = a;
			}
			else{
				med = b;
			}
		}		
		if(large - med == 2 || med - small == 2){
			System.out.println(1);
		}
		else if(large - med == 1 && med - small == 1){
			System.out.println(0);
		}
		else{
			System.out.println(2);
		}
		System.out.println(Math.max(large - med, med - small)- 1);
	}
}
