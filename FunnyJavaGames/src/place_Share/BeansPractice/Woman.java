package place_Share.BeansPractice;

/* VO (Value Object) 또는 Beans(콩알(변수)의 집합)
 * 
 */

public class Woman {
	// # private 으로 변수를 선언 하는 이유?!
	// --> 데이터의 꼬임을 방지하기 위해서( 외부에서 직접 변수를 컨트롤 할 수 없도록 )
	private String name; //
	private int age;
	private int attractive;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		if(age<1) age=1;
		this.age = age;
	}
	public int getAttractive() {
		return attractive;
	}
	public void setAttractive(int attractive) {
		this.attractive = attractive;
	}
	
	
}
