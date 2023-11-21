package BoardJDBC;

import java.util.List;

public interface DAO {

	int write(BoardVO b);

	List<BoardVO> List();

	BoardVO detail(int bno);

	int modify(BoardVO b);

	int remove(int bno);

	int readCount(int bno);

}
