/*
 * Queue (인터페이스) : '선착순' , 줄을 선 대기열처럼 먼저 추가된 데이터부터 꺼내서 사용하는  (FIFO : First In First Out) 방식 
 */

package queue.mail;

import java.util.LinkedList;
import java.util.Queue;

public class MailQueueMain {

	public static void main(String[] args) {
		//부모 인터페이스 : LinkedList가 List<E>, Queue<E> 구현함
		Queue<Mail> mail = new LinkedList<Mail>(); //Queue에 정의된 추상 메서드를 호출하면 LinkedList에 재정의된 메서드가 호출됨

		//메일이 큐에 순서대로 저장
		mail.offer(new Mail("박미현", "안부인사"));
		mail.offer(new Mail("정혜정", "여행계획"));		
		mail.offer(new Mail("김태경", "볼링계모임"));
		
		System.out.println(mail.peek()); //객체 하나를 꺼내고 큐에서 제거 X
		//System.out.println(mail.peek().toString()); 과 같음
		
		System.out.println();
		
		while(!mail.isEmpty()) { //큐가 비어있지 않는 동안
			Mail eachMail = mail.poll(); //객체 하나를 꺼내고 큐에서 제거 O
		
			switch(eachMail.getMailTitle().substring(0, 2)) {
			case "안부" : System.out.println("보낸 사람: " + eachMail.getToSome()); break;
			case "여행" : System.out.println("보낸 사람: " + eachMail.getToSome()); break;
			case "볼링" : System.out.println("보낸 사람: " + eachMail.getToSome()); break;
			}
		}
		
		System.out.println("큐에 남은 Mail 객체 수 : " + mail.size());
		
		
	}//main

}
