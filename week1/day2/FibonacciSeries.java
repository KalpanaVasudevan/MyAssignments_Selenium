package week1.day2;

public class FibonacciSeries {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int inputRange=8;
		int firstNumber=0;
		int secondNumber=1;
		int sum;

		for (int i = 1; i <=inputRange; i++) {

			System.out.println(firstNumber);
			sum=firstNumber+secondNumber;
			firstNumber=secondNumber;
			secondNumber=sum;
			//System.out.println(sum);
		}
				
		
	}
	
}
