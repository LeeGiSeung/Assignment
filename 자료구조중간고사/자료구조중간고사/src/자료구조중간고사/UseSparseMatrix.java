package 자료구조중간고사;
import java.util.Random;

public class UseSparseMatrix {

	
	static class superMartix{
		int[][] a = new int[10][10];
		int[][] b = new int[10][3];
		int n,m,size,k = 0;
		
		void init(int x, int y, int z) {
			a[x][y] = z;
			size++; //나중에 b행렬 print할때 n값으로 받는거임
		}
		
		void makeSpecialArray() {
		
			for(int i = 0; i<a.length; i++) {
				for(int o = 0; o<a[i].length; o++) {
					if(a[i][o] !=0) {
						b[k][0] = i;
						b[k][1] = o;
						b[k][2] = a[i][o];
						k++;
					}
//					a[i][o] = 0; 어차피 0다 들어가있어서 안해줘도 될듯?
				}
				
			}
		}
		
		void display(int[][] a,int n) {
			for(int i = 0; i<n; i++) {
				for(int x = 0; x<a[i].length; x++) {
					System.out.print(a[i][x]+"\t");
				}
				System.out.println();
			}
			System.out.println();
		}
		
		
		
	}
	
	public static void main(String[] args) {
		
		Random r = new Random();
		superMartix sm = new superMartix();
		
		sm.init(9, 9, r.nextInt(100));
		sm.init(5, 1, r.nextInt(100));
		sm.init(8, 5, r.nextInt(100));
		sm.init(1, 3, r.nextInt(100));
		
		sm.makeSpecialArray();
		
		sm.display(sm.a,10);
		sm.display(sm.b,sm.size);
		
	}

}
