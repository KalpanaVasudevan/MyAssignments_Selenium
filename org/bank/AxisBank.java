package org.bank;

public class AxisBank extends BankInfo{
	
	public void deposit()
	{
		System.out.println("Deposited amount is: 2lakh");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AxisBank axis = new AxisBank();
		axis.deposit();
		axis.saving();
		axis.fixed();
	}

}
