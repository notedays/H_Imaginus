package Jeongs_HomeWork;

import java.util.ArrayList;
import java.util.List;

public class Building {
	
	int duration;
	String name;
	int code;
	
	public static List<String> nameList = new ArrayList<>();
	
	static{
		nameList.add("단독 주택");
		nameList.add("빌라");
		nameList.add("학교");
		nameList.add("병원");
		nameList.add("시청");
		nameList.add("공설운동장");
		nameList.add("공단지역");
		nameList.add("군사지역");
		nameList.add("중소기업");
		nameList.add("대기업");
	}
	
	public Building(int code){
		this.code = code;
		name = nameList.get(code);
		duration = code*50;
	}
	
	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public List<String> getNameList() {
		return nameList;
	}

	public void setNameList(List<String> nameList) {
		this.nameList = nameList;
	}
	
	
}
