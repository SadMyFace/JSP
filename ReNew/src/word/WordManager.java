package word;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class WordManager {
	ArrayList<Word> word = new ArrayList<Word>();
	
	public void add(Scanner sc) {
		System.out.print("입력할 단어: ");
		String inWord = sc.next();
		System.out.print("입력할 의미");
		String inMean = sc.next();
		
		Word w = new Word(inWord,inMean);
		
		word.add(w);
	}
	
	public void search(Scanner sc) {
		System.out.print("검색할 단어: ");
		String searWord = sc.next();
		for(int i = 0; i < word.size(); i++) {
			if(searWord.equals(word.get(i).getWord())) {
				System.out.println(word.get(i));
			}
		}
	}
	
	public void modify(Scanner sc) {
		System.out.print("수정할 단어: ");
		String searWord = sc.next();
		for(int i = 0; i < word.size(); i++) {
			if(searWord.equals(word.get(i).getWord())) {
				System.out.print("바꿀 단어");
				String modiWord = sc.next();
				System.out.print("바꿀 의미");
				String modiMean = sc.next();
				word.get(i).setWord(modiWord);
				word.get(i).setMean(modiMean);
			}
		}
	}
	
	public void printAll() {
		for(int i = 0; i < word.size(); i++) {
			System.out.println("단어: " + word.get(i));
		}
	}
	
	public void filePrint() throws IOException {
		
//		try {
//			FileWriter fw = new FileWriter("word.txt");
//			for(int i = 0; i < word.size(); i++) {
//				fw.write(word.get(i).getWord() + " " + word.get(i).getMean() +" \r\n");
//			}
//			fw.close();
//			BufferedReader br = new BufferedReader(new FileReader("word.txt"));
//			
//			String line = "";
//			while((line = br.readLine()) != null) {
//				String[] str = line.split(" ");
//				System.out.println(str[0] +" " + str[1]);
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
		FileWriter fw = new FileWriter("word.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		
		StringBuffer sb = new StringBuffer();
		
		String data = "";
		int cnt = 0;
		
		while(cnt < word.size()) {
			sb.append(word.get(cnt).toString());
			sb.append("\r\n");
			cnt++;
		}
		data = sb.toString();
		System.out.println(data);
		fw.write(data);
		fw.close();
		
		
	}
	
	
	public void menu() throws IOException {
		Scanner scanner = new Scanner(System.in);
		int menu = 0;
		try {
			while(true) {
				System.out.println("1. 단어 등록");
				System.out.println("2. 단어 검색");
				System.out.println("3. 단어 수정");
				System.out.println("4. 단어 출력");
				System.out.println("5. 단어 출력(파일)");
				System.out.println("6. 종료");
				
				System.out.println("메뉴 입력: ");
				menu = scanner.nextInt();
				
				switch (menu) {
				
				case 1:
					add(scanner);
					break;
				case 2:
					search(scanner);
					break;
				case 3:
					modify(scanner);
					break;
				case 4:
					printAll();
					break;
				case 5: 
					filePrint();
					break;
				case 6:
					
				}
				if(menu == 6) {
					break;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
