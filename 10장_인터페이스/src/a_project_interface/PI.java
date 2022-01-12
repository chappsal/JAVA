package a_project_interface;

import java.util.Scanner;

/*
 * PI클래스는 P인터페이스를 구현함
 * 
 * -부모는 1개 상속, 인터페이스는 여러개 구현 가능
 * ex) public class PI implements P, P2, P3 {
		부모 A 클래스의 멤버는 상속받아 사용받아 사용(단 생성자, 초기화블록, private 멤버는 상속되지 않음)
		필요시 메서드 재정의
	
	-P, P2, P3 인터페이스의 미완성된 추상메서드는 반드시 재정의
		}

	ex) public class ArrayLisst<E> extends AbstractList<E>
		implements List<E>, RandomAccess, Cloneable, Serializable{
		
		}
		-인터페이스 이름을 보고 구현한 클래스가 어떤 기능을 가진 클래스인지 유추 가능함
		-able로 끝나는 이름은 거의 대부분 인터페이스임
 */
class Person {//이름과 주민번호를 가진 고객 클래스
	private String name;		//이름 - private 고객 정보는 보안
	private String serialNumber;//주민번호
	
	//생성자가 있으면 컴파일러가 컴파일 전에 기본생성자 삽입 안 함 
	//Person(){} // 기본생성자가 있어야 Person2에서 생성자를 만들지 않아도 오류 나지 않음
	
	Person(String name, String serialNumber) {
		super();
		this.name = name;
		this.serialNumber = serialNumber;
	}

	String getName() {
		return name;
	}

	String getSerialNumber() {
		return serialNumber;
	}
	
	
}


class Person2 extends Person {
	//멤버변수 추가 (private이라 상속은 못 받았음)
	private String phoneNumber;

	//기본생성자 Person(){super();}
	
	Person2(String name, String serialNumber, String phoneNumber) {
		super(name, serialNumber);
		this.phoneNumber = phoneNumber;
	}

	//상속받은 메서드+추가
	String getPhoneNumber() {
		return phoneNumber;
	}
}

class Person3 extends Person {
	//멤버변수 추가 (private이라 상속은 못 받았음)
	private String address;

	//기본생성자 Person(){super();}
	
	Person3(String name, String serialNumber, String address) {
		super(name, serialNumber);
		this.address = address;
	}

	String getAddress() {
		return address;
	}

}




public class PI implements P { //PI : 고객 클래스를 관리하는 '매니저 클래스' (이 클래스만 외부에 알리면 됨)
	//멤버변수
	private Person[] p;//포함관계로 Person을 관리하는 배열객체 생성
	
	Scanner sc = new Scanner(System.in);
	
	int i =0; //index번호 : 생성된 고객 개체를 저장할때 사용
	
	//생성자
	public PI(int personNum){ //size : 고객 수
		p = new Person[personNum]; //배열: length 멤버변수 (읽기전용) == size
	}
	
	
	
	
	@Override
	public void input() {
		System.out.print("이름을 입력하세요 > ");
		String name = sc.next(); //지역변수

		System.out.print("주민등록번호를 입력하세요 > ");
		String serialNumber = sc.next(); //지역변수

		System.out.print("전화번호를 입력하세요 (없으면 0 입력)> ");
		String phoneNumber = sc.next(); //지역변수
		
		System.out.print("주소를 입력하세요 (없으면 '없음' 입력)> ");
		String address = sc.next(); //지역변수

		if(!phoneNumber.equals("0") && address.equals("없음")) {
			p[i++] = new Person2(name, serialNumber, phoneNumber);
		} else if(phoneNumber.equals("0") && !address.equals("없음")) {
			p[i++] = new Person3(name, serialNumber, phoneNumber);
		}
	}

	@Override
	public void search() {
		
	}
	
	
	
	
	
	
	
	
}