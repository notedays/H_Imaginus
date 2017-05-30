package socket;
import java.io.*;
import java.net.*;


public class UnicastClient {
	//소켓과 스트림 생성
	Socket socket = null;
	BufferedReader br = null;
	BufferedWriter bw = null;
	BufferedReader keyboard = null;
	public UnicastClient() {
		//소켓 생성
		try {
			socket = new Socket("localhost",2002);//로컬호스트와 서버의 포트와 동일하게
		} catch (UnknownHostException e) {
			System.out.println("서버를 찾을 수 없습니다.");
			System.exit(0);
		} catch(IOException io){
			System.out.println("서버를 찾을 수 없습니다.");
		}
		//스트림 연결
		try {
			keyboard = new BufferedReader(new InputStreamReader(System.in));
//		소켓으로부터 스트림 얻기
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			//연결된 서버와 메세지 주고받기
			while(true){
				//키보드 내용 입력
				//서버로 보낼 메시지
				System.out.print("전송할 메세지");
				String msg = keyboard.readLine();
				
				//메세지를 서버로 보냄
				bw.write(msg+"\n");
				bw.flush();
				
				//서버가 보낸 메세지 수신
				String getMsg = br.readLine();
				System.out.println("수신된 메세지:"+getMsg);
				
			}
		} catch (IOException e) {
			System.out.println("서버와 연결이 끊겼습니다.");
			System.exit(0);
		}
	}
	public static void main(String[] args) {
		new UnicastClient();
	}
	
}