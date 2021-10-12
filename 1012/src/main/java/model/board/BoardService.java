package model.board;

import java.util.List;

public interface BoardService {
	void insertB(BoardVO bvo);
	void updateB(BoardVO bvo);
	void deleteB(BoardVO bvo);
	BoardVO getB(BoardVO bvo);
	List<BoardVO> getBList(BoardVO bvo);
	// Method Signature
}
