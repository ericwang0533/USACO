import java.util.*;
import java.io.*;
public class marathon{
    public static FastReader in = new FastReader();
    public static int m = in.nextInt();
    public static int n = in.nextInt();
    public static ArrayList<Long> arr = new ArrayList<Long>();
    public static ArrayList<Long> brr = new ArrayList<Long>();
    
    public static void main(String[] args) throws IOException{
        for(int i = 0; i < m; i++){
            long hours = in.nextLong();
            long minutes = in.nextLong();
            long seconds = in.nextLong();
            hours *= 3600;
            minutes *= 60;
            arr.add(hours + minutes + seconds);
            //System.out.println(arr.get(i));
            brr.add(hours + minutes + seconds);
        }
        Collections.sort(arr);
        for(int i = 0; i < n; i++){
            System.out.print(brr.indexOf(arr.get(i)) + 1 + " ");
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