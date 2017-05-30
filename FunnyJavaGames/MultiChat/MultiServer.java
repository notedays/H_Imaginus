package MultiChat;

import java.io.*;
import java.net.*;
import java.util.*;

//	만들어진 스레드 객체를 Collection내에 저장
// 

public class MultiServer {
	/*
	 * 특정한 클라이언트가 보낸 메시지를 모든 클라이언트에게 송신하기 위해 클라이언트와 메시지 송, 수신할 수 있는 기능을 가진 리스트
	 * 구조선언
	 */
	ArrayList<MultiServerThread> clientList = new ArrayList<MultiServerThread>();
	ServerSocket server = null;
	
	public MultiServer() {
		try {
			server = new ServerSocket(3000); // 7000번 포트번호를 통해 클라이언트의 요청을 기다림
			System.out.println("서버 구동 시작.........");

			// 클라이언트가 접속할 때까지 무한정 대기함
			while (true) {

				Socket socket = server.accept();
				// 소켓으로 부터 ip주소와 호스트명을 가지고 있는 InetAddress 객체를 생성함

				InetAddress ip = socket.getInetAddress();
				String ipAddress = ip.getHostAddress();
				System.out.println(ipAddress+"님이 들어옴");
				
			// 클라이언트와 송수신 할 수 있는 기능을 가진 스레드를 객체 생성 
				
				MultiServerThread t = new MultiServerThread(clientList, socket);
				
				//스레드 시작 
				t.start();
				//리스트에다가 스레드를 추가 함 
				clientList.add(t);
			}
			
		} catch (IOException io) {
			io.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new MultiServer();
	}
}
