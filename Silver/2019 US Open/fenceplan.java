import java.util.*;
import java.awt.Point;
import java.io.*;
public class fenceplan {
	static void dbg(Object obj) {
		if(testing) {
			System.out.println(obj);
		}
	}
	
	public static boolean testing = true;
	public static FastAF in = new FastAF();
	public static int n, m;
	public static PrintWriter out;
	public static point[] pts;
	public static HashMap<Integer, moowork> hmap = new HashMap<>();
	public static long ans = Long.MAX_VALUE;
	public static SortedSet<Point> input = new TreeSet<Point>(new ptSort());
	
	public static void main(String[] args) throws IOException{
		out = new PrintWriter(new File("fenceplan.out"));
		input();
		solve();
		
		out.close();
	}
	
	static class ptSort implements Comparator<Point>{
		public int compare(Point o1, Point o2) {
			// TODO Auto-generated method stub
			if(o1.x == o2.x) {
				return o1.y - o2.y;
			}
			return o1.x - o2.x;
		}
		
	}
	
	public static void solve() throws IOException{
		// TODO Auto-generated method stub
		dsu bob = new dsu();
		for(int i = 0; i < m; i++) {
//			bob.unite(in.nextInt(), in.nextInt());
			input.add(new Point(in.nextInt(), in.nextInt()));
		}
		dbg(input);
		Iterator itr = input.iterator();
		while(itr.hasNext()) {
			Point p = (Point) itr.next();
			bob.unite(p.x, p.y);
		}
//		dbg(Arrays.toString(bob.parent));
//		dbg(Arrays.toString(bob.size));
		dbg(hmap);
		
		for(Map.Entry<Integer, moowork> set : hmap.entrySet()) {
			dbg(set.getKey());
			dbg(set.getValue());
			
			for(int x : set.getValue().moos) {
				dbg(x + ": " + pts[x]);
			}
			
			dbg("!: " + (set.getValue().rightTopx-set.getValue().leftBotx + set.getValue().rightTopy-set.getValue().leftBoty)*2);
//			ans = Math.min(ans, (set.getValue().rightTopx-set.getValue().leftBotx + set.getValue().rightTopy-set.getValue().leftBoty)*2);
		}
		
		out.println(ans);
	}

	public static void input() throws IOException {
		// TODO Auto-generated method stub
		n = in.nextInt(); m = in.nextInt();
		pts = new point[n+1];
		for(int i = 1; i <= n; i++) {
			pts[i] = new point(in.nextInt(), in.nextInt(), i);
		}
	}
	
	static class dsu{
		int[] parent;
		int[] size;
		
		public dsu() {
			parent = new int[n+1];
			size = new int[n+1];
			for(int i = 1; i < n+1; i++) {
				parent[i] = i;
				size[i] = 1;
			}
		}
		
		public int findRoot(int curr) {
			if(curr == parent[curr]) return curr;
			return parent[curr] = findRoot(parent[curr]);
		}
		
		public boolean unite(int a, int b) {
			int rootA = findRoot(a);
			int rootB = findRoot(b);
//			dbg("a: " + a + " | rA: " + rootA + " | sA: " + size[rootA]);
//			dbg("b: " + b + " | rB: " + rootB + " | sB: " + size[rootB]);
//			dbg("(" + a + ", " + b + ")");
//			dbg("rA: " + rootA);
//			dbg("rB: " + rootB);
//			dbg("sA: " + size[rootA]);
//			dbg("sB: " + size[rootB]);
			
			if(rootA == rootB) return true;
			if(size[rootA] > size[rootB]) {
				parent[rootB] = rootA;
				size[rootA] += size[rootB];
				if(hmap.containsKey(rootA)) {
					hmap.get(rootA).minMax(pts[b].x, pts[b].y);
//					hmap.get(rootA).minMax(pts[a].x, pts[a].y);
					hmap.get(rootA).moos.add(b);
//					hmap.get(rootA).moos.add(a);
				}
				else {
					hmap.put(rootA, new moowork(a, b, pts[a].x, pts[a].y, pts[b].x, pts[b].y));
				}
			}
			else {
				parent[rootA] = rootB;
				size[rootB] += size[rootA];
				
				if(hmap.containsKey(rootB)) {					
					hmap.get(rootB).minMax(pts[a].x, pts[a].y);
//					hmap.get(rootB).minMax(pts[b].x, pts[b].y);
					hmap.get(rootB).moos.add(a);
//					hmap.get(rootB).moos.add(b);
				}
				else {
					hmap.put(rootB, new moowork(a, b, pts[a].x, pts[a].y, pts[b].x, pts[b].y));
				}
			}
			
			
//			dbg(Arrays.toString(parent));
//			dbg(Arrays.toString(size));
//			dbg("");
			
			return false;
		}
	}
	
	static class moowork{
		public ArrayList<Integer> moos;
		public int leftBotx, leftBoty, rightTopx, rightTopy;
		public moowork(int ind1, int ind2, int x1, int y1, int x2, int y2) {
			moos = new ArrayList<Integer>();
			moos.add(ind1); moos.add(ind2);
			leftBotx = Math.min(x1, x2);
			leftBoty = Math.min(y1, y2);
			rightTopx = Math.max(x1, x2);
			rightTopy = Math.max(y1, y2);
		}
		
		public void minMax(int x, int y) {
//			dbg(x + "," + y);
			leftBotx = Math.min(leftBotx, x);
			leftBoty = Math.min(leftBoty, y);
			rightTopx = Math.max(rightTopx, x);
			rightTopy = Math.max(rightTopy, y);
		}
		
		public String toString() {
			return moos + " | (" + leftBotx + "," + leftBoty + ") | (" + rightTopx + "," + rightTopy + ")";
		}
	}
	
	static class point{
		public int x, y, ind;
		public point(int x, int y, int ind) {
			this.x = x;
			this.y = y;
			this.ind = ind;
		}
		
		public String toString() {
			return "("+x + "," +y + ")";
		}
	}

	static class FastAF{
		final private int bufferSize = 1 << 16;
		public DataInputStream din;
		public byte[] buffer;
		public int bufferPointer, bytesRead;
		
		public FastAF() {
			try {				
				din = new DataInputStream(new FileInputStream("fenceplan.in"));
//			din = new DataInputStream(System.in);
			}
			catch(FileNotFoundException e) {
				e.printStackTrace();
			}
			buffer = new byte[bufferSize];
			bufferPointer = bytesRead = 0;
		}
		
		public int nextInt() throws IOException{
			int ret = 0;
			byte c = read();
			while(c <= ' ') {
				c = read();
			}
			boolean neg = (c == '-');
			if(neg) c= read();
			do {
				ret = ret * 10 + c - '0';
			} while((c = read()) >= '0' && c <= '9');
			
			if(neg) return -ret;
			return ret;
		}
		
		public byte read() throws IOException{
			if(bufferPointer == bytesRead) fillBuffer();
			return buffer[bufferPointer++];
		}
		
		public void fillBuffer() throws IOException{
			bytesRead = din.read(buffer, bufferPointer = 0, bufferSize);
			if(bytesRead == -1) buffer[0] = -1;
		}
	}
}
