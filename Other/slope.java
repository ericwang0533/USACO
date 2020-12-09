import java.util.*;
import java.io.*;
public class slope{
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());
        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());
        double slope = slope(x1, y1, x2, y2);
        int n = Integer.parseInt(in.readLine());
        int counter = 0;
        for(int i = 0; i < n; i++){
            StringTokenizer st1 = new StringTokenizer(in.readLine());
            int x11 = Integer.parseInt(st1.nextToken());
            int y11 = Integer.parseInt(st1.nextToken());
            int x22 = Integer.parseInt(st1.nextToken());
            int y22 = Integer.parseInt(st1.nextToken());
            double slope1 = slope(x11, y11, x22, y22);
            if(slope1 == slope){
              counter++;  
            }
        }
        System.out.println(counter);
    }
    public static double slope (int x1, int y1, int x2, int y2){
        int numerator = y2 - y1;
        int denominator = x2 - x1;
        double slope = 1.23456789;
        if(denominator != 0){
            slope = (double) numerator / denominator;
        }
        return slope;
    }
}