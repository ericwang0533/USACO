import java.util.*;
import java.io.*;
public class palindrome{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String num = "";
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            num += st.nextToken();
        }
        boolean palin = true;
        for(int i = 0; i < num.length()/2; i++){
            if(num.substring(i, i+1).equals(num.substring((num.length()-1-i), (num.length()-i)))){
                
            }
            else {
            	System.out.println("NO");
                System.exit(0);
            }
        }
        System.out.println("YES");
    }
}