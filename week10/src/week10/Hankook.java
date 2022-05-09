package week10;

public class Hankook extends Tire {
	public Hankook(String location, int maxRotation) {
		super(location, maxRotation);
	}
	
	
	public boolean roll() {
		++accRotation;
		
		if(accRotation<maxRatation) {
			System.out.println(location +"한국 타이어 남은 수명 : "+(maxRatation-accRotation));
			return true;
		}
		
		else {
			System.out.println(location+"한국 타이어 펑크");
			return false;
		}
		
	}
	
}
