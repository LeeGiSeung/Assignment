package midterm;

public class Pet {
	String type;
	int age;
	int leg;
	
	
	Pet(String type, int age){
		this.type = type;
		this.age = age;
		if(type == "고양이"||type == "강아지") {
			this.leg = 4;
		}
		else if(type == "새") {
			this.leg = 2;
		}
		
		
	}

}


package midterm;

public class PetEX {
	public static void main(String[] args) {
		Pet dog = new Pet("강아지",8);
		Pet cat = new Pet("고양이",13);
		Pet bird = new Pet("새",6);
		
		System.out.printf("%s는 %d개월 입니다.\n",dog.type,dog.age);
		System.out.printf("%s는 %d개월 입니다.\n",cat.type,cat.age);
		System.out.printf("%s는 %d개월 입니다.\n",bird.type,bird.age);
		
		System.out.println();
		
		System.out.printf("%s 다리는 %d개 입니다.\n",dog.type,dog.leg);
		System.out.printf("%s 다리는 %d개 입니다.\n",cat.type,cat.leg);
		System.out.printf("%s 다리는 %d개 입니다.\n",bird.type,bird.leg);
	}
}
