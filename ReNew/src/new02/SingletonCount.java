package new02;

import java.time.Year;
import java.util.Calendar;

class Counter{

	//객체를 1개만 생성하여 공유
	private static Counter instance;
	private int count;
	
	//생성자를 통한 객체 생성을 막기 위해 생성자를 private 설정
	private Counter() {}

	// getInstance() 메서드를 사용하여 instance가 생성되지 않았다면
	// 생성해서 리턴, 아니면 기존 인스턴스를 리턴
	public static Counter getInstance() {
		if(instance == null) { // 아직 객체가 생성되지 않았다면...
			instance = new Counter();
		}
		
		return instance;
	}
	
	public int countMethod() {
		count++;
		return count;
	}
}

public class SingletonCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Counter c1 = Counter.getInstance();
		Counter c2 = Counter.getInstance();
		
		System.out.println(c1.countMethod()); // 1
		System.out.println(c2.countMethod()); // 2
		System.out.println(c1.countMethod()); // 3
		System.out.println(c1.countMethod()); // 4
		
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		System.out.println(year);
	}

}
