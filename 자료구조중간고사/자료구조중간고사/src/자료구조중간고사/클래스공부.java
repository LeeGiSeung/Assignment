package 자료구조중간고사;
import java.util.Scanner;

public class 클래스공부 {
	
	String name;
	int no;
	int depart;
	int tel;
	
	public void studying(String name) {
		System.out.println(name+"이는 공부를 참 열심이 하는구나");
	}
	
	public void depart(int depart) {
		System.out.println("너의 학과 번호는 "+depart+"구나");
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		클래스공부 cs = new 클래스공부();
		System.out.println("너의 이름은 뭐니?");
		cs.name = sc.next();
		System.out.println("너의 학과번호는 뭐니?");
		cs.depart = sc.nextInt();
		
		cs.studying(cs.name);
		cs.depart(cs.depart);
		
		sc.close();
	}

}
