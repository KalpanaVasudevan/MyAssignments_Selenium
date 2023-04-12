package week3.day3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class PrintUniqueCharacters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//PrintUniqueCharacter
		/*
		 * Problem
		 * 
		 * a) Take your name as input
		 * b) Print all unique characters only (any order)
		 * 
		 * Input:  babu
		 * Output: a u 
		 * 
		 */

		/*
		 * Psuedocode
		 * 
		 * a) Convert String to Character array
		 * b) Create a new Set -> HashSet
		 * c) Add each character to the Set and if it is already there, remove it
		 * d) Finally, print the set
		 * 
		 */
		
		//Input declaration
		String name ="babu";
		String output="";
		
		//convert to char array
		char[] charArray = name.toCharArray();
		
		
		//Set declaration
		Set<Character> unique = new LinkedHashSet<Character>();
		
		
		for (Character ch : charArray) {
			
			boolean add = unique.add(ch);
			
			if(!add)
			{
				unique.remove(ch);
			}
		}
		
		System.out.println(unique);//prints unique characters
		
		
	}

}
