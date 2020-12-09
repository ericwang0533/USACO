import java.util.*;
import java.io.*;
public class cowrow{
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int[] arr = new int[n];
		ArrayList<Integer> nums = new ArrayList<Integer>();
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(in.readLine());
			if(nums.indexOf(arr[i]) == -1) {
				nums.add(arr[i]);
			}
		}
		
		int max = 0;
		for(int i = 0; i < nums.size(); i++) {
			int counter = 1;
			int current = -1;
			for(int j = 0; j < n; j++) {
				if(arr[j] == nums.get(i)) {
					//System.out.println("j: " +j + " : 1");
					continue;
				}
				if(current == -1) {
					//System.out.println("j: " +j + " : 2");
					current = arr[j];
					counter++;
				}
				else if(current == arr[j]) {
					//System.out.println("j: " +j + " : 3");
					counter++;
				}
				else {
					//System.out.println("j: " +j + " : 4");
					max = Math.max(max, counter);
					counter = 1;
					current = arr[j];
				}
			}
			//System.out.println(nums.get(i));
			max = Math.max(max, counter);
			//System.out.println(max);
		}
		System.out.println(max);
	}
}
