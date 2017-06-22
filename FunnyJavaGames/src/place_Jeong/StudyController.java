package place_Jeong;

public class StudyController {
	public static void main(String[] args) {
		new StudyController();
	}
	
	StudyView view;
	StudyModel model;
	
	public StudyController() {
		view = new StudyView();
		model = new StudyModel();
		
		int money = model.receiveMoney();
		if( money <= 0 ){
			view.showText("Success");
		}else{
			view.showText("fail");
		}
	}
}

