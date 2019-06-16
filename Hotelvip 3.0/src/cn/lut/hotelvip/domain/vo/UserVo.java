package cn.lut.hotelvip.domain.vo;

import java.sql.Date;

public class UserVo {

	 String userid;
	 String roomid;
	 String username;
	 String usersex;
	 String useridcard;
	 String userpass;
	 String usertel;
	 Date opendate;
	 int usergrade;
	 double usermoney;
	 
	 String imagecode;
	 String repassword;
	 String token;
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getRoomid() {
		return roomid;
	}
	public void setRoomid(String roomid) {
		this.roomid = roomid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUsersex() {
		return usersex;
	}
	public void setUsersex(String usersex) {
		this.usersex = usersex;
	}
	public String getUseridcard() {
		return useridcard;
	}
	public void setUseridcard(String useridcard) {
		this.useridcard = useridcard;
	}
	public String getUserpass() {
		return userpass;
	}
	public void setUserpass(String userpass) {
		this.userpass = userpass;
	}
	public String getUsertel() {
		return usertel;
	}
	public void setUsertel(String usertel) {
		this.usertel = usertel;
	}
	public Date getOpendate() {
		return opendate;
	}
	public void setOpendate(Date opendate) {
		this.opendate = opendate;
	}
	public int getUsergrade() {
		return usergrade;
	}
	public void setUsergrade(int usergrade) {
		this.usergrade = usergrade;
	}
	public double getUsermoney() {
		return usermoney;
	}
	public void setUsermoney(double usermoney) {
		this.usermoney = usermoney;
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
	@Override
	public String toString() {
		return "UserVo [userid=" + userid + ", roomid=" + roomid + ", username=" + username + ", usersex=" + usersex
				+ ", useridcard=" + useridcard + ", userpass=" + userpass + ", usertel=" + usertel + ", opendate="
				+ opendate + ", usergrade=" + usergrade + ", usermoney=" + usermoney + ", imagecode=" + imagecode
				+ ", repassword=" + repassword + "]";
	}
	 
}
