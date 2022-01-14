package a_project_interface_test;

import java.util.Scanner;


class Person{//이름과 주민번호를 가진 고객 클래스
	//멤버변수
	private String name;//이름 - private 고객 정보는 보안
	private String serialNumber;//주민번호
	
	
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


	@Override
	public String toString() {
		return "[name=" + name + ", serialNumber=" + serialNumber + "]";
	}
	
	
	
}

class Person2 extends Person{
	//멤버변수 추가 
	private String phoneNumber;//전화번호

	Person2(String name, String serialNumber, String phoneNumber) {
		super(name, serialNumber);
		this.phoneNumber = phoneNumber;
	}

	String getPhoneNumber() {
		return phoneNumber;
	}

	@Override
	public String toString() {
		return super.toString()+"[phoneNumber=" + phoneNumber + "]";
	}

	
}

class Person3 extends Person{
	//멤버변수 추가 
	private String address;//주소

	Person3(String name, String serialNumber, String address) {
		super(name, serialNumber);
		this.address = address;
	}

	String getAddress() {
		return address;
	}

	@Override
	public String toString() {
		return super.toString()+"Person3 [address=" + address + "]";
	}
	
	
	
	
}

class Person4 extends Person{
	//멤버변수 추가 
	private String phoneNumber;//전화번호
	private String address;//주소
	
	Person4(String name, String serialNumber, String phoneNumber, String address) {
		super(name, serialNumber);
		this.phoneNumber = phoneNumber;
		this.address = address;
	}

	String getPhoneNumber() {
		return phoneNumber;
	}

	String getAddress() {
		return address;
	}

	@Override
	public String toString() {
		return super.toString()+"Person4 [phoneNumber=" + phoneNumber + ", address=" + address + "]";
	}
	
	
}

public class PI implements P{//PI : 고객 클래스를 관리하는 '매니저 클래스'(이 클래스만 외부에 알리면 됨)
	//멤버변수
	//포함관계로 Person을 관리하는 배열객체 생성	
	private Person[] p;
	int i=0;
	
	
	
	public PI(int personNum) {
		 p = new Person[personNum];
	}



	@Override	
	public void input() throws PersonSizeException{ // 예외 처리 방법-2 로 처리하기:배열의 크기가 차면 PersonSizeException발생
		
		if( i == p.length) {
			throw new PersonSizeException();
		}
		
		System.out.print("이름을 입력하세요 > ");
		String name = MenuViewer.sc.next();
		
		System.out.print("주민등록번호를 입력하세요 > ");
		String serialNumber = MenuViewer.sc.next();
		
		System.out.print("전화번호를 입력하세요(전화번호가 없으면 0입력) > "); 
		String phoneNumber = MenuViewer.sc.next();
		
		System.out.print("주소를 입력하세요(주소가 없으면 \"없음\"입력) > "); 
		String address = MenuViewer.sc.next();
		
		//입력받은 값으로 객체 생성 후 배열에 저장
		if(phoneNumber.equals("0") && address.equals("0")) {
			p[i++] = new Person(name, serialNumber);
		} else if(!phoneNumber.equals("0") && address.equals("0")) {
			p[i++] = new Person2(name, serialNumber, phoneNumber);
		} else if(phoneNumber.equals("0") && !address.equals("0"))  {
			p[i++] = new Person3(name, serialNumber, address);
		} else if(!phoneNumber.equals("0") && !address.equals("0")) {
			p[i++] = new Person4(name, serialNumber, phoneNumber, address);
		}
		
		
	}



	@Override
	public void search() {
		System.out.print("주민등록번호를 입력하세요 > ");
		String serialNumber = MenuViewer.sc.next();//지역변수
		
		String personInfo = search(serialNumber);
		
		if(personInfo != null) {
			show();//"정보출력"->재정의
			
		}else System.out.println("입력한 주민등록번호에 해당하는 고객은 없습니다.");
		
	}
	
	//메서드 오버로딩 : 메서드명은 같아도 된다.단, 매개변수의 수나 타입은 달라야 한다.
	//주민등록번호를 매개값으로 받아 그 고객의 정보 리턴
	private String search(String serialNumber){//사용자가 입력한 주민등록번호
		
		for(Person person:p) {
			String personInfo="";
			
			if(serialNumber.equals(person.getSerialNumber())) {
				
				personInfo = "고객의 이름: " + person.toString();
				
				if(person instanceof Person2) {
					personInfo = ((Person2)person).toString();
				} else if(person instanceof Person3) {
					personInfo = ", 주소: " + ((Person3)person).toString();
				} else if(person instanceof Person4) {
					personInfo = ", 전화번호: " + ((Person4)person).toString() + ", 주소: " + ((Person4)person).toString();
				}
			} return personInfo;
		} return null;
		
	}
	
	/*********************************************************/
	@Override
	public void show() {		
		//P.super.show();//"정보 출력"
		System.out.println("************ [고객 정보 출력] *************");
	}
	
}


























