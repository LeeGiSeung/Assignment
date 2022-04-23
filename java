package week7;

import java.security.DrbgParameters.NextBytes;
import java.util.Scanner;

public class midterm1 {
	public static void main(String[] args) {
		
		boolean run = true;
		int sum = 0;
		String scoreList = "";
		int [] array = {};
		int min = 0;
		int max = 0;
		
		Scanner sc = new Scanner(System.in);
		int count = 0;
		int student = 0;
		int stu_count = 0;
		
		while(run) {
			System.out.println("-----------------------------------------------");
			System.out.println("1.학생수 | 2.점수 입력 | 3. 점수리스트 | 4.분석 | 5.종료");
			System.out.println("-----------------------------------------------");
			System.out.print("선택 : ");
			int choice = sc.nextInt();
			
			if(choice == 1) {
				System.out.printf("학생수를 입력하세요 : ");
				student = sc.nextInt();
				array = new int [student];
			}
			
			
			else if(choice == 2) {
				for(int y = 0; y<student; y++) {
				System.out.print("점수 입력 : ");
				int score = sc.nextInt();
				array[y] = score;
				}
			}
			
			else if(choice == 3) {
				System.out.println(scoreList);
				System.out.print("점수 리스트 : ");
				for(int i = 0; i<array.length; i++) {
					System.out.print(array[i]+" ");
				}
				System.out.println();
			}
			
			else if(choice == 4) {
				for(int i = 0; i<array.length-1; i++) {
					
					if(array[i]==array.length)
						break;
					
					else if(array[i]<array[i+1]) { 
						min = array[i];
						max = array[i+1];
					}
					
					else if(array[i]>array[i+1]) {
						min = array[i+1];
						max = array[i];
					}

					
					}
				System.out.printf("최소 값 : %d\n최대 값 : %d\n",min,max);
			}
			
			else if(choice == 5) {
				System.out.println("프로그램을 종료합니다.");
				run = false;
			}
			
			
			
			}
		
		
		}
	
	
}
//자바 연습문제 6
