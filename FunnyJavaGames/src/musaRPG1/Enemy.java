package musaRPG1;

import java.util.ArrayList;
import java.util.List;

public class Enemy {
	
	private int level;
	private String name;
	private int exp = 10;
	private int attack = 5;
	private int hp = 10;
	private int maxHp = 10;
	private int mp = 5;
	private int maxMp = 5;
	private int money = 0;
	
	private Inventory<Item> inventory = new Inventory<>();
	private List<Skill> skillList = new ArrayList<Skill>();
	
	public static final String names[] = {"미친 개	","반달 곰","호랑이","처녀 귀신","도깨비","산적","낭인 무사","퇴역 장군","검객","용산 검수","무영검 영호","백대 고수 : 십권","십대 고수 : 천검","혈교 호법 : 혈권","혈교 장로 : 혈편자","혈교 문주 : 혈문도","검선 : 천기자","조선 제일검 : 역천"};
	private static final Item items[] = { Item.DOG_BORN, Item.BEAR_SKIN, Item.BEAR_SKIN, Item.GHOST_BLOOD };
	private static final float itemRates[] = { 0.5f, 0.5f, 0.5f, 0.5f, 0.5f, 0.5f};
	private static final int moneyDrop[] = {100, 200, 300, 400, 500, 600, 700, 800, 900, 1000};
	
	
	public Enemy( int level ) {
		level = (level > names.length) ? names.length : level;
		this.level = level;
		this.name = names[level-1];
		this.attack = level * attack;
		this.exp = level * exp;
		this.maxHp = level * maxHp * 2;
		hp = maxHp;
		this.maxMp = level * maxMp * 2;
		mp = maxMp;
		this.money = moneyDrop[level-1];
	}
	
	public int getDamaged(int damage) {
		hp = ( hp >= damage ) ? hp-damage : 0;
		return hp;
	}
	
	public Item dropItem(){
		Item item = null;
		if( Math.random() < itemRates[level-1] ){
			item = items[level-1];
			return item;
		}else{
			return null;
		}
	}
	
	// # Getter / Setter
	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
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

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
}
