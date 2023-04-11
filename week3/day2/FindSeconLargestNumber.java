package week3.day2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindSeconLargestNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Here is the input
				//int[] data = {3,2,11,4,6,7};

				
				/*
				 Pseudo Code:
				 1) Arrange the array in ascending order
				 2) Pick the 2nd element from the last and print it
				 */
				
				List<Integer> list = new ArrayList<Integer>();
				list.add(3);
				list.add(2);
				list.add(11);
				list.add(4);
				list.add(6);
				list.add(7);
				
				Collections.sort(list);
				
				int size = list.size();
				
				
				System.out.println("Second Largest Number is : "+list.get(size-2));
			
				
	}

}
