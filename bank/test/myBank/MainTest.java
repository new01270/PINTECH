package myBank;

public class MainTest {

	public static void main(String[] args) {
		Member member = new Member("choi","1234");
		System.out.println(member.toString());
		// toString메서드를 부르지않아도 자동으로 불러와짐.
	}

}
