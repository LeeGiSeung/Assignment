package week10;

public class carEx {
	public static void main(String[] args) {
		car car = new car();
		for(int i = 0; i<30; i++) {
			int flat = car.run();
			if(flat == 1) {
				System.out.println("�ѱ�Ÿ�̾�� ��ü");
				car.frontLeft = new Hankook("�տ���", 15);
			}
			
			else if(flat == 2) {
				System.out.println("�ѱ�Ÿ�̾�� ��ü");
				car.frontRight = new Hankook("�տ�����", 15);
			}
			
			else if(flat == 3) {
				System.out.println("��ȣŸ�̾�� ��ü");
				car.frontRight = new kumho("�ڿ�����", 15);
			}
			
			else if(flat == 4) {
				System.out.println("��ȣŸ�̾�� ��ü");
				car.frontRight = new kumho("�ڿ�����", 15);
			}
			System.out.println("-----------------------");
		}
	
	}

}
