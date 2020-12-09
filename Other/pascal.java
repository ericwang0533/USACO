import java.util.*;
import java.io.*;
public class pascal{
    public static BufferedReader input;
    public static int n, s;
    public static int[][] mat;
    public static int row = 0;
    public static int column = 0;
    
    public static void main(String[] args) throws IOException{
        input = new BufferedReader(new InputStreamReader(System.in));    
        StringTokenizer st = new StringTokenizer(input.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        
        mat = new int[n][n];
        mat[0][0] = s;
        while(true){
            if(column == row){
                if(column + 1 == n){
                    break;
                }
                else{
                    column++;
                    row = -1;
                }
                //System.out.println(column + ":" + row);
            }
            
            s++;
            if(s == 10) {
            	s = 1;
            }
            row++;
            mat[row][column] = s;
        }
        
        /*for(int i = -1; i < n-1; i++){
            for(int j = i+1; j < n; j++){
                System.out.print(mat[i+1][j] + " ");
            }
            System.out.println();
        }*/
        for(int i = 0; i < n; i++) {
        	for(int j = 0; j < n; j++) {
        		if(mat[i][j] == 0) {
        			System.out.print("  ");
        		}
        		else{
        			System.out.print(mat[i][j] + " ");
        		}
        	}
        	System.out.println();
        }
    }
}