import java.util.*;
import java.io.*;
public class daisyChains {
	public static FastReader in = new FastReader();
	public static int n = in.nextInt();
	public static int[] arr = new int[n];
	public static int ans = n; //starts at n bc the single count are all averages
	public static PrintWriter out;
	
	public static void main(String[] args) throws IOException{
		out = new PrintWriter(System.out);
		
		input();
		
//		ArrayList<Integer> temp = new ArrayList<Integer>();
//		temp.add(0);
//		// temp stores INDEXES
//		photo(2, temp);
		
		for(int i = 2; i <= n; i++) {
			// from 2 flowers in a photo to n flower in a photo
			// recursive function?
			for(int j = 0; j < n-i+1; j++) {
				ArrayList<Integer> temp = new ArrayList<Integer>();
				// temp stores INDEXES
				temp.add(j);
				photo(i, temp);
			}
			
		}
		
		out.print(ans);
		out.close();
	}
	
	public static void photo(int i1, ArrayList<Integer> temp) {
		// TODO Auto-generated method stub
		// loop through each "photo" with i flowers
		// check if its a "average photo"
		//System.out.println(temp.size());
		// check if we need to break the recursion
		if(temp.size() == i1) { // or replae the arraylist w/ a integer and store values in the recursion??
			check_average(temp);
			return;
		}
		
		//for(int i = temp.get(temp.size()-1) + 1; i < n; i++) {
			//System.out.println("here");
			temp.add(temp.get(temp.size()-1) + 1);
			photo(i1, temp);
			temp.remove(temp.size()-1);
		//}
		
	}

	public static void check_average(ArrayList<Integer> temp) {
		// TODO Auto-generated method stub
		// dbg
//		for(int i = 0; i < temp.size(); i++) {
//			System.out.print(temp.get(i) + " ");
//		}
//		System.out.println();
		
		int sum = 0;
		ArrayList<Integer> petals = new ArrayList<Integer>();
		for(int i = 0; i < temp.size(); i++) {
			sum += arr[temp.get(i)];
			petals.add(arr[temp.get(i)]);
		}
		
		if(sum % temp.size() != 0) {
			return;
		}
		sum /= temp.size();
		if(petals.contains(sum)) {
			ans++;
		}
		
	}

	public static void input() {
		// TODO Auto-generated method stub
		for(int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}
	}

	static class FastReader{
		BufferedReader br;
		StringTokenizer st;
		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		String next() {
			while(st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				}
				catch(IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		int nextInt() {
			return Integer.parseInt(next());
		}
		double nextDouble() {
			return Double.parseDouble(next());
		}
		long nextLong() {
			return Long.parseLong(next());
		}
		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			}
			catch(IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}
