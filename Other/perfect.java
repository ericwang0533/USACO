import java.util.*;
import java.io.*;
public class perfect{
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = 2;//Integer.parseInt(st.nextToken());
        int m = 10; //Integer.parseInt(st.nextToken());
        int counter = 0;
        for(int i = n; i <= m; i++){
            if(isPerfect(i)){
                counter++;
            }    
        }
        System.out.println(counter);
    }
    private static int sumofDivisors(int num){
        int sum = 0;
        for(int i = 1; i < num; i++){
            if(num % i == 0){
                sum += i;
            }
        }
        return sum;
    }
    public static boolean isPerfect(int num){
        int sum = sumofDivisors(num);
        if(num == sum){
            return true;
        }
        return false;
    }
}