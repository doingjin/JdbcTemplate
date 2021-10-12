package model.board;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

class BoardRowMapper implements RowMapper<BoardVO>{
	@Override
	public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		BoardVO data=new BoardVO();
		data.setNum(rs.getInt("num"));
		data.setTitle(rs.getString("title"));
		data.setCid(rs.getString("cid"));
		data.setContent(rs.getString("content"));
		data.setBdate(rs.getDate("bdate"));
		return data;
	}
}

@Repository
public class BoardDAO {
	
	private String INSERTB="INSERT INTO BOARD VALUES ((SELECT NVL(MAX(NUM),0)+1 FROM BOARD),?,?,?,SYSDATE)";
	private String UPDATEB="UPDATE BOARD SET TITLE=?,CONTENT=? WHERE NUM=?";
	private String DELETEB="DELETE FROM BOARD WHERE NUM=?";
	private String GETB="SELECT * FROM BOARD WHERE NUM=?";
	private String GETBLIST="SELECT * FROM BOARD WHERE TITLE LIKE ?";
	
	@Autowired
	private JdbcTemplate jdbctemplate;
	
	public void insertB(BoardVO bvo) {
		Object[] args= {bvo.getTitle(),bvo.getCid(),bvo.getContent()};
		jdbctemplate.update(INSERTB, args);
	}
	public void updateB(BoardVO bvo) {
		Object[] args= {bvo.getTitle(), bvo.getContent(), bvo.getNum()};
		jdbctemplate.update(UPDATEB, args);
	}
	public void deleteB(BoardVO bvo) {
		jdbctemplate.update(DELETEB, bvo.getNum());
	}
	public BoardVO getB(BoardVO bvo) {
		Object[] args= {bvo.getNum()};
		return jdbctemplate.queryForObject(GETB, args, new BoardRowMapper());
	}
	public List<BoardVO> getBList(BoardVO bvo){
		return jdbctemplate.query("SELECT * FROM BOARD WHERE TITLE LIKE '%"+bvo.getTitle()+"%'", new BoardRowMapper());
	}
	
}
