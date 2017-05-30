package MultiChat;

import java.io.*;
import java.net.*;


public class MultiClientThread extends Thread{

	BufferedReader in;
	
	
	public MultiClientThread(BufferedReader in) {
		this.in = in;
		
		
	}
	
	@Override
	public void run() {
		try {
			while(true){
				//서버가 전송한 메시지 읽기 
				String txt = in.readLine();
				System.out.println("수신된 메시지: " + txt);
			}
		} catch (IOException ii) {
			ii.printStackTrace();
		}
	}
}
