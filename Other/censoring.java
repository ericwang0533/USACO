import java.util.*;
import java.io.*;
public class censoring{
    public static FastReader in = new FastReader();
    public static String s = in.nextLine();
    public static String t = in.nextLine();
    
    public static boolean tins(String s){
        if(s.contains(t)){
            return true;
        }
        else{
            return false;
        }
    }
    
    public static String sminust(String s){
        s = s.replace(t, "");
        return s;
    }
    
    public static void main(String[] args) throws IOException{
        while(tins(s)){
            s = sminust(s);
            sminust(s);
        }
        
        System.out.println(s);
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