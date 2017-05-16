package place_Jeong;


/* # 상속 : 기존의 설계도(클래스) 에 내용을 추가한 설계도를 만드는 개념
 * 	- 방법 : class 이름 오른쪽에 extends 기존의 설계도 클래스명 
 * 	- 이 때, 기존의 설계도는(extends 기준 우측 클래스) 는 부모 클래스 / 확장 설계도는 자식 클래스 (extends 기준 좌측 클래스)라고 한다.
 * 	- Override : 부모 클래스에 명시된 메소드를 입맛대로 다시 재정의하는 것 
 */
public class ExtendsStudy {
	public static void main(String[] args) {
		BasicHouse house = new WhiteHouse();
		System.out.println("house 이름 : "+house.name);
		System.out.println("house 색깔 : "+house.color);
	}
}

class BasicHouse{
	String name = "기본 집";
	String color = "빨간 색";
}

// # 기존의 집에 컬러만 바꾼 집
class WhiteHouse extends BasicHouse{
	public WhiteHouse() {
		this.color = "하얀 색";
	}
}
