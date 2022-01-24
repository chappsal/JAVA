package set.hashsetmember;

import java.util.Objects;

//사용자 정의 클래스
public class Member {
	String name;
	int age;
	
	
	public Member(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	
	// 우클릭 -> 소스 -> (Object의) hashCode() 및 equals() 생성 
	
	/*
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Member other = (Member) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	*/
	
	
	
	
	// 같은 객체의 기준 : 이름과 나이가 같으면 같은 객체
	// 우클릭 -> 소스 -> 메소드 대체/구현 -> hashCode() equals() 체크 -> 확인
	
	@Override
	public int hashCode() {
		//방법 -1
		//return name.hashCode() + age;
		
		//방법 -2 검색속도 향상
		//return name.hashCode() + (age%3); // 나머지가 같은 것 중에서만 찾으면 됨
		
		//방법 -3 최신 방법
		return Objects.hash(name, age); //가장 최적화된 해쉬코드를 만들어줌
	}

	
	//해쉬코드 비교 후 같으면 equals() 호출 
	// Object의 equals는 주소를 비교하지만 값을 비교하게 재정의
	@Override
	public boolean equals(Object obj) {  
		if(obj instanceof Member) { // obj가 Member객체 또는 Member 자식 개체이면 true
			Member m = (Member)obj;
			
			if(m.name.equals(this.name) && m.age == this.age) {
				return true;
				//else return false;
			}
		} 
		return false;
	}

	
	
}