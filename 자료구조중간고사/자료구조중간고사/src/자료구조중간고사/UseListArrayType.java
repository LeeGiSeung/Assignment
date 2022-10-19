package 자료구조중간고사;
import java.util.Arrays;

public class UseListArrayType {

	public static void main(String[] args) {
		
		int i;
		int[] L  = {1,2,3,4,5};
		
		System.out.print("L = ");
		for(i = 0; i<L.length; i++) {
			System.out.print(L[i]+" ");
		}
		
		System.out.println();
		System.out.println("L 배열 = "+Arrays.toString(L));

	}

}


