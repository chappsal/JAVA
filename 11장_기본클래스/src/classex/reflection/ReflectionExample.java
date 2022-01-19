/*
 * 일반적으로 클래스의 자료형을 모르는 상태에서 Class 클래스를 활용하여 그 클래스의 정보를 가져오고
 * 이 정보를 활용하여 객체를 생성하거나 메서드를 호출하는 방식 : reflection
 * 
 * Class 클래스는 reflection을 위해 메서드를 제공
 * java.lang.reflect 패키지에 소속되어 있음
 * 
 * 각각 생성자 배열, 필드 배열, 메서드 배열로 리턴
 * 1. getDeclaredConstructors(), getDeclaredFields(), getDeclaredMethods() : 클래스에 선언된 멤버만 가져옴
 * 2. getConstructos(), getFields(), getMethods() : 클래스에 선언된 멤버 + 상속된 멤버까지 얻어옴 (★★생성자 상속 불가 -> 부모의 생성자 얻기 불가)
 * 								단, public 멤버만 얻어옴
 */


package classex.reflection;

import java.lang.reflect.*;

public class ReflectionExample {

	public static void main(String[] args) throws Exception {
		
		Class car = Class.forName("classex.reflection.Car");
		
		System.out.println("[패키지명.클래스 이름]");
		System.out.println(car.getName());

		System.out.println("[클래스 이름]");
		System.out.println(car.getSimpleName());
		System.out.println();
		
		System.out.println("-------------- Car의 생성자 - 1 -----------------");
		
		Constructor[] cons = car.getConstructors(); //Car 생성자만 가져오기 (★★생성자 상속 불가 -> 부모의 생성자 얻기 불가)
		for(Constructor c : cons) {
			System.out.println(c);
		}
		System.out.println();
		
		
		System.out.println("-------------- Car의 생성자 - 2 -----------------");
		
		cons = car.getDeclaredConstructors(); //생성자 가져오기
		for(Constructor c : cons) {
			//System.out.println(c);
			System.out.println(c.getName()); //생성자 이름
		}
		System.out.println();

		
		System.out.println("-------------- Car의 필드(멤버변수) - 1 -----------------");
		
		Field[] fs = car.getFields(); //상속 포함하여 public 필드만 가져오기
		for(Field f : fs) {
			System.out.println(f);
		}
		System.out.println();
		
		System.out.println("-------------- Car의 필드(멤버변수) - 2 -----------------");
		
		fs = car.getDeclaredFields(); //Car에 선언된 필드만 가져오기
		for(Field f : fs) {
			//System.out.println(f);
			System.out.println(f.getType().getName() + " " + f.getName());
		}
		System.out.println();
		
		System.out.println("-------------- Car의 메서드 - 1 -----------------");
		
		Method[] ms = car.getMethods(); //상속받은 것 포함하여 모든 메서드 가져오기
		for(Method m : ms) {
			System.out.println(m);
		}
		System.out.println();
		
		System.out.println("-------------- Car의 메서드 - 2 -----------------");
		
		ms = car.getDeclaredMethods(); //Car에 추가한 메서드만 가져오기
		for(Method m : ms) {
			//System.out.println(m);
			System.out.println(m.getName()); //메서드 명
		}
		System.out.println();

	}

}
