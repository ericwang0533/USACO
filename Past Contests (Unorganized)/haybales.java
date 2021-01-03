import java.util.*;
import java.io.*;
public class haybales {
	public static BufferedReader br;
	public static StringTokenizer st;
	public static FastReader in = new FastReader();
	public static int n = in.nextInt(), q = in.nextInt();
	public static int[] haybales = new int[n];
	public static PrintWriter out;
	
	public static void main(String[] args) throws IOException{
		out = new PrintWriter(new BufferedWriter(new FileWriter("haybales.out")));
		
		input();
		binary_search();
		
		out.close();
	}
	
	public static void binary_search() {
		// TODO Auto-generated method stub
		for(int i = 0; i < q; i++) {
			int bi = Arrays.binarySearch(haybales, in.nextInt());
			int ti = Arrays.binarySearch(haybales, in.nextInt());
//			System.out.println(bi + " " + ti);
			if(bi < 0){
				bi = Math.abs(bi+1);
	        }
			if(ti < 0){
				ti = Math.abs(ti+2);
			}
//			System.out.println(bi + " " + ti);
			out.println(ti-bi+1);
//			System.out.println(ti);
		}
		
	}

	private static void input() {
		// TODO Auto-generated method stub
		for(int i = 0; i < n; i++) {
			haybales[i] = in.nextInt();
		}
		Arrays.sort(haybales);
	}

	static class FastReader {
		public FastReader() {
			try {
				br = new BufferedReader(new FileReader("haybales.in"));
//				br = new BufferedReader(new InputStreamReader(System.in));
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
