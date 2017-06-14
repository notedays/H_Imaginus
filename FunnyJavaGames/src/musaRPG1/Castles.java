package musaRPG1;

import java.util.ArrayList;
import java.util.List;

public enum Castles {
	// 주요 성(100~199) 
	JOENJU_SUNG(100, 1, "전주성", "교통의 요지, 전주를 방어하는 성", 50, 100, 20, 1, new ArrayList<Companion>()),
	DONGRAE_SUNG(101, 1, "동래성", "해상교역의 중심, 부산을 방어하는 성", 50, 100, 20, 1, new ArrayList<Companion>()),
	PUSAN_SUNG(102, 1, "부산성", "해상교역의 중심, 부산을 방어하는 성", 50, 100, 20, 1, new ArrayList<Companion>()),
	MASAN_SUNG(103, 1, "마산성", "해상교역의 중심, 부산을 방어하는 성", 50, 100, 20, 1, new ArrayList<Companion>());
	
	private int code;
	private int level;
	private String name;
	private String explanation;
	private int attack;
	private int defense;
	private int accomodate;	//병사 수용가능한 숫자
	private int value; 
	public List<Companion> cattleCompanionList;
	
	private Castles(int code, int level, String name, String explanation, int attack, int defense, 
			int accomodate, int value, List<Companion> cattleCompanionList){
		this.code = code;
		this.level = level;
		this.name = name;
		this.explanation = explanation;
		this.attack = attack;
		this.defense = defense;
		this.accomodate = accomodate;
		this.value = value;
		this.cattleCompanionList = cattleCompanionList;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getExplanation() {
		return explanation;
	}

	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public int getAccomodate() {
		return accomodate;
	}

	public void setAccomodate(int accomodate) {
		this.accomodate = accomodate;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getLevel() {
		return level;
	}

	
	
}
