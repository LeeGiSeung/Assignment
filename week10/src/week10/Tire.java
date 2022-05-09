package week10;

public class Tire {
	public String location; //타이어 위치
	public int maxRatation; //최대 회전수
	public int accRotation; //누적 회전수
	
	public Tire(String location, int maxRatation) {
		this.location = location;
		this.maxRatation = maxRatation;
	}
	
	public boolean roll() {
		++accRotation;
		
		if(accRotation<maxRatation) {
			System.out.println(location +"남은 수명 : "+(maxRatation-accRotation));
			return true;
		}
		
		else {
			System.out.println(location+"타이어 펑크");
			return false;
		}
	
	
	}
		
		
}
