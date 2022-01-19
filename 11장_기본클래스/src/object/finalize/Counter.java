package object.finalize;

public class Counter {
	private int no;

	
	public Counter(int no) {
		super();
		this.no = no;
	}

	/*
	 * 참조하지 않는 배열이나 객체를 GC(가비지 콜렉터)를 사용해 heap영역에서 제거시킴
	 * 이러한 기능을 수행하는 메서드가 바로 finalize()
	 * 자동으로 실행되는 finalize() 메서드를 사용자가 원할경우
	 * 직접 오버라이딩(재정의)하여 사용할 수 있다.
	 */

	@Override
	protected void finalize() throws Throwable {
		super.finalize(); //Object의 finalize()는 텅 비어서 하는 일이 아무 것도 없지만 안전성을 고려해서 삽입
		System.out.println(no + "번 객체의 finalize()가 실행됨");
	}
	
	
}
