package week3.day3;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class RemoveDuplicateStringUsingSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * Pseudo code 
		 
		 * a) Use the declared String text as input
			String text = "We learn java basics as part of java sessions in java week1";		
		 * b) Initialize an integer variable as count	  
		 * c) Split the String into array and iterate over it 
		 * d) Initialize another loop to check whether the word is there in the array
		 * e) if it is available then increase and count by 1. 
		 * f) if the count > 1 then replace the word as "" 
		 
		 * g) Displaying the String without duplicate words	
		 */
		
		//Input String
		String text = "We learn java basics as part of java sessions in java week1";
		
		//Variable declaration
		String output="";
		String str3=" ";
		
		//Set Declaration
		Set<String> unique = new LinkedHashSet<String>();
		
		
		String[] split = text.split(" ");
		
		System.out.println(split);
		
		for (String str : split) {
			
			unique.add(str);
		}
		System.out.println(unique);
		
		List<String> list1 = new ArrayList<String>(unique);
		for (String str2 : list1) {
			
			output=output+str2+str3;
		}
		
		System.out.println(output+" ");
	}

}
