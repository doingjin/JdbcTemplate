package model.client;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

class ClientRowMapper implements RowMapper<ClientVO>{
	@Override
	public ClientVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		ClientVO data=new ClientVO();
		data.setCid(rs.getString("cid"));
		data.setCname(rs.getString("cname"));
		data.setPassword(rs.getString("password"));
		data.setRole(rs.getString("role"));
		return data;
	}
}

@Repository
public class ClientDAO {
	
	private String INSERTC="INSERT INTO CLIENT(CID,CNAME,PASSWORD) VALUES (?,?,?)";
	private String UPDATEC="UPDATE CLIENT SET CNAME=?, PASSWORD=? WHERE CID=?";
	private String DELETEC="DELET FROM CLIENT WHERE CID=?";
	private String GETC="SELECT * FROM CLIENT WHERE CID=? AND PASSWORD=?";
	private String GETCLIST="SELECT * FROM CLIENT";
	
	@Autowired
	private JdbcTemplate jdbctemplate;
	
	public void insertC(ClientVO cvo) {
		Object[] args= {cvo.getCid(),cvo.getCname(),cvo.getPassword()};
		jdbctemplate.update(INSERTC, args);
	}
	public void updateC(ClientVO cvo) {
		Object[] args= {cvo.getCname(),cvo.getPassword(),cvo.getCid()};
		jdbctemplate.update(UPDATEC, args);
	}
	public void deleteC(ClientVO cvo) {
		jdbctemplate.update(DELETEC, cvo.getCid());
	}
	public ClientVO login(ClientVO cvo) {
		Object[] args= {cvo.getCid(),cvo.getPassword()};
		return jdbctemplate.queryForObject(GETC, args, new ClientRowMapper());
	}
	public List<ClientVO> getCList() {
		return jdbctemplate.query(GETCLIST, new ClientRowMapper());
	}
	
}
