import java.util.*;
import java.io.*;

public class whereami {
	public static FastReader in = new FastReader();
	public static PrintWriter out; 
	public static int n = in.nextInt();
	public static String road = in.nextLine();
	
	public static boolean check(int num) {
		for(int i = 0; i < n-num+1; i++) {
			for(int j = i+1; j < n-num+1; j++) {
				if(road.substring(i, i+num).equals(road.substring(j, j+num))) {
					return true;
				}
				//System.out.print(road.substring(i, i+num));
				//System.out.println(" " + road.substring(j, j+num));
			}
		}
		return false;
	}
	
	public static void main(String[] args) throws IOException{
		out = new PrintWriter(new BufferedWriter(new FileWriter("whereami.out")));
		int ans = 1;
		while(true) {
			if(!check(ans)) {
				break;
			}
			ans++;
		}
		out.println(ans);
		out.close();
	}
	
	static class FastReader{
		BufferedReader br;
		StringTokenizer st;
		public FastReader() {
			try {
				br = new BufferedReader(new FileReader("whereami.in"));
			}
			catch(FileNotFoundException e) {
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
