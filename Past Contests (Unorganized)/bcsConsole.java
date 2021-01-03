import java.util.*;
import java.io.*;
public class bcsConsole {
	public static FastReader in = new FastReader();
	public static int n = in.nextInt(), k = in.nextInt();
	public static int[][] fig = new int[n][n];
	public static int[][][] frags = new int[k][n][n];
	public static PrintWriter out;
	
	public static void main(String[] args) throws IOException{
		out = new PrintWriter(System.out);//new BufferedWriter(new FileWriter("diamond.out")));
		
		input();
		
		frags(2, 0);
		
//		for(int i = 0; i < k; i++) {
//			for(int j = i+1; j < k; j++) {
//				//check the two frags
//				frags(i, j);
//			}
//		}
		
		out.close();
	}
	
	public static void frags(int i11, int j11) {
		// TODO Auto-generated method stub
		
		int[][] first = new int[n][n];
		int[][] second = new int[n][n];
		
		
		//move the i frag to the upper left corner
		//check if the frag can be moved to the left/top
		first = top_left(i11);
		second = top_left(j11);
		int[][] combo = first.clone();
		
		int first_xcounter = 0, second_xcounter = 0;
		int first_ycounter = 0, second_ycounter = 0;
		
		for(int i = n-1; i >= 0; i--) {
			int counter = 0;
			for(int j = n-1; j >= 0; j--) {
				if(first[i][j] == 1) {
					counter = j;
					first_xcounter = Math.max(first_xcounter, counter);
					break;
				}
			}
		}
		for(int i = n-1; i >= 0; i--) {
			int counter = 0;
			for(int j = n-1; j >= 0; j--) {
				if(second[i][j] == 1) {
					counter = j;
					second_xcounter = Math.max(second_xcounter, counter);
					break;
				}
			}
		}
		for(int i = n-1; i >= 0; i--) {
			int counter = 0;
			for(int j = n-1; j >= 0; j--) {
				if(first[j][i] == 1) {
					counter = j;
					first_ycounter = Math.max(first_ycounter, counter);
					break;
				}
			}
		}
		for(int i = n-1; i >= 0; i--) {
			int counter = 0;
			for(int j = n-1; j >= 0; j--) {
				if(second[j][i] == 1) {
					counter = j;
					second_ycounter = Math.max(second_ycounter, counter);
					break;
				}
			}
		}
		first_xcounter++; second_xcounter++; first_ycounter++; second_ycounter++;
//		System.out.println(first_xcounter);
//		System.out.println(second_xcounter);
//		System.out.println(first_ycounter);
//		System.out.println(second_ycounter);
		

		
		
//		for(int i1 = 0; i1 < n; i1++) {
//			System.out.println();
//			for(int j1 = 0; j1 < n; j1++) {
//				System.out.print(temp[i1][j1]);
//			}
//		}
		
		
	}

	public static int[][] top_left(int ind) {
		// TODO Auto-generated method stub
		
		int[][] shifted = frags[ind];
		
		outerloop:
		while(true) {
			// check if need to shift left
			for(int i = 0; i < n; i++) {
				if(shifted[i][0] == 1) {
					break outerloop;
				}
			}
			
			// administer the shift
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n-1; j++) {
					shifted[i][j] = shifted[i][j+1];
				}
				shifted[i][n-1] = 0;
			}
		}
		
		outerloop:
		while(true) {
			// check if need to shift up
			for(int i = 0; i < n; i++) {
				if(shifted[0][i] == 1) {
					break outerloop;
				}
			}
			
			//administer the shift
			for(int i = 0; i < n-1; i++) {
				for(int j = 0; j < n; j++) {
					shifted[i][j] = shifted[i+1][j];
				}
			}
			
			for(int i = 0; i < n; i++) {
				shifted[n-1][i] = 0;
			}
			
//			for(int i1 = 0; i1 < n; i1++) {
//				System.out.println();
//				for(int j1 = 0; j1 < n; j1++) {
//					System.out.print(shifted[i1][j1]);
//				}
//			}
		}
		
		return shifted;
	}

	public static void input() {
		// TODO Auto-generated method stub
		for(int i = 0; i < n; i++) {
			String line = in.nextLine();
			String[] splited = line.split("");
			for(int j = 0; j < n; j++) {
				fig[i][j] = splited[j].equals(".") ? 0: 1;
				//System.out.println("fig[i][j]: " + fig[i][j] + " | splited[j]: " + splited[j]);
			}
		}
		
		for(int i = 0; i < k; i++) {
			for(int j = 0; j < n; j++) {
				String line = in.nextLine();
				String[] splited = line.split("");
				for(int a = 0; a < n; a++) {
					frags[i][j][a] = splited[a].equals(".") ? 0: 1;
					//System.out.println("fig[i][j]: " + fig[i][j] + " | splited[j]: " + splited[j]);
				}
			}
		}
		
		//dbg
		System.out.println();
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print(fig[i][j]);
			}
			System.out.println();
		}
		
		for(int a = 0; a < k; a++) {
			System.out.println();
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					System.out.print(frags[a][i][j]);
				}
				System.out.println();
			}
		}
	}

	static class FastReader{
		BufferedReader br;
		StringTokenizer st;
		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));//new FileReader("diamond.in"));
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
