import java.util.*;
import java.io.*;
public class mazeTacToe {
	public static void dbg(Object obj) {
		if(testing) {
			System.out.println(obj);
		}
	}
	
	public static boolean testing = true;
	public static FastAF in = new FastAF();
	public static int n;
	public static int[] papers;
	public static char[] mat;
	public static char[] ttt = new char[9];
	public static int B;
	// 						  d, u, l, r
//	public static int[] dx = {1, -1, 0, 0};
//	public static int[] dy = {0, 0, -1, 1};
	public static int[] d1 = new int[4];
	public static boolean[] visited;
	public static ArrayList<int[]> wins = new ArrayList<int[]>();
	
	public static void main(String[] args) throws IOException{
		input();
		solve();
	}
	
	public static void dfs() throws IOException{
		// TODO Auto-generated method stub
//		dbg(v);
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(B);
		while(!q.isEmpty()) {
			int v = q.poll();
			visited[v] = true;
			if(mat[v] == 'O' || mat[v] == 'M') {
//				dbg("hihihh");
				dbg(papers[v]); 
				dbg(papers[v]/3 + "," + papers[v]%3);
				if(ttt[papers[v]] != 'O' || ttt[papers[v]] != 'M') {
					ttt[papers[v]] = mat[v];
					dbg(Arrays.toString(ttt));				
				}
				
				if(check()) {
					dbg("won");
//					wins.add(e)
//					return;
				}
				else {
					dbg("not won yet:(");
				}
			}
			
			boolean moved = false;
			for(int i = 0; i < 4; i++) {
				int dv = v + d1[i];
//				dbg(dv);
				if(dv < 0 || dv >= n*n || mat[dv] == '#' || visited[dv]) {
					continue;
				}
				moved = true;
				q.add(dv);
			}
			
			if(!moved) {
//				dbg(Arrays.toString(ttt));
//				return;
//				ttt = new char[11];
			}
		}
		
	}
	
	public static boolean check() throws IOException{
		if(ttt[0] == 'M' && ttt[4] == 'O' && ttt[8] == 'O') {
			return true;
		}
		else if(ttt[0] == 'O' && ttt[4] == 'O' && ttt[8] == 'M') {
			return true;
		}
		else if(ttt[0] == 'M' && ttt[1] == 'O' && ttt[2] == 'O') {
			return true;
		}
		else if(ttt[0] == 'O' && ttt[1] == 'O' && ttt[2] == 'M') {
			return true;
		}
		else if(ttt[3] == 'M' && ttt[4] == 'O' && ttt[5] == 'O') {
			return true;
		}
		else if(ttt[3] == 'O' && ttt[4] == 'O' && ttt[5] == 'M') {
			return true;
		}
		else if(ttt[6] == 'M' && ttt[7] == 'O' && ttt[8] == 'O') {
			return true;
		}
		else if(ttt[6] == 'O' && ttt[7] == 'O' && ttt[8] == 'M') {
			return true;
		}
		// 2nd half
		else if(ttt[2] == 'M' && ttt[4] == 'O' && ttt[6] == 'O') {
			return true;
		}
		else if(ttt[2] == 'O' && ttt[4] == 'O' && ttt[6] == 'M') {
			return true;
		}
		else if(ttt[0] == 'M' && ttt[3] == 'O' && ttt[6] == 'O') {
			return true;
		}
		else if(ttt[0] == 'O' && ttt[3] == 'O' && ttt[6] == 'M') {
			return true;
		}
		else if(ttt[1] == 'M' && ttt[4] == 'O' && ttt[7] == 'O') {
			return true;
		}
		else if(ttt[1] == 'O' && ttt[4] == 'O' && ttt[7] == 'M') {
			return true;
		}
		else if(ttt[2] == 'M' && ttt[5] == 'O' && ttt[8] == 'O') {
			return true;
		}
		else if(ttt[2] == 'O' && ttt[5] == 'O' && ttt[8] == 'M') {
			return true;
		}
		return false;
	}
	
	public static void solve() throws IOException{
		// TODO Auto-generated method stub
//		visited[B] = true;
		dfs();
//		Queue q = new LinkedList<>();
//		q.add(6);
//		int cnt = 0;
//		while(!q.isEmpty()) {
//			int a = (int) q.poll();
//			dbg(a);
//			q.add(a-1);
//			cnt++;
//			if(cnt == 5){
//				break;
//			}
//		}
	}

	public static void input() throws IOException{
		// TODO Auto-generated method stub
		n = in.nextInt();
		papers = new int[n*n];
		mat = new char[n*n];
		d1[0] = -n; d1[1] = n; d1[2] = -1; d1[3] = 1;
		visited = new boolean[n*n];
		for(int i = 0; i < n; i++) {
			char[] temp = in.nextLine().toCharArray();
			for(int j = 0; j < n*3; j+=3) {
				if(temp[j] == '#') {
					mat[i * n + j/3] = '#';
				}
				else if(temp[j] == '.') {
					mat[i * n + j/3] = '.';
				}
				else if(temp[j] == 'B') {
					mat[(B = i * n + j/3)] = 'B';
				}
				else {
					mat[i * n + j/3] = temp[j];
					papers[i * n + j/3] = (Character.getNumericValue(temp[j+1])-1) * 3 + Character.getNumericValue(temp[j+2])-1;
				}
			}
		}
		
		dbg(Arrays.toString(papers));
		dbg(Arrays.toString(mat));
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
		
		public int nextInt() throws IOException{
			int ret = 0;
			byte c = read();
			while(c <= ' ') {
				c = read();
			}
			boolean neg = (c == '-');
			if(neg) c = read();
			do {
				ret = ret * 10 + c - '0';
			} while((c = read()) <= '9' && c >= '0');
			
			if(neg) return -ret;
			return ret;
		}
		
		public double nextDouble() throws IOException{
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
 
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
 
            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }
 
            if (neg)
                return -ret;
            return ret;
        }
		
		public long nextLong() throws IOException{
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }
		
		public String nextLine() throws IOException{
			byte[] buf = new byte[64];
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
			return new String(buf, 0, cnt-1);
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
