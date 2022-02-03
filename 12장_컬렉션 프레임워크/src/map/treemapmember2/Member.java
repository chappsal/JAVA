/*
 *  String이나 Integer등 제공받은 클래스는 Comparable 인터페이스를 이미 구현하여
 *  재정의된 CompareTo()로 오름차순 정렬되어 추가됨
 * 
 *  그런데 내림차순으로 바꾸고 싶은 경우에는 어떻게 해야 하는지?
 *  String이나 Integer 클래스의 경우 final로 선언되어 있어 
 *  compareTo()를 상속받아 내림차순 정렬로 재정의 불가
 *  이러한 경우 Comparator 인터페이스를 구현하여 compare()를 내림차순 정렬로 재정의 후 사용하면 해결
 *  
 *  우리가 만든 사용자 정의 클래스는 Comparable<T> 인터페이스와 Comparator<T> 인터페이스를 함께 구현하여
 *  compareTo()로 '오름차순 정렬'되도록 재정의, compare()로 '내림차순 정렬'되도록 재정의하면 된다
 *  
 *  ※ Comparator 사용 시 유의점 : TreeMap 생성자에 Comparator를 구현한 객체를 매개변수로 전달해야 함
 *  
 */


package map.treemapmember2;


//사용자 정의 클래스
public class Member {
	
	// 1. 멤버변수
	private int memberId;
	private String memberName;
	
	// 2. 생성자
	public Member(int memberId, String memberName) {
		super();
		this.memberId = memberId;
		this.memberName = memberName;
	}

	//3. public get~ , set~ 메서드를 통해 private 멤버변수에 접근
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
	
	

	@Override
	public String toString() {
		return "회원 [아이디=" + memberId + ", 이름=" + memberName + "]";
	}

	
	
}