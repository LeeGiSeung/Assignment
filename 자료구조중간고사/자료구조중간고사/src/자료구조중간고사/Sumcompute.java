package �ڷᱸ���߰����;

public class Sumcompute {
	
	public void sum(int x, int y) {
		System.out.println("�� ���� ���� : "+(x+y));
	}
	
	public void sum(double x, double y) {
		System.out.println("�� ���� ���� : "+(x+y));
	}
	
	public static void main(String[] args) {
		
		Sumcompute my = new Sumcompute();
		
		my.sum(5, 4);
		my.sum(3.241, 5.158);
		
		
	}

}
