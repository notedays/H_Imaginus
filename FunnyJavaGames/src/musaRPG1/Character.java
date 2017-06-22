package musaRPG1;

import java.util.ArrayList;
import java.util.List;

public enum Character {
	MUHULE(1, 000, "무휼", "초급 의병장", 9, 5000, 0, 1, 10000, 10000, 10, 10, 10000, 100, true,
			new Inventory<Item>(), new ArrayList<Skill>(),
			new ArrayList<Castles>(), new ArrayList<Companion>()),
	
	ILJIMAE(1, 000, "일지매", "초급 의병장", 1, 5, 0, 100, 10000, 10000, 10, 10, 10000, 100, true,
			new Inventory<Item>(), new ArrayList<Skill>(),
			new ArrayList<Castles>(), new ArrayList<Companion>()),

	// 불속성 전직 캐릭터
	FIRE_MUSA(1, 100, "불꽃 무사", "불꽃의 힘을 가진 의병장", 11, 1000, 0, 1, 10000, 10000, 10, 10, 10000, 100, true,
			new Inventory<Item>(), new ArrayList<Skill>(),
			new ArrayList<Castles>(), new ArrayList<Companion>()),
	FLAME_MUSA(1, 200, "화염 무사", "화염의 힘을 가진 의병장", 21, 1500, 0, 1, 10000, 10000, 10, 10, 10000, 100, true,
			new Inventory<Item>(), new ArrayList<Skill>(),
			new ArrayList<Castles>(), new ArrayList<Companion>()),
	LAVA_MUSA(1, 300, "용암 무사", "용암의 힘을 가진 의병장", 31, 2000, 0, 1, 10000, 10000, 10, 10, 10000, 100, true,
			new Inventory<Item>(), new ArrayList<Skill>(),
			new ArrayList<Castles>(), new ArrayList<Companion>()),
	
	// 얼음속성 전직 캐릭터
	CHILL_MUSA(1, 400, "냉기 무사", "냉기의 힘을 가진 의병장", 11, 10, 0, 100, 100, 100, 10, 10, 10000, 100, true,
			new Inventory<Item>(), new ArrayList<Skill>(),
			new ArrayList<Castles>(), new ArrayList<Companion>()),
	ICE_MUSA(1, 500, "얼음 무사", "얼음의 힘을 가진 의병장", 21, 15, 0, 100, 100, 100, 10, 10, 10000, 100, true,
			new Inventory<Item>(), new ArrayList<Skill>(),
			new ArrayList<Castles>(), new ArrayList<Companion>()),
	GLACIER_MUSA(1, 600, "빙하 무사", "빙하의 힘을 가진 의병장", 31, 20, 0, 100, 100, 100, 10, 10, 10000, 100, true,
			new Inventory<Item>(), new ArrayList<Skill>(),
			new ArrayList<Castles>(), new ArrayList<Companion>());
	
	private final int code;	// 0: 무 속성, 1: 불 속성, 2: 얼음 속성 
	private int changeCode;	// 전직 코드
	private final String name;
	private String grade;
	private int level;
	private int attack;
	private int exp;
	private int maxExp;
	private int hp;
	private int maxHp;
	private int mp;
	private int maxMp;
	private int money;
	private int food;
	private boolean memory;	//전직 여부 확인, true = 전직안함, flase = 전직한 상태

	private final Inventory<Item> inventory;
	public List<Skill> skillList;
	public List<Castles> castles;
	public List<Companion> companionList;

	
	private Character(int code, int changeCode, String name, String grade, int level, int attack, int exp, int maxExp, int hp,
			int maxHp, int mp, int maxMp, int money, int food, boolean memory, Inventory<Item> inventory, List<Skill> skillList,
			List<Castles> castles, List<Companion> companionList){
		this.code = code;
		this.changeCode = changeCode;
		this.name = name;
		this.grade = grade;
		this.level = level;
		this.attack = attack;
		this.exp = exp;
		this.maxExp = maxExp;
		this.hp = hp;
		this.maxHp = maxHp;
		this.mp = mp;
		this.maxMp = maxMp;
		this.money = money;
		this.food = food;
		this.setMemory(memory);
		this.inventory = inventory;
		this.skillList = skillList;
		this.castles = castles;		
		this.companionList = companionList;
	}

	// # 추가 메소드	
	
	public void setLevel(int setLevel){
		this.level = setLevel;
	}
	
	public int getChangeCode() {
		return changeCode;
	}

	public void setChangeCode(int changeCode) {
		this.changeCode = changeCode;
	}

	public void getFood(int obtainFood){
		this.food += obtainFood;
	}
	
