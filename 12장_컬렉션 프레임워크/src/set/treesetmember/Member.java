/*
 * String이나 Integer등 제공받은 클래스는 Comparable 인터페이스를 이미 구현하여
 * 재정의된 CompareTo()로 오름차순 정렬되어 추가됨
 * 
 *  그런데 내림차순으로 바꾸고 싶은 경우에는 어떻게 해야 하는지?
 *  String이나 Integer 클래스의 경우 final로 선언되어 있어 
 *  compareTo()를 상속받아 내림차순 정렬로 재정의 불가
 *  이러한 경우 Comparator 인터페이스를 구현하여 compare()를 내림차순 정렬로 재정의 후 사용하면 해결
 *  
 *  우리가 만든 사용자 정의 클래스는 Comparable<T> 인터페이스와 Comparator<T> 인터페이스를 함께 구현하여
 *  compareTo()로 '오름차순 정렬'되도록 재정의, compare()로 '내림차순 정렬'되도록 재정의하면 된다
 *  
 *  ※ Comparator 사용 시 유의점 : TreeSet 생성자에 Comparator를 구현한 객체를 매개변수로 전달해야 함
 *  
 */

package set.treesetmember;

import java.util.Comparator;

// 사용자 정의 클래스
public class Member implements Comparable<Member>, Comparator<Member> { 
	// 1. private 멤버변수
	private int memberId; // 회원 아이디
	private String memberName; // 회원 이름

	
	// 2. 생성자
	//public Member() {} // 생성자 하나도 안 만들면 자동으로 생성
	
	public Member(int memberId, String memberName) {
		super();
		this.memberId = memberId;
		this.memberName = memberName;
	}

	/*-------------------------------------------------------------*/
	

	// ※ Comparator 사용 시 유의점 : TreeSet 생성자에 'Comparator를 구현한 객체'를 매개변수로 전달해야 함
	// 생성자 직접 추가 (why? TreeSet 생성자 호출할 때 'Comparator를 구현한 객체'를 매개값으로 주기위해)
	public Member() {
		//super();
	}

	/*-------------------------------------------------------------*/
	

	//public get~ , set~ 메서드를 통해 private 멤버변수에 접근
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	//memberId로 오름차순 정렬
	@Override 
	public int compareTo(Member o) {	
		//오름차순 정렬 방법-1
		return this.memberId - o.memberId; // 새로 추가되는 값 - 기존의 비교하는 값 = 반환값 양수 : 오름차순
										   //								  0 : 중복되어 add()안 됨 
		//오름차순 정렬 방법-2
		//if(this.memberId < o.memberId) return -1;// 새로 추가되는 값 - 기존의 비교하는 값 < 0 => 대표값 -1 리턴
		//else if(this.memberId == o.memberId) return 0; // 새로 추가되는 값 - 기존의 비교하는 값  == 0 리턴
		//else return 1;// 새로 추가되는 값 - 기존의 비교하는 값 > 0 => 1리턴

		/*******************************************************************/
		//내림차순 정렬 방법-1
		//return (this.memberId - o.memberId)*(-1); // 새로 추가되는 값 - 기존의 비교하는 값 = 반환값 음수 : 내림차순
	
		//내림차순 정렬 방법-2
		//if(this.memberId < o.memberId) return -1;// 새로 추가되는 값 - 기존의 비교하는 값 < 0 => 대표값 1 리턴
		//else if(this.memberId == o.memberId) return 0; // 새로 추가되는 값 - 기존의 비교하는 값  == 0 리턴
		//else return 1;// 새로 추가되는 값 - 기존의 비교하는 값 > 0 => -1리턴
	
	}


	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", memberName=" + memberName + "]";
	}


	/*-------------------------------------------------------------*/
	
	//memberId로 내림차순 정렬
	@Override
	public int compare(Member o1, Member o2) {
		// TODO 자동 생성된 메소드 스텁
		//return o1.memberId - o2.memberId; //새로 추가되는 값 - 기존의 비교하는 값 : 오름차순
		return (o1.memberId - o2.memberId)*(-1); //내림차순
	}
	
	/*-------------------------------------------------------------*/
	
	
	
	
	
	
	
}