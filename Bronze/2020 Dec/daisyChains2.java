import java.io.*;
import java.util.*;

public class daisyChains2 {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);

    int n = Integer.parseInt(sc.nextLine());
    
    int[] petals = new int[n];
    for(int i = 0; i < n; i++) {
      petals[i] = sc.nextInt();
    }

    int photos = 0;
    for(int i = 0; i < n; i++) {
      for(int j = i; j < n; j++) {

        // get total petals
        int totalPetals = 0;
        for(int k = i; k <= j; k++) {
          totalPetals += petals[k];
        }

        for(int k = i; k <= j; k++) {
          if(petals[k] * (j-i+1) == totalPetals) { // checks if current petal = total petals
            photos++;
            break;
          }
        }
      }
    }

    System.out.println(photos);
  }
}






// for (int i = 0; i < N; i++)
    // for (int j = i; j < N; j++)
        // i ==> Pi (starting flower)
        // j ==> Pn (ending flower)

        //GOALS:
        // get the total number of petals from Pi --> Pn
        // check every flower from Pi --> Pn to see if its a golden flower 


        // TOTAL NUMBER OF PETALS
        // totalFlower = 0;
        // for loop from i to j (aka from Pi to Pn) and sum every element
            // totalFlower += PETALS[element]