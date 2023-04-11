package week3.day2;

public class Automation extends MultipleLanguage implements Language,TestTool{

	

	public void selenium() {
		// TODO Auto-generated method stub
		System.out.println("Selenium is webbased opensource automation tool");
		
	}

	public void java() {
		// TODO Auto-generated method stub
		System.out.println("Java is the #1 language to automate using selenium ");
	}

	public void ruby() {
		// TODO Auto-generated method stub
		System.out.println("Ruby is one of the programming language to automate using selenium");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Automation automate = new Automation();
		automate.selenium();
		automate.java();
		automate.python();
		automate.ruby();
		
	}
	

}
