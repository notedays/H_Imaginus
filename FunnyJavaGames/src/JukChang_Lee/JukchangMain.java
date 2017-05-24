package JukChang_Lee;

import java.util.*;

public class JukchangMain {
	Scanner scan = new Scanner(System.in);
	Random random = new Random();
	Teacher teacher = new Teacher();

	Student student = new Student();

	public static void main(String[] args) {
		new JukchangMain();
	}

	public JukchangMain() {

		System.out.println("때는 바야흐로 난세의 기운이 하늘을 뒤덮는고 나라가 진동하는 2017년 어느 날.");
		System.out.println("청운의 꿈을 안고 자바라는 산을 점령하려 하였으나, 관리들의 횡포가 심하여 낙심하던 중");
		System.out.println("청운의 꿈을 접고 붕당정치의 꿈을 꾸는 이들이 있었으니");
		System.out.println("이름하야 '죽창 워리어s' 그들의 죽창의 난이 시작된다.\n");
		while (true) {
			teacher.setSpeed(random.nextInt(101));
			student.setChanceRate(random.nextInt(2));
			if (student.getHp() <= 0) {
				System.out.println("죽창의 난에서 실패했습니다. 당신은 영원히 for문 안에서 잠듭니다.");
				System.exit(0);
			}
			if (teacher.getHp() <= 0) {
				System.out.println("당신은 힘겨운 싸움 끝에 죽창의 난에서 승리하였습니다. 축하합니다!!!");
				System.exit(0);
			}

			System.out.println("1.수업듣기 2.죽창깎기 3.파이널찌르기");
			int menu = scan.nextInt();
			switch (menu) {
			case 1: {
				if (teacher.danger(teacher.getSpeed())) {
					student.setHp(student.getHp() - 1);
					System.out.println("진도를 따라가지 못하여, 멘탈이 깎였습니다.ㅂㄷㅂㄷ 학생HP -1");
				} else {
					teacher.setHp(teacher.getHp() - 1);
					System.out.println("다행히 적절한 진도입니다. 방어성공! 선생HP-1");
				}
				System.out.printf("선생님HP:%d,진도의상태가?%d 학생HP:%d\n", teacher.getHp(), teacher.getSpeed(), student.getHp());
				break;
			}
			case 2: {
				if (teacher.danger(teacher.getSpeed())) {
					teacher.setHp(teacher.getHp() - 1);
					System.out.println("죽창을 깎으며 아이들을 선동했습니다.반응이 좋습니다. 선생HP-1");
				} else {
					student.setHp(student.getHp() - 1);
					System.out.println("죽창을 깎다가 손이 베였습니다. 학생HP-1");
				}
				System.out.printf("선생님HP:%d,진도의상태가?%d 학생HP:%d\n", teacher.getHp(), teacher.getSpeed(), student.getHp());
				break;
			}
			case 3: {
				if (student.getHp() < 2)
					System.out.println("주화입마에 걸렸습니다. 스킬사용불가!!!");
				else {
					if (student.getHp() >= 2 && student.getChanceRate() > 0.5) {
						teacher.setHp(teacher.getHp() - 4);
						student.setHp(1);
						System.out.println("오늘을 위해 죽창을 깎았다!!!비전공생 오의 죽창 4연격 성공!!!선생HP-4 학생HP >> 1");
						System.out.printf("선생님HP:%d,진도의상태가?%d 학생HP:%d\n", teacher.getHp(), teacher.getSpeed(),
								student.getHp());
					} else {
						student.setHp(1);
						System.out.println("완성된 죽창을 들고 일어났지만 혼자입니다. 따가운 눈총을 받으며 최후의 일격에 실패했습니다. 학생HP >> 1");
						System.out.printf("선생님HP:%d,진도의상태가?%d 학생HP:%d\n", teacher.getHp(), teacher.getSpeed(),
								student.getHp());
					}

				}
			}
				break;

			}
		} // end while
	}

}
