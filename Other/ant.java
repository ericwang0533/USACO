import java.util.*;
import java.io.*;
public class ant{
    public static BufferedReader input;
    public static int ans = 2;
    public static int row = 1;
    public static int column = 1;
    public static int[][] mat;
    
    public static void position(int a){
        if(a == 1){
            row--;
        }
        else if(a == 2){
            row--;
            column++;
        }
        else if(a == 3){
            column++;
        }
        else if(a == 4){
            row++;
            column++;
        }
        else if(a == 5){
            row++;
        }
        else if(a == 6){
            row++;
            column--;
        }
        else if(a == 7){
            column--;
        }
        else if(a == 8){
            row--;
            column--;
        }
        crumb(row, column);
    }
    
    public static void crumb(int i, int j){
    	if(mat[i][j] != 1) {
    		int crumbs = (i + j) % 6;
            ans += crumbs;
    	}
    	mat[row][column] = 1;
        //System.out.println(ans);
    }
    
    public static void main(String[] args) throws IOException{
        input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        mat = new int[n+1][n+1];
        
        StringTokenizer st1 = new StringTokenizer(input.readLine());
        for(int i = 0; i < k; i++){
            int a = Integer.parseInt(st1.nextToken());
            position(a);
        }
        System.out.println(ans);
    }
}