package set.treesetmember;

public class TreeSetMemberMain {

	public static void main(String[] args) {
		System.out.println("------- 처음부터 오름차순 정렬 -------");
		TreeSetMember tsm = new TreeSetMember(); // 매개변수가 없는 생성자 호출 -> 오름차순 정렬 TreeSet 객체 생성

		//Member 클래스가 Comparable 인터페이스를 구현하지 않고 저장하는 순간 ClassCastException 예외 발생
		Member m1 = new Member(3, "박영현");
		tsm.addMember(m1);
	
		Member m2 = new Member(1, "최희윤");
		tsm.addMember(m2);
		
		Member m3 = new Member(2, "유신재");
		tsm.addMember(m3);
		
		tsm.showAllMember();
	
		Member m3_2 = new Member(3, "장수효"); //중복 아이디 회원 추가
		tsm.addMember(m3_2);
	
		tsm.showAllMember(); //아이디 중복되어 추가 안 됨
	
		Member m4 = new Member(4, "장수효"); //다른 아이디로 회원 추가
		tsm.addMember(m4);
	
		tsm.showAllMember(); 
		
		tsm.removeMember(4); //아이디로 삭제
		tsm.removeMember(m3); //Member(2, "유신재") 삭제
		
		System.out.println("------- 삭제 후 Member -------");
		System.out.println("오름차순");
		tsm.showAllMember();
		

		System.out.println("내림차순");
		tsm.showAllDesendingMember();
	
	
		System.out.println("*******************************************");
		System.out.println("------- 처음부터 내림차순 정렬 -------");
		TreeSetMember tsm2 = new TreeSetMember(new Member()); // 매개변수가 있는 생성자 호출 -> 내림차순 정렬 TreeSet 객체 생성

	
		//Member 클래스가 Comparator 인터페이스를 구현하지 않고 저장하는 순간 ClassCastException 예외 발생
		Member m5 = new Member(5, "노석찬");
		tsm2.addMember(m5);
	
		Member m7 = new Member(7, "박미현");
		tsm2.addMember(m7);
		
		Member m6 = new Member(6, "정혜정");
		tsm2.addMember(m6);
		
		tsm2.showAllMember();
	
		Member m5_2 = new Member(5, "김태경"); //중복 아이디 회원 추가
		tsm2.addMember(m5_2);
	
		tsm2.showAllMember(); //아이디 중복되어 추가 안 됨
	
		Member m8 = new Member(8, "정성훈"); //다른 아이디로 회원 추가
		tsm2.addMember(m8);
	
		tsm2.showAllMember(); 
		
		tsm2.removeMember(6); //아이디로 삭제
		tsm2.removeMember(m8); //Member(8, "정성훈") 삭제
		
		System.out.println("------- 삭제 후 Member -------");
		System.out.println("내림차순");
		tsm2.showAllMember();
		

		System.out.println("오름차순");
		tsm2.showAllDesendingMember();
	
	
	
	}

}