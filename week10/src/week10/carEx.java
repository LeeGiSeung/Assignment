package week10;

public class carEx {
	public static void main(String[] args) {
		car car = new car();
		for(int i = 0; i<30; i++) {
			int flat = car.run();
			if(flat == 1) {
				System.out.println("한국타이어로 교체");
				car.frontLeft = new Hankook("앞왼쪽", 15);
			}
			
			else if(flat == 2) {
				System.out.println("한국타이어로 교체");
				car.frontRight = new Hankook("앞오른쪽", 15);
			}
			
			else if(flat == 3) {
				System.out.println("금호타이어로 교체");
				car.frontRight = new kumho("뒤오른쪽", 15);
			}
			
			else if(flat == 4) {
				System.out.println("금호타이어로 교체");
				car.frontRight = new kumho("뒤오른쪽", 15);
			}
			System.out.println("-----------------------");
		}
	
	}

}
