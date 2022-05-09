package week10;

public class SonicAirplane extends Airplane {
	
	
	public static final int Normal =1;
	public static final int SUPERSONIC =2;
	
	int flymode = Normal;
	
	int soundSpeed;
	int maxSpeed;
	
	public void fly() {
		if(flymode == SUPERSONIC) 
			System.out.println("음속비행");
		else 
			super.fly();
	}
	int getSoundSpeed() {
		return soundSpeed;
	}

}
