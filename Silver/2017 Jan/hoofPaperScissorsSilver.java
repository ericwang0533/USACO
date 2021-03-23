import java.util.*;
import java.io.*;
public class hoofPaperScissorsSilver {
	// debug, fastreader, setup
	public static boolean debug = false, testing = false;
	public static BufferedReader br; public static StringTokenizer st;
	public static FastReader in = new FastReader();
	public static PrintWriter out;
	
	// n = num of games
	public static int n = in.nextInt();
	
	// 3 arrs to store num of h,p,s at game n
	public static int[] hoofs = new int[n], papers = new int[n], scissorss = new int[n];
	// stores num of h,p,s; helps storing the above arrs
	public static int hoofNum = 0, paperNum = 0, scissorsNum = 0;
	
	// ans (maxing)
	public static int ans = 0;
	
	
	public static void main(String[] args) throws IOException{
		// printwriter
		out = (testing) ? new PrintWriter(System.out) : new PrintWriter(new FileWriter(new File("hps.out")));
		
		// grab input; prefix sums
		input();
		
		// one edge case that we dont cover
		// farmerj only chooses one h,p,s (we wouldnt need to switch at all)
		if(hoofNum == n || paperNum == n || scissorsNum == n) {
			// print n (cause thats the answer as we dont switch)
			out.println(n);
			
			// make sure to close the printwriter
			out.close();
			// exits the program, 0 indicates successful termination
			System.exit(0);
		}
		
		// loop through all games (starting at 1)
		for(int i = 1; i < n; i++) {
			// calc max wins of games before i
			int bigPos = Math.max(hoofs[i], Math.max(papers[i], scissorss[i]));
			// calc max wins of games after i
			bigPos += Math.max(hoofNum-hoofs[i-1], Math.max(paperNum-papers[i-1], scissorsNum-scissorss[i-1]));
			
			// check if its greater than ans
			ans = Math.max(ans, bigPos);
		}
		
		// print ans; close printwriter; program done
		out.println(ans);
		out.close();
	}
	
	public static void input() {
		// loop through all n games and grab input/psums
		for(int i = 0; i < n; i++) {
			// if h,p,s then increment h,p,s,Num
			String next = in.next();
			if(next.equals("H")) {
				hoofNum++;
			}
			else if(next.equals("P")) {
				paperNum++;
			}
			else { // next.equals("S")
				scissorsNum++;
			}
			
			// even if there wasnt a new h,p,s
			// we do not want any 'gaps' in our array b/c psums
			hoofs[i] = hoofNum;
			papers[i] = paperNum;
			scissorss[i] = scissorsNum;
		}
		
		// debug statements
		dbg(Arrays.toString(hoofs) + " | " + hoofNum);
		dbg(Arrays.toString(papers) + " | " + paperNum);
		dbg(Arrays.toString(scissorss) + " | " + scissorsNum);
	}

	// fastreader
	public static class FastReader{
		public FastReader() {
			try {
				br = (testing) ? new BufferedReader(new InputStreamReader(System.in)) : new BufferedReader(new FileReader(new File("hps.in")));
			}
			catch(FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		public String next() {
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
		
		public int nextInt() {
			return Integer.parseInt(next());
		}
		
		public double nextDouble() {
			return Double.parseDouble(next());
		}
		
		public long nextLong() {
			return Long.parseLong(next());
		}
		
		public String nextLine() {
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
	
	// dbg
	public static void dbg(Object obj) {
		if(testing)
			System.out.println(obj);
	}
}
