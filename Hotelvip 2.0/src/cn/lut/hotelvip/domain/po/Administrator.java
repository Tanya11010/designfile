package cn.lut.hotelvip.domain.po;

public class Administrator {

	//管理员号、管理员密码、管理员姓名
     String adminNumber;
     String username;
	 String userpass;
	public String getAdminNumber() {
		return adminNumber;
	}
	public void setAdminNumber(String adminNumber) {
		this.adminNumber = adminNumber;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserpass() {
		return userpass;
	}
	public void setUserpass(String userpass) {
		this.userpass = userpass;
	}
	@Override
	public String toString() {
		return "Administrator [adminNumber=" + adminNumber + ", username=" + username + ", userpass=" + userpass + "]";
	}
	
	
	
}
