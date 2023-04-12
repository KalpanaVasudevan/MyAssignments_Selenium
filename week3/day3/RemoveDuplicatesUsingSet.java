package week3.day3;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesUsingSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num={3,5,7,2,5,7,9,2,1,54,8,4,6,4,8};
		
		Set<Integer> unique = new HashSet<Integer>();
		Set<Integer> duplicates = new HashSet<Integer>();
		
		
		
		for (Integer i : num) {
			
			boolean add = unique.add(i);
			if(!add)
			{
				duplicates.add(i);
				
			}
		}
		
		System.out.println("Set values after removing duplicates: "+unique);
		System.out.println(duplicates);
	}

}
