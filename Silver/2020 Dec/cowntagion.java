import java.util.*;
import java.io.*;
public class cowntagion {
	public static BufferedReader br;
	public static StringTokenizer st;
	public static FastReader in = new FastReader();
	public static PrintWriter out;
	public static int n = in.nextInt();
	public static int count = 0;
	public static Node[] nodes = new Node[n+1];
	public static Queue<Integer> q = new LinkedList<>();
	public static double log2 = Math.log(2);
//	public static ArrayList<Integer> q = new ArrayList<Integer>();
	
	public static void main(String[] args) throws IOException{
		out = new PrintWriter(System.out);
		
		for(int i = 1; i <= n; i++) {
			nodes[i] = new Node();
		}
		
		input();
		q.add(1);
		while(!q.isEmpty()) {
			
			
			solve(q.peek());
			q.poll();
		}
//		solve(1);//, 1);
		
		out.println(count);
		
		out.close();
	}
	
	public static void solve(int ind){//, int cows) {
		// TODO Auto-generated method stub
		
		
		
//		System.out.println("ind: " + ind + " | count: " + count);
		
		Node node = nodes[ind];
		node.infected = true;
		node.cows = 1;
		
//		int counter = 0;
//		boolean temp = false;
		for(int i = 0; i < node.edges.size(); i++) {
			if(!nodes[node.edges.get(i).destination].infected) {
//				temp = true;
//				counter++;
				continue;
			}
			node.edges.remove(i);
		}
		
		if(node.edges.isEmpty()) {
			return;
		}
//		if(!temp) {
//			return;
//		}
		
		count += (int) (Math.log(node.edges.size()) / log2 + 1);
		
//		while(node.cows <= node.edges.size()) {
//			node.cows *= 2;
//			count++;
//		}
//		System.out.println("cows: " + node.cows + " | count: " + count);
		
		for(int i = 0; i < node.edges.size(); i++) {
			if(!nodes[node.edges.get(i).destination].infected) {
				count++;
//				solve(node.edges.get(i).destination);//, 1);
//				System.out.println("adding: " + node.edges.get(i).destination);
				q.add(node.edges.get(i).destination);
			}
		}
		
	}

	public static void input() {
		// TODO Auto-generated method stub
		for(int i = 0; i < n-1; i++) {
			int first = in.nextInt(); int second = in.nextInt();
			nodes[first].edges.add(new Edge(second));
			nodes[second].edges.add(new Edge(first));
		}
		
		// dbg
//		for(int i = 1; i <= n; i++) {
//			System.out.println(i);
//			for(int j = 0; j < nodes[i].edges.size(); j++) {
//				System.out.println("destination: " + nodes[i].edges.get(j).destination);
//			}
//		}
	}

	static class Edge{
		int destination;
		public Edge(int destination) {
			this.destination = destination;
		}
	}
	
	static class Node{
		boolean infected;
		int cows;
		List<Edge> edges = new ArrayList<Edge>();
		
		public Node() {
			cows = 0;
			infected = false;
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
