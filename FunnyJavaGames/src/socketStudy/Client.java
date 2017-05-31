package socketStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/*
 * # 클라이언트에서 필요한 쓰레드 
 * 1. 계속 대기하며 서버에서 메세지를 받아서 처리할 쓰레드 
 */
public class Client {

	public static final String HOST = "192.168.0.20";
	public static final int PORT = 3005;

	Socket socket;
	Scanner sc = new Scanner(System.in);

	public Client() {
		try {
			socket = new Socket(HOST, PORT);

			receive();
			
			while(true){
				System.out.print("나 : ");
				String msg = sc.next();
				send(msg);
			}

		} catch (UnknownHostException e) {
			System.out.println(HOST + " 호스트가 없습니다.");
		} catch (IOException e) {
			System.out.println(HOST + " 서버와 연결을 할 수가 없습니다.");
		}
	}

	private void receive() {
		new Thread() {
			public void run() {
				try {
					BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					while (true) {
						String msgs = reader.readLine();
						System.out.println(msgs);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			};
		}.start();
	}

	private void send(String msg) {
		try {
			socket.getOutputStream().write((msg + "\n").getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new Client();
	}
}
