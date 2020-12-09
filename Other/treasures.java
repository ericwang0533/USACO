import java.io.*;
import java.util.*;
public class treasures{
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(in.readLine());
        long result = 1;
        int ans = 0;
        StringTokenizer st = new StringTokenizer(in.readLine());
        for(int i = 0; i < n; i++){
            result *= Integer.parseInt(st.nextToken());
            if(result%10 == 0) {
            	ans++;
            	result /= 10;
            }
        }
        System.out.println(result);
        /*int ans = 0;
        while(result > 0){
            if(result % 10 == 0){
                ans++;
            }
            result /= 10;
        }*/
        System.out.println(ans);
    }
}