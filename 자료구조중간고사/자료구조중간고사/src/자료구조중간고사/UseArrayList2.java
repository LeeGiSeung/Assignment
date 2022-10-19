package 자료구조중간고사;

public class UseArrayList2 {
	
	static void print(int[] a, char ch) {
		for(int i = 0; i<a.length; i++) {
			System.out.print(ch+"["+i+"] = "+a[i]+" ");
			System.out.println();
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int[] a = {5,1,23,5,1};
		int[] b = {6,8,1,0,3};
		int[] c = new int[5];
		
		print(a,'a');
		print(b,'b');
		
		for(int i = 0; i<a.length; i++) {
			c[i] = a[i] + b[i];
		}
		
		print(c,'c');
		
	}

}
