package Portune;

import java.io.File;

public class Pcontrol {

	public static void main(String[] args) {
		new Pcontrol();
	}

	Pview view;
	Pmodel model;
	Character character = new Character("정정원");

	public Pcontrol() {
		view = new Pview();
		model = new Pmodel();
		view.textView("=== 포춘쿠키뽑기 앱에 오걸 환영한다===");

		int mainChoice;
		do {
			mainChoice = view.mainMenu();
			action(mainChoice);
		} while (mainChoice <= view.menu.length - 1);
		view.textView("시스템 종료");
		System.exit(1);
	}

	public void action(int mainChoice) {
		switch (mainChoice) {
		//포춘쿠키 뽑기
		case ActionNum.PICK:
			pick();
			break;

		//포춘쿠키 불러오기
		case ActionNum.LOAD:
			load();
			break;
		}
	}

	// 컨트롤러 메소드
	public void pick() {
		Bean loads = model.fileLoad();
		String[] a = model.chooseBean(loads);
		view.chooseView(a);
		int secondChoice = view.secondView();

		switch (secondChoice) {
		case ActionNum.SAVE:
			if (model.save(character, a) == true) {
				view.textView("저장에 성공");
			}
			break;
		case ActionNum.AGAIN:
			pick();
			break;
		}
	}

	public void load() {
		if( model.load(character)[0] != null ) {
			view.myFortune( model.load(character) );
		}else{
			view.textView("포춘쿠키를 먼저 뽑아주세요");
		}
	}
}
