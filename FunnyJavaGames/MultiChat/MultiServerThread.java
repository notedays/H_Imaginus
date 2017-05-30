package MultiChat;

import java.io.*;
import java.net.*;
import java.util.*;

/*	각각의 클라이언트와 연결된 Socket 객체를 가지며, 클라이언트와 접속을 유지
 * 	통신을 담당하는 역할을 함 
 * 	서버가 전송한 메시지를 수신해서 모든 클라이언트에게 전송하는 
 * 	broadcasting이 구현되어야 함 
 */

public class MultiServerThread extends Thread {

	// 서버가 전달해 주는 소켓을 담아둘 변수 선언
	Socket socket;

	// 클라이언트가 전달한 메시지를 읽어들일 스트림 생성
	BufferedReader in;
	PrintWriter out;

	// 모든 서버스레드 객체를 저장할 ArrayList 선언
	ArrayList<MultiServerThread> clientList;

	public MultiServerThread(ArrayList<MultiServerThread> clientList, Socket socket) {
		this.socket = socket;
		this.clientList = clientList;
	}

	// 스레드 실행
	@Override
	public synchronized void run() {

		try {
			// 스트림 연결
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream());
			// 클라이언트와 메시지를 송수신함
			while (true) {
				// 클라이언트가 보낸 메시지 읽음
				String msg = in.readLine();
				System.out.println(msg);

				// 모든 클라이언트에게 메시지 전달
				broadcasting(msg);

			}
		} catch (IOException io) {
			// 클라이언트와 연결이 해제 되었을 경우
			// 해당 멀티서버스레드 객체를 목록에서 삭제
			// 여러명이 접속했는데 한 사람이 접속이 해제 되었을 경우
			// IOException 발생
			// 이 경우에 자기 자신을 삭제함
			clientList.remove(this);

			// 클라이언트의 연결이 해제되어도 소켓은 그 ip주소를 가지고 있음
			String ipAddress = socket.getInetAddress().getHostAddress();

			try {
				// 다른 클라이언트에게 퇴장 사실을 알림

				// 브로드캐스팅함
				broadcasting(ipAddress+"와 연결이 해제 되었습니다...");

			} catch (IOException ii) {
				ii.printStackTrace();
			}
		} // end catch

	} // end run()
	
	//	모든 클라이언트에게 메시지 전달을 담당할 브로드 캐스팅 함수 구현 
	public void broadcasting(String msg) throws IOException{
		//	clientList에 저장된 스레드 개수만큼 반복하면서
		//	각각의 스레드의 sendMsg 메소드 호출 
		//	연결된 클라이언트에게 전달함 
		
		for(MultiServerThread t : clientList)
			t.sendMsg(msg);
	}
	
	
	// 	클라이어언트에게 메시지 전달할 함수 구현 
	public void sendMsg(String msg){
		
		//전달받은 메시지를 소켓을 출력스트림을 통해서 클라이언트에게 전달함 
		out.println(msg);
		out.flush();
	}
}
