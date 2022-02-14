package studentsubject;

import java.util.ArrayList;

public class Student {
	//1. 멤버변수 =필드 : 속성 (옵션)
	int studentID;
	String studentName;
	
	
	//★★수강하는 과목을 처리해주는 멤버변수(클래스간의 포함관계)
	private ArrayList<Subject> subjectList;

	
	//2. 생성자
	public Student(int studentID, String studentName) {
		super();
		this.studentID = studentID;
		this.studentName = studentName;
	
		subjectList = new ArrayList<Subject>();
	
	}


	//생성자
	/*
	public Student(int studentID, String studentName, ArrayList<Subject> subjectList) {
		this.studentID = studentID;
		this.studentName = studentName;
		this.subjectList = subjectList;
	}
	*/
	
	
	//3. 메서드 : 수강한 과목과 점수 추가
	
	public void addSubject(String subjectName, int subjectScore) {
		Subject subject = new Subject(subjectName, subjectScore);
		subjectList.add(subject);
		
		//subjectList.add(new Subject(subjectName, subjectScore));
	}
	
	//학생이 수강하는 과목의 성적 출력, 총점과 평균 출력
	public void showStudentInfo() {
		double totalScore = 0;
		for(Subject s:subjectList) {
			
			totalScore += s.getSubjectScore();
			System.out.println("학생 " +studentName+"의 " +s.getSubjectName()+" 성적은 " +s.getSubjectScore()+"점 입니다.");
		}
		//System.out.println("학생 " +studentName+"의  총점은 " + totalScore +", 평균은 " + totalScore/subjectList.size()+ "점 입니다.");
		System.out.printf("학생 %s의  총점은 %.0f, 평균은 %.2f점 입니다. \n" , studentName, totalScore, totalScore/subjectList.size());
	}
	 	
	
	
	
	
	
	
	
	
	
	
	
} //class student