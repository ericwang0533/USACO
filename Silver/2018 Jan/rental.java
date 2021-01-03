import java.util.*;
import java.io.*;
public class rental {
	public static BufferedReader br;
	public static StringTokenizer st;
	public static FastReader in = new FastReader();
	public static PrintWriter out;
	
	public static int n = in.nextInt(), m = in.nextInt(), r = in.nextInt();
	public static Integer[] milk = new Integer[n];
	public static int[][] shop = new int[m][2];
	public static Integer[] rent = new Integer[r];
	public static int[][] money = new int[2][n];
	
	public static void main(String [] args) throws IOException{
		out = new PrintWriter(new BufferedWriter(new FileWriter("rental.out")));
		
		input();
		from_shop();
		
		int breakind = -1;
		int j = 0;
		long rentSum = 0;
		long shopSum = 0;
		for(int i = n-1; i >= 0; i--) {
			if(j >= r) {
				for(i = i-1;i >= 0; i--) {
//					out.println(shopSum);
					shopSum += money[0][i];
				}
				break;
			}
			
//			out.println(rent[j] + " " + money[0][i]);
			
			if(rent[j] < money[0][i]) {
				breakind = i;
				shopSum += money[0][i];
				for(i = i-1;i >= 0; i--) {
//					out.println(shopSum);
					shopSum += money[0][i];
				}
				break;
			}
			else {
				rentSum += rent[j];
//				shopSum += money[0][i];
			}
			j++;
		}
		
		
//		out.println("breakInd: " + breakind);
//		out.println("rentSum: " + rentSum);
//		out.println("shopSum: " + shopSum);
		
		out.println(shopSum + rentSum);
		out.close();
	}
	
	public static void from_shop() {
		// TODO Auto-generated method stub
		int ind = 0;
		int gals = 0;
		outer:
		for(int i = 0; i < n; i++) {
			int temp = milk[i];
			while(temp != 0) {
				if(gals + temp > shop[ind][0]) {
					money[0][i] += (shop[ind][0] - gals) * shop[ind][1];
					temp -= (shop[ind][0] - gals);
					ind++;
					gals = 0;
					
					if(ind >= m) {
						break outer;
					}
					
				}
				else {
					money[0][i] += (temp * shop[ind][1]);
					gals += temp;
					temp = 0;
				}
			}
			
		}
		
//		out.println(Arrays.toString(money[0]));
	}

	public static void input() {
		// TODO Auto-generated method stub
		for(int i = 0; i < n; i++) {
			milk[i] = in.nextInt();
		}
		Arrays.sort(milk, Collections.reverseOrder());
		for(int i = 0; i < m; i++) {
			shop[i][0] = in.nextInt();
			shop[i][1] = in.nextInt();
		}
		java.util.Arrays.sort(shop, new java.util.Comparator<int[]>() {
		    public int compare(int[] a, int[] b) {
		        return -Integer.compare(a[1], b[1]);
		    }
		});
		

		for(int i = 0; i < r; i++) {
			rent[i] = in.nextInt();
		}
		Arrays.sort(rent, Collections.reverseOrder());
		
//		out.println("milk");
//		out.println(Arrays.toString(milk));
//		out.println("shop");
//		for(int i = 0; i < m; i++) {
//			out.println(Arrays.toString(shop[i]));
//		}
//		out.println("rent");
//		out.println(Arrays.toString(rent));
	}
	
	static class FastReader{
		public FastReader() {
			try {
				br = new BufferedReader(new FileReader(new File("rental.in")));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
