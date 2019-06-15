package cn.lut.hotelvip.domain.vo;

public class AdminVo {

	String managerId;
	 String username;
	 String userpass;
	
	String imagecode;
	 String repassword;
	 String token;
	public String getManagerId() {
		return managerId;
	}
	public void setManagerId(String managerId) {
		this.managerId = managerId;
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
	public String getImagecode() {
		return imagecode;
	}
	public void setImagecode(String imagecode) {
		this.imagecode = imagecode;
	}
	public String getRepassword() {
		return repassword;
	}
	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	@Override
	public String toString() {
		return "AdminVo [managerId=" + managerId + ", username=" + username + ", userpass=" + userpass + ", imagecode="
				+ imagecode + ", repassword=" + repassword + ", token=" + token + "]";
	}
	 
	 
	
	 
}
