package week3.day2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FindIntersection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		/*
		 * Pseudo Code
		
		 * a) Declare An array for {3,2,11,4,6,7};	 
		 * b) Declare another array for {1,2,8,4,9,7};
		 * c) Declare for loop iterator from 0 to array length
		 * d) Declare a nested for another array from 0 to array length
		 * e) Compare Both the arrays using a condition statement
		 
		 *  f) Print the first array (shoud match item in both arrays)
		 */
		
		//Declare list1 and list2
		List<Integer> list1 = new ArrayList<Integer>();
		List<Integer> list2 = new ArrayList<Integer>();
		
		
		//Add elements to List
		list1.add(3);
		list1.add(2);
		list1.add(11);
		list1.add(4);
		list1.add(6);
		list1.add(7);
		
		System.out.println("Elements in List1: "+list1);
		
		//Size of list1 and list2
		int list1_size = list1.size();
		
		//Add elements to list2
		list2.add(1);
		list2.add(2);
		list2.add(8);
		list2.add(4);
		list2.add(9);
		list2.add(7);
		
		System.out.println("Elements in List2: "+list2);
		
		int list2_size = list2.size();
		
		System.out.println("Intersction between two list is: ");
		for (int i = 0; i < list1_size; i++) {
			for (int j = 0; j < list2_size; j++) 
			{
				
				if (list1.get(i)==list2.get(j)) {
					
					
					System.out.println(list1.get(j));
				}
			}
			
		}
		
	}

}
