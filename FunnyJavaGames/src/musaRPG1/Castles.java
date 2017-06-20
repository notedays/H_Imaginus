package musaRPG1;

import java.util.ArrayList;
import java.util.List;

public enum Castles {
	// 주요 성(100~199)
	JOENJU_SUNG(100, 1, "전주성", "교통의 요지, 전주를 방어하는 성", 1, 100, 0, 5, 1, 10, 10,
			new ArrayList<Companion>(), new ArrayList<GoldGenerator>(), new ArrayList<FoodGenerator>()),
	DONGRAE_SUNG(101, 1, "동래성", "해상교역의 중심, 부산을 방어하는 성", 1, 100, 0, 5, 1, 100, 100,
			new ArrayList<Companion>(), new ArrayList<GoldGenerator>(), new ArrayList<FoodGenerator>()), 
	PUSAN_SUNG(102, 1, "부산성", "해상교역의 중심, 부산을 방어하는 성", 1, 100, 0, 5, 1, 100, 100,
			new ArrayList<Companion>(), new ArrayList<GoldGenerator>(), new ArrayList<FoodGenerator>()),
	MASAN_SUNG(103, 1, "마산성", "해상교역의 중심, 부산을 방어하는 성", 1, 100, 0, 5, 1, 100, 100,
			new ArrayList<Companion>(), new ArrayList<GoldGenerator>(), new ArrayList<FoodGenerator>());

	private int code;
	private int level;
	private String name;
	private String explanation;
	private int attack;
	private int defense;
	private int nowCount; // 현재 병사 수용 수
	private int maxCount; // 병사 수용 가능한 숫자
	private int value;
	private int castleHp;
	private int castleMaxHp;
	public List<Companion> cattleCompanionList;
	public List<GoldGenerator> goldGeneratorList;
	public List<FoodGenerator> foodGeneratorList;
	
	private Castles(int code, int level, String name, String explanation, int attack, int defense, int nowCount,
			int maxCount, int value, int castleHp, int castleMaxHp, List<Companion> cattleCompanionList,
			List<GoldGenerator> goldGeneratorList, List<FoodGenerator> foodGeneratorList) {
		this.code = code;
		this.level = level;
		this.name = name;
		this.explanation = explanation;
		this.attack = attack;
		this.defense = defense;
		this.nowCount = nowCount;
		this.maxCount = maxCount;
		this.value = value;
		this.castleHp = castleHp;
		this.castleMaxHp = castleMaxHp;
		this.cattleCompanionList = cattleCompanionList;
		this.goldGeneratorList = goldGeneratorList;
		this.foodGeneratorList = foodGeneratorList;
	}

	// 추가 메소드
	public boolean getDamaged(int damage) {
		if (castleHp - damage <= 0) {
			castleHp = 0;
			return true;
		} else {
			castleHp -= damage;
			System.out.println(damage + "만큼 성이 데미지 입음");
			System.out.println("남은 성의 Hp는 " + castleHp);
			return false;
		}
	}

	public int addCount(int number) {
		if ( number <= (maxCount - nowCount)){
			nowCount += number;
			return nowCount;
			
		} else{
			return maxCount;
		}
	}

	// getter, setter 설정
	public void setLevel(int level) {
		this.level = level;
	}

	public int getNowCount() {
		return nowCount;
	}

	public int getMaxCount() {
		return maxCount;
	}

	public void setMaxCount(int maxCount) {
		this.maxCount = maxCount;
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
