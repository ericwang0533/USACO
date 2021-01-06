import java.util.*;
import java.awt.Point;
import java.io.*;
public class mountains {
	public static BufferedReader br;
	public static StringTokenizer st;
	public static FastReader in = new FastReader();
	public static PrintWriter out;
	public static int n = in.nextInt();
	public static Point[] peaks = new Point[n];
	public static int ans = n;
	
	public static void main(String[] args) throws IOException{
		out = new PrintWriter(new FileWriter("mountains.out"));
		
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

	static class FastReader{
		public FastReader() {
			try {
				br = new BufferedReader(new FileReader("mountains.in"));
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
