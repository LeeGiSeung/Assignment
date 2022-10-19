package 자료구조중간고사;

public class UseNode {
	
	class Node{
		Object data;
		Node link;
		void build() {
			Node L = null,temp,end;
			end = L;
			String[] Data = {"kim","yeor","werk"};
			int no = Data.length;
			for(int i=0; i<no; i++) {
				temp = new Node();
				temp.data = Data[i];
				if(L==null) {
					L=temp;
					end=L;
				}
				else {
					end.link = temp;
					end = temp;
				}
				System.out.println("*** 리스트 L 출력***");
				L.print(L);
			}
		}
		
		void print(Node p) {
			{
				while (p!= null) {
					System.out.println(p.data+" ->");
					p = p.link;
				}
			}
			System.out.println("null");
		}
		
		
		
	}
	
	public static void main(String[] args) {
		UseNode obj = new UseNode();
		obj.build();
	}
}
