package studentsubject;

public class Subject {
	//정보보안
	private String subjectName;//과목명
	private int subjectScore; //성적

	
	public Subject(String subjectName, int subjectScore) {
		super();
		this.subjectName = subjectName;
		this.subjectScore = subjectScore;
	}


	//접근가능한 메서드를 통해 private 멤버변수의 값을 알기위해 간접접근  
	String getSubjectName() {
		return subjectName;
	}


	int getSubjectScore() {
		return subjectScore;
	}
	
	




} //class subject
