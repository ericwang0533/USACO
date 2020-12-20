import java.util.*;
import java.io.*;
public class reduce {
	public static FastReader in = new FastReader();
	public static int n = in.nextInt();
	//public static int[][] coords = new int[n][2];
	public static int[][] x = new int[n][2], y = new int[n][2];
	public static PrintWriter out;
	public static int ans = Integer.MAX_VALUE; //make this min
	
	//TODO: check if ans = 0, when its in a line/row
	
	public static void main(String[] args) throws IOException{
		out = new PrintWriter(new BufferedWriter(new FileWriter("reduce.out")));
		
		input();
		left(x, y);
		right(x, y);
		top(x, y);
		bottom(x, y);
		
		out.println(ans);
		out.close();
	}
	
	public static void left(int[][] x2, int[][] y2) {
		// TODO Auto-generated method stub
		int area = 1;
		if(y2[0][0] == x2[0][0] && y2[0][1] == x2[0][1]) {
			area *= (x2[n-1][0] - x2[1][0]);
			area *= (y2[n-1][1] - y2[1][1]);
		}
		else if(y2[n-1][0] == x2[0][0] && y2[n-1][1] == x2[0][1]) {
			area *= (x2[n-1][0] - x2[1][0]);
			area *= (y2[n-2][1] - y2[0][1]);
		}
		else {
			area *= (x2[n-1][0] - x2[1][0]);
			area *= (y2[n-1][1] - y2[0][1]);
		}
		
		ans = Math.min(ans, area);
//		System.out.println(area);
	}
	
	public static void right(int[][] x2, int[][] y2) {
		// TODO Auto-generated method stub
		int area = 1;
		if(y2[0][0] == x2[n-1][0] && y2[0][1] == x2[n-1][1]) {
			area *= (x2[n-2][0] - x2[0][0]);
			area *= (y2[n-1][1] - y2[1][1]);
		}
		else if(y2[n-1][0] == x2[n-1][0] && y2[n-1][1] == x2[n-1][1]) {
			area *= (x2[n-2][0] - x2[0][0]);
			area *= (y2[n-2][1] - y2[0][1]);
		}
		else {
			area *= (x2[n-2][0] - x2[0][0]);
			area *= (y2[n-1][1] - y2[0][1]);
		}
		
		ans = Math.min(ans, area);
//		System.out.println(area);
	}
	
	public static void top(int[][] x2, int[][] y2) {
		// TODO Auto-generated method stub
		int area = 1;
		if(y2[n-1][0] == x2[n-1][0] && y2[n-1][1] == x2[n-1][1]) {
			area *= (x2[n-2][0] - x2[0][0]);
			area *= (y2[n-2][1] - y2[0][1]);
		}
		else if(y2[n-1][0] == x2[0][0] && y2[n-1][1] == x2[0][1]) {
			area *= (x2[n-1][0] - x2[1][0]);
			area *= (y2[n-2][1] - y2[0][1]);
		}
		else {
			area *= (x2[n-1][0] - x2[0][0]);
			area *= (y2[n-2][1] - y2[0][1]);
		}
		
		ans = Math.min(ans, area);
//		System.out.println(area);
	}
	
	public static void bottom(int[][] x2, int[][] y2) {
		// TODO Auto-generated method stub
		int area = 1;
		if(y2[0][0] == x2[n-1][0] && y2[0][1] == x2[n-1][1]) {
			area *= (x2[n-2][0] - x2[0][0]);
			area *= (y2[n-1][1] - y2[1][1]);
		}
		else if(y2[0][0] == x2[0][0] && y2[0][1] == x2[0][1]) {
			area *= (x2[n-1][0] - x2[1][0]);
			area *= (y2[n-1][1] - y2[1][1]);
		}
		else {
			area *= (x2[n-1][0] - x2[0][0]);
			area *= (y2[n-1][1] - y2[1][1]);
		}
		
		ans = Math.min(ans, area);
//		System.out.println(area);
	}

	public static void input() {
		// TODO Auto-generated method stub
		for(int i = 0; i < n; i++) {
			//coords[i][0] = in.nextInt();
			//coords[i][1] = in.nextInt();
			x[i][0] = in.nextInt();//coords[i][0];
			x[i][1] = in.nextInt();//coords[i][1];
			y[i][0] = x[i][0];
			y[i][1] = x[i][1];
		}
		
		Arrays.sort(x, Comparator.comparingDouble(o -> o[0]));
		Arrays.sort(y, Comparator.comparingDouble(o -> o[1]));
		
	}
	
	static class FastReader{
		BufferedReader br;
		StringTokenizer st;
		public FastReader() {
			try {
				br = new BufferedReader(new FileReader("reduce.in"));
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
