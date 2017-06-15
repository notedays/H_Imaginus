package musaRPG1;

import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.CachedRowSet;

public enum Castles {
	// 주요 성(100~199) 
	JOENJU_SUNG(100, 1, "전주성", "교통의 요지, 전주를 방어하는 성", 5, 100, 20, 1, 10, 10, new ArrayList<Companion>()),
	DONGRAE_SUNG(101, 1, "동래성", "해상교역의 중심, 부산을 방어하는 성", 5, 100, 20, 1, 100, 100, new ArrayList<Companion>()),
	PUSAN_SUNG(102, 1, "부산성", "해상교역의 중심, 부산을 방어하는 성", 5, 100, 20, 1, 100, 100, new ArrayList<Companion>()),
	MASAN_SUNG(103, 1, "마산성", "해상교역의 중심, 부산을 방어하는 성", 5, 100, 20, 1, 100, 100, new ArrayList<Companion>());
	
	private int code;
	private int level;
	private String name;
	private String explanation;
	private int attack;
	private int defense;
	private int accomodate;	// 병사 수용가능한 숫자
	private int value; 
	private int castleHp;
	private int castleMaxHp;
	public List<Companion> cattleCompanionList;
	
	private Castles(int code, int level, String name, String explanation, int attack, int defense, 
			int accomodate, int value, int castleHp, int castleMaxHp, List<Companion> cattleCompanionList){
		this.code = code;
		this.level = level;
		this.name = name;
		this.explanation = explanation;
		this.attack = attack;
		this.defense = defense;
		this.accomodate = accomodate;
		this.value = value;
		this.castleHp = castleHp;
		this.castleMaxHp = castleMaxHp;
		this.cattleCompanionList = cattleCompanionList;
	}
	
	//추가 메소드
	public boolean getDamaged(int damage){
		if(castleHp - damage <= 0){
			castleHp = 0;
			return true;
		}else{
			castleHp -= damage;
			System.out.println(damage+"만큼 성이 데미지 입음");
			System.out.println("남은 성의 Hp는 "+ castleHp);
			return false;
		}
	}
	
	//getter, setter 설정
	public void setLevel(int level) {
		this.level = level;
	}


	public int getCastleMaxHp() {
		return castleMaxHp;
	}

	public void setCastleMaxHp(int castleMaxHp) {
		this.castleMaxHp = castleMaxHp;
	}

	public int getCastleHp() {
		return castleHp;
	}

	public void setCastleHp(int castleHp) {
		this.castleHp = castleHp;
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
