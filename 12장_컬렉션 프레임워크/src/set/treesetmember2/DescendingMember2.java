package set.treesetmember2;

import java.util.Comparator;

public class DescendingMember2 implements Comparator<Member2>{

	//기본생성자
	

	//Member2를 내림차순 정렬
	@Override
	public int compare(Member2 o1, Member2 o2) {
		//내림차순 정렬 방법-1 : 권장하지 않음 (오버플로우, 언더플로우 발생 가능성)
		//return (o1.getMemberId() - o2.getMemberId()) *(-1); //새로 추가되는 값-기존의 비교하는 값 => 반환값이 음수 : 내림차순
		
		//내림차순 정렬 방법-2
		//if(o1.memberId < o2.memberId) return -1;// 새로 추가되는 값 - 기존의 비교하는 값 < 0 => 대표값 1 리턴
		//else if(o1.memberId == o2.memberId) return 0; // 새로 추가되는 값 - 기존의 비교하는 값  == 0 리턴
		//else return 1;// 새로 추가되는 값 - 기존의 비교하는 값 > 0 => -1리턴
		
		//내림차순 정렬 방법-3
		return o1.compareTo(o2) * (-1);
	
	}

}