import java.util.*;
import java.io.*;

public class lonelyphoto{
    public static int n;
    public static char[] arr;
    
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        n = Integer.parseInt(in.nextLine());
        arr = in.nextLine().toCharArray();
        long ans = 0;


        // WORKING SOLUTION

        // ans var to keep track
                // for loop starting at 0 --> n (breaks when ?) [ind i]
                    // have counter for G and H
                    // for loop starting at i going to n [ingd j]
                        // breaks when both are above 1 
                        // if j is >= 2 and either G or H = 1 then ans++


        for(int i = 0; i < n-2; i++){
            int gcount = 0; int hcount = 0;
            
            // System.out.println("i: " + i);
            for(int j = i; j < n; j++){
                // System.out.println("gcount: " + gcount);
                // System.out.println("hcount: " + hcount);

                if(arr[j] == 'G'){
                    gcount++;
                }
                else{
                    hcount++;
                }

                if(gcount > 1 && hcount > 1){
                    break;
                }

                if((gcount + hcount >= 3) && (gcount == 1 || hcount == 1)){
                    // System.out.println("ans++");
                    ans++;
                }
            }
        }

        System.out.println(ans);

    }
}

















// ArrayList<Integer> Gs = new ArrayList<Integer>();
// ArrayList<Integer> Hs = new ArrayList<Integer>();

// for(int i = 0; i < n; i++){
//     if(arr[i] == 'G'){
//         Gs.add(i);
//     }
//     else{
//         Hs.add(i);
//     }
// }

// System.out.println(Gs);
// System.out.println(Hs);

// if(Gs.size() == 1){
//     System.out.println("G size = 0");
// }
// if(Hs.size() == 1){
//     System.out.println("H size = 0");
// }

// for(int i = 0; i < Gs.size(); i++){
    
// }


// for(int i = 0; i < n-2; i++){
//     int gcount = 0; int hcount = 0;

//     // System.out.println("i: " + i);
//     for(int j = i; j < n; j++){
//         // System.out.println("gcount: " + gcount);
//         // System.out.println("hcount: " + hcount);

//         if(arr[j] == 'G'){
//             gcount++;
//         }
//         else{
//             hcount++;
//         }

//         if(gcount > 1 && hcount > 1){
//             break;
//         }

//         if((gcount + hcount >= 3) && (gcount == 1 || hcount == 1)){
//             // System.out.println("ans++");
//             ans++;
//         }
//     }
// }



// // above (list of gs, list of hs)
// // if size is 1 
//     // throw out n + 
// // loop through list of gs to find the # of lonelyGs
//     // if starts w/ 0
//         // 


// for(int i = 0; i < Gs.size(); i++){
//     if(i+1 == Gs.size()){
//         if(n-1 - Gs.get(i) <= 2){
//             // no lonelyGs
//         }
//         else{
//             ans +=n - 1 -Gs.get(i)-2;
//         }
//         break;
//     }

//     if(Gs.get(i+1) - Gs.get(i) <= 2){
//         // no lonelyGs
//     }
//     else{
//         ans += Gs.get(i+1)-Gs.get(i)-2;
//     }
// }

// for(int i = 0; i < Hs.size(); i++){
//     if(i+1 == Hs.size()){
//         if(n-1 - Hs.get(i) <= 2){
//             // no lonelyGs
//         }
//         else{
//             ans +=n - 1 -Hs.get(i)-2;
//         }
//         break;
//     }

//     if(Hs.get(i+1) - Hs.get(i) <= 2){
//         // no lonelyGs
//     }
//     else{
//         ans += Hs.get(i+1)-Hs.get(i)-2;
//     }
// }




// for(int i = 0; i < N-2; i++){

//     for(int j = i; j < N; j++){
//         // do magic

//         // have a counter for G and a counter for H
//         // and based on the values of Gcounter and Hcouter, do 
//             // that incremeents counter when there is a lonely photo (takes into account if the >=3 requirement is satisfied)
//             // breaks when there is no possibility of MORE lonely photos 


     
//         if(breed[i] == h){
//             hcounter++
//         }
//         else if(breed[i] == g){
//             gcounter++;
//         }


//                 // and based on the values of Gcounter and Hcouter, do 
//             // that incremeents counter when there is a lonely photo (takes into account if the >=3 requirement is satisfied)
//             // breaks when there is no possibility of MORE lonely photos 




//         // if # of cows so far is >= 3 AND one of the cows is =1
//             // lonelyphotos++
//         // if both number of cows are > 1 
//             // break;

//     }

// }

// outerloop:
// for(ind i )
//  for (int j)

//     iif condtion
//         break outerloop;
//         // break OUT OF THE FIRST FOR LOOP





// woeijwoer