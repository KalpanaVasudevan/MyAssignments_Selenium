package week3.day1;

public class Students {
	
	public int getStudentInfo(int id)
	{
		return id;
	}
	
	public void getStudentInfo(int id,String name)
	{
		System.out.println("Student id is: "+id+" Student name is: "+name);
		
	}
	
	public void getStudentInfo(String email,int phone)
	{
		System.out.println("Phone number is: "+phone+" emailid is: "+email);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Students student = new Students();
		int studentId = student.getStudentInfo(100500);
		System.out.println("Student id is: "+studentId);
		
		student.getStudentInfo(100300, "kalpana");
		
		student.getStudentInfo("kalpana.kripa@gmail.com", 100600);
		
	}
	
	
}
