package socketStudy;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/*
 * # 클라이언트에서 필요한 쓰레드 
 * 1. 계속 대기하며 서버에서 메세지를 받아서 처리할 쓰레드 
 */
public class Client {
	
	public static final String HOST = "localhost";
	public static final int PORT = 6969;
	
	Socket socket;
	
	public Client() {
		try {
			socket = new Socket(HOST, PORT);
			
		} catch (UnknownHostException e) {
			System.out.println(HOST+" 호스트가 없습니다.");
		} catch (IOException e) {
			System.out.println(HOST+" 서버와 연결을 할 수가 없습니다.");
		}
	}
}
