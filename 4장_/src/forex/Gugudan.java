package forex;

import java.util.Scanner;

public class Gugudan {

	public static void main(String[] args) {
		System.out.println("1-1.구구단 출력 : 단 사이에 빈 줄 넣기");//구구단 출력
		
		int i,j; // i=단
		for(i=2;i<=9;i++) {
			
			for(j=1;j<=9;j++) {
				System.out.println(i+"X"+j+"="+(i*j));
			}//안쪽 for끝
			System.out.println("");//구분용 빈줄
		}//바깥 for끝

		
		
		System.out.println("1-2.구구단 출력: 단 사이에 빈 줄 + ***제 몇 단*** ");
		System.out.println("");// 구분용 빈줄
		
		
		for(i=2;i<=9;i++) {
			System.out.println("제 "+i+"단");
			for(j=1;j<=9;j++) {
				System.out.println(i+"X"+j+"="+(i*j));
			}
			System.out.println("");
		}
		

		System.out.println("2-1.구구단 출력: 옆으로 출력 ");
		System.out.println("");// 구분용 빈줄
		
		for(j=1;j<=9;j++) {
			
			for(i=2;i<=9;i++) {

				System.out.print(i+"X"+j+"="+(i*j)+"	");
			}
			System.out.println("");
		} System.out.println("");// 구분용 빈줄 
				
		
		
		//[과제1]
		System.out.println("[과제] 2-2.구구단 출력: 옆으로 출력 + 제 몇 단");
		System.out.println("");// 구분용 빈줄
		
		for(int k=2;k<=9;k++) {
			System.out.print("제 "+k+"단	");
		}
		System.out.println();
		for(j=1;j<=9;j++) {
			
			for(i=2;i<=9;i++) {

				System.out.print(i+"X"+j+"="+(i*j)+"	");
			}
			System.out.println("");
		} System.out.println("");// 구분용 빈줄 
		
		
		
		
		
		System.out.println("3-1.구구단 출력: 2단~입력받은 단까지 아래로 출력 ");
		
		Scanner sc = new Scanner(System.in);
		System.out.print("단 입력:");
		int dan = sc.nextInt();
		
		for(j=2;j<=dan;j++) {
			for(i=1;i<=9;i++) {
				System.out.println(j+"X"+i+"="+(j*i));
			}
			System.out.println("");
		}
		
		
		
		System.out.println("3-2.구구단 출력: 2단~입력받은 단까지 옆으로 출력 ");
		
		System.out.print("단 입력:");
		dan = sc.nextInt();
		
		
		for(i=1;i<=9;i++) {
			for(j=2;j<=dan;j++) {
				System.out.print(j+"X"+i+"="+(j*i)+"	");
				}
			System.out.println("");
		}
		
		
		

		System.out.println("4-1.구구단 출력: 구구단 중에서 두 수를 곱해서 72가 되는 것(=조건)만 아래로 출력 ");
		System.out.println("");
		
		for(j=2;j<=9;j++) {
			for(i=1;i<=9;i++) {
				if(j*i==72)
				System.out.println(j+"X"+i+"="+(j*i));
			}
			
		}
		System.out.println("");
		

		
		
		System.out.println("4-2.구구단 중에서 8X9=72(조건)만 아래로 출력 ");
		System.out.println("");
		
		for(j=2;j<=9;j++) {
			for(i=1;i<=9;i++) {
				if(j==8 && i==9)
				System.out.println(j+"X"+i+"="+(j*i));
			}
		}  
		System.out.println("");
		
		
		
		

		System.out.println("4-3.구구단 중에서 8*9(=조건)만 아래로 출력한 후 바깥쪽 반복문 멈추기 ");
		System.out.println("");
		
		outer : for(j=2;j<=9;j++) {
			for(i=1;i<=9;i++) {
				if(j==8 && i==9) {
					System.out.println(j+"X"+i+"="+(j*i));	
					//break; // 가장 가까운 반복문을(안쪽) 빠져나감(=바깥 반복문은 계속 돌아가는 중)
					break outer; //바깥 반복문을 빠져나감, 반복문을 멈추면 cpu의 효율 올라감
					             // outer = 레이블, 라벨
				}
			}//안쪽 for
		}//바깥 for
		
		
		sc.close(); // 스캐너 객체 사용후 닫아주기
	} //main끝

} // class끝