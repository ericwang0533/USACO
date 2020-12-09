import java.io.*;
import java.util.*;
public class pascaltri {
	public static FastReader input = new FastReader();
	public static int n = input.nextInt();
	public static int k = input.nextInt();
	
	public static void main(String[] args) throws IOException{
		if(k == 0 || k == n) {
			System.out.println(1);
			System.exit(1);
		}
		n++;
		int[][] mat = new int[n][n];
		mat[0][0] = 1;
		mat[1][0] = 1;
		mat[1][1] = 1;
		
		for(int i = 2; i < n; i++) {
			for(int j = 0; j < i+1; j++) {
				if(j == 0 || j == i) {
					mat[i][j] = 1;
					continue;
				}
				mat[i][j] = mat[i-1][j] + mat[i-1][j-1];
			}
		}
		
		System.out.println(mat[n-1][k]);
		mat[n-1][k] = -1;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
		
		
	}
	
	static class FastReader 
    { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader() 
        { 
            br = new BufferedReader(new InputStreamReader(System.in)); 
        } 
  
        String next() 
        { 
            while (st == null || !st.hasMoreElements()) 
            { 
                try
                { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException  e) 
                { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
        } 
  
        int nextInt() 
        { 
            return Integer.parseInt(next()); 
        } 
  
        long nextLong() 
        { 
            return Long.parseLong(next()); 
        } 
  
        double nextDouble() 
        { 
            return Double.parseDouble(next()); 
        } 
  
        String nextLine() 
        { 
            String str = ""; 
            try
            { 
                str = br.readLine(); 
            } 
            catch (IOException e) 
            { 
                e.printStackTrace(); 
            } 
            return str; 
        } 
    }
}
	
