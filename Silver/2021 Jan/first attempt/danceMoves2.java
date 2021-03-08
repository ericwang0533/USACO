// jan 24
import java.util.*;
import java.io.*;
public class danceMoves2 {
	public static BufferedReader br;
	public static StringTokenizer st;
	public static FastReader in = new FastReader();
//	public static PrintWriter out = new PrintWriter(System.out);
	public static int n = in.nextInt(), k = in.nextInt();
	public static moove[] moves = new moove[k];
	public static ArrayList<cow> cows = new ArrayList<cow>(n);
	public static cow[] cowmaster = new cow[n];
	public static ArrayList<cow> master;
	
	public static void main(String[] args) throws IOException{
		input();
		simulate();
		calculate();
		for(int i = 0; i < n; i++) {
			System.out.println(cowmaster[i].visited.size());
		}
//		cows.forEach(o -> System.out.println(o.num + ": " + o.visited.size() + " " + o.visited));
//		System.out.println(Arrays.toString(cowmaster));
	}
	
	public static void calculate() {
		// TODO Auto-generated method stub
		for(int j = 0; j < n; j++) {
			for(int i = 0; i < n; i++) {
				cows.get(i).visited.addAll(cowmaster[i].visited);
			}			
		}
	}

	public static void simulate() {
		// TODO Auto-generated method stub
		int counter = 0;
		while(counter != k) {
//			counter%=k;
			Collections.swap(cows, moves[counter].x-1, moves[counter].y-1);
			if(!cows.get(moves[counter].x-1).visited.contains(moves[counter].x-1)) {
				cows.get(moves[counter].x-1).visited.add(moves[counter].x-1);
//				cows.get(moves[counter].x-1).count++;
			}
			if(!cows.get(moves[counter].y-1).visited.contains(moves[counter].y-1)) {
				cows.get(moves[counter].y-1).visited.add(moves[counter].y-1);
//				cows.get(moves[counter].y-1).count++;
			}
			
//			System.out.println(Arrays.toString(cows.toArray()));
			if(master.equals(cows)) {
				return;
			}
			
			counter++;
		}
	}

	private static void input() {
		// TODO Auto-generated method stub
		for(int i = 0; i < k; i++) {
			moves[i] = new moove(in.nextInt(), in.nextInt());
		}
//		System.out.println(Arrays.toString(moves));
		
		for(int i = 1; i <= n; i++) {
			cow temp = new cow(i);
			cows.add(temp);
			cowmaster[i-1] = temp;
		}
		master = (ArrayList<cow>) cows.clone();
	}
	
	static class cow{
		public Set<Integer> visited;
		public int count;
		public int num;
		public cow(int num) {
			this.num = num;
			count = 1;
			visited = new HashSet<Integer>(Arrays.asList(num-1));
		}
		public String toString() {
			return this.num + " " + count + " " + visited;
		}
	}
	
	static class moove{
		public int x;
		public int y;
		public moove(int x, int y) {
			this.x = x;
			this.y = y;
		}
		public String toString() {
			return this.x + " " + this.y;
		}
	}

	static class FastReader{
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
