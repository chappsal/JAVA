package set.treesetmember;

import java.util.Iterator;
import java.util.NavigableSet;
import java.util.TreeSet;

public class TreeSetMember {
	//Member를 관리하는 TreeSet 타입을 포함 관계로 가짐
	private TreeSet<Member> treeSet;
	
	//매개변수가 없는 생성자
	public TreeSetMember() { //오름차순 정렬된 TreeSet 객체 만들어짐
		treeSet = new TreeSet<Member>();
	}

	
	/*-------------------------------------------------------------*/
	
	// ※ Comparator 사용 시 유의점 : TreeSet 생성자에 'Comparator를 구현한 객체'를 매개변수로 전달해야 함
	public TreeSetMember(Member member) { //내림차순 정렬된 TreeSet 객체 만들어짐
		treeSet = new TreeSet<Member>(member);
	}
	
	/*-------------------------------------------------------------*/	
	
	
	//메서드 : 외부에 노출된 버튼
	public void addMember(Member m) { // 회원 추가
		treeSet.add(m); //실질적인 기능은 TreeSet<Member> 객체 안에 있으므로 
		
		/* 1. TreeSet<Member>() 생성자로 객체 생성
		 * add() 호출되면 compareTo() 자동 호출되어 크기(값)을 비교해가며 오름차순 정렬시켜 저장
		 * (반환 값이 0이면 동일 객체로 인식하여 추가 x. 즉, 중복된 객체는 추가 x)
		 * 
		 * 
		 * 2. TreeSet<Member>(Member member) 생성자로 객체 생성
		 * 	    매개변수인 Member 클래스는 반드시 Comparator 인터페이스를 구현해야 함
		 * 	  add() 호출되면 compare() 자동 호출되어 크기를 비교해가며 내림차순 정렬시켜 저장
		 * 
		 * 
		 */
	}
	
	
	//회원 아이디로 삭제
	public boolean removeMember(int memberId) {
		Iterator<Member> itr = treeSet.iterator(); //반복자 생성
		
		while(itr.hasNext()) {
			Member member = itr.next();
			if(member.getMemberId() == memberId) { //회원 아이디를 얻어와 매개값과 비교
				treeSet.remove(member); //실질적인 기능
				return true;
			}
			//else return false; 있으면 안 됨(return 만나면 무조건 해당 메서드는 종료되므로)
		} 
		System.out.println(memberId + "가 존재하지 않습니다.");
		return false;
	}
	
	
	//회원으로 삭제
	public boolean removeMember(Member member) {
		Iterator<Member> itr = treeSet.iterator(); //반복자 생성
		
		while(itr.hasNext()) {
			Member member2 = itr.next();
			if(member.getMemberId() == member.getMemberId()) { //회원 아이디를 얻어와 매개값과 비교
				treeSet.remove(member); //실질적인 기능
				return true;
			}
		} 
		System.out.println(member + "가 존재하지 않습니다.");
		return false;
	}
	
	
	//1. TreeSet<Member>() 생성자로 객체 생성 : 오름차순 정렬
	//2. TreeSet<Member>(Member member) 생성자로 객체 생성 : 내림차순 정렬
	public void showAllMember() { // 오름차순 정렬
		for(Member member : treeSet) {
			/*
			 * 참조변수만으로 원하는 결과가 출력되려면 Member 클래스에서 toString()가 재정의되어야 함
			 * println(참조변수) 호출되면 자동으로 참조변수가 참조하는 객체의 toString()가 호출되어 리턴되는 문자열 출력
			 */
			System.out.println(member); // = System.out.println(member.toString());
		}
		System.out.println();
	}
	
	
	
	//1. TreeSet<Member>() 생성자로 객체 생성 : 내림차순 정렬
	//2. TreeSet<Member>(Member member) 생성자로 객체 생성 : 오름차순 정렬
	public void showAllDesendingMember() { //
		NavigableSet<Member> dMemberSet = treeSet.descendingSet(); //1. 내림차순 정렬된 Set객체 생성 => 2. 오름차순 정렬된 Set객체 생성
		
		//1. 내림차순 방법 1 => 2. 오름차순 방법 1
		
		for(Member member : dMemberSet) {
			System.out.println(member);
		}
		
		
		//1. 내림차순 방법 2 => 2. 오름차순 방법 2
		/* 
		Iterator<Member> itr = dMemberSet.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		System.out.println();
		}
		*/
		
		
		/*
		Iterator<Member> itr = dMemberSet.descendingIterator(); //1. 다시 오름차순 => 2. 다시 내림차순
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		System.out.println();
		*/
		
		
		}
	}