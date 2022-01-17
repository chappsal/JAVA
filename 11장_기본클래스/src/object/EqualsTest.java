package object;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

//라이브러리용
class Student{ //부모:Object
	int studentId; //값을 가짐
	String studentName; //주소를 가짐
	
	Student(int studentId, String studentName){
		super();
		this.studentId = studentId;
		this.studentName = studentName;
	}
	

	
	@Override
	public int hashCode() {
		return Objects.hash(studentId, studentName);
	}



	/*
	 * Object의 s.equals(s1) : 두 객체의 '주소를 비교'하여 같으면 true, 다르면 false
	 * 
	 * 따라서, 값을 비교하도록 재정의해야 함
	 * 이 때, 비교하는 기준을 '아이디와 이름이 모두 같으면' 같은 객체로 인식 - [방법 1]
	 * 이 때, 비교하는 기준을 '아이디만 같으면' 같은 객체로 인식 - [방법 2]
	 * 
	 */
	@Override
	public boolean equals(Object obj) {//Student객체 => Object타입으로 자동 형 변환
		if(obj instanceof Student) {
			Student std = (Student)obj;
			//방법1
			if(std.studentId == this.studentId && (std.studentName).equals(this.studentName)) { //String의 equals()는 이미 값을 비교하도록 재 정의되어 있음
			
			//방법2
			//if(std.studentId == this.studentId) {
				return true;
			} //else return false; 
		}
		
		//obj가 Student객체 또는 Student자식 객체가 아니면  
		return false;
	}
}



//실행용
public class EqualsTest {

	public static void main(String[] args) {
		Student s = new Student(1, "김동준");
		Student s1= s;
		Student s2 = new Student(1, "김동준");
		
		//주소 비교는 중요하지 않음
		if(s == s1) {//주소 비교
			System.out.println("주소가 같다.");
		} else System.out.println("주소가 다르다.");
	
		if(s == s2) {//주소 비교
			System.out.println("주소가 같다.");
		} else System.out.println("주소가 다르다.");
		
		/*
		 * hashCode()재정의 전 : Object의 hashCode() 호출하여 서로 다른 결과가 나옴
		 * hashCode()재정의 후 : Student의 hashCode() 호출하여 같은 결과가 나옴
		 */
		System.out.println("s의 hashCode: " + s.hashCode());
		System.out.println("s2의 hashCode: " + s2.hashCode());
		
		System.out.println("s의 실제 주소 값 : " + System.identityHashCode(s));
		System.out.println("s2의 실제 주소 값 : " + System.identityHashCode(s2));		
		
		
		//주소가 참조하는 값을 비교하는 것이 중요
		if(s.equals(s1)) System.out.println("값이 같다. 즉, 같은 객체");
		else System.out.println("값이 다르다.");
	
		if(s.equals(s2)) System.out.println("값이 같다. 즉, 같은 객체");
		else System.out.println("값이 다르다.");		//값이 같은데 다르다고 출력 : object의 equals를 사용했기 때문
		
		
		System.out.println("--------------------------------------------------");
		
		/* [Hash~시작하는 클래스에서 객체를 추가할 때 '같은 객체 판단하는 방법']
		 * ex) HashSet, HashMap (키 값: 중복 허용하지 않음)
		 * 
		 * 객체를 add(),put()(저장=추가)하기 전에
		 * 1. 반드시 hashCode()메서드 호출
		 * 	  => 리턴된 해쉬코드(정수)값 비교 : 같으면  -> 2. 같은지 한번 더 확인하기 위해 equals()메서드 호출
		 * 										-> true이면 같은 객체로 인식하여 추가하지 않고
		 * 										  false이면 다른 객체로 인식하여 추가
		 * 
		 * 	  => 리턴된 해쉬코드(정수)값 비교 : 다르면  -> 2. 서로 다른 객체로 인식하여 추가함
		 * 
		 * 
		 * ※ 해쉬코드(정수) : 객체의 주소로 만듦
		 * 
		 * [Object]
		 * - Object의 hashCode() : 객체의 '주소 값'으로 해쉬코드 만듦
		 * - 제공받은 Object의 자식 클래스들(ex.String)의 hashCode() : 객체의 '실제 값'으로 해쉬코드 만듦  // int 리턴
		 *
		 * - Object의 equals() : 객체의 '주소 값' 비교
		 * - 제공받은 Object의 자식 클래스들(ex.String)의 equals() : 객체의 '실제 값'으로 해쉬코드 만듦 // true ,false 리턴
		 * 
		 * 그러나, 우리가 만든 '사용자 정의 클래스'는 Object의 hashCode()와 equals()를 재 정의하여 사용해야 함
		 * (단, Set인터페이스를 구현한 클래스(ex.HashSet)를 사용하려면 반드시 재 정의) 
		 * 
		 */
		
		//HashSet으로 Student 관리
		
		//Set : 부모 인터페이스
		Set<Student> set = new HashSet<Student>();
		set.add(new Student(1, "김동준"));		
		set.add(new Student(1, "김동준"));
		
		System.out.println("저장된 총 객체 수-1: " + set.size()) ;
		
		
		HashSet<String> set2 = new HashSet<String>();
		set2.add("김동준");		
		set2.add(new String("김동준"));
		
		System.out.println("저장된 총 객체 수-2: " + set2.size()) ;
		
		
		
		
		
		
		
		
		
		
	}//main
}























