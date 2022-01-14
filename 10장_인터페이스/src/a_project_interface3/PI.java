package a_project_interface3;

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


class Person4 extends Person {
	//멤버변수 추가 (private이라 상속은 못 받았음)
	private String phoneNumber;
	private String address;
	
	//기본생성자 Person(){super();}
	
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
	
}




public class PI implements P { //PI : 고객 클래스를 관리하는 '매니저 클래스' (이 클래스만 외부에 알리면 됨)
	//멤버변수
	private Person[] p;//포함관계로 Person을 관리하는 배열객체 생성
	
	//Scanner sc = new Scanner(System.in);
	
	int i =0; //index번호 : 생성된 고객 개체를 저장할때 사용
	
	//생성자
	public PI(int personNum){ //size : 고객 수
		p = new Person[personNum]; //배열: length 멤버변수 (읽기전용) == size
	}
	
	
	
	
	@Override
	//public void input() { // 예외 처리 방법-1
	public void input() throws PersonSizeException { // 예외 처리 방법 -2
		/*
		 * 예외 처리 방법-1 : try{
		 * 					    예외 발생 가능성
		 *					} catch(예외 객체 잡음){
		 *    				     처리(예외 발생시에만 실행)
		 * 					} finally{
		 * 					  try영역에 진입하면 예외 유무에 관계 없이 무조건 실행
		 *					}
		 * 
		 * 예외 처리 방법-2 : input() 메서드를 호출한 곳에(main) 던져서 처리(호출한 곳이 처리)
		 */
		if(i == p.length) // i : index번호 , length : 배열의 크기 
			throw new PersonSizeException(); //수동으로 예외객체 생성 -> JVM에게 던져주면
		/*
		try {
			if(i == p.length) // i : index번호 , length : 배열의 크기 
				throw new PersonSizeException(); //수동으로 예외객체 생성 -> JVM에게 던져주면
		} catch(Exception e) { //예외객체 잡아서  (PersonSizeException : 본인 또는 자식객체만 잡음)
			//아래 메서드가 실행되면 e.getMessage()가 포함되어 '예외 메세지' 출력 + '예외 클래스 종류'와 '예외 발생 경로' 출력
			//e.printStackTrace(); //잘 모르겠으면 얘만 넣으면 됨 but 지저분
			
			System.out.println(e); // 예외 클래스 종류 + 예외 메세지 출력
			
			//System.out.println(e.getMessage()); //예외 메세지만 출력
			return; //해당(input) 메서드 종료 -> main()의 반복문의 그 다음 실행문(break;)으로 돌아가 계속 프로그램 실행
		}
		*/

		
		
		System.out.print("이름을 입력하세요 > ");
		String name = MenuViewer.sc.next(); //지역변수

		System.out.print("주민등록번호를 입력하세요 > ");
		String serialNumber = MenuViewer.sc.next(); //지역변수

		MenuViewer.sc.nextLine();
		
		System.out.print("전화번호를 입력하세요 (없으면 엔터)> ");
		String phoneNumber = MenuViewer.sc.nextLine();    //지역변수
		
		System.out.print("주소를 입력하세요 (없으면 엔터)> ");
		String address = MenuViewer.sc.nextLine();//지역변수

		if(phoneNumber.trim().equals("") && address.trim().equals("")) {
			p[i++] = new Person(name, serialNumber);
		} else if(!phoneNumber.trim().equals("") && address.trim().equals("")) {
			//Person2 객체 -> Person 타입으로 자동 형 변환되어 저장
			p[i++] = new Person2(name, serialNumber, phoneNumber);
		} else if(phoneNumber.trim().equals("") && !address.trim().equals("")) {
			//Person3 객체 -> Person 타입으로 자동 형 변환되어 저장
			p[i++] = new Person3(name, serialNumber, phoneNumber);
		} else if(!phoneNumber.trim().equals("") && !address.trim().equals("")) {
			//Person4 객체 -> Person 타입으로 자동 형 변환되어 저장
			p[i++] = new Person4(name, serialNumber, phoneNumber, address);
		}
	}

	
	@Override
	public void search() {
		System.out.print("주민등록번호를 입력하세요 > ");
		String serialNumber = MenuViewer.sc.next(); //지역변수
		
		String personInfo = search(serialNumber);
		
		if(personInfo != null) {
			show(); //"정보출력" -> 재정의
			System.out.println(personInfo); // String은 toString을  '값을 리턴'하도록 재정의  
			//System.out.println(personInfo.toString()); //위와 같음
		} else System.out.println("입력한 주민등록번호에 해당하는 고객이 없습니다");
	}
	
	
	
	//메서드 오버로딩 : 메서드 명은 같아도 된다. 단, 매개변수의 수나 타입은 달라야 함
	//주민등록번호를 매개 값으로 받아 그 객체(고객)의 정보(위치) 리턴
	private String search(String serialNumber) { //사용자가 입력한 주민번호 //홍대표에게 의뢰받은 것이 아닌 우리가 만든 것 => 보이지 않게 private
		for(Person person:p) { //person : 배열에 저장된 각 주소가 들어있음
			String personInfo = "";
			
			if(serialNumber.equals(person.getSerialNumber())) {
				personInfo += "고객의 이름: " + person.getName();
			
				if(person instanceof Person3) {
					personInfo += ", 주소: " + ((Person3) person).getAddress();
				} else if (person instanceof Person2) {
					personInfo += ", 전화번호: " +((Person2) person).getPhoneNumber();
				} else if(person instanceof Person4) {
					personInfo += ", 전화번호: " + ((Person4) person).getPhoneNumber() + ", 주소: " + ((Person4) person).getAddress();
				}
				
				return personInfo; //return 만나면 메서드 종료되어 더 이상 반복문 실행 안 함
			}
		} // for 끝
		
		return null; // 반복문을 끝나도록 같은 주민번호를 찾지 못 함
	}


	
	/**문법설명*********************************************************************************/
	
	
	@Override
	public void show() {
		//P.super.show(); // "정보출력"
		System.out.println("**************** [고객 정보 출력] ******************");
		
	}
	
	
}














