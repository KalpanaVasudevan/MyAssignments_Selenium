package week3.day2;

public class Samsung extends AndroidTV{
	
	public void playVideo() {
		// TODO Auto-generated method stub
		System.out.println("Playing video from Concrete Class");
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Samsung ss = new Samsung();
		ss.openApp();
		ss.playVideo();
		
	}

	
	

}
