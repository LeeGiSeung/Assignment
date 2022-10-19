import java.util.Random;

public class Score {
	

		public int STno = 0;
		public int lan = 0;
		public int math = 0;
		public int size = 0;
		public float lan_avg = 0;
		public float math_avg = 0;
		public int sum = 0;
		
		int[][] L = new int[4][3]; 
		
		public void insert(int STno, int lan, int math) {
			L[size][0] = STno;
			L[size][1] = lan;
			L[size][2] = math;
			size++;

		}
		
		public void print() {
//			국어점수
			for(int i = 0; i<L.length; i++) {
					sum += L[i][1];
			}
			lan_avg = sum/(L.length-1);
			
			sum = 0;
			
			for(int i = 0; i<L.length; i++) {
				sum += L[i][2];
			}
			math_avg = sum/(L.length-1);
			
			System.out.println("*** Score 리스트 ***");
			System.out.println("학번 \t국어 \t수학");
			System.out.println();
			for(int i=0; i<L.length; i++) {
				for(int x=0; i<L[i].length; i++) {
					System.out.print(L[i][0]+"\t");
					System.out.print(L[i][1]+"\t");
					System.out.print(L[i][2]+"\t");
					System.out.println();
				}
				System.out.println();
			}
			
			System.out.print("국어 평균 : "+ lan_avg);
			System.out.println();
			System.out.print("수학 평균 : "+ math_avg);
			
		}
		
	
	
	public static void main(String[] args) {
		Score sc = new Score();
		Random r = new Random();
		
		
		sc.insert(1001, r.nextInt(100), r.nextInt(100));
		sc.insert(1002, r.nextInt(100), r.nextInt(100));
		sc.insert(1003, r.nextInt(100), r.nextInt(100));
		
		sc.print();
		
	}
}

