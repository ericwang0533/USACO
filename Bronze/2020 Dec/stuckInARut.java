import java.util.*;
import java.awt.Point;
import java.io.*;
public class stuckInARut {
	public static FastReader in = new FastReader();
	public static int n = in.nextInt();
	public static String[] direct = new String[n];
	public static int[] x = new int[n], y = new int[n]; // maybe 2d array?
	//public static boolean[][] coords = new boolean[30001][30001];
	//public static ArrayList<Integer> xTrues = new ArrayList<Integer>();
	//public static ArrayList<Integer> yTrues = new ArrayList<Integer>();
	public static ArrayList<Point> points = new ArrayList<Point>();
	//public static ArrayList<ArrayList<Integer>> coords1 = new ArrayList<ArrayList<Integer>>();
	public static boolean[] dead = new boolean[n];
	public static int[] counter = new int[n];
	public static PrintWriter out;
	
	public static void main(String[] args) throws IOException{
		out = new PrintWriter(System.out);
		
		input();
		
		
		outerloop:
		while(true) {
			boolean game = true;
			simulate();
			for(int i = 0; i < n; i++) {
				if(!dead[i]) {
					game = false;
					break;
				}
			}
			
			if(game) {
				break outerloop;
			}
			//game = true;
			//out.println("test");
		}
//		for(int i = 0; i < 30000; i++) {
//			
//		}
		
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
				if(x[i] + 1 >= 1000) {
					//out.println(i + " reached infinity");
					boolean infinite = true;
					for(int j = 0; j < n; j++) {
						if(i == j || dead[j]) {
							continue;
						}
						
						if(direct[j].equals("N")) {
							// directions are not equal
							
//							if(x[j] <= x[i] || y[j] >= x[j]) {
//								
////							}
//							
							int toX = x[j] - x[i];
							int toY = Math.abs(y[i] - y[j]);
							if(toX <= 0 || toX <= toY ){//|| y[j] > y[i]) {
								// wont get stopped by this other cow
								//out.println("wont get stopped top one");
							}
							else {
								infinite = false;
								break;
								// it will get stopped
								//ans[i] = Math.min(ans[i], Math.abs(toX));
							}
						}
					}
					if(infinite) {
						counter[i] = -1000;
						dead[i] = true;
					}
					
				}
				else {
					if(points.contains(new Point(x[i]+1, y[i]))) {// && yTrues.contains(y[i])){//coords[x[i]+1][y[i]]) {
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
				if(y[i] + 1 >= 1000) {
					//out.println(i + " reached infinity");
					
					boolean infinite = true;
					for(int j = 0; j < n; j++) {
						if(i == j || dead[j]) {
							continue;
						}
						
						if(direct[j].equals("E")) {
							// directions are not equal
							
//							if(x[j] >= x[i] || y[j] <= y[i]) {
//								
////							}
//							
							int toX = Math.abs(x[i] - x[j]);
							int toY = y[j] - y[i];
							if(toY <= 0 || toY <= toX ){//|| x[j] > x[i]) {
								// wont get stopped by this other cow
								//out.println("wont get stopped bottom one");
							}
							else {
								infinite = false;
								break;
								// it will get stopped
								//ans[i] = Math.min(ans[i], Math.abs(toX));
							}
						}
					}
					if(infinite) {
						counter[i] = -1000;
						dead[i] = true;
					}
					
				}
				else {
					if(points.contains(new Point(x[i], y[i]+1))){//xTrues.contains(x[i]) && yTrues.contains(y[i]+1)){//coords[x[i]][y[i]+1]) {
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
			//if(!points.contains(new Point(toTrue[i][0], toTrue[i][1]))) {
				points.add(new Point(toTrue[i][0], toTrue[i][1]));
			//}
			
			
			//coords[toTrue[i][0]][toTrue[i][1]] = true;
		}
		
	}

	public static void input() {
		// TODO Auto-generated method stub
		for(int i = 0; i < n; i++) {
			direct[i] = in.next();
			x[i] = in.nextInt();
			y[i] = in.nextInt();			
			//xTrues.add(x[i]);
			//yTrues.add(y[i]);
			//coords[x[i]][y[i]] = true;
			points.add(new Point(x[i], y[i]));
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
