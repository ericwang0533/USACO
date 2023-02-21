import java.io.*;
import java.util.*;

public class shellgame {
    public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("shell.in"));
        PrintWriter out = new PrintWriter(new File("shell.out"));

        int n = sc.nextInt();

		// shellAtPos[i] stores the label of the shell located at position i
		int[] shellAtPos = new int[3];

		// Arbitrarily place the shells down
		for (int i = 0; i < 3; i++) {
			shellAtPos[i] = i;
		}

		// counter[i] stores the number of times the shell with label i was picked
		int[] counter = new int[3];

		for (int i = 0; i < n; i++) {
			// Zero indexing: offset all positions by 1
			int a = sc.nextInt() - 1;
			int b = sc.nextInt() - 1;
			int g = sc.nextInt() - 1;

			// Perform Bessie's swapping operation
			int temp = shellAtPos[b];
			shellAtPos[b] = shellAtPos[a];
			shellAtPos[a] = temp;

			// Count the number of times Elsie guesses each particular shell
			counter[shellAtPos[g]]++;
		}

		out.println(Math.max(counter[0], Math.max(counter[1], counter[2])));
        out.close();
    }
}
