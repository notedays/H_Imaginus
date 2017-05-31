package musaRPG;

import java.util.ArrayList;
import java.util.List;

public enum Character {
	MUHYUL(1,"무휼","초급 무사", 1, 5, 0,30, 20,20, 10,10, new Inventory<Item>(), new ArrayList<Skill>()),
	ILJIMAE(2,"일지매","도둑", 1, 5, 0,30, 20,20, 10,10, new Inventory<Item>(), new ArrayList<Skill>());
	
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
	
	private final Inventory<Item> inventory;
	private final List<Skill> skillList;
	
	private Character(int code, String name, String grade, int level, int attack, int exp, int maxExp,  int hp, int maxHp, int mp, int maxMp, Inventory<Item> inventory, List<Skill> skillList) {
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
		this.inventory = inventory;
		this.skillList = skillList;
	}

	// # 추가 메소드
	public boolean obtainItem(Item item){
		return inventory.addItem(item);
	}
	
	public void battleWin(int exp, Item item){
		this.exp += exp;
		if(exp >= maxExp) levelUp();
		
		if(item != null){
			System.out.println("\n아이템 ["+item.getName()+"] 을(를) 획득했습니다.");
		}
	}
	
	public void levelUp(){
		++this.level;
		this.maxExp = level * 30;
		this.exp = 0;
		this.attack += 5;
		this.maxHp += 15;
		this.maxMp += 10;
	}
	
	public int getDamaged(int damage) {
		hp = ( hp >= damage ) ? hp-damage : 0;
		return hp;
	}
	
	public void learnSkill(Skill skill){
		skillList.add(skill);
	}
	
	public void die(){
		if(code == 1){
			System.out.println(name+"는 조선제일검이 되지 못하고 치명적인 피해를 입고 쓰러졌습니다.");
		}else{
			System.out.println(name+"는  치명적인 피해를 입고 쓰러졌습니다.");
		}
		System.out.println("=== 게임 오버 ===");
	}
	
	// # GETTER / SETTER =================
	public int getCode() {
		return code;
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

}
