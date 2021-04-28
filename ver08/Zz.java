package project01.ver08;

import java.util.HashSet;
import java.util.Scanner;

public class Zz {
	HashSet hash = new HashSet();
	Scanner scan = new Scanner(System.in);
	//1번 1번 중복으로 눌렀을때 발생하는 중복만가져온코드
	public void dataInput(int choice) {
		if (choice == SubMenultem.nomal) {
			System.out.print("이름:");
			String name = scan.nextLine();
			System.out.print("전화번호:");
			String phoneNumber = scan.nextLine();
			PhoneInfo friend = new PhoneInfo(name, phoneNumber);
			friend.showPhoneInfo();
			overLap(friend);
			
		}
	}
	
	public void overLap(PhoneInfo imformation) {
		if (hash.add(imformation) == false) {
			System.out.println("이미 저장된 데이터입니다.\r\n" + 
							"덮어쓸까요?1번:yes(덮어쓴다) / 2.번:NO(n)(거절한다)");
			int yesorno = scan.nextInt();
			if (yesorno == 1) {
				hash.remove(imformation);
				hash.add(imformation);
				System.out.println("덮어쓰기가 완료되었습니다");
			} else if (yesorno == 2) {
				System.out.println("정보저장이취소되었습니다");

			}
		}
	}
	
}
