package project01;

import project01.ver08.*;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PhoneBookVer08 {
	public static void main(String[] args) {
		PhoneBookManager manager = new PhoneBookManager();
		AutoSaverT autosave = null;

		int numplus = 0;
		Scanner scan = new Scanner(System.in);
		manager.callPhoneBook();
		while (true) {
			try {
				manager.printMenu();
				int choice = scan.nextInt();
				if (!(choice >= 1 && choice <= 6)) {
					MenuSelectException ex = new MenuSelectException();
					throw ex;
				}

				switch (choice) {
				case MunuItem.input:
					manager.inputSub();
					int num = scan.nextInt();
					manager.dataInput(num);
					break;
				case MunuItem.search:
					manager.dataSearch();
					break;
				case MunuItem.delete:
					manager.dataDelete();
					break;
				case MunuItem.allshow:
					manager.dataAllShow();
					break;
				case MunuItem.storage:
					System.out.println("시작1 종료2");
					int choice1 = scan.nextInt();
					if (choice1 == 1) {
						if (autosave == null || !autosave.isAlive()) {
							autosave = new AutoSaverT(manager);
							autosave.setDaemon(true);
							autosave.start();
							System.out.println("자동저장시작합니다");
						} else {
							System.out.println("쓰레드가 이미진행중입니다");
						}
					} else if (choice1 == 2) {
						if (autosave == null) {
							System.out.println("쓰레드가 실행되지않았습니다"
									+ "		 실행하려면 5번==>1번선택하세요");
						} else {
							if (autosave.isAlive()) {
								System.out.println("자동저장이종료됩니다");
								autosave.interrupt();
							}
						}
					}
					break;
				case MunuItem.numbreak:
					System.out.println("입력데이터가 저장후 종료되었습니다");
					manager.savePhoneBook();
					System.exit(choice);
					break;
				}
			} catch (MenuSelectException e) {
				System.out.println(e.getMessage());

			} catch (InputMismatchException e) {
				System.out.println("문자말고 정수를입력하세요");
				scan.nextLine();

			} catch (NullPointerException e) {
				System.out.println("검색결과가 없습니다");

			} catch (IllegalThreadStateException e) {
				System.out.println("이미 자동저장이 실행중입니다.");
			} catch (IndexOutOfBoundsException e) {
				System.out.println("자동저장이 실행되고 있지 않습니다.");
			} catch (Exception e) {

			}
		}
	}
}
