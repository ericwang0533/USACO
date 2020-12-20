import java.util.*;
import java.io.*;
public class socdist2Console {
	public static FastReader in = new FastReader();
	public static int n = in.nextInt();
	public static int[][] mat = new int[n][2];
	public static ArrayList<Integer> gaps = new ArrayList<Integer>();
	public static int R = n;
	public static int infect = 0;
	public static PrintWriter out;
	
	public static void main(String[] args) throws IOException{
		out = new PrintWriter(System.out);//new BufferedWriter(new FileWriter("socdist.out")));
		
		input();
		
		int counter = 0;
		Collections.sort(gaps);
		for(int i = 0; i < gaps.size(); i++) {
			if(gaps.get(i) >= R) {
				break;
			}
			counter++;
		}
		
		out.println("counter: " + (infect - counter));
		//dbg
		for(int i = 0; i < n; i++) {
			System.out.println(mat[i][0] + " " + mat[i][1]);
		}
		
		for(int i = 0; i < gaps.size(); i++) {
			System.out.println(gaps.get(i));
		}
		
		System.out.println("R: " + R);
		
		out.print("test");
		out.close();
	}
	
	public static void input() {
		// TODO Auto-generated method stub
		for(int i = 0; i < n; i++) {
			mat[i][0] = in.nextInt();
			mat[i][1] = in.nextInt();
			if(mat[i][1] == 1) {
				infect++;
			}
		}
		
		Arrays.sort(mat, Comparator.comparingDouble(o -> o[0]));
		for(int i = 1; i < n; i++) {
			if(mat[i][1] == 1 && mat[i-1][1] == 1) {
				gaps.add(mat[i][0] - mat[i-1][0]);
			}
			//gaps[i-1] = mat[i][0] - mat[i-1][0];
			if(mat[i][1] != mat[i-1][1]) {
				R = Math.min(mat[i][0] - mat[i-1][0], R);
			}
		}
	}

	static class FastReader{
		BufferedReader br;
		StringTokenizer st;
		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));//new FileReader("socdist2.in"));
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
