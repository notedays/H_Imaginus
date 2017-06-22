package Portune;

import java.util.Scanner;

public class Pview {

	Scanner sc = new Scanner(System.in);

	void textView(String text) {
		System.out.println(text);
	}

	public final static String[] menu = { "포춘쿠키 뽑기", "불러오기", "앱 종료" };

	int mainMenu() {
		for (int i = 1; i <= menu.length; i++) {
			System.out.println(i + ". " + menu[i - 1]);
		}
		return inputNumber(menu.length);
	}

	public int inputNumber(int maxNum) {
		int i = -1;
		do {
			try {
				System.out.print("원하는 번호를 입력해라: ");
				i = sc.nextInt();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				sc.nextLine();
			}
		} while (i < 1 || i > maxNum);
		return i;
	}

	public void chooseView(String[] a) {
		for (int i = 0; i < 5; i++) {
			System.out.println((i + 1) + ". " + a[i]);
		}
		System.out.println("포춘쿠키 5개를 뽑았다");
	}

	public int secondView() {
		String[] name = { "저장하기", "다시뽑기" };
		for (int i = 1; i <= name.length; i++) {
			System.out.println(i + ". " + name[i - 1]);
		}return inputNumber(name.length);
	}
	
	public void myFortune(String[] a){
		for(int i=0; i< a.length; i++){
			System.out.println( (i + 1) +". "+ a[i]);
		}
		System.out.println("내가 뽑은 포춘쿠키를 불러왔다");
	}
}
