import java.util.*;
import java.awt.Point;
import java.io.*;
public class reactangular_pasture {
	static int[][] sums;
	 
    static int getSum(int fromX, int toX, int fromY, int toY) {
        return sums[toX][toY] - sums[fromX - 1][toY] - sums[toX][fromY - 1] + sums[fromX - 1][fromY - 1];
    }
 
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] xs = new int[n];
        int[] ys = new int[n];
        Integer[] cows = new Integer[n];
        for (int j = 0; j < n; j++) {
            xs[j] = in.nextInt();
            ys[j] = in.nextInt();
            cows[j] = j;
        }
        
        //dbg
        System.out.println(Arrays.toString(xs));
        System.out.println(Arrays.toString(ys));
        System.out.println(Arrays.toString(cows));
        System.out.println();
        
        Arrays.sort(cows, Comparator.comparingInt(j -> xs[j]));
        System.out.println(Arrays.toString(cows));
        
        for (int x = 1; x <= n; x++) {
            xs[cows[x - 1]] = x;
        }
        System.out.println(Arrays.toString(xs));
        
        Arrays.sort(cows, Comparator.comparingInt(j -> ys[j]));
        System.out.println(Arrays.toString(cows));
        for (int y = 1; y <= n; y++) {
            ys[cows[y - 1]] = y;
        }
        System.out.println(Arrays.toString(ys));
        
        sums = new int[n + 1][n + 1];
        for (int j = 0; j < n; j++) {
            sums[xs[j]][ys[j]]++;
        }
        for (int x = 0; x <= n; x++) {
            for (int y = 0; y <= n; y++) {
                if (x > 0) {
                    sums[x][y] += sums[x - 1][y];
                }
                if (y > 0) {
                    sums[x][y] += sums[x][y - 1];
                }
                if (x > 0 && y > 0) {
                    sums[x][y] -= sums[x - 1][y - 1];
                }
            }
        }
        long answer = n + 1;
        for (int j = 0; j < n; j++) {
            for (int k = j + 1; k < n; k++) {
                answer += getSum(Math.min(xs[j], xs[k]), Math.max(xs[j], xs[k]), 1, Math.min(ys[j], ys[k]))
                        * getSum(Math.min(xs[j], xs[k]), Math.max(xs[j], xs[k]), Math.max(ys[j], ys[k]), n);
            }
        }
        System.out.println(answer);
    }
}
	
//	public static BufferedReader br;
//	public static StringTokenizer st;
//	public static FastReader in = new FastReader();
//	public static PrintWriter out;
//	
//	public static int n = in.nextInt();
//	public static Point[] coords = new Point[n];
//	
//	public static void main(String[] args) throws IOException{
//		out = new PrintWriter(System.out);
//		
//		input();
//		
//		out.close();
//	}
//	
//	public static void input() {
//		// TODO Auto-generated method stub
//		for(int i = 0; i < n; i++) {
//			coords[i] = new Point(in.nextInt(), in.nextInt());
////			System.out.println(coords[i]);
//		}
//	}
//
//	static class FastReader{
//		public FastReader() {
//			br = new BufferedReader(new InputStreamReader(System.in));
//		}
//		String next() {
//			while(st == null || !st.hasMoreElements()) {
//				try {
//					st = new StringTokenizer(br.readLine());	
//				}
//				catch(IOException e) {
//					e.printStackTrace();
//				}
//			}
//			return st.nextToken();
//		}
//		int nextInt() {
//			return Integer.parseInt(next());
//		}
//		double nextDouble() {
//			return Double.parseDouble(next());
//		}
//		long nextLong() {
//			return Long.parseLong(next());
//		}
//		String nextLine() {
//			String str = "";
//			try {
//				str = br.readLine();
//			}
//			catch(IOException e) {
//				e.printStackTrace();
//			}
//			return str;
//		}
//	}
//}
