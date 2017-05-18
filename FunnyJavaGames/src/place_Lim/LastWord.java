package place_Lim;
import java.util.Scanner;
/*    # 끝말 잇기 게임
 *  - 친구들과 함께 할 수 있도록 게임 시작 시 플레이 인원을 입력받고 해당 인원 수 만큼 Player 클래스 생성하기
 *  - Player 클래스에는 String name, int point 가 들어감.
 *  - LastWordGame 클래스 내에는 String lastWord, int gameCount 가 들어감.
 */
public class LastWord {
    Players[] players;
    int gameCount;
    public static void main(String[] args) {
        new LastWord();
    }
    public LastWord(){
        System.out.println("***End word game***");
        System.out.println("Type number of game players :");
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        
        // # 여기서 배열을 선언했지만 그 배열안에 실제적으로 들어갈 Players 값을 초기화하지 않음
        players = new Players[number];
        
        for (int i = 0; i < players.length; i++) {
            System.out.println((i+1)+"번째 플래이어의 이름을 입력하시오 :");
            Players player = new Players();
            String name = sc.next();
            player.name = name;
            players[i] = player;
        }
        if(players[0].lastWord.equals(players[1].lastWord) == true){
        }
        
   }
}
class Players {
    String lastWord;
    String name;
    int point;
    void lastWords(){
        System.out.println("단어를 입력하시오 :");
        Scanner sc = new Scanner(System.in);
        lastWord = sc.next();
    }
}