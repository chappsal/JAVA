package object.deepclone;

import java.util.Arrays;

class Computer {
	String brand;

	Computer(String brand) {
		super();
		this.brand = brand;
	}
}


/*
 * Cloneable 구현하지 않고 clone() 메서드 호출하면
 * CloneNotSupportedException 예외객체 발생하여 복제 실패
 */

class Student implements Cloneable { //Cloneable 구현함으로써 객체를 복제할 수 있는 클래스라고 사용자에게 알림
	/*
	 * 깊은 복제 대상 : 배열, 클래스 타입 (★단, String 제외)
	 * 
	 */
	int studentId; //기본타입 : 깊은 복제에서 제외
	String studentName; //String : 깊은 복제에서 제외(이유: 원본 객체 값 변경 불가능. 변경 시 새로운 객체 생성)
	
	int[] scores; //배열 : 깊은 복제의 대상
	Computer com; //클래스 타입 : 깊은 복제의 대상
	
	
	Student(int studentId, String studentName, int[] scores, Computer com) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.scores = scores;
		this.com = com;
	}
	
	//Object의 clone()메서드는 얕은 복제하므로 문제가 발생할 수 있으므로 깊은 복제가 되도록 제정의 함
	
	/*
	 * 얕은 복제 단점을 해결하기 위해 깊은 복제를 한다
	 * 방법 : 객체를 통째로 복사한 후 객체가 참조하는 또 다른 객체까지 복사한다
	 */
	//★★오버라이딩(=재정의)할 때 부모 메서드 반환 타입을 자손 클래스 타입으로 변경 허용
	
	@Override
	protected Student clone() throws CloneNotSupportedException {
		//1. 먼저 얕은 복제로 객체를 통째로 복사
		Student cpyStudent = (Student)super.clone();
				
		//2. 깊은 복제의 대상이 되는 객체들을 복제
		//배열복사
		cpyStudent.scores = Arrays.copyOf(this.scores, scores.length);
		cpyStudent.com = new Computer(this.com.brand);
		
		//3. 깊은 복제된 cpy를 리턴
		return cpyStudent;
	}
	
	
	
	
	//복제된 Student 리턴
	Student copyStudent() {
		Student cpyStudent = null; //지역변수는 초기화 필수
		try {
			//cpyStudent = (Student)clone();  //Object로부터 상속받은 clone()메서드
			cpyStudent = clone(); //재정의된 메서드가 호출되어 복제된 Student 리턴
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
		return cpyStudent;
	}


	void showStudentInfo() {
		System.out.println("아이디 : "+ studentId);
		System.out.println("이름 : "+ studentName);
		System.out.println("점수 : "+ Arrays.toString(scores));
		System.out.println("컴퓨터 브랜드 : "+ com.brand);
	}
	
}


public class StudentClone {

	public static void main(String[] args) {
		Student orgStudent = new Student(3, "노석찬", new int[] {99, 93}, new Computer("LG"));
		System.out.println("[원본 학생]");
		orgStudent.showStudentInfo();
		
		
		System.out.println(); // 구분용
		
		Student cpyStudent = orgStudent.copyStudent();
		System.out.println("[복제 학생]");
		cpyStudent.showStudentInfo();
		
		
		System.out.println();
		
		System.out.println("--- 복제 학생 값 변경 ---");
		cpyStudent.studentName = "유재훈";   //깊은 복제 대상에서 제외되지만 String타입이라 원본에는 영향 x
		cpyStudent.scores[0] = 100;
		cpyStudent.com.brand = "삼성";
		
		System.out.println("[복제 학생 값 변경 후 원본 학생]");
		orgStudent.showStudentInfo();
		
		System.out.println();
		
		System.out.println("[복제 학생 값 변경 후 복제 학생]");
		cpyStudent.showStudentInfo();
		
		
	}

}








