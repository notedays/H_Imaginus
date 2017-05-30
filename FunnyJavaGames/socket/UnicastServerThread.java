package socket;

import java.io.*;
import java.net.*;

public class UnicastServerThread extends Thread {

	// 서버로 부터 전달된 소을 저장함
	Socket socket = null;
	BufferedReader br = null;
	BufferedWriter bw = null;

	public UnicastServerThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {

		// 스트림 연결
		try {
			// 메시지 수신
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

			// 클라이언트와 메시지를 송수신함
			while (true) {

				// 클라이언트가 보낸 메시를 읽음
				String msg = br.readLine();
				System.out.println(msg);
				// 서버 클라이언트로 메시지를 보냄
				bw.write(msg + "\n");
				bw.flush();
				// 메시지를 보낸후 버퍼를 비움
			}
		} catch (IOException io) {
			io.printStackTrace();
			
			//클라이언트와 연결이 끊어진 경우
			InetAddress ip = socket.getInetAddress();
			String address = ip.getHostAddress();
			System.out.println("["+address+"]"+"와의 연결이 해제 되었습니다...");
			
		} 
	}
}
