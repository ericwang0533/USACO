import java.util.*;
import java.io.*;
public class AcowemiaII {
	static void dbg(Object obj) {
		if(testing) {
			System.out.println(obj);
		}
	}
	
	public static boolean testing = false;
	public static FastAF in = new FastAF();
	public static int k, n; //k, n
	// hashmap to store order of lab members
	public static Map<String, Integer> map = new HashMap<String, Integer>(); 
	// answer in their output format (n by n)
	public static char[][] ans;
	
	public static void main(String[] args) throws IOException{
		input();
		
		// output answer
		for(int i = 0; i < n; i++) {
			System.out.println(Arrays.toString(ans[i]).replaceAll("\\[|\\]|\\,| ", ""));
		}
	}
	
	public static void input() throws IOException {
		// TODO Auto-generated method stub
		k = in.nextInt(); n = in.nextInt();
//		dbg(k); dbg(n);
		
		// store lab members in proper order
		String[] init = in.nextLine().split(" ");
		for(int i = 0; i < n; i++) {
			// init[i] is the lab member name, i is their order from 0 to n-1
			map.put(init[i], i);
		}
//		dbg(map);
		
		// initialize ans and fill it with ?s except for where it should be 'B' at (i, i)
		ans = new char[n][n];
		for(int i = 0; i < n; i++) {
			Arrays.fill(ans[i], '?');
			ans[i][i] = 'B';
		}
//		dbg(Arrays.deepToString(ans));
		
		// loop through the k publications and solve()
		for(int i = 0; i < k; i++) {
			solve(in.nextLine());
		}
	}

	// takes in the line (lab member names in a line w/ spaces)
	public static void solve(String line) throws IOException {
		// TODO Auto-generated method stub
		// array of lab member names
		String[] arr = line.split(" ");
		
		// if its not alphabetical at one point, then everything after that point is senior to the ones before
		// loop through from 0 to n-1
		for(int i = 0; i < n-1; i++) {
			boolean abc = true;
			dbg(i);
			// loop from i+1 to n
			for(int j = i+1; j < n; j++) {
				dbg(arr[j-1] + " | " + arr[j]);
				// check if everything is still alphabetical
				if (arr[j-1].compareTo(arr[j]) > 0) {
                    abc = false;
                    dbg("false");
                }
				// if it isnt, then add this one pair as junior/senior
                if (!abc) {
                    int a = map.get(arr[i]);
                    int b = map.get(arr[j]);
                    dbg(a + "," + b);
                    ans[a][b] = '0';
                    ans[b][a] = '1';
                }
			}	
			dbg(Arrays.deepToString(ans));
			dbg("");
		}
		
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
			byte[] buf = new byte[100*100];
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
			if(neg) c = read();
			do {
				ret = ret * 10 + c - '0';
			} while((c = read()) <= '9' && c >= '0');
			
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
