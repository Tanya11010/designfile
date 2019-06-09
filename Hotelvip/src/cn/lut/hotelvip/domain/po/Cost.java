package cn.lut.hotelvip.domain.po;

import java.sql.Timestamp;

//����ʵ��
public class Cost {

	Integer costid; 
	String username;
	Integer grade;
	double costmoney;
	Timestamp costtime;
	public Integer getCostid() {
		return costid;
	}
	public void setCostid(Integer costid) {
		this.costid = costid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getGrade() {
		return grade;
	}
	public void setGrade(Integer grade) {
		this.grade = grade;
	}
	public double getCostmoney() {
		return costmoney;
	}
	public void setCostmoney(double costmoney) {
		this.costmoney = costmoney;
	}
	public Timestamp getCosttime() {
		return costtime;
	}
	public void setCosttime(Timestamp costtime) {
		this.costtime = costtime;
	}
	@Override
	public String toString() {
		return "Cost [costid=" + costid + ", username=" + username + ", grade=" + grade + ", costmoney=" + costmoney
				+ ", costtime=" + costtime + "]";
	}
	

	

	
}
