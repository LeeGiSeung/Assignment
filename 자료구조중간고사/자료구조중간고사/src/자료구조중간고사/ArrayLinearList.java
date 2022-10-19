package 자료구조중간고사;

public class ArrayLinearList {

	private int no;
	private int size;
	private int increment;
	private int[] itemList;
	
	public ArrayLinearList() {
		no = -1;
		size = 50;
		increment = 10;
		itemList = new int[size];
	}
	
	public void insert(int x) {
		int pos = 0;
		if(no == size-1) {
			size += increment;
			int[] tempArray = new int[size];
			for(int i = 0; i<=no; i++) {
				tempArray[i] = itemList[i];
			}
			itemList = tempArray;
		}
		
		if(no ==-1) {
			no++;
			itemList[no] = x;
		}
		
		else
		{
			for(int i = 0; i<=no; i++) 
				if(x>itemList[i])
					pos++;
			for(int i = no+1; i> pos; i--)
				itemList[i] = itemList[i-1];
			itemList[pos] = x;
			no++;
			
			
		}
		
	}
	
	public static void main(String[] args) {
		

	}

}
