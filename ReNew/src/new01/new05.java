package new01;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class new05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * new04 클래스의 단어장을 메서드로 분리
		 * 메서드에서 리턴한 map을 받아서 출력
		 */
		Scanner sc = new Scanner(System.in);
		HashMap<String, String> map = make(sc);
		
//		for(String tmp : map.keySet()) {
//			System.out.println(tmp + ":" + map.get(tmp));
//		}
		Iterator<String> iterator = map.keySet().iterator();
		while(iterator.hasNext()) {
			String word = iterator.next();
			String mean = map.get(word);
			System.out.println(word + ":" + mean);
		}
	}
	/*
	 * 
	 * 기능 : 단어:의미를 입력받아 map을 구석
	 * map은 메서드 안에서 생성하여 리턴
	 * make()
	 */
	public static HashMap<String, String> make(Scanner scan) {
		HashMap<String, String> map = new HashMap<String, String>();
		System.out.println("개수 입력");
		int makeNum = scan.nextInt();
		String makeStr = "";
		String makeMean = "";
		for(int i = 0; i < makeNum; i++) {
			System.out.println((i+1) + "번째 입력");
			System.out.print("단어 입력: ");
			makeStr = scan.next();
			System.out.print("의미 입력: ");
			makeMean = scan.next();
			map.put(makeStr, makeMean);			
		}
		System.out.println("입력 완료");
		
		return map;
	}
	
}
