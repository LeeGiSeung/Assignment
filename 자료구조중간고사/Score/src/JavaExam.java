import java.util.Random;
import java.util.*;

public class JavaExam {
	
	int size = 0;
	int[] STno_score = new int[5];
	int[] Lan_score = new int[5];
	int[] math_score = new int[5];
	
	public void Score(int STno, int lan, int math) {
		
		STno_score[size] = STno;
		Lan_score[size] = lan;
		math_score[size] = math;
		size++;
		
		Object data;
		JavaExam link;
		
		JavaExam L = null,temp,end;
		end = L;
		
		int no = STno_score.length;
		
		for(int i = 0; i<no; i++) {
			JavaExam STno1 = new JavaExam(); 
			temp
		}
		
		
	}
	
	
	public static void main(String[] args) {
		Random r = new Random();
		JavaExam sc = new JavaExam();
		
		sc.Score(1001, r.nextInt(100), r.nextInt(100));
		sc.Score(1002, r.nextInt(100), r.nextInt(100));
		sc.Score(1003, r.nextInt(100), r.nextInt(100));
		sc.Score(1004, r.nextInt(100), r.nextInt(100));
		sc.Score(1005, r.nextInt(100), r.nextInt(100));
	}
}
