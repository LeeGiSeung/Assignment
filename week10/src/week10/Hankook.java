package week10;

public class Hankook extends Tire {
	public Hankook(String location, int maxRotation) {
		super(location, maxRotation);
	}
	
	
	public boolean roll() {
		++accRotation;
		
		if(accRotation<maxRatation) {
			System.out.println(location +"�ѱ� Ÿ�̾� ���� ���� : "+(maxRatation-accRotation));
			return true;
		}
		
		else {
			System.out.println(location+"�ѱ� Ÿ�̾� ��ũ");
			return false;
		}
		
	}
	
}
