package �ڷᱸ���߰����;
import java.util.Scanner;

public class Ŭ�������� {
	
	String name;
	int no;
	int depart;
	int tel;
	
	public void studying(String name) {
		System.out.println(name+"�̴� ���θ� �� ������ �ϴ±���");
	}
	
	public void depart(int depart) {
		System.out.println("���� �а� ��ȣ�� "+depart+"����");
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Ŭ�������� cs = new Ŭ��������();
		System.out.println("���� �̸��� ����?");
		cs.name = sc.next();
		System.out.println("���� �а���ȣ�� ����?");
		cs.depart = sc.nextInt();
		
		cs.studying(cs.name);
		cs.depart(cs.depart);
		
		sc.close();
	}

}
