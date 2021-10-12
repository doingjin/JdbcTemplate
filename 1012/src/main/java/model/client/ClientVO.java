package model.client;

public class ClientVO {
	/*	CID VARCHAR(10) PRIMARY KEY,	-- 회원 고유 아이디
		CNAME VARCHAR(15),				-- 이름
		PASSWORD VARCHAR(10),			-- 패스워드
		ROLE VARCHAR(10) DEFAULT 'USER' -- '유저' OR '관리자'	*/
	
	private String cid;
	private String cname;
	private String password;
	private String role;
	
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	@Override
	public String toString() {
		return "ClientVO [ID: " + cid + ", NAME: " + cname + ", PW: " + password + ", ROLE: " + role + "]";
	}
	
}
