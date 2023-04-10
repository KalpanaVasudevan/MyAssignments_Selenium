package org.system;


public class Desktop extends Computer{

	public void desktopSize()
	{
		System.out.println("My desktop size is 24inch");
	}
	
	public static void main(String[] args) {
		// single inheritance concept
		Desktop ds = new Desktop();
		ds.computerModel();
		ds.desktopSize();
	}
}
