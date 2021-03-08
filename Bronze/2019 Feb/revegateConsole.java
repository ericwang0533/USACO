import java.util.*;
import java.awt.Point;
import java.io.*;
public class revegateConsole {
	public static BufferedReader br;
	public static StringTokenizer st;
	public static PrintWriter out;
	public static FastReader in = new FastReader();
	public static int n = in.nextInt(), m = in.nextInt();
	public static Point[] cows = new Point[m];
	public static int[] ans = new int[n];
	
	public static void main(String[] args) throws IOException{
//		out = new PrintWriter(new FileWriter("revegetate.out"));
//		out.println("test");
		
		input();
		
		solve();
		
//		out.close();
	}
	
	public static void solve() {
		// TODO Auto-generated method stub
		Arrays.fill(ans, 1);
		for(int i = 0; i < m; i++) {
			Point curr = cows[i];
			System.out.println(curr.x + " : " + curr.y);
		
			if(ans[curr.y-1] == ans[curr.x-1]) {
				ans[curr.y-1]++;
			}
			System.out.println("1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5");
			System.out.println(Arrays.toString(ans).replaceAll("\\[|\\]|\\,", ""));
			System.out.println();
		}
		
		System.out.println();
		System.out.println(Arrays.toString(ans).replaceAll("\\[|\\]|\\,"/*|\\s"*/, ""));
	}

	public static void input() {
		// TODO Auto-generated method stub
		for(int i = 0; i < m; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			cows[i] = new Point(Math.min(a, b), Math.max(a, b));
		}
//		System.out.println(Arrays.toString(cows));
		
		Arrays.sort(cows, new pointSort());
		
//		for(int i = 0; i < cows.length; i++) {
//			System.out.println(cows[i].x + " : " + cows[i].y);
//		}
//		System.out.println();
//		System.out.println(Arrays.toString(cows));
	}
	
	static class pointSort implements Comparator<Point>{
		public int compare(Point o1, Point o2) {
			// TODO Auto-generated method stub
			if(o1.x != o2.x) {
				return o1.x - o2.x;
			}
			else {
				return o1.y - o2.y;
			}
			
//			if(o1.y != o2.y) {
//				return o1.y - o2.y;
//			}
//			return o1.x - o2.x;
		}
	}

	static class FastReader{
		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
//				br = new BufferedReader(new FileReader(new File("revegetate.in")));
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
