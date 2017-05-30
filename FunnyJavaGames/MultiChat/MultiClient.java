package MultiChat;

import java.io.*;
import java.net.*;
import java.nio.Buffer;

public class MultiClient {

	Socket socket;
	// 서버랑 연결된 소켓
	BufferedReader in;
	// 서버가 보낸메시지를 읽어들임
	PrintWriter out;
	// 서버로 메시지를 보냄
	BufferedReader keyborad;
	// 키보드 입력 내용을 읽어 들일때

	public MultiClient() {
		try {
			socket = new Socket("192.168.0.131", 3000);
			System.out.println("서버연결 성공......");
			
			//스트림 연결 
			keyborad = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintWriter(socket.getOutputStream());
			in  = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			//서버가 전송한 메시지를 읽어들이기 위한 읽기 전용
			//스레드 생성
			//멀티스레드 생성시에 서버가 전송한 메시지를 읽어 들일 수 있는 스트림 전달 
			
			MultiClientThread t = new MultiClientThread(in);
			t.start();
			
			while(true){
				String txt = keyborad.readLine();
				out.println(txt);
			}
			
		} catch (UnknownHostException uu) {
			uu.printStackTrace();
			
		} catch (IOException io){
			io.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new MultiClient();
	}

}
