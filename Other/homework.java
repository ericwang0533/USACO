import java.util.*;
import java.io.*;
public class homework{
    public static FastReader in = new FastReader();
    public static int n = in.nextInt();
    public static int m = in.nextInt();
    public static ArrayList<Double> arr = new ArrayList<Double>();
    public static ArrayList<Double> brr = new ArrayList<Double>();
    
    public static void main(String[] args) throws IOException{
        for(int i = 0; i < n; i++){
            int num = in.nextInt();
            int worst = num;
            int counter = 0;
            int sum = 0;
            while(num > -1){
                worst = Math.min(worst, num);
                sum += num;
                counter++;
                num = in.nextInt();
                //System.out.print(sum + " ");
            }
            //System.out.println();
            if(counter == 5){
                sum -= worst;
            }
            /*if(counter == 0) {
            	arr.add(0.0);
            	brr.add(0.0);
            	continue;
            }*/
            arr.add((double)sum / 4);
            brr.add(arr.get(i));
        }
        /*for(int i = 0; i < n; i++) {
        	System.out.println(arr.get(i));
        }*/
        Collections.sort(arr, Collections.reverseOrder());
        for(int i = 0; i < m; i++){
            System.out.print(brr.indexOf(arr.get(i)) + 1 + " ");
            brr.set(brr.indexOf(arr.get(i)), (double)-1);
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