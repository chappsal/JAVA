package map.hashmapstudent;

import java.util.Objects;

//사용자 정의 클래스
public class Student { //Key 역할
	
	int studentId; //학번
	String studentName; //이름
	
	
	public Student(int studentId, String studentName) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
	}


	//학번과 이름이 같으면 같은 Student로 인식하게 설정
	
	@Override
	public int hashCode() {
		return Objects.hash(studentId, studentName);
	}


	@Override
	public boolean equals(Object obj) {
		Student s = (Student)obj;
		
		if(s.studentId == studentId && s.studentName.equals(studentName)) {
			return true;
		}
		return false;
	}

	//아래는 이클립스가 자동으로 설정해주는 것 (소스-hashcode및 equals생성)
	//이것말고 직접 재정의하기 (소스-메소드 대체/구현)
	/*
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + studentId;
		result = prime * result + ((studentName == null) ? 0 : studentName.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (studentId != other.studentId)
			return false;
		if (studentName == null) {
			if (other.studentName != null)
				return false;
		} else if (!studentName.equals(other.studentName))
			return false;
		return true;
	}
	*/
	
	@Override
	public String toString() {
		return "학생 [아이디 : " + studentId + ", 이름 : " + studentName + "]"; 
	}
	
}
