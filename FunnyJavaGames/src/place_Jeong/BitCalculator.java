package place_Jeong;

import java.util.Scanner;

public class BitCalculator {
	public static void main(String[] args) {
		new BitCalculator();
	}
	
	private Scanner sc = new Scanner(System.in);
	
	public BitCalculator() {
		while(true){
			System.out.print("출력할 비트의 길이를 입력하세요 : ");
			int no = sc.nextInt();
			System.out.println("결과 값 : "+caculate(no));	
		}
	}
	
	private long caculate(int length){
		long bit = 1;
		for (int i = 1; i < length; i++) {
			long no=1;
			for (int j = i; j < length; j++) {
				no = no * 2;
			}
			
			bit += no;
		}
		return bit;
	}
}
