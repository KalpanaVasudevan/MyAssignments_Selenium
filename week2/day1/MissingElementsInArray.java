package week2.day1;

import java.util.Arrays;

public class MissingElementsInArray {

	public static void main(String[] args) {
		
		int[] arr = {1,2,3,4,7,6,8};
		
		//Array Size
		int size = arr.length;
		
		// Sort the array	
		Arrays.sort(arr);	
		

		// loop through the array (start i from arr[0] till the length of the array)
		for (int i = 0; i < size; i++) {
		
			int j=i+1;
			// check if the iterator variable is not equal to the array values respectively
			if(j!=arr[i]) {
				
				System.out.println(j);
				break;
			}
			
		}				
						
	}

}
