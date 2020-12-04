package myBank;

public class Member {
	String id;
	String pw;
	
	
	//생성자를 만들면 컴파일러가 default 생성자를 만들지 않는다.
	public Member() {};
	public Member(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;
	}
	
	//source > Generate toString()
	@Override
	public String toString() {
		return "Member [id=" + id + ", pw=" + pw + "]";
	}
	
}
