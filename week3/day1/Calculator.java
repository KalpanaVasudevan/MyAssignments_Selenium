package week3.day1;

public class Calculator {

//Method overload concept: Same function name with different no of input arguments and different return type
	
	//Add method with 2 integer no's
	public int add(int a,int b)
	{
		return a+b;	
	}
	
	//add method with 3 integer no's
	public int add(int a,int b,int c)
	{
		return a+b+c;
	}
	
	//multiplication method with 1int and 1 double argument
	public void mulitiplication(int a, double b)
	{
		
		int c=(int) (a*b);
		System.out.println(c);
	}
	
	//mulitiplication metho with 2 double arguments
	public double mulitiplication(double a,double b)
	{
		return a*b;
	}
	
	public static void main(String[] args)
	{
		Calculator calc= new Calculator();
		int c = calc.add(5, 5);
		System.out.println("Addition of two integer no's:"+c);
		
		int d = calc.add(10, 10, 10);
		System.out.println("Addition of three integer no's: "+d);
		
		calc.mulitiplication(10, 100);
		
		double mulitiplication = calc.mulitiplication(10.58,2.30);
		System.out.println("Mulitiplication of two double no's: "+mulitiplication);
		
		
	}
}
