package 자료구조중간고사;
import java.util.Scanner;

public class Node2 {
	
	Object data;
	Node2 link;
	
	void build() {
		Scanner sc = new Scanner(System.in);
		Node2 p = null, end, temp;
		end = p;
		System.out.println("자료를 입력하세요");
		System.out.println("입력 마침 문자 ----[*]");
		while(true) {
			String x = sc.next();
			
			if(x.equals("*")) {
				break;
			}
			temp = new Node2();
			temp.data = x;
			
			if(p==null) {
				p = temp;
				end = p;
			}
			else
			{
				end.link = temp;
				end = temp;
			}
			
			System.out.println("리스트 출력");
			display(p);
		}
	}
		
		
		void display(Node2 p) {
			if(p!=null) {
				System.out.print(p.data+"->");
				display(p.link);
			}
//			else {
//				System.out.println("null");
//			}
			System.out.println();
		
	}
	
	
	public static void main(String[] args) {
		Node2 list = new Node2();
		list.build();
	}
}
