package BoardJDBC;

import java.util.List;
import java.util.Scanner;

public class BoardController {
	
	private Scanner scan;
	private Service svc;
	private boolean flag;
	
	public BoardController() {
		scan = new Scanner(System.in);
		svc = new BoardServiceImpl();
		flag = true;
		printMenu();
	}

	private void printMenu() {
		// TODO Auto-generated method stub
		while(flag) {
			System.out.println("--게시판--");
			System.out.println("1.글쓰기|2.글목록보기|3.글상세보기");
			System.out.println("4.글수정|5.글삭제|6.종료");
			System.out.println(">> 메뉴선택 : ");
			int menu = scan.nextInt();
			
			switch (menu) {
			case 1: write();
				break;
			case 2: list();
				break;
			case 3: detail();
				break;
			case 4: modify();
				break;
			case 5: remove();
				break;

			default: flag = false;
				break;
			}
		}
	}

	private void remove() {
		// TODO Auto-generated method stub
		System.out.println("번호 입력: ");
		int bno = scan.nextInt();
		
		int isOk = svc.remove(bno);
		System.out.println("삭제" + (isOk > 0 ? "완료" : "실패"));
		
	}

	private void modify() {
		// TODO Auto-generated method stub
		//글 수정용 : bno, title, content
		System.out.println("번호 입력: ");
		int bno = scan.nextInt();
		System.out.println("제목 입력: ");
		scan.nextLine();
		String title = scan.next();
		System.out.println("내용 입력: ");
		scan.nextLine();
		String content = scan.next();
		
		BoardVO b = new BoardVO(bno, title, content);
		int isOk = svc.modify(b);
		
		System.out.println("수정" + (isOk > 0 ? "완료" : "실패"));	
	}

	private void detail() {
		// TODO Auto-generated method stub
		// int bno, String title, String writer, String content, String regdate, String moddate
		System.out.println("번호 입력: ");
		int bno = scan.nextInt();
		System.out.println("조회수: " + svc.readCount(bno));
		BoardVO b = svc.detail(bno);
		b.printDetail();
	}

	private void list() {
		// TODO Auto-generated method stub
		List<BoardVO> list = svc.list();
		
		for(BoardVO b : list) {
			System.out.println(b);
		}
	}

	private void write() {
		// TODO Auto-generated method stub
		//글 쓰기용 : title, writer, content
		System.out.println("제목 입력: ");
		scan.nextLine();
		String title = scan.next();
		System.out.println("작성자 입력: ");
		scan.nextLine();
		String writer = scan.next();
		System.out.println("내용 입력: ");
		scan.nextLine();
		String content = scan.next();
		
		BoardVO b = new BoardVO(title, writer, content);
		
		int isOk = svc.write(b);
		System.out.println("작성" + (isOk > 0 ? "완료" : "실패"));
	}
}
