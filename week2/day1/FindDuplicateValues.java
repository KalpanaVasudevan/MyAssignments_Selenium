package week2.day1;

public class FindDuplicateValues {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int[] nums= {2,5,7,7,5,9,2,3};
		
		System.out.println("Duplicate Values Are: ");
		
		
		for (int i = 0; i < nums.length; i++) {
			
			for (int j = i+1; j < nums.length; j++) {
				
				if (nums[i]==nums[j]) {
					System.out.println(nums[i]);
					
				}
			}
			
		}
	}

}
