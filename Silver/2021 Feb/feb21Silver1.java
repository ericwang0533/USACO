import java.util.*;
import java.io.*;
public class feb21Silver1 {
	public static BufferedReader br;
	public static StringTokenizer st;
	public static PrintWriter out;
	public static FastReader in = new FastReader();
	
	public static void main(String[] args) throws IOException{
		out = new PrintWriter(System.out);
	
		out.close();
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
