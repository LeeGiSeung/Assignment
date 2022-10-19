package 자료구조중간고사;

public class Sumcompute {
	
	public void sum(int x, int y) {
		System.out.println("두 값의 합은 : "+(x+y));
	}
	
	public void sum(double x, double y) {
		System.out.println("두 값의 합은 : "+(x+y));
	}
	
	public static void main(String[] args) {
		
		Sumcompute my = new Sumcompute();
		
		my.sum(5, 4);
		my.sum(3.241, 5.158);
		
		
	}

}
