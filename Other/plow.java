import java.util.*;
import java.io.*;
public class plow{
    public static FastReader input = new FastReader();
    public static int x = input.nextInt();
    public static int y = input.nextInt();
    public static int n = input.nextInt();
    public static int[][] mat = new int[y][x];
    public static int counter = 0;
    
    public static void main(String[] args) throws IOException{
        for(int i = 0; i < n; i++){
            int x1 = input.nextInt();
            int y1 = input.nextInt();
            int x2 = input.nextInt();
            int y2 = input.nextInt();
            for(int j = x1; j <= x2; j++){
                for(int k = y1; k <= y2; k++){
                    if(mat[k-1][j-1] != 1){
                        counter++;
                        mat[k-1][j-1] = 1;
                    }
                }
            }
        }
        
        System.out.println(counter);
    }
    
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        
        public FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        
        String next(){
            while (st == null || !st.hasMoreElements()){
                try{
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e){
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