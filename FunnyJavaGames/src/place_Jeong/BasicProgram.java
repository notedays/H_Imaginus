package place_Jeong;

import java.util.Scanner;

public class BasicProgram {
	public static void main(String[] args) {
		new BasicProgram();
	}
	
	Scanner scan = new Scanner(System.in);
	
	public BasicProgram() {
		System.out.print("Could you understand this sentence? [YES / NO]");
		String text = scan.nextLine();
		if(text.toUpperCase().equals("YES")){
			System.out.println("You should study program!!!");
		}else{
			System.out.println("You can be anyone who you want to be!!");
		}
	}

}
