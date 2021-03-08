// jan 24
import java.util.*;
import java.awt.Point;
import java.io.*;
public class noTimeToPaint {
	public static BufferedReader br;
	public static StringTokenizer st;
	public static FastReader in = new FastReader();
//	public static PrintWriter out = new PrintWriter(System.out);
	public static int n = in.nextInt(), q = in.nextInt();	
//	public static Queue<Point> pq = new LinkedList<>();
//	public static PriorityQueue<Point> pq = new PriorityQueue<Point>(q, new Comp());
	public static char[] chars = in.nextLine().toCharArray();
	public static Set<Character> set = new HashSet<Character>();
	public static Set<Character> set2 = new HashSet<Character>();
	
	public static void main(String[] args) throws IOException{
		input();
	}
	
	public static void input() {
		// TODO Auto-generated method stub
		for(int i = 0; i < q; i++) {
//			pq.add(new Point(in.nextInt(), in.nextInt()));
			solve(new Point(in.nextInt(), in.nextInt()));
		}
		
//		while (!pq.isEmpty()) {
////		    System.out.println(pq.poll());
//			solve(pq.poll());
//		}
	}

	public static void solve(Point pt) {
		// TODO Auto-generated method stub
//		System.out.println(pt);
		int ans;
//		if(set == null) {
//			set = new HashSet<Character>();
			for(int i = 0; i < pt.x-1; i++) {
//				System.out.println(chars[i]);
				set.add(chars[i]);
			}
			
			ans = set.size();
//			System.out.println(set);
			
			for(int i = pt.y; i < n; i++) {
//				System.out.println(chars[i]);
				set2.add(chars[i]);
			}
			
			ans += set2.size();
//			System.out.println(set2);
			
			System.out.println(ans);
			set.clear();
			set2.clear();
//			System.out.println(set + " " + set2);
//			return;
//		}
	}

//	static class Comp implements Comparator<Point>{
//		public int compare(Point a1, Point a2) {
//			if(a1.x == a2.x) {
//				return a1.y - a2.y;
//			}
//			else {
//				return a1.x - a2.x;
//			}
//		}
//	}
	
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
