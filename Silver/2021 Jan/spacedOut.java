// jan 24
import java.util.*;
import java.io.*;
public class spacedOut {
	public static BufferedReader br;
	public static StringTokenizer st;
	public static FastReader in = new FastReader();
//	public static PrintWriter out = new PrintWriter(System.out);
	public static int n = in.nextInt();
	public static int[][] mat = new int[n][n];
	public static int max = 0;
	
	public static void main(String[] args) throws IOException{
		input();
		recurse(new boolean[n][n], 0, 0, 0);
	}
	
	public static void recurse(boolean[][] visited, int sum, int i, int j) {
		// step one base case
		if(i + j + 2 == (n-1) * (n-1)) {
			max = Math.max(sum, max);
//			System.out.println("max: " + max);
			return;
		}
		
		// step two figure out which 2 by 2 we're looking at
//		for(int) {
//			
//		}
	}
	
	public static void input() {
		// TODO Auto-generated method stub
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {				
				mat[i][j] = in.nextInt();
			}
		}
		
		for(int i = 0; i < n; i++) {
			System.out.println(Arrays.toString(mat[i]));
		}
	}

	static class FastReader{
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
