package model.board;

import java.sql.Date;

public class BoardVO {
	/*		NUM INT PRIMARY KEY,		-- 게시글  고유번호
			TITLE VARCHAR(20),			-- 제목
			CID VARCHAR(10),			-- 작성자 아이디
			CONTENT VARCHAR(100),		-- 내용
			BDATE DATE DEFAULT SYSDATE	-- 작성일			*/
	
	private int num;
	private String title;
	private String cid;
	private String content;
	private Date bdate;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getBdate() {
		return bdate;
	}
	public void setBdate(Date bdate) {
		this.bdate = bdate;
	}
	
	@Override
	public String toString() {
		return "BoardVO [" + num + ". 제목: " + title + ", ID: " + cid + ", 내용: " + content + ", 작성일: " + bdate
				+ "]";
	}
	
}
