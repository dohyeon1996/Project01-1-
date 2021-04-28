package project01.ver08;
import project01.ver08.PhoneInfo;
import project01.ver08.PhoneCompanyInfo;
import project01.ver08.PhoneSchoolInfo;
public class PhoneCompanyInfo extends PhoneInfo {
	
	public PhoneCompanyInfo(String name, String phoneNumber, String company) {
		super(name, phoneNumber,company);
	}
	@Override
	public void showPhoneInfo() {
		System.out.println("이름:"+name+"  ||전화번호:"+phoneNumber+"  ||회사:"+company+"||의 정보가 저장되었습니다");
	}
	@Override
	public String toString() {
		return "이름:"+name+"전화번호:"+phoneNumber+"회사:"+company;
	}
}
