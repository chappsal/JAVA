package object;

import java.util.ArrayList;

class MyBook implements Cloneable{
	String title; //깊은 복제의 대상에서 제외
	
	public MyBook(String title){
		this.title = title;
	}
	
	public void setTitle(String title){
		this.title = title;
	}
	
	public String toString(){
		return title;
	}

	/*
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	*/
	@Override
	protected MyBook clone() throws CloneNotSupportedException {
		return (MyBook)super.clone();
	
	}
}

public class ObjectArrayClone {

	public static void main(String[] args) {

		ArrayList<MyBook> bookList = new ArrayList<MyBook>();
		
		MyBook book1 = new MyBook("어린왕자");
		MyBook book2 = new MyBook("토지");
		MyBook book3 = new MyBook("백범김구");
		
		bookList.add(book1);
		bookList.add(book2);
		bookList.add(book3);
		
		ArrayList<MyBook> copyList = (ArrayList)bookList.clone();
		copyList.add(new MyBook("지리산"));
		System.out.println(bookList);
		System.out.println(copyList);
	
		System.out.println();
		
		book3.setTitle("홍길동");
		System.out.println(bookList);
		System.out.println(copyList);
		
		copyList.remove(0);
		System.out.println(bookList);
		System.out.println(copyList);
	}
}