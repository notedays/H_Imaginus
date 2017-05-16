package place_Lim;

class Animal {
	String naaa = "ssss";
	String name;
	String a = "동물 울음소리는";
	void hear(){
		System.out.println(a);
	}
}

class Mouse extends Animal {
	public Mouse(String name){
		super.name = name;
	}
	void hear(){
		System.out.println(name+"의 울음소리 입니다.");
	}
}

class cow {
}

public class Test {
	public static void main(String[] args) {
		Animal ssss = new Mouse("호랑이");
		ssss.hear();
		System.out.println(ssss.naaa);
	}
}
