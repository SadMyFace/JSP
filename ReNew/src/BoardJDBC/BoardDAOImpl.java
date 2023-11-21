package BoardJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardDAOImpl implements DAO {
	
	// db 연결
	private Connection conn;
	private PreparedStatement pst;
	private String query = "";
	private ResultSet rs;
	
	public BoardDAOImpl(){
		// 데이터베이스 정보 객체 생성
		DatabaseConnection dbc = DatabaseConnection.getInstance();
		conn = dbc.getConnection();
	}

	@Override
	public int write(BoardVO b) {
		// TODO Auto-generated method stub
		//글 쓰기용 : title, writer, content
		System.out.println("write DAO success!!");
		query = "insert into board(title, writer, content) values(?, ?, ?)";
		
		try {
			pst = conn.prepareStatement(query);
			
			pst.setString(1, b.getTitle());
			pst.setString(2, b.getWriter());
			pst.setString(3, b.getContent());
			
			return pst.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("write error");
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public java.util.List<BoardVO> List() {
		// TODO Auto-generated method stub
		//전체 리스트용 : bno, title, writer, moddate
		System.out.println("list DAO success!!");
		query = "select * from board order by bno desc";
		
		List<BoardVO> list = new ArrayList<BoardVO>();
		try {
			pst = conn.prepareStatement(query);
			rs = pst.executeQuery();
			while(rs.next()) {
				BoardVO b = new BoardVO(rs.getInt("bno"), rs.getString("title"), rs.getString("writer"), rs.getString("moddate"), rs.getInt("readCount"));
				list.add(b);
			}
			return list;
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("list error");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public BoardVO detail(int bno) {
		// TODO Auto-generated method stub
		// int bno, String title, String writer, String content, String regdate, String moddate
		System.out.println("detail DAO success!!");
		query = "select * from board where bno = ?";
		 try {
			pst = conn.prepareStatement(query);
			
			pst.setInt(1, bno);
			rs = pst.executeQuery();
			if(rs.next()) {
				BoardVO b = new BoardVO(rs.getInt("bno"), rs.getString("title"), rs.getString("writer"), rs.getString("content"), rs.getString("regdate"), rs.getString("moddate"), rs.getInt("readCount"));
				return b;
			}
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("detail error");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int modify(BoardVO b) {
		// TODO Auto-generated method stub
		//글 수정용 : bno, title, content
		System.out.println("modify DAO success!!");
		query = "update Board set title = ?, content = ?, moddate = now(), where bno = ?";
		
		try {
			pst = conn.prepareStatement(query);
			
			pst.setString(1, b.getTitle());
			pst.setString(2, b.getContent());
			pst.setInt(3, b.getBno());
			
			return pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("modify error");
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int remove(int bno) {
		// TODO Auto-generated method stub
		System.out.println("remove DAO success!!");
		query = "delete from Board where bno = ?";
		
		try {
			pst = conn.prepareStatement(query);
			
			pst.setInt(1, bno);
			return pst.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("remove error");
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int readCount(int bno) {
		// TODO Auto-generated method stub
		System.out.println("readCount DAO success!!");
		query = "update board set readCount = readCount + 1 where bno = ?";
		try {
			pst = conn.prepareStatement(query);
			
			pst.setInt(1, bno);
			return pst.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("reacount error");
			e.printStackTrace();
		}
		return 0;
	}
	
	// 메서드 처리
}
