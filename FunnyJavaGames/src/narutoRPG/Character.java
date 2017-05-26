package narutoRPG;

import java.util.ArrayList;
import java.util.List;

public enum Character {
	
	NARUTO(1,"나루토", 20,20, 10,10, new Inventory<Item>(), new ArrayList<Skill>()),
	SASUKE(2,"사스케", 20,20, 10,10, new Inventory<Item>(), new ArrayList<Skill>());
	
	private final int code;
	private final String name;
	private int hp;
	private int maxHp;
	private int chakura;
	private int maxChakura;
	
	private final Inventory<Item> inventory;
	private final List<Skill> skillList;
	
	private Character(int code, String name, int hp, int maxHp, int chakura, int maxChakura, Inventory<Item> inventory, List<Skill> skillList) {
		this.code = code;
		this.name = name;
		this.hp = hp;
		this.maxHp = maxHp;
		this.chakura = chakura;
		this.maxChakura = maxChakura;
		this.inventory = inventory;
		this.skillList = skillList;
	}

	// # 추가 메소드
	public boolean obtainItem(Item item){
		return inventory.addItem(item) != -1;
	}
	
	public int getDamaged(int damage) {
		hp = ( hp >= damage ) ? hp-damage : 0;
		if( hp >= damage ){
			hp -= damage;
		}else{
			hp = 0;
			die();
		}
		return hp;
	}
	
	public void die(){
		if(code == 1){
			System.out.println(name+"는 호카게가 되지 못하고 치명적인 피해를 입고 쓰러졌습니다.");
		}else{
			System.out.println(name+"는 형 이타치의 복수를 하지 못하고 치명적인 피해를 입고 쓰러졌습니다.");
		}
		System.out.println("=== 게임 오버 ===");
		System.exit(0);
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

	public List<Skill> getskillList() {
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

	public int getChakura() {
		return chakura;
	}

	public void setChakura(int chakura) {
		this.chakura = chakura;
	}

	public int getMaxChakura() {
		return maxChakura;
	}

	public void setMaxChakura(int maxChakura) {
		this.maxChakura = maxChakura;
	}
}
