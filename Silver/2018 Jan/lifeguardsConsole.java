import java.util.*;
import java.awt.Point;
import java.io.*;
public class lifeguardsConsole {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));//FileReader("lifeguards.in"));
		PrintWriter pw = new PrintWriter(System.out);//new BufferedWriter(new FileWriter("lifeguards.out")));
		TreeSet<Integer> set = new TreeSet<Integer>();
		int n = Integer.parseInt(br.readLine());
		State[] l = new State[2*n];
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			l[2*i] = new State(start, i);
			l[2*i+1] = new State(end, i);
		}
		
		System.out.println(Arrays.toString(l));
		
		Arrays.sort(l);
		System.out.println(Arrays.toString(l));
		System.out.println();

		int actualCover = 0;
		int[] alone = new int[n];
		int last = 0;
		for(State out: l) {
			if(set.size() == 1) {
				System.out.println("set.size() == 1");
				System.out.println("set.first(): " + set.first());
				alone[set.first()] += out.time - last;
			}
			else {
				System.out.println("set.size() != 1");				
			}
			
			if(!set.isEmpty()) {
				System.out.println("set is not empty");
				actualCover += out.time - last;
			}
			else {
				System.out.println("set is empty");				
			}
			
			if(set.contains(out.index)) {
				System.out.println("set contains out.index");
				set.remove(out.index);
			}
			else {
				System.out.println("set does not contains out.index");
				set.add(out.index);
			}
			
			last = out.time;
			
			System.out.println(out.time + " " + out.index);
			System.out.println("actualCover: " + actualCover);
			System.out.println("set: " + Arrays.toString(set.toArray()));
			System.out.println("alone: " + Arrays.toString(alone));
			System.out.println("last: " + last);
			System.out.println(set.size());
			System.out.println();
		}
		
		System.out.println(Arrays.toString(alone));
		
		int ret = 0;
		for(int out: alone) {
			ret = Math.max(ret, actualCover - out);
		}
		pw.println(ret);
		pw.close();
	}
	
	static class State implements Comparable<State> {
		public int time, index;
		public State(int a, int b) {
			time=a;
			index=b;
		}
		
		public String toString() {
			return time + " " + index;
		}
		
		public int compareTo(State s) {
			return time - s.time;
		}
	}
	
	
//	public static BufferedReader br;
//	public static StringTokenizer st;
//	public static FastReader in = new FastReader();
//	public static PrintWriter out;
//	public static int n = in.nextInt();
//	public static Point[] points = new Point[n];
//	public static int full_sum = 0;
//	public static int min = Integer.MAX_VALUE;
//	public static Point currPoint = new Point();
//	
//	public static void main(String[] args) throws IOException{
//		out = new PrintWriter(System.out);//new BufferedWriter(new FileWriter("lifeguards.out")));
//		
//		input();
//		
//		currPoint = points[0];
//		full_sum += points[0].y - points[0].x;
//		for(int i = 1; i < n; i++) {
//			Point point = points[i];
//			full_sum_plus(point);
//			remove(point);
//		}
//		
//		
//		out.close();
//	}
//	
//	public static void remove(Point point) {
//		// TODO Auto-generated method stub
//		
//		//cases
//		//1. the time does not overlap at all
//		//2. the time overlaps from the left
//		//3. the time overlaps from the right
//		
//		
//	}
//
//	public static void full_sum_plus(Point point) {
//		// TODO Auto-generated method stub
//		if(point.x <= currPoint.x) {
//			full_sum += point.y - currPoint.y;
//		}
//		else if(point.y > currPoint.y){
//			full_sum += point.y - currPoint.y;
//		}
//		
//		currPoint = point;
//		System.out.println(full_sum);
//		
//	}
//
//	private static void input() {
//		// TODO Auto-generated method stub
//		for(int i = 0; i < n; i++) {
//			points[i] = new Point(in.nextInt(), in.nextInt());
//		}
//		
//		Arrays.sort(points, new PointSort());
//		
//		System.out.println(Arrays.toString(points));
//	}
//	
//	static class PointSort implements Comparator<Point>{
//		public int compare(Point a, Point b) {
//			if(a.x < b.x) {
//				return -1;
//			}
//			else if(a.x > b.x) {
//				return 1;
//			}
//			else {
//				if(a.y < b.y) {
//					return -1;
//				}
//				else if(a.y > b.y) {
//					return 1;
//				}
//				else {
//					return 0;
//				}
//			}
//		}
//	}
//
//	static class FastReader{
//		public FastReader() {
//			br = new BufferedReader(new InputStreamReader(System.in));//FileReader("lifeguards.in"));
//		}
//		String next() {
//			while(st == null || !st.hasMoreElements()) {
//				try {
//					st = new StringTokenizer(br.readLine());
//				}
//				catch(IOException e) {
//					e.printStackTrace();
//				}
//			}
//			return st.nextToken();
//		}
//		int nextInt() {
//			return Integer.parseInt(next());
//		}
//		double nextDouble() {
//			return Double.parseDouble(next());
//		}
//		long nextLong() {
//			return Long.parseLong(next());
//		}
//		String nextLine() {
//			String str = "";
//			try {
//				str = br.readLine();
//			}
//			catch(IOException e) {
//				e.printStackTrace();
//			}
//			return str;
//		}
//	}
}
