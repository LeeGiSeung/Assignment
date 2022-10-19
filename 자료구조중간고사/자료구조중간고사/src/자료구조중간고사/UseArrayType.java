package 자료구조중간고사;

public class UseArrayType {
	
	static void print(int a[][], char ch) {
		for(int i = 0; i<a.length; i++) {
			for(int x = 0; x<a[i].length; x++) {
				System.out.print(ch+"["+i+"]"+"["+x+"] = "+a[i][x]);
				System.out.println();
			}
		}
		System.out.println();
	}
	
	
	public static void main(String[] args) {
		
		
		int[][] a = new int[2][2];
		int[][] b = {{3,2},{8,65}};
		
		print(a,'a');
		print(b,'b');
		
	}

}
