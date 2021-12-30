package bookArray;

import book.Book;

public class BookArrayMain {

	public static void main(String[] args) {
		Book[] library = new Book[3]; // [null,null,null]
		
		library[0] = new Book("태백산맥", "조정래", 1);
		library[1] = new Book("토지", "박경리", 2);
		library[2] = new Book("어린왕자", "생텍쥐베리", 3);
		//library[3] = new Book("신데렐라", "작자미상", 4);  // 컴파일 오류(문법적인 오류) 없음.  but, 실행 시 오류
		
		System.out.println(library[0]);
		System.out.println(library[1]);
		System.out.println(library[2]); // 주소로 접근했으나  tostring을 재정의 했기 때문에 출력시 나옴.
		
		System.out.println("**** 반복문 for 사용 ****");
		int i;
		for(i=0; i<library.length; i++) {
			System.out.println(library[i]);
		}
		

		// 향상된 for : 값을 참조할 때만 사용. 값 변경 불가 (index 사용하지 않음)
		System.out.println("**** 반복문 향상된 for 사용 ****");
		for( Book b : library) {
			System.out.println(b);
			b.showBookInfo();
		}
		
		System.out.println("--------------------------------------------------------------------");
		for( Book b : library) {
			b.showBookInfo();
		}
		
		System.out.println("------ 토지 객체 삭제 후 출력  -----------------");
		library[1] = library[2];
		library[2] = null;
		for( Book b : library) {
			System.out.println(b);
		}
	
		System.out.println("------ 새 객체 추가  -----------------");
		library[2] = new Book("신데렐라", "작자미상", 4);
		for( Book b : library) {
			System.out.println(b);
		}
		
		
		/*
		 * 배열로 처리 문제 ?
		 * 1. 배열은 크기 고정 : 메모리 비효율적으로 사용 
		 * 					ex) length==100, 그런데 1개만 사용 -> 나머지는 놀고 있는 문제
		 * 						length==100, 그런데 1개가 더 필요 -> 크기 변경 불가
		 * 
		 * 2. 추가와 삭제에 대한 코드를 프로그래머가 작성해야 하지만
		 *    [컬렉션 프레임워크]를 이용하여 간단하게 해결할 수 있다.
		 *    ex) ArrayList, Vector, LinkedList ...
		 */
		
	}

}