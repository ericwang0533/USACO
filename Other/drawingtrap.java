import java.util.*;
import java.io.*;
public class drawingtrap{
    public static FastReader in = new FastReader();
    public static int b = in.nextInt();
    public static int h = in.nextInt(); 
    
    public static void space(){
        System.out.print("  ");
    }
    
    public static void star(){
        System.out.print("* ");
    }
    
    public static void main(String[] args) throws IOException{
        for(int i = h; i > 0; i--){
            for(int j = 0; j < i-1; j++){
                space();
            }
            for(int j = 0; j < b-(2*(i-1)); j++){
                star();
            }
            for(int j = 0; j < i-1; j++){
                space();
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