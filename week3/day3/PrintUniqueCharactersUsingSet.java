package week3.day3;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class PrintUniqueCharactersUsingSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String companyName = "google";
		String output="";
		
		//conver to char array
		char[] ch = companyName.toCharArray();
		System.out.println(ch);
		
		Set<Character> unique = new LinkedHashSet<Character>();
		Set<Character> dup= new LinkedHashSet<Character>();
		
 		for (Character c : ch) {
			boolean add = unique.add(c);
			if(!add)
			{
				dup.add(c);
			}
			
			
		}
 		
 		//Convert Set to List to convert character set to String
 		List<Character> list = new ArrayList<Character>(unique);
 		
 		for (Character ch2 : list) {
 			output=output+ch2;
		}
 		
		System.out.println(unique);
		System.out.println(dup);
		System.out.println("Unique Characters :"+output);
	}

}
