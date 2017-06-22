package Portune;

import java.io.File;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Pmodel {
	Random random = new Random();
	TextFileInOut s = new TextFileInOut();

	/*
	 * public void fileSave(String text) { Bean bean = new Bean(text); // # 파일
	 * 저장하기 (Output) File saveFile = new
	 * File("/Users/juhyun/Desktop/Joon/textFile.txt"); s.save(saveFile, bean);
	 * }
	 */

	public Bean fileLoad() {
		// # 저장된 파일 불러오기 (Input)
		Bean loadBeans = new Bean();
		loadBeans.setText(""); // @ 파일로 부터 데이터를 제대로 읽어 왔는지 확인하기 위해 Bean 의 text
								// 값을 미리 초기화
		File loadFile = new File("/Users/juhyun/Desktop/Joon/textFile.txt");
		loadBeans = s.load(loadFile);
		return loadBeans;
	}

	public String[] chooseBean(Bean bean) { // 5개뽑아서 리스트에 담아서 리턴
		String[] choose = new String[5];
		Set <Integer> duplicate = new HashSet<Integer>();
		int randomNum = 0;
		
		String[] sp = bean.getText().split("\n");
		int num = sp.length;
		int count = 0;
		do{
			randomNum = random.nextInt(num);
			if(duplicate.contains(randomNum)){
				continue;
			}else{
				duplicate.add(randomNum);
				choose[count] = sp[randomNum];
				count ++;
			}
		}while( count < 5);	
		return choose;
	}

	public boolean save(Character character, String[] a) {
		String[] fortuneList = character.getFortune();
		for (int i = 0; i < a.length; i++) {
			fortuneList[i] = a[i];
		}
		return true;
	}

	public String[] load(Character character) {
		String[] fortuneList = character.getFortune();
		return fortuneList;
	}

}
