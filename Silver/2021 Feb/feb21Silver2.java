import java.util.*;
import java.io.*;
public class feb21Silver2 {
	public static BufferedReader br;
	public static StringTokenizer st;
	public static PrintWriter out;
	public static FastReader in = new FastReader();
	public static int n = Integer.parseInt(in.next(), 16);
	public static int k = Integer.parseInt(in.next(), 16);
	public static double[] arr = new double[n];
	public static int ans;
	
	public static void main(String[] args) throws IOException{
		out = new PrintWriter(System.out);
		
		System.out.println(n);
		System.out.println(k);
		input();
		
		solve();
		
		out.close();
	}
	
	public static void solve() {
		
	}
	
	public static void input() {
		// TODO Auto-generated method stub
		for(int i = 0; i < n; i++) {
			arr[i] = in.nextDouble()/12.0;
		}
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
	}

	static class FastReader{
		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		
		String next() {
			while(st == null || !st.hasMoreTokens()) {
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
	}
}
