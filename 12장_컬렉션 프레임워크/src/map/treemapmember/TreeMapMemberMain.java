package map.treemapmember;

public class TreeMapMemberMain {

	public static void main(String[] args) {
		TreeMapMember tmm = new TreeMapMember();

		Member m3 = new Member(3, "장수호");
		tmm.addMember(m3);

		Member m1 = new Member(1, "박영현");
		tmm.addMember(m1);
				
		Member m2 = new Member(2, "최희윤");
		tmm.addMember(m2);
		
		tmm.showAllMember();
		System.out.println();
		//------------------------------------
		
		Member m3_2 = new Member(3, "유재훈"); //같은 아이디로 회원 추가
		tmm.addMember(m3_2);
		
		tmm.showAllMember(); //중복 아이디의 값 변경 (장수호 -> 유재훈)
		System.out.println();
		
		Member m4 = new Member(4, "노석찬");
		tmm.addMember(m4);
		
		tmm.showAllMember();
		System.out.println();
		
		//아이디(4)로 Entry<4, 4노석찬> 삭제
		tmm.removeMember(4);
		tmm.showAllMember();
		System.out.println();
		
		//회원(2최희윤)으로 Entry<2, 2최희윤> 삭제
		tmm.removeMember(m2);
		System.out.println();
		
		tmm.showAllMember();
		System.out.println();
		tmm.showAllDesendingMember();
		
		
		
	}

}