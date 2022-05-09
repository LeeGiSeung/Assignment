package week10;

public class kumho extends Tire{
	public kumho(String location, int maxRotation) {
		super(location,maxRotation);
	}
	
	public boolean roll() {
		++accRotation;
		
		if(accRotation<maxRatation) {
			System.out.println(location +"금호 타이어 남은 수명 : "+(maxRatation-accRotation));
			return true;
		}
		
		else {
			System.out.println(location+"금호 타이어 펑크");
			return false;
		}
		
	}

}
