import java.util.*;
import java.io.*;
public class AcowdemiaIII {
	static void dbg(Object obj) {
		if(testing) {
			System.out.println(obj);
		}
	}
	
	public static boolean testing = false;
	public static FastAF in = new FastAF();
	public static int n, m; // n, m
	public static char[][] mat; // the "board" or field they give us
	// a set of our friends (so we don't store dups)
	public static Set<Integer> set = new HashSet<Integer>();
	
	public static void main(String[] args) throws IOException{
		input();
		solve();
	}
	
	public static void solve() throws IOException {
		// TODO Auto-generated method stub
		
		// loop through every point, and check if its G (grass, can make friends)
		// then check immediate adjacent cows, if theres two on opposite sides then they are first priority for friends
		// opposite side cows can only be friends at that G, but other 90dg cows can be friends at another G
		// takes the 2d pts into 1d compression then does it one more time b4 inserting into the Set
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(mat[i][j] == 'G') {
					// first check opposites
					// check above and below (i-1) and (i+1)
					if(i != 0 && i+1 != n && mat[i-1][j] == 'C' && mat[i+1][j] == 'C') {
//						set.add(i * m + j);
						dbg("(" + i + "," + j + ")");
						dbg(1);
						int first = (i-1) * m + j;
						int second = (i+1) * m + j;
						int comp = Math.min(first, second) * (n*m) + Math.max(first, second);
//						int comp = (i-1) * m + j;
//						comp *= n*m;
//						comp += (i+1) * m + j;
						set.add(comp);
						dbg(comp);
					}
					// check left and right (j-1) and (j+1)
					else if(j != 0 && j+1 != m && mat[i][j-1] == 'C' && mat[i][j+1] == 'C') {
//						set.add(i * m + j);
						dbg("(" + i + "," + j + ")");
						dbg(2);
						int first = (i) * m + j-1;
						int second = (i) * m + j+1;
						int comp = Math.min(first, second) * (n*m) + Math.max(first, second);
//						int comp = (i) * m + j-1;
//						comp *= n*m;
//						comp += (i) * m + j+1;
						set.add(comp);
						dbg(comp);
					}
					// now check the other 4 90s
					else if(i != 0 && j != 0 && mat[i-1][j] == 'C' && mat[i][j-1] == 'C') {
//						set.add(i * m + j);
						dbg("(" + i + "," + j + ")");
						dbg(3);
						int first = (i-1) * m + j;
						int second = (i) * m + j-1;
						int comp = Math.min(first, second) * (n*m) + Math.max(first, second);
//						int comp = (i-1) * m + j;
//						comp *= n*m;
//						comp += (i) * m + j-1;
						set.add(comp);
						dbg(comp);
					}
					else if(i != 0 && j+1 != m && mat[i-1][j] == 'C' && mat[i][j+1] == 'C') {						
//						set.add(i * m + j);
						dbg(4);
						dbg("(" + i + "," + j + ")");
						int first = (i-1) * m + j;
						int second = (i) * m + j+1;
						int comp = Math.min(first, second) * (n*m) + Math.max(first, second);
//						int comp = (i-1) * m + j;
//						comp *= n*m;
//						comp += (i) * m + j+1;
						set.add(comp);
						dbg(comp);
					}
					else if(i+1 != n && j+1 != m && mat[i+1][j] == 'C' && mat[i][j+1] == 'C') {
//						set.add(i * m + j);		
						dbg("(" + i + "," + j + ")");
						dbg(5);
						int first = (i+1) * m + j;
						int second = (i) * m + j+1;
						int comp = Math.min(first, second) * (n*m) + Math.max(first, second);
//						int comp = (i+1) * m + j;
//						comp *= n*m;
//						comp += (i) * m + j+1;
						set.add(comp);
						dbg(comp);
					}
					else if(i+1 != n && j != 0 && mat[i+1][j] == 'C' && mat[i][j-1] == 'C') {					
//						set.add(i * m + j);		
						dbg("(" + i + "," + j + ")");
						dbg(6);
						int first = (i+1) * m + j;
						int second = (i) * m + j-1;
						int comp = Math.min(first, second) * (n*m) + Math.max(first, second);
//						int comp = (i+1) * m + j;
//						comp *= n*m;
//						comp += (i) * m + j-1;
						set.add(comp);
						dbg(comp);
					}
				}
			}
		}
		// output answer
		System.out.println(set.size());
	}
	

	public static void input() throws IOException {
		// TODO Auto-generated method stub
		n = in.nextInt(); m = in.nextInt();
		dbg(n); dbg(m);
		// init mat and store the chars
		mat = new char[n][m];
		for(int i = 0; i < n; i++) {
			mat[i] = in.nextLine().toCharArray();
		}
		dbg(Arrays.deepToString(mat));
	}

	static class FastAF{
		final private int bufferSize = 1 << 16;
		public DataInputStream din;
		public byte[] buffer;
		public int bufferPointer, bytesRead;
		
		public FastAF() {
			din = new DataInputStream(System.in);
			buffer = new byte[bufferSize];
			bufferPointer = bytesRead = 0;
		}
		
		public String nextLine() throws IOException{
			byte[] buf = new byte[1000];
			int cnt = 0, c;
			while((c = read()) != -1) {
				if(c == '\n') {
					if(cnt != 0) {
						break;
					}
					else {
						continue;
					}
				}
				buf[cnt++] = (byte) c;
			}
			return new String(buf, 0, cnt);
		}
		
		public int nextInt() throws IOException{
			int ret = 0;
			byte c = read();
			while(c <= ' ') {
				c = read();
			}
			boolean neg = (c == '-');
			if(neg) c =read();
			do {
				ret = ret * 10 + c - '0';
			} while((c = read()) <= '9' && c >= '0');
			if(neg) return -ret;
			return ret;
		}
		
		public byte read() throws IOException{
			if(bytesRead == bufferPointer) fillBuffer();
			return buffer[bufferPointer++];
		}
		
		public void fillBuffer() throws IOException{
			bytesRead = din.read(buffer, bufferPointer = 0, bufferSize);
			if(bytesRead == -1) buffer[0] = -1;
		}
	}
}
