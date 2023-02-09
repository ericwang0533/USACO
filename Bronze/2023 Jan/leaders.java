import java.util.*;
import java.io.*;

public class leaders {
    public static Scanner in = new Scanner(System.in);
    public static int n;
    public static char[] charArr;
    public static int[] intArr;

    public static int lastG = -1;
    public static int lastH = -1;
    public static int firstG = -1;
    public static int firstH = -1;

    public static int leaderG = -1;
    public static int leaderH = -1;

    public static int ans = 0; 

    public static void main(String[] args) throws IOException {
        // input
        n = in.nextInt();
        // System.out.println(n);

        String line = in.next();
        charArr = line.toCharArray();
        // System.out.println(Arrays.toString(charArr));

        intArr = new int[n];
        for(int i = 0; i < n; i++){
            intArr[i] = in.nextInt();
        }
        // System.out.println(Arrays.toString(intArr));

        // find firstG, lastG, firstH, lastH
        for(int i = 0; i < n; i++){
            // System.out.println("i: " +charArr[0]);
            
            if(charArr[i] == 'G'){
                if(firstG == -1){
                    firstG = i;
                }
                lastG = i;
            }
            else{
                if(firstH == -1){
                    firstH = i;
                }
                lastH = i;
            }
        }

        // System.out.println(firstG);
        // System.out.println(lastG);
        // System.out.println(firstH);
        // System.out.println(lastH);


        //TODO: firstG or firstH has to be "leaderG/H" and "leaderG/H" can be blank  

        // find G H leader 
        if(intArr[firstG] > lastG){
            leaderG = firstG;
        }

        if(intArr[firstH] > lastH){
            leaderH = firstH;
        }

        // for(int i = firstG; i <= lastG; i++) {
        //     if(charArr[i] == 'G' && intArr[i] > lastG){
        //         leaderG = i;
        //         break;
        //     }
        // }

        // for(int i = firstH; i <= lastH; i++) {
        //     if(charArr[i] == 'H' && intArr[i] > lastH){
        //         leaderH = i;
        //         break;
        //     }
        // }        

        // System.out.println(leaderG);
        // System.out.println(leaderH);


        if(leaderG != -1 && leaderH != -1){
            ans++;
            // System.out.println("both not -1");
            if(leaderG > leaderH){
                // System.out.println("lookin for lH");
                // find all possible leaders H
                for(int i = 0; i < leaderG; i++){
                    if(charArr[i] == 'H' && intArr[i] > leaderG){
                        ans++;
                    }
                }
            }            
            else{
                // System.out.println("lookin for lG");
                for(int i = 0; i < leaderH; i++){
                    if(charArr[i] == 'G' && intArr[i] > leaderH){
                        ans++;
                    }
                }
            }
        }
        else if(leaderG != -1){
            // System.out.println("looking for leaderH");
            // no leader H (find all possible leader Hs)
            for(int i = 0; i < leaderG; i++){
                if(charArr[i] == 'H' && intArr[i] > leaderG){
                    ans++;
                }
            }
        }
        else{
            // System.out.println("looking for leaderG");
            // no leader G (find all possible leader Gs)
            for(int i = 0; i < leaderH; i++){
                if(charArr[i] == 'G' && intArr[i] > leaderH){
                    ans++;
                }
            }
        }


        // 

        // for(int i = 0; i <= leaderG; i++) {
        //     if(charArr[i] == 'H' && intArr[i] > leaderG && i != leaderH){
        //         ans++;
        //     }
        // }

        // for(int i = 0; i <= leaderH; i++) {
        //     if(charArr[i] == 'G' && intArr[i] > leaderH && i != leaderG){
        //         ans++;
        //     }
        // }

        System.out.println(ans);

    }
}