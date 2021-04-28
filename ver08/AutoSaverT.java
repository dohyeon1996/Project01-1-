package project01.ver08;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class AutoSaverT extends Thread {
	PhoneBookManager manager;

	public AutoSaverT(PhoneBookManager manager) {
		super();
		this.manager = manager;
	}
	@Override
	public void run() {
		try {
			while (true) {
				manager.threadingrun();
				System.out.println("주소록이 텍스트로 자동저장되었습니다");
				sleep(5000);
			}
		} catch (InterruptedException e) {

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
