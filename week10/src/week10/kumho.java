package week10;

public class kumho extends Tire{
	public kumho(String location, int maxRotation) {
		super(location,maxRotation);
	}
	
	public boolean roll() {
		++accRotation;
		
		if(accRotation<maxRatation) {
			System.out.println(location +"��ȣ Ÿ�̾� ���� ���� : "+(maxRatation-accRotation));
			return true;
		}
		
		else {
			System.out.println(location+"��ȣ Ÿ�̾� ��ũ");
			return false;
		}
		
	}

}
