package 자료구조중간고사;

public class Node {
	Object data;
	Node link;
	
	void print(Node p) 
		{ while (p!= null) {
			System.out.print(p.data +" ->");
			p = p.link;
		}
		System.out.print("null");
		
	}
	
	public static void main(String[] args) {
		
		Node l = new Node();
		
		l.data = "Kim","af";
		l.link = null;
		
		Node temp = new Node();
		
		temp.data = "GU";
		l.link = temp;
		
		Node temp1 = new Node();
		
		temp1.data = "JU";
		temp.link = temp1;
		
		Node temp2 = new Node();
		
		temp2.data = "Park";
		temp1.link = temp2;
		temp2.link = null;
		
		l.print(l);
	}

}
