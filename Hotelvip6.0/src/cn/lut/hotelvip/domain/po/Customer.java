package cn.lut.hotelvip.domain.po;

import java.sql.Date;

public class Customer {
	
	 String userid;
	 String roomid;
	 String username;
	 String usersex;
	 String useridcard;
	 String userpass;
	 String reuserpass;
	 String usertel;
	 Date opendate;
	 public String getReuserpass() {
		return reuserpass;
	}
	public void setReuserpass(String reuserpass) {
		this.reuserpass = reuserpass;
	}
	int usergrade;
	 double usermoney;
	
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
	@Override
	public String toString() {
		return "Customer [userid=" + userid + ", roomid=" + roomid + ", username=" + username + ", usersex=" + usersex
				+ ", useridcard=" + useridcard + ", userpass=" + userpass + ", usertel=" + usertel + ", opendate="
				+ opendate + ", usergrade=" + usergrade + ", usermoney=" + usermoney + "]";
	}
	
	
	
	
		

}
