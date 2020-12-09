import java.util.*;
import java.io.*;

public class lineupConsole {
	public static FastReader in = new FastReader();
	//public static PrintWriter out;
	public static int n = in.nextInt();
	public static int[][] mat = {{0, 1, 2, 3, 4, 5, 6, 7},
								 {9, 9, 9, 9, 9, 9, 9, 9}, 
								 {9, 9, 9, 9, 9, 9, 9, 9}};
	public static ArrayList<String> cows = new ArrayList<>(Arrays.asList("Beatrice", "Belinda", "Bella", "Bessie", "Betsy", "Blue", "Buttercup", "Sue"));
	public static ArrayList<Integer> arr = new ArrayList<>();
	public static ArrayList<Integer> brr = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7));
	
	public static void main(String[] args) throws IOException{
		//out = new PrintWriter(new BufferedWriter(new FileWriter("lineup.out")));
		
		for(int i = 0; i < n; i++) {
			String first = in.next();
			for(int j = 0; j < 4; j++) {
				String temp = in.next();
			}
			String second = in.next();
			int firstIndex = cows.indexOf(first);
			int secondIndex = cows.indexOf(second);
			if(mat[1][firstIndex] != 9) {
				mat[2][firstIndex] = secondIndex;
			}
			else {
				mat[1][firstIndex] = secondIndex;
			}
			if(mat[1][secondIndex] != 9) {
				mat[2][secondIndex] = firstIndex;
			}
			else {
				mat[1][secondIndex] = firstIndex;
			}
		}
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 8; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
		int curr = -1;
		boolean new1 = false;
		for(int i = 0; i < 8; i++) {
			if(mat[2][i] == 9) {
				arr.add(i);
				brr.remove(i);
				curr++;
				if(mat[1][i] != 9) {
					arr.add(mat[1][i]);
					brr.remove(brr.indexOf(mat[1][i]));
					curr++;
					if(mat[2][arr.get(1)] != 9) {
						new1 = true;
					}
				}
				break;
			}
		}
		
		while(arr.size() < 8) {
			System.out.println(arr.size());
			if(new1) {
				if(mat[2][arr.get(curr)] != arr.get(curr - 1)) {
					arr.add(mat[2][arr.get(curr)]);
					brr.remove(brr.indexOf(mat[2][arr.get(curr)]));
					curr++;
				}
				else {
					arr.add(mat[1][arr.get(curr)]);
					brr.remove(brr.indexOf(mat[1][arr.get(curr)]));
					curr++;
				}
				
				if(mat[2][arr.get(curr)] == 9) {
					new1 = false;
				}
				else {
					new1 = true;
				}
			}
			else {
				for(int i = 0; i < brr.size(); i++) {
					if(mat[2][brr.get(i)] == 9) {
						arr.add(brr.get(i));
						int temp = brr.get(i);
						brr.remove(i);
						curr++;
						if(mat[1][temp] != 9) {
							arr.add(mat[1][temp]);
							brr.remove(brr.indexOf(mat[1][temp]));
							curr++;
							
							if(mat[2][arr.get(curr)] != 9) {
								new1 = true;
							}
						}
						break;
					}
				}
				//arr.add(9);
			}
		}
		
		for(int i = 0; i < 8; i++) {
			System.out.println(cows.get(arr.get(i)));
			//System.out.print(arr.get(i) + " ");
		}
		/*System.out.println();
		for(int i = 0; i < brr.size(); i++) {
			System.out.print(brr.get(i) + " ");
		}*/
		//System.out.println();
		//System.out.println();
		
		/*for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 8; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}*/
		
		
		//out.close();
	}
	
	static class FastReader {
		BufferedReader br;
		StringTokenizer st;
		public FastReader() {
			//try {
				br = new BufferedReader(new InputStreamReader(System.in));
			//}
			//catch(FileNotFoundException e) {
				//e.printStackTrace();
			//}
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
