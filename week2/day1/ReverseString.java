package week2.day1;

public class ReverseString {

	private static char[] charArray;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		String input="KALPANA";
		
		char[] ch = input.toCharArray();
		int len=input.length();
		
		for (int i = len-1; i >=0; i--) {
			
			System.out.println(ch[i]);
		}
	}

}
