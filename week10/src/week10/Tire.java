package week10;

public class Tire {
	public String location; //Ÿ�̾� ��ġ
	public int maxRatation; //�ִ� ȸ����
	public int accRotation; //���� ȸ����
	
	public Tire(String location, int maxRatation) {
		this.location = location;
		this.maxRatation = maxRatation;
	}
	
	public boolean roll() {
		++accRotation;
		
		if(accRotation<maxRatation) {
			System.out.println(location +"���� ���� : "+(maxRatation-accRotation));
			return true;
		}
		
		else {
			System.out.println(location+"Ÿ�̾� ��ũ");
			return false;
		}
	
	
	}
		
		
}
