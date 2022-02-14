package studentsubject;

public class StudentSubjectMain {

	public static void main(String[] args) {
		// 학생 생성 -> 과목 추가
		Student s1 = new Student(1001, "홍길동");
		s1.addSubject("자바", 95);
		s1.addSubject("JSP", 87);
		
		Student s2 = new Student(1002, "이순신");
		s2.addSubject("자바", 90);
		s2.addSubject("JSP", 98);		
		s2.addSubject("html", 97);
		
		
		s1.showStudentInfo();
		System.out.println("------------------------------");
		s2.showStudentInfo();
		
		
		
		
		
		
		
	} //main

}
