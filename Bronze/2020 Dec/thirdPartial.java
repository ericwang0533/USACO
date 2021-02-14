import java.util.*;
import java.io.*;
public class thirdPartial {
	public static FastReader in = new FastReader();
	public static int n = in.nextInt();
	public static String[] direct = new String[n];
	public static int[] x = new int[n], y = new int[n]; // maybe 2d array?
	public static boolean[][] coords = new boolean[30001][30001];
	public static boolean[] dead = new boolean[n];
	public static int[] counter = new int[n];
	public static PrintWriter out;
	
	public static void main(String[] args) throws IOException{
		out = new PrintWriter(System.out);
		
		input();
		for(int i = 0; i < 30000; i++) {
			simulate();
		}
		
//		for(int i = 1; i < 101; i++) {
//			for(int j = 1; j < 101; j++) {
//				out.print(coords[i][j] + " ");
//			}
//			out.println();
//		}
		for(int i = 0; i < n; i++) {
			if(counter[i] != -1000) {
				counter[i]++;
				out.println(counter[i]);
			}
			else {
				out.println("Infinity");
			}
		}
		out.close();
	}
	
	public static void simulate() {
		// TODO Auto-generated method stub
		//dbg
//		for(int i = 0; i < 101; i++) {
//			for(int j = 0; j < 101; j++) {
//				out.print(coords[i][j]);
//			}
//			out.println();
//		}
		
//		for(int i = 0; i < n; i++) {
//			for(int j = 0; j < ) {
//				
//			}
//		}
		
		int[][] toTrue = new int[n][2];
		int toTruecounter = 0;
		
		for(int i = 0; i < n; i++) {
			if(direct[i].equals("E") && !dead[i]) {
				//east
				if(x[i] + 1 >= 30001) {
					//out.println(i + " reached infinity");
					counter[i] = -1000;
					dead[i] = true;
				}
				else {
					if(coords[x[i]+1][y[i]]) {
						// cow needs to stop
						//out.println("cow is dead east");
						//counter[i] = 1000;
						dead[i] = true;
					}
					else {
						x[i]++;
					//	out.println(i + " " + x[i]);
						toTrue[toTruecounter][0] = x[i];
						toTrue[toTruecounter][1] = y[i];
						toTruecounter++;
						//coords[x[i]][y[i]] = true;
						counter[i]++;
					}
				}
			}
			else if(direct[i].equals("N") && !dead[i]){
				//north
				if(y[i] + 1 >= 30001) {
					//out.println(i + " reached infinity");
					counter[i] = -1000;
					dead[i] = true;
				}
				else {
					if(coords[x[i]][y[i]+1]) {
						// cow needs to stop
						//out.println("cow is dead north");
						//counter[i] = 1000;
						//out.println("TESTE" + i);
						dead[i] = true;
					}
					else {
						y[i]++;
						//out.println(i + " " + y[i]);
						toTrue[toTruecounter][0] = x[i];
						toTrue[toTruecounter][1] = y[i];
						toTruecounter++;
						//coords[x[i]][y[i]] = true;
						counter[i]++;
					}
				}
			}
			else {
				//out.println("?");
			}
		}
		
		for(int i = 0; i < toTruecounter; i++) {
			coords[toTrue[i][0]][toTrue[i][1]] = true;
		}
		
	}

	public static void input() {
		// TODO Auto-generated method stub
		for(int i = 0; i < n; i++) {
			direct[i] = in.next();
			x[i] = in.nextInt();
			y[i] = in.nextInt();			
			coords[x[i]][y[i]] = true;
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
