package cn.lut.hotelvip.domain.po;

public class Good {

	String goodid;
	String goodname; 
	double goodprice;
	Integer goodnum;
	public String getGoodid() {
		return goodid;
	}
	public void setGoodid(String goodid) {
		this.goodid = goodid;
	}
	public String getGoodname() {
		return goodname;
	}
	public void setGoodname(String goodname) {
		this.goodname = goodname;
	}
	public double getGoodprice() {
		return goodprice;
	}
	public void setGoodprice(double goodprice) {
		this.goodprice = goodprice;
	}
	public Integer getGoodnum() {
		return goodnum;
	}
	public void setGoodnum(Integer goodnum) {
		this.goodnum = goodnum;
	}
	@Override
	public String toString() {
		return "Good [goodid=" + goodid + ", goodname=" + goodname + ", goodprice=" + goodprice + ", goodnum=" + goodnum
				+ "]";
	}
	
	
}
