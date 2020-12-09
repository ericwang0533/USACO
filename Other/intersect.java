import java.util.*;
import java.io.*;
public class intersect{
    public static FastReader in = new FastReader();
    public static int n = in.nextInt();
    public static int m = in.nextInt();
    public static int[][] mat = new int[n][5];
    //public static int[] sorted = new int[n];
    
    public static double distance(int x1, int y1, int x2, int y2){
        return Math.sqrt(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2));
    }
    
    public static void main(String[] args) throws IOException{
        for(int i = 0; i < n; i++){
            mat[i][0] = in.nextInt();
            mat[i][1] = in.nextInt();
            mat[i][2] = in.nextInt();
        }
        
        //int max = 0; 
        //int id = 0;
        
        for(int i = 0; i < n; i++){
        	mat[i][4] = i+1;
            for(int j = i+1; j < n; j++){
                double radii = (double)mat[i][2] + mat[j][2];
                if(radii >= distance(mat[i][0], mat[i][1], mat[j][0], mat[j][1])){
                    mat[i][3]++;
                    mat[j][3]++;
                    //sorted[i]++;
                    //sorted[j]++;
                    /*if(mat[i][3] > max){
                        max = mat[i][3];
                        id = i+1;
                    }
                    if(mat[j][3] > max){
                        max = mat[j][3];
                        id = j+1;
                    }*/
                }
            }
        }
        Arrays.sort(mat, Comparator.comparingDouble(o -> o[3]));
        for(int i = 0; i < n; i++) {
        	for(int j = 0; j < 5; j++) {
        		System.out.print(mat[i][j] + " ");
        	}
        	System.out.println();
        }
        for(int i = n-1; i > n-m-1; i--) {
        	System.out.print(mat[i][4] + " ");
        }
        //System.out.println(id);
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