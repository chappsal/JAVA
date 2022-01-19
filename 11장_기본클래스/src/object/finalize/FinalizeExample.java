package object.finalize;

public class FinalizeExample {

	public static void main(String[] args) {
		
		Counter counter = null; //지역변수는 초기화
		for(int i=1; i<=50; i++) {
			counter = new Counter(i); //객체 생성하자마자
			counter = null; //필요없는 객체(=쓰레기)로 만들어
			
			/* GC는 메모리가 부족할 때, cpu가 한가할 때 JVM(자바가상머신)에 의해 자동 실행 됨
			 * 
			 * GC() 호출해서 쓰레기 수집기를 가급적 빨리 실행해 달라고 JVM에게 요청했다
			 *    ↓
			 */	
			System.gc(); 	//가비지 콜렉터 호출하면 재정의된 finalize()가 실행됨
			//결과 : 무작위로 일부만 소멸시킴
			//전부 소멸되지 않고 heap 메모리의 용량 여부를 체크하여 일부만 소멸
		}
		System.runFinalization(); //GC에 의해 소멸이 결정된 객체 즉시 소멸하라
	}
}
