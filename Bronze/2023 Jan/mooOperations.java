import java.util.*;
import java.io.*;

public class mooOperations {
    public static Scanner in = new Scanner(System.in);
    public static int n;
    
    public static void main(String[] args) throws IOException{
        input();
        // debugInput();

        for(int i = 0; i < n; i++){
            System.out.println(solve());
        }
    }

    public static int solve(){
        int lowest = -1;
        int startingInd = -1;
        String str = in.nextLine();
        char[] arr = str.toCharArray();
        // System.out.println("str: " + str);

        // scan every three chars and look for MOO (0), MOM (1), OOO (1), OOM (2)
        for(int i = 0; i < arr.length-2; i++){
            if(arr[i] == 'M' && arr[i+1] == 'O' && arr[i+2] == 'O'){
                lowest = 0;
                startingInd = i;
                break;
            }
            else if(arr[i] == 'M' && arr[i+1] == 'O' && arr[i+2] == 'M'){
                lowest = 1;
                startingInd = i;
            }
            else if(arr[i] == 'O' && arr[i+1] == 'O' && arr[i+2] == 'O'){
                lowest = 1;
                startingInd = i;
            }
            else if(lowest != 0 && lowest != 1 && arr[i] == 'O' && arr[i+1] == 'O' && arr[i+2] == 'M'){
                lowest = 2;
                startingInd = i;
            }
        } 

        // System.out.println("lowest: " + lowest);
        // System.out.println("startingInd: " + startingInd);

        if(lowest == -1){
            return lowest;
        }

        int removeFromFront = startingInd;
        int removeFromBack = arr.length - startingInd - 3;

        // System.out.println("removeFromFront: " + removeFromFront);
        // System.out.println("removeFromBack: " + removeFromBack);

        return lowest + removeFromBack + removeFromFront;
    }

    public static void input(){
        n = in.nextInt();
        in.nextLine();
    }

    public static void debugInput(){
        System.out.println(n);
    }
}
