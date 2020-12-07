package bank;

public class EmpVO {
	/*
	 * empList1
	 * { "empList" : [ {"name":"scott", "age":20, "addr":"대구"},
	 * {"name":"king", "age":25, "addr":"서울"}, {"name":"steven", "age":30,
	 * "addr":"부산"} ] }
	 * 
	 * empList3
	 * [ {"name":"scott", "age":20, "addr":"대구"}, {"name":"king", "age":25,
	 * "addr":"서울"}, {"name":"steven", "age":30, "addr":"부산"} ]
	 */
	
	private String name;
	private int age;
	private String addr;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}
}
