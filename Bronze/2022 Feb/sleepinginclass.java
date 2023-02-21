import java.util.*;
import java.io.*;

public class sleepinginclass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        // System.out.println("n: " + n);
        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(sc.nextLine());
            int[] arr = new int[num];
            int sum = 0;
            boolean flag = true;        // if all elements are the same (no moves required)

            for(int j = 0; j < num; j++){
                arr[j] = sc.nextInt();
                sum += arr[j];

                if(j != 0 && arr[j] != arr[j-1]){
                    flag = false;
                }
            }
            sc.nextLine();

            if(flag){
                System.out.println(0);
                continue;
            }

            solve(arr, sum);
        }
    }    

    public static void solve(int[] arr, int sum){
        // System.out.println("arr: " + Arrays.toString(arr));
        // System.out.println("sum: " + sum);

        int lowest = arr.length-1;

        outerloop:
        for(int i = 2; i < sum; i++){
            // System.out.println("top");
            if(sum % i == 0){
                // divisible
                
                int curr = 0;
                int old = 0;
                int counter = 0;
                // boolean flag = false;
                innerloop:
                while(curr < arr.length){
                    if(curr == -1){
                        // System.out.println("continue outerloopp");
                        // flag = true;
                        // curr = Integer.MAX_VALUE;
                        continue outerloop;
                    }
                    else{
                        // System.out.println("hey");
                        curr = comb(arr, curr, i);
                        counter+=curr-old-1;
                        old = curr;
                    }
                }
                
                // System.out.println("OUTSIDE");

                // if(flag){
                //     continue outerloop;
                // }

                
                // System.out.println(counter);
                lowest = Math.min(counter, lowest);
                // return;
                // System.out.println("counter: " + counter);
 
            }
        }

        // if no divisors work then combine to form sum using length-1 moves
        // System.out.println(arr.length - 1);
        System.out.println(lowest);
    }

    public static int comb(int[] arr, int ind, int total){
        // System.out.println("ind: " + ind);
        // System.out.println("total: " + total);
        int pre = 0;
        for(int i = ind; i < arr.length; i++){
            pre += arr[i];
            if(pre == total){
                // System.out.println("pre == total");
                return i+1;
            }
            else if(pre > total){
                // System.out.println("pre > total");
                return -1;
            }
        }

        // System.out.println("return down here weird");
        return -1;
    }
}
