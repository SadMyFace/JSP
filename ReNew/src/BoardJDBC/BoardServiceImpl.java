package BoardJDBC;

import java.util.List;

public class BoardServiceImpl implements Service {
	private DAO dao;
	
	public BoardServiceImpl() {
		dao = new BoardDAOImpl();
	}

	@Override
	public int write(BoardVO b) {
		// TODO Auto-generated method stub
		System.out.println("write_Service success!!");
		return dao.write(b);
	}

	@Override
	public List<BoardVO> list() {
		// TODO Auto-generated method stub
		System.out.println("list_Service success!!");
		return dao.List();
	}

	@Override
	public BoardVO detail(int bno) {
		// TODO Auto-generated method stub
		System.out.println("detail_Service success!!");
		return dao.detail(bno);
	}

	@Override
	public int modify(BoardVO b) {
		// TODO Auto-generated method stub
		System.out.println("modify_Service success!!");
		return dao.modify(b);
	}

	@Override
	public int remove(int bno) {
		// TODO Auto-generated method stub
		System.out.println("remove_Service success!!");
		return dao.remove(bno);
	}

	@Override
	public int readCount(int bno) {
		// TODO Auto-generated method stub
		System.out.println("readCount_Service success!!");
		return dao.readCount(bno);
	}
}
