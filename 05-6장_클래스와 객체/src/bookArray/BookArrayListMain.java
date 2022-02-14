package bookArray;

import java.util.ArrayList;
import java.util.Arrays;

import book.Book;

public class BookArrayListMain {

	public static void main(String[] args) {
		/*
		 * 2. ArrayList 이용하여 객체 관리 - 삭제, 추가 편리 
		 * 	    초기화가 안되는 단점       
		 *    해결법: Arrays.asList() 메서드 사용하여 초기화 가능
		 * 	 (배열은 초기화가 가능 ex. int[] arr = {1,2,3})
		 */
		
		ArrayList<Book> library = new ArrayList<Book>(); // <Book> (다이아몬드 연산자) : Book 클래스 또는 Book 클래스의 자식 객체만
										   	  // ↑ 생략가능 컴파일러가 앞의 <>를 보고 유추함				
		library.add(new Book("태백산맥", "조정래", 1));
		library.add(new Book("토지", "박경리", 2));
		library.add(new Book("어린왕자", "생텍쥐베리", 3));
		
		System.out.println("** size() 사용 : 저장된 객체수 **");
		int i;
		for(i=0; i<library.size(); i++) { //length 없음 자리가 10인데 남는 자리는 null이 되기 때문에 size()만 두고 저장된 객체의 수만 체크
			System.out.println(library.get(i));
			//System.out.println(library.get(i).toString()); 위 아래 같음. toString 생략가능. 재정의 하면 값이 나오고 안했으면 @
		}
		System.out.println();
		
		
		// 향상된 for : 값을 참조할 때만 사용. 값 변경 불가 (index 사용하지 않음)
		System.out.println("**** 반복문 향상된 for 사용 ****");
		for( Book b : library) {
			System.out.println(b);
		}
		System.out.println();
		
		
		System.out.println("**** Book 추가 ****");
		library.add(1, new Book("신데렐라", "작자미상", 4)); // 원래 index 4 위치인데 1로 옮겨보기
		
		for( Book b : library) {
			System.out.println(b);
		}
		System.out.println();
		
		
		System.out.println("**** Book 삭제 1 (신데렐라 Book) : index로 삭제 ****");
		System.out.println(library.remove(1)); 
		System.out.println();
		
		
		System.out.println("**** Book 삭제 2 : 객체로 삭제 ****");
		if(library.remove(new Book("신데렐라", "작자미상", 4))) 
			System.out.println("찾아서 삭제함");
		else System.out.println("찾았는데 없어서 삭제못함"); // "찾았는데 없어서 삭제못함"
		
		
		if(library.remove(new Book("태백산맥", "조정래", 1))) 
			System.out.println("찾아서 삭제함");
		else System.out.println("찾았는데 없어서 삭제못함"); // "찾아서 삭제함" : Book 클래스에 hashCode(), equals() 메서드 멤버 변수의 값으로 재정의

		
		if(library.remove(new Integer(1))) // library는 Book객체만 다룸, "홍길동 이야기"는 String 객체
			System.out.println("찾아서 삭제함");
		else System.out.println("찾았는데 없어서 삭제못함"); // "찾았는데 없어서 삭제못함"
		System.out.println();
		
		System.out.println("**** toString() 사용 ****");
		System.out.println(library.toString());	// 배열처럼 출력되게 재정의 되어있음 
		System.out.println();
		
		
		System.out.println("------------------Integer------------------------");
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		numbers.add(new Integer(1));
		numbers.add(2); // 자동 박싱됨 (2 -> Integer 객체 2)
		numbers.add(3);
		numbers.add(45);
		
		
		System.out.println("**** 향상된 for 사용 ****");
		for( int value : numbers) { // 자동 언박싱 (Integer 객체 1 -> 1)
			System.out.print(value + " ");
		}
		System.out.println(); // 커서 아래로
		
		
		System.out.println("**** Integer 2 삭제 ****");
		//numbers.remove(1); // numbers.remove : 삭제된 Integer 객체의 주소
		System.out.println(numbers.remove(1).toString());
		
		
		System.out.println("**** Integer 3 찾아서 있으면 삭제 후 true ****");
		if(numbers.remove(new Integer(3))) 
			// Integer 클래스는 hashCode(), equals() 메서드를 이미 재정의함
			System.out.println("찾아서 삭제함"); 
		else System.out.println("찾았는데 없어서 삭제못함"); // "찾아서 삭제함"
			
		
		System.out.println("**** 향상된 for 사용 ****");
		for( int value : numbers) { // 자동 언박싱 (Integer 객체 1 -> 1)
			System.out.print(value + " ");
		}
		System.out.println();
		
		
		System.out.println("**** toString() 사용 ****");
		System.out.println(numbers.toString());	// [1, 45] 배열처럼 출력되게 재정의 되어있음 
		System.out.println();
		
		
		System.out.println("-----String(ArrayList의 초기화가 안되는 단점 해결 : Arrays.asList())-----");
		// 1. (처리하고 싶은)배열 객체 생성
		String[] fruitsArr = {"apple", "banana", "mango", "kiwi"};
		// 2. Arrays.asList(초기화된 배열 객체) 사용하여 초기화된 ArrayList 객체 생성
		ArrayList<String> fruits = new ArrayList<String>(Arrays.asList(fruitsArr));
		fruits.add("딸기");
		
		System.out.println("모두 = "+fruits.toString());
		fruits.remove(1); // index로 삭제
		System.out.println("삭제 후 = "+fruits.toString());
		
		fruits.remove(new String("딸기")); // object(객체)로 삭제
		System.out.println("삭제 후 = "+fruits.toString());
		
		fruits.remove("kiwi");		
		System.out.println("삭제 후 = "+fruits.toString());
		
		/*
		String은 new로 생성하는 법, 문자열 객체로 생성하는 법 두가지가 있음
		new 는 같은 값이어도 다른 주소로 생성됨
		재정의해서
		같은 해쉬코드 값을 equals로 찾음
		new를 이용하지 않으면 
		new는 새로운 객체를 만들고 아닌건 기존의 객체를 참조하는것 암튼 해쉬코드 어쩌고로 해야 삭제 가능함
		----------------------------------------------------------------
		주소로 해쉬코드를 만들면 다른 값으로 인식
		값으로 해쉬코드를 만들면 같은 값으로 인식
		
		멤버변수의 값으로 만든 해쉬코드가 같음(값은 다름)
		equals는 진짜 멤버변수의 값이 같은지 비교
		
		그래서 해쉬코드랑 이퀄스 둘 다 있어야 함 // Book.java 에 만들은 재정의 메서드
		*/
		System.out.println("------------------Integer------------------------");
		

		
		
		
		
		
		
	} //main
}