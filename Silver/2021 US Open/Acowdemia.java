import java.util.*;
import java.io.*;
public class Acowdemia {
	public static void dbg(Object obj) {
		if(testing) {
			System.out.println(obj);
		}
	}
	
	public static boolean testing = false;
	public static FastAF in = new FastAF();
	public static int n, k, l;
	public static Integer[] arr;
	public static int hind = 0;
	
	public static void main(String[] args) throws IOException{
		input();
		solve();
	}
	
	private static void solve() throws IOException{
		// TODO Auto-generated method stub
		while(true) {
			if(hind == n) {
				break;
			}
			int rounds = hind+1 - arr[n-1-hind];
			if(k - rounds < 0) {
				break;
			}
			k -= rounds;
//			dbg(n-1-hind);
//			dbg(rounds);
//			break;
			if(l > n-hind) {
				for(int i = 0; i < Math.min(n, l); i++) {
					arr[i] += rounds;
				}
				hind++;
			}
			else {
				for(int i = n-hind-1; i > n-hind-1-l; i--) {
					arr[i] += rounds;
				}
				hind++;
			}
		}
		System.out.println(hind);
	}

	public static void input() throws IOException{
		// TODO Auto-generated method stub
		n = in.nextInt(); k = in.nextInt(); l = in.nextInt();
		arr = new Integer[n];
		for(int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}
		Arrays.sort(arr);//, Collections.reverseOrder());
//		dbg(Arrays.toString(arr));
		
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
