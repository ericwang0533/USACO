import java.util.*;
import java.io.*;
public class comfortableCows {
	// stores cow's neighbors
	public static int[][] mat = new int[1003][1003];
	// stores if cow exists or not
	public static boolean[][] cow = new boolean[1003][1003];
	public static int ans = 0;		// a.k.a # of comfortable cows
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.nextLine();
		
		for(int i = 0; i < n; i++) {
			// add 1 b/c we might need to check x-1 and y-1
			// prevents checks of neg values
			int x = in.nextInt() + 1;
			int y = in.nextInt() + 1;
			
			// cow exists
			cow[x][y] = true;
			
			
			if(mat[x][y] == 3) {
				ans++;
			}
			
			// update each of the cows neighbors
			update(x-1, y);
			update(x+1, y);
			update(x, y-1);
			update(x, y+1);
		
			System.out.println(ans);
		}
		
		in.close();
	}
	
	public static void update(int x, int y) {
		// increment mat[x][y] b/c it has a new neighbor
		mat[x][y]++;
		
		// check if cow exists first (a cow cant be uncomfortable if it doesnt exist)
		if(cow[x][y]) {
			// its comfortable
			if(mat[x][y] == 3) {
				ans++;
			}
			// it used to be comfortable but is now uncomfortable
			else if(mat[x][y] > 3) {
				ans--;
			}
		}
	}
}
