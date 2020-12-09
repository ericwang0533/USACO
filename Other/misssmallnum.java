import java.util.*;
import java.io.*;
public class misssmallnum{
    public static FastReader in = new FastReader();
    public static int n = in.nextInt();
    public static ArrayList<Integer> arr = new ArrayList<Integer>();
    public static int min = -100;
    
    public static void main(String[] args) throws IOException{
        for(int i = 0; i < n; i++){
            arr.add(in.nextInt());
            while(min <= 100){
                if(arr.indexOf(min) != -1){
                    min++;   
                }   
                else {
                	break;
                }
            }
        }
        if(min <= 100){
            System.out.println(min);
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