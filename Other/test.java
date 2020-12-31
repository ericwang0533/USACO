import java.util.*;
import java.io.*;
public class test {
	public static void main(String[] args) throws IOException{
		int[] arr = {1, 2, 3, 5, 6, 8, 9};
		int test = Arrays.binarySearch(arr, 2);
		System.out.println(test);
		int test1 = Arrays.binarySearch(arr, 5);
		System.out.println(test1);
		int test2 = Arrays.binarySearch(arr, 4);
		test2 = Math.abs(test2+2);
		System.out.println(test2);
	}
}
