package new01;

import java.util.Scanner;

public class new02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// TODO Auto-generated method stub
		// for 문 이용하여 1 ~ 10 까지 짝수만 출력
		
		// 1부터 내가 입력한 수까지 5의 배수를 출력
		
		for(int i = 1; i <= 10; i++) {
			if(i % 2 == 0) {
				System.out.print(i + " ");
			}
		}
		System.out.println();
		
		System.out.println("숫자 입력: ");
		int myNum = sc.nextInt();
		int checkNum = myNum / 5;
		for(int i = 1; i <= checkNum; i++){
			System.out.print(5 * i + " ");
		}
		
	}

}
