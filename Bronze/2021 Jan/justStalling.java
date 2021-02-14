import java.util.*;
import java.io.*;
public class justStalling {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] cows = new int[n];
		int[] stalls = new int[n];
		for(int i = 0; i < n; i++) {
			cows[i] = in.nextInt();
		}
		for(int i = 0; i < n; i++) {
			stalls[i] = in.nextInt();
		}
		// store input
		
		int[] results = new int[n];
		// store the number of cows that can fit into each cow
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(cows[j] <= stalls[i]) {
					results[i]++;
				}
			}
		}
		
//		System.out.println(Arrays.toString(results));
		
		Arrays.sort(results);
		// sort results
		
		long ans = 1;
		for(int i = 0; i < n; i++) {
			ans *= results[i] - i;
			// subtract i from each because some cows are already placed in previous stalls
		}
		
		System.out.println(ans);
	}
}
