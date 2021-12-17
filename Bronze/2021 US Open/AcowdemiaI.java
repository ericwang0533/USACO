import java.util.*;
import java.io.*;
public class AcowdemiaI {
	static void dbg(Object obj) {
		if(debug) {
			System.out.println(obj);
		}
	}
	
	public static boolean debug = false;
	public static FastAF in = new FastAF();
	public static int n, l, hind; 	// n, l, hind = h-index
	public static int[] arr;		// arr stores Bessie's N papers
	
	public static void main(String[] args) throws IOException{
		input();
		solve();
	}
	
	public static void solve() throws IOException {
		// TODO Auto-generated method stub
		
		// if hind == n then Bessie already maxed her hind
		// if l == 0 Bessie cannot increase her hind
		if(hind == n || l == 0) {
			System.out.println(hind);
			System.exit(0);
		}
//		dbg(n-1-hind);
//		dbg(rounds);
//		break;
		
		// n-hind is # of papers Bessie has that isnt contributing to her hind
		// if l > n-hind, we have enough "extra citations" to cover all her uncontributing papers and more
		if(l > n-hind) {
			for(int i = 0; i < Math.min(n, l); i++) {
				arr[i]++;
			}
//			hind++;
		}
		// else l <= n-hind, we dont have enough "extra citations" to cover all her uncontributing papers so
		// we start from the papers closest to helping her hind and go backwards
		else {
//			dbg("hi");
			for(int i = n-hind-1; i > n-hind-1-l; i--) {
				arr[i]++;
			}
//			dbg(Arrays.toString(arr));
//			hind++;
		}
		
		// recalculate hind w/ the 2 pointer
		Arrays.sort(arr);
//		dbg(Arrays.toString(arr));
		for(int i = 0, j = n; i < n; i++, j--) {
			if(arr[i] >= j) {
				hind = j;
				break;
			}
		}
		System.out.println(hind);
	}

	public static void input() throws IOException {
		// TODO Auto-generated method stub
		n = in.nextInt(); l = in.nextInt();
		arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}
		Arrays.sort(arr);//, Collections.reverseOrder());
//		dbg(Arrays.toString(arr));
		
		// calculate initial hind with a 2 pointer
		for(int i = 0, j = n; i < n; i++, j--) {
			if(arr[i] >= j) {
				hind = j;
				break;
			}
		}
//		dbg(hind);
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
		
		public byte read() throws IOException {
			if(bytesRead == bufferPointer) fillBuffer();
			return buffer[bufferPointer++];
		}
		
		public void fillBuffer() throws IOException {
			bytesRead = din.read(buffer, bufferPointer = 0, bufferSize);
			if(bytesRead == -1) buffer[0] = -1;
		}
	}
}