	public void getMoney(int obtainMoney){
		this.money += obtainMoney;
		
	}
	
	public boolean usdFood(int useFood){
		if(food >= useFood){
			this.food -= useFood;
			System.out.println("군량미 "+useFood+"만큼 사용");
			return true;
		}else{
			this.food = 0;
			System.out.println("군량미가 부족합니다, 퇴각합니다");
		}return false;
	}
	
	public void obtainCastle(Castles castle){
		castles.add(castle);
		System.out.println(castle.getName()+"을 획득했습니다");
	}
	
	public void obtainItem(Item item) {
		System.out.println(item + "획득");
		inventory.addItem(item);
	}

	public void battleWin(int exp, Item item) {
		this.exp += exp;
		System.out.println("현재 경험치: "+this.exp + "/" + "최대 경험치: "+maxExp);
		if (this.exp >= maxExp)
			levelUp();
		if (item != null) {
			System.out.println("\n아이템 [" + item.getName() + "] 을(를) 획득했습니다.");
			inventory.addItem(item);
		}

	}

	public void levelUp() {
		//	전직할수 있게 불리언값 변경
		if(level == 10){
			System.out.println("전직이 가능합니다");
			System.out.println("전직하기 전까진 경험치가 오르지 않습니다");
			return;
		}else if(level == 20){
			setMemory(true);
		}else if( level == 21){
			setMemory(true);
		}
		
		//	레벨 업
		++this.level;
		this.maxExp = level * 30;
		this.exp = 0 ;
		this.attack += 5;
		this.maxHp += 15;
		this.maxMp += 10;
		System.out.println("levelUp++ :" + level);
		
		//	레벨 업, 기술 데미지 보정
		Skill[] values = Skill.values();
		for(int i=0; i < values.length; i++){
			values[i].setDamage( values[i].getDamage() + this.level * 2);
		}
		
	}
	
	
	
	public void plusHp(int portion){
		hp = ( (hp + portion) >= maxHp) ? maxHp : hp+portion;
		
	}

	public void plusMp(int MpPortion){
		mp = ( (mp + MpPortion) >= maxMp) ? maxMp : hp+MpPortion;
		
	}
	
	public int getDamaged(int damage) {
		hp = (hp >= damage) ? hp - damage : 0;
		return hp;
	}

	public int getUsedMp(int demandChakra) {
		mp = (mp >= demandChakra) ? mp - demandChakra : 0;
		return mp;
	}

	public void learnSkill(Skill skill) {
		if (level >= skill.getLevelLimit() && level >= 0) {
			if (skillList.contains(skill)) {
				System.out.print("이미 배운 스킬입니다.");
			} else {
				skillList.add(skill);
				System.out.print(skill.getName() + "을 배웠습니다.");
			}
		} else {
			System.out.print("요구 레벨이 부족합니다.");
		}
	}

	public void die() {
		if (code == 1) {
			System.out.println(name + "는 조선제일검이 되지 못하고 치명적인 피해를 입고 쓰러졌습니다.");
		} else {
			System.out.println(name + "는  치명적인 피해를 입고 쓰러졌습니다.");
		}
		System.out.println("=== 게임 오버 ===");
		System.exit(1);
	}
	
	public boolean useMoney(int useMoney){
		if(money >= useMoney){
			money -= useMoney;
			System.out.println(useMoney + " 원을 사용했습니다");
			return true;
		}else{
			System.out.println("돈이 부족합니다");
		}return false;
	}
	
	

	// # GETTER / SETTER =================
	
	public int getCode() {
		return code;
	}

	public int getFood() {
		return food;
	}

	public void setFood(int food) {
		this.food = food;
		System.out.println("군량미가 추가되어 "+this.food+"만큼 보유 중");
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public void setSkillList(List<Skill> skillList) {
		this.skillList = skillList;
	}

	public String getName() {
		return name;
	}

	public Inventory<Item> getInventory() {
		return inventory;
	}

	public List<Skill> getSkillList() {
		return skillList;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getMaxHp() {
		return maxHp;
	}

	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}

	public int getMp() {
		return mp;
	}

	public void setMp(int mp) {
		this.mp = mp;
	}

	public int getMaxMp() {
		return maxMp;
	}

	public void setMaxMp(int maxMp) {
		this.maxMp = maxMp;
	}

	public int getLevel() {
		return level;
	}

	public int getExp() {
		return exp;
	}

	public int getMaxExp() {
		return maxExp;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getUserMoney() {
		return money;
	}

	public void setUserMoney(int money) {
		this.money = money;
	}

	public boolean isMemory() {
		return memory;
	}

	public void setMemory(boolean memory) {
		this.memory = memory;
	}

}