import java.util.*;
import java.io.*;
public class socdist1 {
	public static FastReader in = new FastReader();
	public static int n = in.nextInt();
	public static String line = in.nextLine();
	public static String copy = line;
	public static int ans = 0;
	public static int biggestgap = 0, biggap = 0, start = 0, end = 0, startbiggestgap = 0, startbiggap = 0;
	public static boolean startB = false;
	public static PrintWriter out;
	
	
	public static void main(String[] args) throws IOException{
		out = new PrintWriter(new FileWriter("socdist1.out"));
		
		//10001001000010
		
		int counter = 0;
		for(int i = 0; i < n; i++) {
			//System.out.println(startB);
			if((i == 0 || startB) && line.charAt(i) == '0') {
				startB = true;
				//System.out.println(startB);
				start++;
			}
			
			if(line.charAt(i) == '0') {
				counter++;
			}
			else {
				if(startB) {
					startB = false;
				}
				
				if((i > start) && (counter > biggestgap)) {
					biggap = biggestgap;
					startbiggap = startbiggestgap;
					biggestgap = counter;
					startbiggestgap = i-counter;
				}
				else if((i > start) && (counter > biggap)) {
					biggap = counter;
					startbiggap = i-counter;
				}
				counter = 0;
			}
		}
		end = counter;
		if(counter > biggestgap) {
			biggap = biggestgap;
			biggestgap = counter;
		}
		else if(counter > biggap) {
			biggap = counter;
		}
		

		
		// check start case
		if(start > 0) {
			String temp = "1" + line.substring(1, startbiggestgap + biggestgap/2) + "1" + line.substring(startbiggestgap + biggestgap/2 + 1);
			//System.out.println(temp);
			dist(temp);
		}
		
		// check end case
		if(end > 0) {
			String temp = line.substring(0, startbiggestgap + biggestgap/2) + "1" + line.substring(startbiggestgap + biggestgap/2+1, n-1) + "1";
			dist(temp);
		}
		
		if(start > 0 && end > 0) {
			String temp = "1" + line.substring(1, n-1) + "1";
			dist(temp);
		}
		
		if(biggap != 0 && startbiggestgap < startbiggap) {
			String temp = line.substring(0, startbiggestgap + biggestgap/2) + "1" + line.substring(startbiggestgap + biggestgap/2+1, startbiggap + biggap/2) + "1" + line.substring(startbiggap + biggap/2 + 1);
			dist(temp);
		}
		else if(biggap != 0){
			String temp = line.substring(0, startbiggap + biggap/2) + "1" + line.substring(startbiggap + biggap/2+1, startbiggestgap + biggestgap/2) + "1" + line.substring(startbiggestgap + biggestgap/2 + 1);
			dist(temp);
		}
		
		if(biggap == 0 && biggestgap == n) {
			ans = n-2;
		}
		
		String temp = line.substring(0, startbiggestgap + biggestgap/3) + "1" + line.substring(startbiggestgap + biggestgap/3 + 1, startbiggestgap + biggestgap/3 + 1 + biggestgap/3) + "1" + line.substring(startbiggestgap + biggestgap/3 + 1 + biggestgap/3 + 1);
		dist(temp);
//		for(int i =) {
//			
//		}
		
//		out.println("start: " + start);
//		out.println("end: " + end);
//		out.println("biggap: " + biggap);
//		out.println("startbiggap: " + startbiggap);
//		out.println("biggestgap: " + biggestgap);
//		out.println("startbiggestgap: " + startbiggestgap);
		out.println(ans+1);
		
		/*for(int i = 0; i < line.length()-1; i++) {
			if(line.charAt(i) == '0') {
				//System.out.println(i + " is a 0");
				copy = line.substring(0, i) + "1" + line.substring(i+1, line.length()-1);
				System.out.println(copy);
				for(int j = i+1; j < line.length()-1; j++) {
					if(copy.charAt(j) == '0') {
						System.out.println(j + " is a 0");
						String temp = copy.substring(0, j) + "1" + copy.substring(j+1, copy.length()-1);
						System.out.println(temp);
						dist(temp);
					}					
				}
				System.out.println(i);
			}
		}*/
		
		//out.println(ans);
//		out.println("test");
		out.close();
	}
	
	public static void dist(String temp) {
		int d = n;
		boolean start = false;
		int counter = 0;
		for(int i = 0; i < temp.length(); i++) {
			if(!start) {
				if(temp.charAt(i) == '1') {
					start = true;
				}
				continue;
			}
			
			if(temp.charAt(i) == '0') {
				counter++;
			}
			else {
				d = Math.min(d, counter);
				counter = 0;
			}
			//System.out.println(d);
		}
		if(ans == n) {
			ans = d;
		}
		else {
			ans = Math.max(d, ans);//Math.max(Math.max(d, counter), ans);			
		}
	}
	
	static class FastReader{
		BufferedReader br;
		StringTokenizer st;
		public FastReader() {
			try {
				br = new BufferedReader(new FileReader("socdist1.in"));
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
