import java.util.*;
import java.io.*;
public class thirdPartialNew {
	public static FastReader in = new FastReader();
	public static int n = in.nextInt();
	public static String[] direct = new String[n];
	public static int[] x = new int[n], y = new int[n]; // maybe 2d array?
	public static int[] ans = new int[n];
	public static PrintWriter out;
	
	public static void main(String[] args) throws IOException{
		out = new PrintWriter(System.out);
		
		input();
		
		for(int i = 0; i < n; i++) {
			if(direct[i].equals("E")) {
				
				for(int j = 0; j < n; j++) {	//can optimize by not having to check previous ones
					
					if(i == j) {
						continue;
					}
					
					if(direct[j].equals("N")) {
						// directions are not equal
						int toX = x[j] - x[i];
						int toY = Math.abs(y[i] - y[j]);
						if(toX < 0 || toX <= toY || y[j] > y[i]) {
							// wont get stopped by this other cow
						}
						else {
							// it will get stopped
							ans[i] = Math.min(ans[i], Math.abs(toX));
						}
					}
					
				}
				
			}
			else {	//north
				
				for(int j = 0; j < n; j++) {	//can optimize by not having to check previous ones
					
					if(i == j) {
						continue;
					}
					
					if(direct[j].equals("E")) {
						// directions are not equal
						int toX = Math.abs(x[i] - x[j]);
						int toY = y[j] - y[i];
						if(toY < 0 || toY <= toX || x[j] > x[i]) {
							// wont get stopped by this other cow
						}
						else {
							// it will get stopped
							ans[i] = Math.min(ans[i], Math.abs(toY));
						}
					}
					
				}
				
			}
			
		}
		
		for(int i = 0; i < n; i++) {
			out.println(ans[i]);
		}
		
		out.close();
	}
	
	public static void input() {
		// TODO Auto-generated method stub
		for(int i = 0; i < n; i++) {
			direct[i] = in.next();
			x[i] = in.nextInt();
			y[i] = in.nextInt();			
			ans[i] = Integer.MAX_VALUE;
		}
		
		//dbg
//		for(int i = 0; i < n; i++) {
//			out.println(direct[i] + " " + x[i] + " " + y[i]);
//		}
	}
	
	static class FastReader{
		BufferedReader br;
		StringTokenizer st;
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

