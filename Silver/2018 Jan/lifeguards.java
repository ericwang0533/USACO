import java.util.*;
import java.awt.Point;
import java.io.*;
public class lifeguards {
	public static BufferedReader br;
	public static StringTokenizer st;
	public static FastReader in = new FastReader();
	public static PrintWriter out;
	public static int n = in.nextInt();
	public static Point[] points = new Point[n];
	
	public static void main(String[] args) throws IOException{
		out = new PrintWriter(new BufferedWriter(new FileWriter("lifeguards.out")));
		
		input();
		out.close();
	}
	
	private static void input() {
		// TODO Auto-generated method stub
		for(int i = 0; i < n; i++) {
			points[i] = new Point(in.nextInt(), in.nextInt());
		}
		
		Arrays.sort(points);
		
		System.out.println(Arrays.toString(points));
	}

	static class FastReader{
		public FastReader() {
			try {
				br = new BufferedReader(new FileReader("lifeguards.in"));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
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
