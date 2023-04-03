package week2.day1;

import java.util.Arrays;

public class FindSecondLargestFromArray {

	public static void main(String[] args) {
		/*
		 Pseudo Code:
		 1) Arrange the array in ascending order
		 2) Pick the 2nd element from the last and print it
		*/
		
		int[] data = {3,2,11,4,6,7};
		
		// Array size
		int size = data.length;
		
		//Sort the array in ascending order 
		 Arrays.sort(data);
		 
		//Pick the 2nd element from the last and print it
		System.out.println("Second Largest Element is: "+data[size-2]);
		
	}

}
