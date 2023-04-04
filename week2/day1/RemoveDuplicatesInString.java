package week2.day1;

public class RemoveDuplicatesInString {

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
		
		String text = "We learn java basics as part of java sessions in java week1";	
		
		int count=0;
		String temp=" ";
		
		
		String[] split = text.split(" ");
		
		for (int i = 0; i < split.length; i++) {
			
			for (int j = i+1; j < split.length; j++) {
				
				if (split[i].equals(split[j])) {
					temp=split[i];
					count++;
				}
			}
			

		    }
		if(count>1)
		{
			System.out.println(text.replace(temp, " "));
			
		}
	}

}
