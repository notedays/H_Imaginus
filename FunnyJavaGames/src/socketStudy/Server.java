package socketStudy;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

/*
 * # 서버에서 필요한 Thread 2개 
 * 1. 항상 대기하면서 클라이언트의 접속을 받을 쓰레드
 * 2. 항상 대기하면서 클라이언트가 보내는 메세지를 받아서 처리할 쓰레드
 */
public class Server {
	public static void main(String[] args) {
		new Server();
	}
	
	ServerSocket server;
	List<User> userList;
	
	private final static int PORT = 6969;
	public Server() {
		try {
			server = new ServerSocket(PORT);
			
			new Thread(){
				public void run() {
					while(!server.isClosed()){
						try {
							Socket socket = server.accept();
							userList.add(new User(socket));
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				};
			}.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class User{
	Socket socket;
	String name;
	
	public User(Socket socket) {
		this.socket = socket;
	}
	public Socket getSocket() {
		return socket;
	}
	public void setSocket(Socket socket) {
		this.socket = socket;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
