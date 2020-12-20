import java.util.*;
import java.io.*;
public class diamondConsole {
	public static FastReader in = new FastReader();
	public static int n = in.nextInt(), k = in.nextInt();
	public static int[] arr = new int[n];
	public static PrintWriter out;
	public static int ans = 0;
	
	public static void main(String[] args) throws IOException{
		out = new PrintWriter(System.out);//new BufferedWriter(new FileWriter("diamond.out")));
		
		input();
		
		
		for(int i = 0; i < n; i++) {
			int counter = 1;
			for(int j = i+1; j < n; j++) {
				if(arr[j] <= arr[i]+k) {
					counter++;
				}
				else {
					ans = Math.max(counter, ans);
					break;
				}
			}
			ans = Math.max(counter, ans);
		}
		
		out.println(ans);
		out.close();
	}
	
	public static void input() {
		// TODO Auto-generated method stub
		for(int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}
		Arrays.sort(arr);
	}

	static class FastReader{
		BufferedReader br;
		StringTokenizer st;
		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));//new FileReader("diamond.in"));
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
