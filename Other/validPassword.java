import java.util.*;
import java.io.*;
public class validPassword{
    public static FastReader in = new FastReader();
    public static String password = in.nextLine(); 
    public static char[] chars = password.toCharArray();
    public static ArrayList<Integer> nums = new ArrayList<Integer>();
    public static boolean spec = false;
    public static boolean low = false;
    public static boolean up = false;
    public static boolean num = false;
    
    public static void charToNum(){
    	if(chars.length < 4 || chars.length > 12) {
    		System.out.println("NO");
    		System.exit(1);
    	}
        for(int i = 0; i < chars.length; i++){
            nums.add((int)chars[i]);
        }
        Collections.sort(nums);
    }
    
    public static void check(int curr) {
    	if(curr <= 46 && curr >= 33 && !spec) {
    		spec = true;
    	}
    	if(curr <= 57 && curr >= 48 && !num) {
    		num = true;
    	}
    	if(curr <= 90 && curr >= 65 && !up) {
    		up = true;
    	}
    	if(curr <= 122 && curr >= 97 && !low) {
    		low = true;
    	}
    	if(curr < 33 || curr > 122 || (curr < 97 && curr > 90) || (curr < 65 && curr > 57) || (curr== 47)) {
    		System.out.println("NO");
    		System.out.println(curr);
    		System.exit(1);
    	}
    	
    	if(spec && low && up && num) {
    		System.out.println("OK");
    		System.exit(1);
    	}
    }
    
    
    public static void main(String[] args) throws IOException{
        charToNum();
        boolean spec = false;
        for(int i = 0; i < nums.size(); i++) {
        	check(nums.get(i));
        }
        if(!spec || !low || !up || !num) {
        	System.out.println("NO");
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