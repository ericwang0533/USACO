import java.util.*;
import java.io.*;
public class doYouKnowYourABCsUSOPEN2021 {
	public static void dbg(Object obj) {
		if(testing) {
			System.out.println(obj);
		}
	}
	
	public static boolean testing = true;
	public static FastAF in = new FastAF();
	public static int t;
	public static int n;
	public static ArrayList<Integer> arr;
	
	public static void main(String[] args) throws IOException{
		input();
		solve();
	}
	
	private static void solve() throws IOException{
		// TODO Auto-generated method stub
//		dbg(n + " | " + arr);
		if(n == 7) {
			int c;
			if(arr.contains(c = (arr.get(0) + arr.get(1))) && arr.contains(arr.get(6) - arr.get(0)) && arr.contains(arr.get(6) - arr.get(1)) && arr.contains(arr.get(6) - c) && arr.contains(arr.get(0) + arr.get(1) + c)) {
				System.out.println(1);
				return;
			}
			System.out.println(0);
			return;
		}
		else {
			
		}
	}

	public static void input() throws IOException{
		// TODO Auto-generated method stub
		t = in.nextInt();
		for(int i = 0; i < t; i++) {
			n = in.nextInt();
			arr = new ArrayList<Integer>(n);
			for(int j = 0; j < n; j++) {
				arr.add(in.nextInt());
			}
			Collections.sort(arr);
			solve();
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
