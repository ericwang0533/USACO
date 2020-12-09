import java.util.*;
import java.io.*;

public class gymnastics {
	public static FastReader in = new FastReader();
	public static PrintWriter out;
	public static int k = in.nextInt();
	public static int n = in.nextInt();
	
	public static void main(String[] args) throws IOException{
		out = new PrintWriter(new BufferedWriter(new FileWriter("gymnastics.out")));
		
		int[][] mat = new int[k][n];
		for(int i = 0; i < k; i++) {
			for(int j = 0; j < n; j++) {
				int curr = in.nextInt();
				mat[i][curr-1] = j+1;
			}
		}
		
		int ans = 0;
		for(int i = 0; i < n; i++) {
			for(int j = i+1; j < n; j++) {
				int test = 0;
				boolean stop = false;
				for(int a = 0; a < k; a++) {
					if(mat[a][i] > mat[a][j]) {
						if(test == -1) {
							stop = true;
							continue;
						}
						test = 1;
					}
					else{
						if(test == 1) {
							stop = true;
							continue;
						}
						test = -1;
					}
				}
				if(!stop) {
					ans++;
				}
			}
		}
		
		out.println(ans);
		out.close();
	}
	
	static class FastReader{
		BufferedReader br;
		StringTokenizer st;
		public FastReader() {
			try {
				br = new BufferedReader(new FileReader("gymnastics.in"));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
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
