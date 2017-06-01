package place_Share;

public class ListTest<T extends String> {
//	public static void main(String[] args) {
//		new ListTest();
//	}
	
	T[] array;
	public ListTest() {
		array = (T[]) new Object[10];
	}
	
	public void add(T obj){
		int index = findEmptyIndex();
		if( index == -1 ) return ;
		array[index] = obj;
	}
	private int findEmptyIndex(){
		for (int i = 0; i < array.length; i++) {
			if( array[i] == null ) return i;
		}
		return -1;
	}
	
	public T get(int index){
		return array[index];
	}
}
