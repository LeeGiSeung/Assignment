package �ڷᱸ���߰����;
import java.util.Scanner;
import java.util.Random;


public class UseMatrix {

	int[][] a = new int[10][10];
	int[][] b = new int[10][10];
	int[][] c = new int[10][10];
	int no;
	int i;
	int j;
	
	public void randomArray() {
		Random r = new Random();
		for(int x = 0; x<=i; x++) {
			for(int y = 0; y<=j; y++) {
				a[x][y] = (int)(r.nextDouble()*100);
				b[x][y] = (int)(r.nextDouble()*100);
			}	
		}
	}
	
	public void computeArray() {
		for(int x = 0; x<i; x++) {
			for(int y = 0; y<j; y++) {
				c[x][y] = a[x][y] + b[x][y];
			}
		}
	}
	
	public void ArrayPrint(int aa[][]) {
		for(int x = 0; x<i; x++) {
			for(int y = 0; y<j; y++) {
				System.out.print(aa[x][y]+"\t");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		UseMatrix us = new UseMatrix();
		
		System.out.printf("��� ���� ũ�� �Է� : ");
		us.i = sc.nextInt();
		us.j = sc.nextInt();
		
		us.randomArray();
		us.computeArray();
		
		System.out.println("***a ���");
		us.ArrayPrint(us.a);
		System.out.println("***b ���");
		us.ArrayPrint(us.b);
		System.out.println("***a �� b�� �� ���");
		us.ArrayPrint(us.c);
		
		sc.close();
		
	}
	
	
	
}
