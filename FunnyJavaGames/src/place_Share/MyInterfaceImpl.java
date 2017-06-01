package place_Share;

public class MyInterfaceImpl implements MyInterface{

	@Override
	public void makeJukchang() {
		System.out.println("죽창을 신나게 깍아보자~~");
	}

	@Override
	public void attack() {
		System.out.println("참다 참다 찌른다 시바");
	}
	
	public void cancel(){
		System.out.println("아 그래도 함만 더 참아보자 ");
	}
}
