package �ڷᱸ���߰����;

//�˰����� �ܺο��� �����ϴ� 0�� �̻��� �Է��� �����ؾ� �Ѵ�.
//�˰����� �ּ��� �ϳ��̻��� ��� ����� �����ؾ� �Ѵ�
//�˰����� ������ �ܰ�� ������ �����ϰ� ��Ȯ�ϰ� ���ؾ� �Ѵ�. �� ��ɾ ��Ȯ�ϰ� �ָŸ�ȣ���� �ʾƾ� �Ѵ�.
//�˰������� ������ �ܰ踦 ��ģ �� �ݵ�� �����ؾ� �Ѵ�.
//��� ��ɾ�� ȿ�������� ���� �����ؾ� �Ѵ�.

public class SuperClass {
	int sum = 0;
	
	//�ݺ����� �ݺ����� �����
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
