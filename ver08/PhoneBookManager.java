package project01.ver08;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import project01.ver08.PhoneInfo;
import project01.ver08.PhoneCompanyInfo;
import project01.ver08.PhoneSchoolInfo;

public class PhoneBookManager {
	HashSet hash = new HashSet();

	Scanner scan = new Scanner(System.in);

	public void printMenu() {
		System.out.println("★★★★★★★★★★★★★★★★★★★★★★주소록관리프로그램★★★★★★★★★★★★★★★★★★★★★★");
		System.out.print("★1번←데이터 입력 " + "     ");
		System.out.print("2번←데이터 검색" + "      ");
		System.out.println("3번←데이터 삭제" + "     ");
		System.out.print("★4번←데이터 출력" + "      ");
		System.out.print("5번←저장 옵션  " + "      ");
		System.out.println("6번←프로그램 종료" + "      ");
		System.out.print("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★");
	}

	public void inputSub() {
		System.out.println("★★★★★★데이터입력을시작합니다★★★★★★");
		System.out.println("1번←일반   2번←동창   3번←회사");
		System.out.print("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★");
	}

	public void savePhoneBook() {
		try {
			FileOutputStream fileOut = new FileOutputStream("src/project01/ver08/PhoneBook.obj");
			ObjectOutputStream objOut = new ObjectOutputStream(fileOut);

			Iterator itr = hash.iterator();
			while (itr.hasNext()) {
				Object outstoage = (Object) itr.next();
				objOut.writeObject(outstoage);
			}
		} catch (Exception e) {

		}
	}

	public void callPhoneBook() {
		try {
			FileInputStream fileIn = new FileInputStream("src/project01/ver08/PhoneBook.obj");
			ObjectInputStream objIn = new ObjectInputStream(fileIn);
			while (true) {
				PhoneInfo phone = (PhoneInfo) objIn.readObject();
				if (phone == null) {
					break;
				}
				hash.add(phone);
			}

		} catch (EOFException e) {

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void threadingrun() {
		try {
			PrintWriter out = new PrintWriter
								(new FileWriter("src/project01/ver08/AutoSaveBook.txt"));
			Scanner scan = new Scanner(System.in);
			Iterator itr = hash.iterator();
			while (itr.hasNext()) {
				PhoneInfo input = (PhoneInfo) itr.next();
				out.println(input.toString());
			}
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public void overLap(PhoneInfo imformation) {
		if (hash.add(imformation) == false) {
			System.out.println("이미 저장된 데이터입니다.\r\n" + "덮어쓸까요?1번:yes(덮어쓴다) / 2.번:NO(n)(거절한다)");
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
	public void dataInput(int choice) {
		Scanner scan = new Scanner(System.in);
		if (choice == SubMenultem.nomal) {
			System.out.print("이름:");
			String name = scan.nextLine();
			System.out.print("전화번호:");
			String phoneNumber = scan.nextLine();
			PhoneInfo friend = new PhoneInfo(name, phoneNumber);
			friend.showPhoneInfo();
			overLap(friend);
			
		} else if (choice == SubMenultem.schoolfr) {
			System.out.print("이름:");
			String name = scan.nextLine();
			System.out.print("전화번호:");
			String phoneNumber = scan.nextLine();
			System.out.println("전공:");
			String major = scan.nextLine();
			System.out.println("학년:");
			int grade = scan.nextInt();
			PhoneSchoolInfo school = new PhoneSchoolInfo(name, phoneNumber, major, grade);
			school.showPhoneInfo();
			overLap(school);

		} else if (choice == SubMenultem.company) {
			System.out.print("이름:");
			String name = scan.nextLine();
			System.out.print("전화번호:");
			String phoneNumber = scan.nextLine();
			System.out.println("회사 :");
			String company = scan.nextLine();
			PhoneCompanyInfo com = new PhoneCompanyInfo(name, phoneNumber, company);
			com.showPhoneInfo();
			overLap(com);
		}
	}

	public void dataSearch() {
		boolean isname = false;
		System.out.println("검색할 이름을 입력하세요");
		String searchName = scan.nextLine();
		Iterator<PhoneInfo> itr = hash.iterator();
		while (itr.hasNext()) {
			PhoneInfo input = itr.next();
			if (searchName.compareTo(input.name) == 0) {
				System.out.println("데이터가검색되었습니다");
				hash.contains(input);
				input.showPhoneInfo();
				isname = true;

			}
		}
		if (isname == false) {
			System.out.println("검색결과가없습니다");
		}
	}
	public void dataDelete() {
		boolean isname = false;
		Scanner scan = new Scanner(System.in);
		System.out.print("삭제할 이름을 입력하세요:");
		String deleteName = scan.nextLine();
		Iterator<PhoneInfo> itr = hash.iterator();
		while (itr.hasNext()) {
			PhoneInfo input = itr.next();
			if (deleteName.compareTo(input.name) == 0) {
				System.out.println("이름||" + input.name + "||의 데이터가 삭제되었습니다");
				hash.remove(input);
				isname = true;
			}
		}
		if (isname==false) {
			System.out.println("삭제된데이터가없습니다");
		}
	}

	public void dataAllShow() {
		Iterator<PhoneInfo> itr = hash.iterator();
		while (itr.hasNext()) {
			PhoneInfo input = itr.next();
			input.showPhoneInfo();
		}
	}
}
