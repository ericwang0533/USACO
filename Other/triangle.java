import java.util.*;
import java.io.*;
public class triangle {
	public static void main(String[] args) throws IOException{
		Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // # of numbers
        
        // size of triangle
        int m = 0, cnt = 1;
        while (m + cnt <= n ) 
        {
            m += cnt;
            cnt++;
        }
        m = cnt -1;
        
        // Print triangle
        for (int j = 1; j <= m; j++) 
        {
            for( int i = 1; i<= j; i++)
            {
                int num = in.nextInt();
                System.out.println("num " + num);
                // Transform the number 
                int sum = 0;
                while(num > 0)
                {
                    sum += num % 10;
                    num /= 10;
                    System.out.println(sum);
                    System.out.println(num);
                    if(num == 0 && sum >= 10) 
                    { 
                    	System.out.println(1);
                        num = sum;
                        sum = 0;
                        System.out.println(sum);
                        System.out.println(num);
                        
                    }
                } // end of while
                System.out.println("end");
                System.out.print(sum + " ");
            }
            System.out.println();
        } // end of for
        
	}
}
