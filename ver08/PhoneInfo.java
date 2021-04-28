package project01.ver08;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import project01.ver08.PhoneInfo;
import project01.ver08.PhoneCompanyInfo;
import project01.ver08.PhoneSchoolInfo;
import project01.ver08.PhoneBookManager;

public class PhoneInfo implements Serializable {
	String name;
	String phoneNumber;
	String company;
	String major;
	int grade;

	public PhoneInfo(String name, String phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
	}

	public PhoneInfo(String name, String phoneNumber, String company) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.company = company;
	}

	public PhoneInfo(String name, String phoneNumber, String major, int grade) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.major = major;
		this.grade = grade;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void showPhoneInfo() {
		System.out.println("이름:" + name + " ||전화번호:" + phoneNumber + "||의 정보가 저장되었습니다");
	}

	@Override
	public String toString() {
		return "이름:" + name + "전화번호" + phoneNumber;
	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		PhoneInfo info = (PhoneInfo) obj;
		if (info.name.equals(this.name)) {
			return true;
		} else {

			return false;
		}
	}

}
