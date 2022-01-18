/* < Object의 clone() 메서드 >
 * 
 * 1. 얕은 복사 : 멤버변수(=필드)만 복제
 * (1). 기본타입 : 값을 복사
 * (2). 클래스타입(객체의 주소를 참조하는 참조변수) : 객체의 주소 복사  (ex)배열, 클래스타입
 * 	즉, 객체를 통째로 복사하지만 객체가 참조하는 또 다른 객체까지 복사하지 못 함
 * 	그래서 아래의 단점 발생
 *  
 *  
 * 2. 얕은 복사 단점
 * 복제 객체에서 참조변수가 참조하는 객체의 값,주소를 변경하면
 * 원본 객체의 참조변수가 참조하는 객체의 값,주소도 함께 변경됨
 * (★★ 단, String은 제외) : 기존 객체 값이 바뀌는게 아니라 새로운 객체가 생성되어 둘은 다른 객체를 참조
 * 
 * 
 * 3. 이 clone()메서드로 객체를 복제하려면 원본 객체는 반드시
 * java.lang.Cloneable 인터페이스를 구현해야 함
 * 구현하지 않으면 clone() 호출할 때 
 * CloneNotSupportedException 예외 발생하여 복제 실패
 * 
 * 
 * 4. CloneNotSupportedException 예외 처리가 필요한 메서드이기 때문에
 * try-catch()로 예외 처리해야 함
 * 
 */

package object.clone;


class Point implements Cloneable{ //점   // 1.객체를 복제할 수 있는 클래스
	private int xPos;
	private int yPos;
	Integer i = new Integer(123);
	
	Point(int xPos, int yPos) {
		super();
		this.xPos = xPos;
		this.yPos = yPos;
	}
	
	
	void showPosition() { 
		System.out.printf("[%d, %d]", xPos, yPos);
	}
	
	
	
	//매개 값으로 기존 값 변경
	void changePosition(int x, int y) {
		xPos = x;
		yPos = y;
	}


	//Object의 clone() 메서드로 복제할 수 있도록 함
	@Override
	protected Object clone() throws CloneNotSupportedException { //throws : 던져줌
		return super.clone(); //Object의 clone() 메서드 : 얕은 복제
	}
	
	
	
}


class Rectangle implements Cloneable { //사각형
	private Point upperLeft, lowerRight; //class Point 포함관계
	
	Rectangle(int x1, int y1, int x2, int y2) {
		super();
		upperLeft = new Point(x1, y1);
		lowerRight = new Point(x2, y2);
	}
	
	void showPosition() {
		System.out.println("사각형 위치 정보....");
		System.out.print("좌 상단: "); upperLeft.showPosition(); // [x1, y1]
		System.out.print(" 우 하단: "); lowerRight.showPosition(); // [x2, y2]
		System.out.println("\n"); //커서를 아래로 내린 다음 빈 줄
	}
	
	
	//매개 값으로 기존 값 변경
	void changePosition(int x1, int y1, int x2, int y2) {
		upperLeft.changePosition(x1, y1);
		lowerRight.changePosition(x2, y2);
	}

	
	//★★오버라이딩(=재정의)할 때 부모 메서드 반환 타입을 자손 클래스 타입으로 변경 허용
	@Override
	protected Rectangle clone() throws CloneNotSupportedException {
		return (Rectangle)super.clone();
	}
	
	/*
	//★★오버라이딩(=재정의)할 때 부모 메서드 반환 타입을 자손 클래스 타입으로 변경 허용
	
	@Override
	protected Point clone() throws CloneNotSupportedException { 
		return (Point)super.clone(); //Object의 clone() 메서드 : 얕은 복제 					
	}
	 
	 */
	
}



public class ShallowCopy {

	public static void main(String[] args) {
		System.out.println("-----Point 얕은 복사-----");
		Point p = new Point(1, 1);
		System.out.println("[원본 Point]");
		p.showPosition();

		System.out.println();
		Point pointCpy;
		
		try {
			if(p instanceof Point) {
				pointCpy = (Point)p.clone();
				System.out.println("[복사 Point]");
				pointCpy.showPosition();
				
				System.out.println();
				System.out.println("---[원본 Point 정보 변경]---");
				p.changePosition(3, 3);
				
				System.out.println();
				System.out.println("[변경 후 원본 Point]");
				p.showPosition();
				
				System.out.println();
				System.out.println("[변경 후 복제 Point]");
				pointCpy.showPosition();
			}
		} catch (CloneNotSupportedException e1) {
			e1.printStackTrace();
		}
		
		
		System.out.println();
		System.out.println("-----Rectangle 얕은 복사-----");
		Rectangle org = new Rectangle(1, 1, 9, 9);
		System.out.println("[원본 직사각형]");
		org.showPosition();

		Rectangle cpy;
		
		try {
			//if(org instanceof Rectangle) {

				//cpy = (Rectangle) org.clone();
				cpy = org.clone();
				System.out.println("[복사 직사각형]");
				cpy.showPosition();

				
				System.out.println("---[원본 직사각형 정보 변경]---");
				org.changePosition(2, 2, 7, 7); // org 포지션 변경
				
				System.out.println("[원본 직사각형]");	
				org.showPosition();    			

				System.out.println("[복사 직사각형]");	
				cpy.showPosition();    			// 원본을 변경했는데 복사까지 변경됨
				
				System.out.println("---[복사 직사각형 정보 변경]---");
				org.changePosition(3, 3, 10, 10); // org 포지션 변경
				
				System.out.println("[원본 직사각형]");	
				org.showPosition();    			
				
				System.out.println("[복사 직사각형]");	
				cpy.showPosition();    			// 복사를 변경했는데 원본까지 변경됨
			//}
		} catch (CloneNotSupportedException e) {
			//e.printStackTrace(); //예외 클래스 이름+메세지+경로.. 지저분함
			//System.out.println(e); //예외 클래스 이름 + 예외 메세지
			System.out.println(e.getMessage()); // 예외 메세지
		}
		
		
		
	}

}


















