package place_Share;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.plaf.FileChooserUI;

public class FileInOutput {
	public static void main(String[] args) {
//		new FileInOutput();
		new FileInOutput("image");
	}
	
	String path = "C:/Users/leehg/Desktop/";
	
	public FileInOutput() {
		Bean bean = new Bean();
		bean.name = "홍삼이";
		bean.age = 13;
		
		File file = fileMaker(bean);
		saveFile(file, bean);
		// ---  # 파일 생성 끝
		
		
		bean = loadFile("홍삼이.txt");
		
		System.out.println(bean.name);
		System.out.println(bean.age);
	}
	
	public FileInOutput(String trash) {
		File image = loadImageFile("전주.jpg");
		saveImageFile(image);
	}
	
	
	File fileMaker(Bean bean){
		return new File(path+bean.name+".txt");
	}
	
	void saveFile(File file, Bean bean){
		try (FileWriter writer = new FileWriter(file);){
			writer.write(bean.name+"\r\n");
			writer.write(bean.age+"\r\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	Bean loadFile(String fileName){
		String filePath = path + fileName;
		Bean bean = new Bean();
		try (BufferedReader reader = new BufferedReader(new FileReader(new File(filePath)));){
			bean.name = reader.readLine();
			bean.age = Integer.parseInt(reader.readLine());
		} catch (Exception e){
			e.printStackTrace();
		}
		return bean;
	}
	
	void saveImageFile(File imageFile){
		try(FileOutputStream out = new FileOutputStream(imageFile)){
			out.write(1);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	File loadImageFile(String fileName){
		File file = new File(path+fileName);
		try(FileInputStream in = new FileInputStream(new File(path+fileName))){
			int t = 0 ;
			while( (t=in.read()) !=-1 ){
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		return file;
	}
}

class Bean{
	String name;
	int age;
}
