package week3.day1;

public class Smartphone extends AndroidPhone{
	
	public void connectWhatsApp()
	{
		System.out.println("Connect to whatsapp");
	}
	
	public void takeVideo()
	{
		System.out.println("Take video from smartphone");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//sendMsg, makeCall, saveContact
		Smartphone smartphone = new Smartphone();
		smartphone.saveContact();
		smartphone.sendMsg();
		smartphone.makeCall();
		smartphone.takeVideo();
		smartphone.connectWhatsApp();
		
	}

	

}
