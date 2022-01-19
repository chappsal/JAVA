package classex;

public class Person {

	private String name;
	private int age;
	
	
	public Person() { // 생성자 1 : 기본값으로 채워진 객체
		super();
	}


	public Person(String name) { // 생성자 2 : 입력받은 이름으로 채워진 객체
		super();
		this.name = name;
	}


	public Person(String name, int age) { //생성자 3 : 입력받은 이름, 나이로 채워진 객체
		super();
		this.name = name;
		this.age = age;
	}


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
	
	
}