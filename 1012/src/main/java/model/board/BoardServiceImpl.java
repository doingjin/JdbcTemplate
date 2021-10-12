package model.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("BoardService")
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDAO bdao;
	
	public void insertB(BoardVO bvo) {
		bdao.insertB(bvo);
	}

	public void updateB(BoardVO bvo) {
		bdao.updateB(bvo);
	}

	public void deleteB(BoardVO bvo) {
		bdao.deleteB(bvo);
	}

	public BoardVO getB(BoardVO bvo) {
		return bdao.getB(bvo);
	}

	public List<BoardVO> getBList(BoardVO bvo) {
		return bdao.getBList(bvo);
	}

}
