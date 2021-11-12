//[ mms.member.vo : 특정 단위를 데이터를 저장하는 클래스가 정의되는 패키지]


package mms.member.vo;
//2. 회원 한명의 정보를 저장하는 클래스

public class Member {
//	private : 외부에서 직접적으로 접근 불가, get set같은걸로 접근 가능
	 private int id;
	 private String name; // 식별값
	 private String  Addr;
	 private String nation;
	 private String  email;
	 private int  age;
	 
//  get, set 메소드
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getAddr() {
		return Addr;
	}
	public String getNation() {
		return nation;
	}
	public String getEmail() {
		return email;
	}
	public int getAge() {
		return age;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAddr(String addr) {
		Addr = addr;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setAge(int age) {
		this.age = age;
	}
	 
	 

}
