import java.util.*;
import java.awt.Point;
import java.io.*;
public class mountainsConsole {
	public static BufferedReader br;
	public static StringTokenizer st;
	public static FastReader in = new FastReader();
	public static PrintWriter out;
	public static int n = in.nextInt();
	public static Point[] peaks = new Point[n];
	public static int ans = n;
	
	public static void main(String[] args) throws IOException{
		out = new PrintWriter(System.out);
		
		input();
		solve();
		
		out.println(ans);
		out.close();
	}
	
	
    public static void solve() {
		// TODO Auto-generated method stub
    	int curr = 0;
        int next = curr + 1;
        while (curr < n) {
          while (next < n && isCovered(curr, next)) {
            next++;
            ans--;
          }
          curr = next; // new curr when you find a new mountain that isn't covered
          next = curr + 1;
        }
	}


	public static boolean isCovered(int curr, int next) {
		// TODO Auto-generated method stub
		Point first = peaks[curr];
		Point second = peaks[next];
		if(second.y <= (first.x + first.y - second.x)) {
			return true;
		}
		return false;
	}


	public static void input() {
		// TODO Auto-generated method stub
    	for(int i = 0; i < n; i++) {
    		peaks[i] = new Point(in.nextInt(), in.nextInt());
    	}
    	
    	Arrays.sort(peaks, (a, b) -> {
    		int left1 = a.x - a.y;
    		int left2 = b.x - b.y;
    		if(left1 != left2) {
    			return left1 - left2;
    		}
    		return b.y - a.y;
    	});
    	
//    	System.out.println(Arrays.toString(peaks));
	}


//	public static BufferedReader br;
//	public static StringTokenizer st;
//	public static FastReader in = new FastReader();
//	public static PrintWriter out;
//	public static int n = in.nextInt();
//	public static peak[] peaks = new peak[n];
//	public static int ans = n;
//	
//	public static void main(String[] args) throws IOException{
//		out = new PrintWriter(System.out);//new FileWriter("mountains.out"));
//		
//		input();
//		
//		solve();
//		
//		System.out.println("ans: " + ans);
//		
//		
//		out.close();
//	}
//	
//	public static void solve() {
//		// TODO Auto-generated method stub
//		for(int i = 0; i < n; i++) {
//			for(int j = i+1; j < n; j++) {
//				if(check(i, j)) {
//					break;
//				}
//			}
//		}
//	}
//
//	public static boolean check(int i, int j) {
//		// TODO Auto-generated method stub
//		Point first = peaks[i].point;
//		Point second = peaks[j].point;
//		System.out.println(first);
//		System.out.println(second);
//		
//		int deltay;
//		if(first.y > second.y) {// && !peaks[j].covered) {
//			deltay = first.y - second.y;
//			System.out.println(deltay);
//			if((second.x < first.x + deltay) && (second.x > first.x - deltay)) {
//				peaks[j].covered = true;
//				ans--;
//				return true;
//			}
//		}
//		else if(first.y < second.y) {// && !peaks[i].covered) {
//			deltay = second.y - first.y;
//			System.out.println(deltay);
//			if((first.x < second.x + deltay) && (first.x > second.x - deltay)) {
//				ans--;
//				peaks[i].covered = true;
//				return true;
//			}
//		}
//		else {
//			return false;
//		}
//		
//		return false;
//	}
//
//	public static void input() {
//		// TODO Auto-generated method stub
//		for(int i = 0; i < n; i++) {
//			peaks[i] = new peak(in.nextInt(), in.nextInt());
//		}
//		
//		Arrays.sort(peaks, new pointSort());
////		System.out.println(Arrays.toString(points));
//	}
//	
//	static class peak{
//		Point point;
//		boolean covered;
//		public peak(int x, int y) {
//			point = new Point(x, y);
//			covered = false;
//		}
//	}
//	
//	static class pointSort implements Comparator<peak>{
//		public int compare(peak o1, peak o2) {
//			// TODO Auto-generated method stub
//			
//			if(o1.point.x < o2.point.x) {
//				return -1;
//			}
//			else if(o1.point.x > o2.point.x) {
//				return 1;
//			}
//			else {
//				if(o1.point.y < o2.point.y) {
//					return -1;
//				}
//				else if(o1.point.y > o2.point.y) {
//					return 1;
//				}
//				return 0;
//			}
//			
////			return 0;
//		}
//		
//	}

	static class FastReader{
		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));//FileReader("mountains.in"));
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
