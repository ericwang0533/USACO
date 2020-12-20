import java.util.*;
import java.io.*;
public class tracingConsole {
	public static void main(String[] args) throws IOException {
        //Scanner sc = new Scanner(new File("/Users/qixia/IdeaProjects/USACO/src/main/java/bronze/CowtactTracing/1.in"));
        Scanner sc = new Scanner(System.in);//new File("tracing.in"));
        //PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("/Users/qixia/IdeaProjects/USACO/src/main/java/bronze/CowtactTracing/TRACING.out")));
        PrintWriter pw = new PrintWriter(System.out);//new BufferedWriter(new FileWriter("tracing.out")));
        int N = sc.nextInt();
        int T = sc.nextInt();
        String line3 = sc.next();
        boolean[] finalState = new boolean[N + 1];
        for (int i = 0; i < N; i++)
            finalState[i + 1] = line3.charAt(i) == '1';

        //the index of cowx and cowy should be time
        int[] cowx = new int[251];
        int[] cowy = new int[251];

        for (int i = 0; i < T; i++) {
            int time = sc.nextInt();
            //System.out.println(time);
            int x = sc.nextInt();
            int y = sc.nextInt();
            //System.out.println("x = " + x + " y = " + y);
            cowx[time] = x;
            cowy[time] = y;
        }
        
//        for(int i = 0; i < cowx.length; i++) {
//        	System.out.println(cowx[i]);
//        }
//        for(int i = 0; i < cowx.length; i++) {
//        	System.out.println(cowy[i]);
//        }

        boolean[] possibleI = new boolean[N + 1];
        boolean[] possibleK = new boolean[251];


        for (int i = 1; i <= N; i++)
            for (int K = 0; K < 251; K++) {
                if (consistentWithData(N, i, K, cowx, cowy, finalState)) {
                    possibleI[i] = true;
                    System.out.println(i + " | " + K);
                    possibleK[K] = true;
                }
            }

        int lower_K = 251;
        int upper_K = 0;
        int num_patientZero = 0;

        for (int i = 0; i <= 250; i++) {
            if (possibleK[i]) {
                lower_K = i;
                break;
            }
        }

        for (int i = 250; i > 0; i--) {
            if (possibleK[i]) {
                upper_K = i;
                break;
            }
        }
        for (int i = 1; i <= N; i++)
            if (possibleI[i])
                num_patientZero++;


        String upper_K_result = "";
        if (upper_K >= 250)
            upper_K_result = "Infinity";
        else
            upper_K_result = Integer.toString(upper_K);
        pw.print(num_patientZero + " " + lower_K + " " + upper_K_result);
        pw.close();
    }

    static boolean consistentWithData(int N, int patientZeroPosition, int K, int[] cowx, int[] cowy, boolean[] cow_infected_final_state) {
        boolean[] infect = new boolean[N + 1];
        int[] num_Handshakes_for_each_cow = new int[N + 1]; //index is the cow's index, value is the number of handshakw
        infect[patientZeroPosition] = true;
        for (int t = 0; t <= 250; t++) {
            int x = cowx[t];
            int y = cowy[t];

            if (x > 0 && y > 0) {
                if (infect[x])
                    num_Handshakes_for_each_cow[x]++;
                if (infect[y])
                    num_Handshakes_for_each_cow[y]++;
                if (num_Handshakes_for_each_cow[x] <= K && infect[x])
                    infect[y] = true;
                if (num_Handshakes_for_each_cow[y] <= K && infect[y])
                    infect[x] = true;
            }
        }
        for (int i = 0; i <= N; i++) {
            if (infect[i] != cow_infected_final_state[i])
                return false;
        }
        return true;
    }
	/*public static FastReader in = new FastReader();
	public static int n = in.nextInt(), t = in.nextInt();
	public static String line = in.nextLine();
	//public static int[] cows = new int[n];
	public static ArrayList<Integer> infected = new ArrayList<Integer>();
	public static int[][] mat = new int[t][3];
	public static int x = 0, y = n, z = 0; 
	public static PrintWriter out;
	
	public static void main(String[] args) throws IOException{
		out = new PrintWriter(System.out);//new BufferedWriter(new FileWriter(System.in)));//"tracing.out")));
		
		input();
		
		// loop through the infected cows, simulate 
		for(int i = 0; i < infected.size(); i++) {
			simulate(infected.get(i));
		}
		
		//dbg
		for(int i = 0; i < t; i++) {
			System.out.println(mat[i][0] + " " + mat[i][1] + " " + mat[i][2]);
		}
		
		for(int i = 0; i < infected.size(); i++) {
			System.out.println(infected.get(i));
		}
		
		out.close();
	}
	
	// check if the cow could be a patient zero
	// if it is a patient zero check for the smallest K
	// if it is a patient zero check for the largest K
	public static void simulate(int cow) {
		// TODO Auto-generated method stub
		int[] sims = new int[n];
		sims[cow-1] = 1;
		
		for(int i = 0; i < t; i++) {
			
			if(sims[mat[i][1]-1] == 1) { 
				
				if(infected.contains(mat[i][2]-1)) {
					sims[mat[i][2]-1] = 1;
					// check if conds are all satisfied
				}
				else {
					// broken alert
				}
				
			}
			else if(sims[mat[i][2]-1] == 1) {
				
				if(infected.contains(mat[i][1]-1)) {
					sims[mat[i][1]-1] = 1;
					// check if conds are all satisfied
					for(int j = 0; j < sims.length; j++) {
						if(sims[j] == 1 && !infected.contains(j)) {
							break;
						}
						else if(sims[j] == 0 && !infected.contains(j)) {
							break;
						}
						else {
							
						}
					}
				}
				else {
					// broken alert
				}
				
			}
			
			
		}
	}

	public static void input() {
		// TODO Auto-generated method stub
		for(int i = 0; i < t; i++) {
			mat[i][0] = in.nextInt();
			mat[i][1] = in.nextInt();
			mat[i][2] = in.nextInt();
		}
		Arrays.sort(mat, Comparator.comparingDouble(o -> o[0]));
		
		String[] splited = line.split("");
		for(int i = 0; i < n; i++) {
			//cows[i] = Integer.parseInt(splited[i]);
			if(Integer.parseInt(splited[i]) == 1) {
				infected.add(i+1);
			}
			//System.out.println(cows[i]);
		}
	}

	static class FastReader{
		BufferedReader br;
		StringTokenizer st;
		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));//new FileReader("tracing.in"));
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
	}*/
}
