import java.util.*;
import java.io.*;
public class doYouKnowYourABCs {
	public static FastReader in = new FastReader();
	//public static int[] arr = {in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt()};
	public static ArrayList<Integer> arr = new ArrayList<Integer>();
	public static int[] ans = new int[3];
	public static PrintWriter out;
	
	public static void main(String[] args) throws IOException{
		out = new PrintWriter(System.out);
		
		input();
		
		outerloop:
		for(int i = 0; i < 7; i++) {
			for(int j = i+1; j < 7; j++) {
				for(int a = j+1; a < 7; a++) {
					if(check(i, j, a)) {
						
						out.println();
						break outerloop;
					}
				}
			}
		}
		
		out.close();
	}
	
	public static void input() {
		// TODO Auto-generated method stub
		for(int i = 0; i < 7; i++) {
			arr.add(in.nextInt());
		}
	}

	public static boolean check(int i1, int j1, int a1) {
		// TODO Auto-generated method stub
		// check for i1 + j1, i1 + a1, and j1 + a1
		// check for i1 + j1 + a1
		
		if(arr.contains(arr.get(i1) + arr.get(j1)) && arr.contains(arr.get(j1) + arr.get(a1)) && arr.contains(arr.get(i1) + arr.get(a1)) && arr.contains(arr.get(i1) + arr.get(j1) + arr.get(a1))) {
			ans[0] = arr.get(i1);
			ans[1] = arr.get(j1);
			ans[2] = arr.get(a1);
			Arrays.sort(ans);
			out.print(ans[0] + " " + ans[1] + " " + ans[2]);// + " ");
			//out.println();
			return true;
		}
		
		return false;
	}

	static class FastReader{
		BufferedReader br;
		StringTokenizer st;
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
