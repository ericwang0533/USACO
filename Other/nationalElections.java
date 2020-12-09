import java.util.*;
import java.io.*;
public class nationalElections{
    public static FastReader in = new FastReader();
    public static int n = in.nextInt();
    public static int k = in.nextInt();
    public static ArrayList<String> arr = new ArrayList<String>();
    public static ArrayList<Integer> brr = new ArrayList<Integer>();
    public static ArrayList<Integer> clone = new ArrayList<Integer>();
    public static int m;
    
    public static void main(String[] args) throws IOException{
        for(int i = 0; i < n; i++){
           arr.add(in.next());
           arr.add(in.next());
           brr.add(in.nextInt());
           clone.add(brr.get(i));
        }
        m = in.nextInt();
        for(int i = 0; i < m; i++){
            arr.add(in.next());
            arr.add(in.next());
            brr.add(in.nextInt());
            clone.add(brr.get(i+n));
        }
        Collections.sort(brr);
        int sortedIndex = clone.indexOf(brr.get(k-1));
        System.out.print(arr.get(sortedIndex * 2));
        System.out.print(" " + arr.get((sortedIndex * 2) + 1));
        System.out.print(" " + brr.get(k-1));
        /*System.out.println();
        
        System.out.println(sortedIndex);
        System.out.println(clone.get(k-1));
        
        System.out.println("brr arraylist");
        for(int i = 0; i < brr.size(); i++) {
        	System.out.println(brr.get(i));
        }
        System.out.println("clone arraylist");
        for(int i = 0; i < clone.size(); i++) {
        	System.out.println(clone.get(i));
        }*/
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