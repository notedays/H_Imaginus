package musaRPG1;

import java.util.ArrayList;
import java.util.List;

public enum Character {
	MUHYUL(1, "무휼", "초급 의병장", 1, 5, 0, 1, 1000, 100, 10, 10, 10000, 100, new Inventory<Item>(), new ArrayList<Skill>(),
			new ArrayList<Castles>(), new ArrayList<Companion>()),
	
	ILJIMAE(2, "일지매", "초급 의병장", 1, 5, 0, 1, 1000, 100, 10, 10, 10000, 100,
			new Inventory<Item>(), new ArrayList<Skill>(),
			new ArrayList<Castles>(), new ArrayList<Companion>());

	private final int code;
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

	private final Inventory<Item> inventory;
	public List<Skill> skillList;
	public List<Castles> castles;
	public List<Companion> companionList;
	
	private Character(int code, String name, String grade, int level, int attack, int exp, int maxExp, int hp,
			int maxHp, int mp, int maxMp, int money, int food, Inventory<Item> inventory, List<Skill> skillList,
			List<Castles> castles, List<Companion> companionList) {
		this.code = code;
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
		this.inventory = inventory;
		this.skillList = skillList;
		this.castles = castles;		//보유한 성 리스트 
		this.companionList = companionList;
	}

	// # 추가 메소드
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
		System.out.println(this.exp + "/" + maxExp);
		if (this.exp >= maxExp)
			levelUp();
		if (item != null) {
			System.out.println("\n아이템 [" + item.getName() + "] 을(를) 획득했습니다.");
			inventory.addItem(item);
		}

	}

	public void levelUp() {
		++this.level;
		this.maxExp = level * 30;
		this.exp = 0;
		this.attack += 5;
		this.maxHp += 15;
		this.maxMp += 10;
		System.out.println("levelUp++ :" + level);
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
	
	public void useMoney(int useMoney){
		if(money >= useMoney){
			money -= useMoney;
			System.out.println(useMoney + " 원을 사용했습니다");
		}
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

}