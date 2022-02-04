/*
 * Queue (인터페이스) : '선착순' , 줄을 선 대기열처럼 먼저 추가된 데이터부터 꺼내서 사용하는  (FIFO : First In First Out) 방식 
 */


package queue;

import java.util.ArrayList;


//ArrayList로 Queue 구현하기
class MyQueue {
	//멤버변수(=필드) : ArrayList<String>을 포함관계
	private ArrayList<String> arrayQueue = new ArrayList<String>(); //String을 관리하는 ArrayList객체

	//(보이지 않는)기본생성자
	
	
	/*
	기존에는 아래처럼 생성자를 만들었다면 위처럼 기본생성자를 만들수도 있음
	
	private ArrayList<String> arrayQueue //멤버변수
	
	MyQueue() {							 //생성자
		new ArrayList<String>();
	}
	*/
	
	//메서드
	void push(String data) { //외부에 노출된 메서드
		arrayQueue.add(data);
	}
	
	
	String pop() {
		int number = arrayQueue.size(); //0 1 2 3 -> 0 1 2 -> 0 1 -> 1 (ArrayList특징 : 삭제되면 앞으로 이동)
		
		if(number == 0) {
			System.out.println("큐가 비었습니다");
			return null;
		}
		return (arrayQueue.remove(0));
	}
			
}



public class QueueTest_ArrayList {

	public static void main(String[] args) {
		
MyQueue queue = new MyQueue();
		

		queue.push("a"); //0
		queue.push("b"); //1
		queue.push("c"); //2
		queue.push("d"); //3
		
		System.out.println(queue.pop()); //"a"
		System.out.println(queue.pop()); //"b"
		System.out.println(queue.pop()); //"c"
		System.out.println(queue.pop()); //"d"

	}

}
