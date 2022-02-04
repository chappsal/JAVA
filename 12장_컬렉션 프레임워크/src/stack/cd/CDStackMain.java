/*
 * Stack (클래스) : 맨 나중에 추가된 데이터를 먼저 꺼내는 (LIFO : Last In First Out) 방식
 * 가장 최근에 추가된 자료부터 반환해주므로 
 * 최근 검색 단어를 찾거나, 장기, 체스 등의 게임에서 수를 무를 때도 응용 가능
 */

package stack.cd;

import java.util.Stack;

public class CDStackMain {

	public static void main(String[] args) {
		Stack<CD> cdBox = new Stack<CD>(); 

		cdBox.push(new CD("BTS")); //1
		cdBox.push(new CD("블랙핑크")); //2
		cdBox.push(new CD("레드벨벳")); //3
		
		CD cd = cdBox.peek(); //스택의 맨 위 객체를 가져오고 "객체를 스택에서 제거 X" (pop하지 않고 보기만 함)
		System.out.println(cd);
		
		cd = cdBox.peek();
		System.out.println(cd);
		
		
		int number=0;
		while(!cdBox.isEmpty()) {
			cdBox.pop();  	//스택의 맨 위 객체를 가져오고 "객체를 스택에서 제거"
			System.out.println(++number + "-CD제목 : " + cd.getCdTitle());
		}
		
		cdBox.clear(); //전체 값 제거 = 초기화
		
		System.out.println("Stack에 남은 CD 객체 수 : " + cdBox.size());
		
		
		/* cd = cdBox.get(0);
		 * 빈 상태에서 index로 접근하여 값을 얻어오려고 하면 
		 * ArrayIndexOutOfBoundsException 예외 발생 -> 프로그램 강제 종료
		 */
		
		//예외처리 방법 1
		try {
			cd = cdBox.get(0);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		//예외처리 방법 2 (권장)
		if(!cdBox.isEmpty()) {
			cd = cdBox.get(0);
			System.out.println(cd);
		}
		
		System.out.println("프로그램이 종료");
		
		
		
		
		
		
	}

}