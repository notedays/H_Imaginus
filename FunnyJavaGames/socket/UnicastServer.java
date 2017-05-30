package socket;

import java.io.*;
import java.net.*;


public class UnicastServer {
	public UnicastServer(){
		
		ServerSocket server = null;
		try {
			//서버 소캣 생성
			server = new ServerSocket(2002);
		} catch (IOException io) {
			io.printStackTrace();
		}
		try
		{
			//클라이언트가 접속할때까지 무한정 기다림 
			while(true){
				System.out.println("서버준비..");
				//클라이언트가 접속하게되면 클라이언트와 통신할수 있는
				//소켓을 생성함
			Socket socket = server.accept();
			
			//스레드 클래스 구현 
			//클라이언트와 메시지를 송수신할 스레스 생성 
			UnicastServerThread thread = new UnicastServerThread(socket);
			thread.start();
			}
		} catch(IOException io){
			io.printStackTrace();
		}
	}
		public static void main(String[] args){
			new UnicastServer();
		}

}
