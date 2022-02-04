/*
 * Stack (클래스) : 맨 나중에 추가된 데이터를 먼저 꺼내는 (LIFO : Last In First Out) 방식
 * 가장 최근에 추가된 자료부터 반환해주므로 
 * 최근 검색 단어를 찾거나, 장기, 체스 등의 게임에서 수를 무를 때도 응용 가능
 */


package stack;

import java.util.ArrayList;

//ArrayList로 Stack 구현하기
class MyStack {
	//멤버변수(=필드) : ArrayList<String>을 포함관계
	private ArrayList<String> arrayStack = new ArrayList<String>(); //String을 관리하는 ArrayList객체

	//(보이지 않는)기본생성자
	
	
	/*
	기존에는 아래처럼 생성자를 만들었다면 위처럼 기본생성자를 만들수도 있음
	
	private ArrayList<String> arrayStack //멤버변수
	
	MyStack() {							 //생성자
		new ArrayList<String>();
	}
	*/
	
	//메서드
	void push(String data) { //외부에 노출된 메서드
		arrayStack.add(data);
	}
	
	
	String pop() {
		int number = arrayStack.size(); //0 1 2 3(마지막 index), size() = 4
		
		if(number == 0) {
			System.out.println("스택이 비었습니다");
			return null;
		}
		return (arrayStack.remove(number-1));
	}
	
	
	

} //MyStack class



public class StackTest_ArrayList {
	//기본생성자
	public static void main(String[] args) {
		
		MyStack stack = new MyStack();
		

		stack.push("a"); //0
		stack.push("b"); //1
		stack.push("c"); //2
		stack.push("d"); //3
		
		System.out.println(stack.pop()); //"d"
		System.out.println(stack.pop()); //"c"
		System.out.println(stack.pop()); //"b"
		System.out.println(stack.pop()); //"a"
		
		
		

	}

}

