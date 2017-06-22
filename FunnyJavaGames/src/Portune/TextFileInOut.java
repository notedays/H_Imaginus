package Portune;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TextFileInOut {
	public static void main(String[] args) {
		new TextFileInOut();
	}

	void save(File file, Bean bean) {
		// # try-catch-resources 구문 ( Java 7 이상 지원 ) : 객체를 자동으로 close() 해줌.
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(file));) {
			writer.write(bean.getText());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	Bean load(File file) {
		Bean loadBean = new Bean();
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			do{
				String a = reader.readLine();
				if( a != null){
					loadBean.setText(a);
				}else{
					break;
				}
			}while(true);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return loadBean;
	}
	
	
}

class Bean {
	private String text;

	public Bean() {
	}

	public Bean(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		if(this.text == null){
			this.text = text;
			this.text += "\n";
		}else{
			this.text += text;
			this.text += "\n";
		}
	}
	
	
	
}
