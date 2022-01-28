package map.hashmapstudent;

import java.util.HashMap;

public class HashMap_Student {

	public static void main(String[] args) {
		//학생의 점수를 관리하는 HashMap 객체
		HashMap<Student, Integer> map = new HashMap<Student, Integer>(); 

		//map.put(new Student(1, "홍길동"), 85); // int 85 -> 자동 Boxing되어 Integer객체
		//map.put(new Student(1, "홍길동"), 85);
		
		 //key값을 따로 넣어도 됨
		 
		 Student key = new Student(1, "홍길동");
		 map.put(key, 85); 
		 
	
		System.out.println("총 Entry 객체 수 : " + map.size()); //2 (중복됨) 
		map.put(new Student(2, "이순신"), 97);
		
		
		System.out.println("** map 주소만 **");
		System.out.println(map); 
		// {map.hashmapstudent.Student@30502b7=97, map.hashmapstudent.Student@33a478e=85}
		// => toString()메서드 재정의되어 있지 않아서 => 재정의하기
		
		System.out.println("학번 1 홍길동의 점수 : " + map.get(key));		
		System.out.println("학번 1 홍길동의 점수 : " + map.get(new Student(1, "홍길동")));
		
		
		
		
		
		
		
		
		
	}

}