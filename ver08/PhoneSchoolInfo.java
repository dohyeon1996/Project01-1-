package project01.ver08;
import project01.ver08.PhoneInfo;
public class PhoneSchoolInfo extends PhoneInfo  {
	
	public PhoneSchoolInfo(String name, String phoneNumber, String major, int grade) {
		super(name, phoneNumber,major,grade);
	}
	@Override
	public String toString() {
		return "이름:"+name+"전화번호:"+phoneNumber+"전공:"+major+"학년:"+grade;
	}
	@Override
	public void showPhoneInfo() {
		System.out.println("이름:"+name+" ||전화번호:"+phoneNumber+" ||전공:"+major+" ||학년:"+grade+"||의 정보가 저장되었습니다");
	}
}
