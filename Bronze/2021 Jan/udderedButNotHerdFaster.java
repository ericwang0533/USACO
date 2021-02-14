import java.util.*;
import java.util.stream.Collectors;
import java.io.*;
public class udderedButNotHerdFaster {
	public static BufferedReader br;
	public static StringTokenizer st;
	public static FastReader in = new FastReader();
	
	public static void main(String[] args) {
		ArrayList<Character> cowphabet = new ArrayList<>(in.nextLine().chars().mapToObj(e -> (char) e).collect(Collectors.toList()));    
		
		char[] hum = in.nextLine().toCharArray();
		
		int counter = 1;
		for(int i = 1; i < hum.length; i++) {
			char curr = hum[i];	// current character
			char prev = hum[i-1];	// previous character
			if(cowphabet.indexOf(curr) <= cowphabet.indexOf(prev)) {
				// if the index of the current character is less than the index of the previous character
				counter++;
			}
		}
		
		System.out.println(counter);
	}
	
	static class FastReader{
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
