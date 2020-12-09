
import java.util.*;
import java.io.*;
public class ageSor{
    public static FastReader in = new FastReader();
    public static int n = in.nextInt();
    public static int k = in.nextInt();
    public static int[][] mat = new int[n][3];
    
    public static void main(String[] args) throws IOException{
        for(int i = 0; i < n; i++){
            mat[i][0] = in.nextInt();
            mat[i][1] = in.nextInt();
            mat[i][2] = in.nextInt();
        }
        Arrays.sort(mat, Comparator.comparingDouble(o -> o[0]));

        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < 3; j++){
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        public FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        String next(){
            while(st == null || !st.hasMoreElements()){
                try{
                    st = new StringTokenizer(br.readLine());
                }
                catch(IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt(){
            return Integer.parseInt(next());
        }
        double nextDouble(){
            return Double.parseDouble(next());
        }
        long nextLong(){
            return Long.parseLong(next());
        }
        String nextLine(){
            String str = "";
            try{
                str = br.readLine();
            }
            catch(IOException e){
                e.printStackTrace();
            }
            return str;
        }
    }
}