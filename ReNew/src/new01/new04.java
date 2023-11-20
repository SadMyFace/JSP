package new01;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class new04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 단어장 만들기
		 * 단어 만들 개수
		 * 단어 의미 입력
		 */
		
		Scanner sc = new Scanner(System.in);
		HashMap<String, String> map = new HashMap<String, String>();
		
		System.out.println("개수 입력");
		int makeNum = sc.nextInt();
		String makeStr = "";
		String makeMean = "";
		for(int i = 0; i < makeNum; i++) {
			System.out.println((i+1) + "번째 입력");
			System.out.print("단어 입력: ");
			makeStr = sc.next();
			System.out.print("의미 입력: ");
			makeMean = sc.next();
			map.put(makeStr, makeMean);			
		}
		System.out.println("입력 완료");
//		for(String tmp : map.keySet()) {
//			System.out.println(tmp + ":" + map.get(tmp));
//		}
		Iterator<String> it = map.keySet().iterator();
		while(it.hasNext()) {
			String wordString = it.next();
			System.out.println(makeStr + ":" + map.get(makeMean));
		}
	}

}
