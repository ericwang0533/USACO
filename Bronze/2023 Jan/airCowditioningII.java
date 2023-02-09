import java.util.*;
import java.io.*;

public class airCowditioningII {
    public static Scanner in = new Scanner(System.in);

    public static int n;
    public static int m;
    public static int[][] cowRanges;
    public static int[] cool;
    public static int[][] acRanges;
    public static int[] reduce;
    public static int[] costt;

    public static int[] stalls = new int[101];
    public static int lowCost = Integer.MAX_VALUE;
    // public static in

    public static void main(String[] args) throws IOException {
        input();
        // debugInput();

        // recursive function moment
        for(int i = 0; i < m; i++){
            int[] copy = stalls.clone();
            recurse(copy, 0, i);
        }

        System.out.println(lowCost);


        // int cost = checkAC(0, stalls);
        // System.out.println(cost);
        // debugInput();
        // System.out.println(checkCondiditions(stalls));


        // cost += checkAC(2, stalls);
        // System.out.println(cost);
        // debugInput();
        // System.out.println(checkCondiditions(stalls));

        // cost += checkAC(3, stalls);
        // System.out.println(cost);
        // debugInput();
        // System.out.println(checkCondiditions(stalls));
    }

    // stallNum is 0indexed
    public static void recurse(int[] arr, int cost, int acNum){
        // System.out.println("acNum: " + acNum + " | cost: " + cost);

        // check conditions first (shouldnt need to worry about checking if we turned on all ACs bc problem states that solution is there if all AC is on)
        if(checkCondiditions(arr)){
            lowCost = Math.min(cost, lowCost);
            // System.out.println("lowcost: " + lowCost);
            return;
        }
        else if(acNum >= m){
            return;
        }


        arr = checkAC(acNum, arr);
        // arr = 
        // int[] ccrr = arr.clone();

        cost += costt[acNum];

        // System.out.println("newcost: " + cost);

        int[] bbrr = arr.clone();
        recurse(bbrr, cost, acNum+1);

        for(int i = acNum+2; i < m; i++){
            int[] brr = arr.clone();
            recurse(brr, cost, i);
        }

        // System.out.println("bottom recurse");
        return;
    }

    public static int[] checkAC(int num, int[] arr){
        for(int i = acRanges[num][0]; i <= acRanges[num][1]; i++){
            arr[i] -= reduce[num];
        }

        return arr;
    }

    public static boolean checkCondiditions(int[] arr){
        for(int i = 0; i < n; i++){
            for(int j = cowRanges[i][0]; j <= cowRanges[i][1]; j++){
                if(arr[j] > 0){
                    return false;
                }
            }
        }
        
        return true;
    } 

    public static void input(){
        n = in.nextInt(); m = in.nextInt();
        cowRanges = new int[n][2];
        cool = new int[n];
        acRanges = new int[m][2];
        reduce = new int[m];
        costt = new int[m];

        for(int i = 0; i < n; i++){
            cowRanges[i][0] = in.nextInt();
            cowRanges[i][1] = in.nextInt();
            cool[i] = in.nextInt();

            for(int j = cowRanges[i][0]; j <= cowRanges[i][1]; j++){
                stalls[j] = cool [i];
            }
        }

        for(int i = 0; i < m; i++){
            acRanges[i][0] = in.nextInt();
            acRanges[i][1] = in.nextInt();
            reduce[i] = in.nextInt();
            costt[i] = in.nextInt();
        }
    }

    public static void debugInput() {
        // System.out.println("n: " + n);
        // System.out.println("m: " + m);
        System.out.println("cowRanges: " + Arrays.deepToString(cowRanges));
        System.out.println("cool: " + Arrays.toString(cool));
        System.out.println("acRanges: " + Arrays.deepToString(acRanges));
        System.out.println("reduce: " + Arrays.toString(reduce));
        System.out.println("cost: " + Arrays.toString(costt));
        System.out.println("stalls: " + Arrays.toString(stalls));
    }
}
