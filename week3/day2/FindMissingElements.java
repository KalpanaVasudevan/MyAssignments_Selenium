package week3.day2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindMissingElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//int[] arr = {1,2,3,4,7,6,8};

		// Sort the array	
		

		// loop through the array (start i from arr[0] till the length of the array)

			// check if the iterator variable is not equal to the array values respectively
			
				// print the number
				
				// once printed break the iteration
				
			//List Declaration
			List<Integer> list = new ArrayList<Integer>();
			
			//Add elements to List
			list.add(1);
			list.add(2);
			list.add(3);
			list.add(4);
			list.add(7);
			list.add(6);
			list.add(8);
			
			System.out.println("Elemts in List are: "+list);
			//List Size
			int size = list.size();
			
			Collections.sort(list);
			
			
			for (int i = 0; i < size; i++) {
				int j=i+1;
				
				if (j!=list.get(i)) {
					
					System.out.println("Missing Element in List is: "+j);
					break;
				}
			}
		
	}

}
