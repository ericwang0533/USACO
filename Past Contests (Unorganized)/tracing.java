import java.util.*;
import java.io.*;
public class tracing {
	/*public static FastReader in = new FastReader();
	
	public static PrintWriter out;
	
	public static void main(String[] args) throws IOException{
		out = new PrintWriter(new BufferedWriter(new FileWriter("tracing.out")));
		
		out.close();
	}
	
	static class FastReader{
		BufferedReader br;
		StringTokenizer st;
		public FastReader() {
			try {
				br = new BufferedReader(new FileReader("tracing.in"));
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
	}*/
	public static void main(String[] args) throws IOException {
        //Scanner sc = new Scanner(new File("/Users/qixia/IdeaProjects/USACO/src/main/java/bronze/CowtactTracing/1.in"));
        Scanner sc = new Scanner(new File("tracing.in"));
        //PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("/Users/qixia/IdeaProjects/USACO/src/main/java/bronze/CowtactTracing/TRACING.out")));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("tracing.out")));
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
            System.out.println(time);
            int x = sc.nextInt();
            int y = sc.nextInt();
            System.out.println("x = " + x + " y = " + y);
            cowx[time] = x;
            cowy[time] = y;
        }

        boolean[] possibleI = new boolean[N + 1];
        boolean[] possibleK = new boolean[251];


        for (int i = 1; i <= N; i++)
            for (int K = 0; K < 251; K++) {
                if (consistentWithData(N, i, K, cowx, cowy, finalState)) {
                    possibleI[i] = true;
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
}
