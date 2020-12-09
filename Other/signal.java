import java.util.*;
import java.io.*;
public class signal{
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        String[][] arr = new String[n * k + 1][m * k + 1];
        int row = 0;
        int column = 0;
        for(int i = 0; i < n; i++){
            String line = in.readLine();
            for(int j = 0; j < m; j++){
                for(int a = 0; a < k; a++){
                    for(int b = 0; b < k; b++){
                        arr[i + a + row][j + b + column] = line.substring(j, j+1);
                    }
                }
                column += 7;
            }
            row += 7;
            column = 0;
        }
        
        for(int i = 0; i < n * k; i++){
            for(int j = 0; j < m * k; j++){
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
}