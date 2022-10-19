package 자료구조중간고사;

//알고리즘은 외부에서 제공하는 0개 이상의 입력이 존재해야 한다.
//알고리즘은 최소한 하나이상의 출력 결과를 생성해야 한다
//알고리즘은 수행할 단계와 순서를 완전하고 명확하게 명세해야 한다. 각 명령어가 명확하고 애매모호하지 않아야 한다.
//알고리ㅏ즘은 유한한 단계를 거친 후 반드시 종료해야 한다.
//모든 명령어는 효율적으로 실행 가능해야 한다.

public class SuperClass {
	int sum = 0;
	
	//반복적인 반복으로 만들기
	int computeSum(int n){
		for(int i = 0; i<=n; i++) {
			sum +=i;
		}
		return sum;
	}
	
	int recSum(int n) {
		if(n==1) {
			return 1;
		}
		else
		{
			return (n+recSum(n-1));
		}
	}
	
	
	public static void main(String[] args) {
		SuperClass sp = new SuperClass();
		System.out.println(sp.computeSum(5));
		System.out.println(sp.recSum(5));
	}
	
}
