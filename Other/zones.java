import java.util.*;
import java.io.*;
public class zones{
    public static FastReader in = new FastReader();
    public static int n = in.nextInt();
    public static ArrayList<Integer> arr = new ArrayList<Integer>();
    
    public static boolean prime(int n){
        for(int i = 2; i < n; i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) throws IOException{
        int prime1 = 0;
        int prime3 = 0;
        for(int i = 0; i < n; i++){
            arr.add(in.nextInt());
            if(prime(arr.get(i)) && prime1 == 0){
                prime1 = arr.get(i);
            }
        }   
        
        for(int i = 0; i < n; i++){
            arr.add(in.nextInt());
        }
        
        for(int i = 0; i < n; i++){
            arr.add(in.nextInt());
            if(prime(arr.get(i+(2*n)))){
                prime3 = arr.get(i+(2*n));
            }
        }
        
        if(prime3 != 0 && prime1 != 0){
            int index1 = arr.indexOf(prime1);
            int index3 = arr.lastIndexOf(prime3);
            int temp = arr.get(index1);
            arr.set(index1, arr.get(index3));
            arr.set(index3, temp);
        }
        for(int i = 0; i < arr.size(); i++){
            System.out.print(arr.get(i) + " ");
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