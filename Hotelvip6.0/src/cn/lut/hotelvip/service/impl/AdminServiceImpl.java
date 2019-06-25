package cn.lut.hotelvip.service.impl;

import java.sql.Timestamp;
import java.util.List;

import cn.lut.hotelvip.dao.AdminDao;
import cn.lut.hotelvip.dao.impl.AdminDaoImpl;
import cn.lut.hotelvip.domain.po.Customer;
import cn.lut.hotelvip.domain.po.Good;
import cn.lut.hotelvip.domain.po.Room;
import cn.lut.hotelvip.service.AdminService;

public class AdminServiceImpl implements AdminService{

	AdminDao ad = new AdminDaoImpl();
	//显示房间信息
	@Override
	public List<Room> showRoom(int pageindex, int pagesize) {
		List<Room> list = ad.showRoom(pageindex, pagesize);
		return list;
	}
	//计算房间总数
	@Override
	public long getRoomCount() {
		return ad.getRoomCount();
	}
	//显示商品信息
	@Override
	public List<Good> showGood(int pageindex, int pagesize) {
		List<Good> list = ad.showGood(pageindex, pagesize);
		return list;
	}
	//计算商品总数
	@Override
	public long getGoodCount() {
		return ad.getGoodCount();
	}
	//显示会员信息
	@Override
	public List<Customer> showCustomer(int pageindex, int pagesize) {
		List<Customer> list = ad.showCustomer(pageindex, pagesize);
		return list;
	}
	//计算会员总数
	@Override
	public long getCustomerCount() {
		return ad.getCustomerCount();
	}
	//注册会员
	@Override
	public boolean resgisteruser(Customer cus) {
		if (cus.getUsername() == null || cus.getUsername().length() == 0 || cus.getUsername().length() > 10) {
			return false;
		}
		if (cus.getUserpass() == null || cus.getUserpass().length() == 0 || cus.getUserpass().length() > 10) {
			return false;
		}
		if(cus.getUserpass().equals(cus.getReuserpass())) {
			return ad.registerUser(cus);
		}else {
			return false;
		}
	}
	//查询会员（会员编号和用户名）
	@Override
	public Customer selectUser(String id, String name) {
		return ad.selectUser(id, name);
	}
	//住房（事务）
	@Override
	public boolean inRoom(Customer cus, String roomId) {
		Customer cust = ad.selectCustomer(cus.getUserid());
		if (ad.selectMoney(cus.getUserid()) < ad.selectRoomPrice(roomId)) {
			return false;
		} 
		if(!cus.getUsername().equals(cust.getUsername())) {
			return false;
		}
		if(!cus.getUseridcard().equals(cust.getUseridcard())) {
			return false;
		}
			ad.inRoom(cus, roomId);
			return true;
	}
	//退房
	@Override
	public boolean outRoom(String roomId) {
		return ad.outRoom(roomId);
	}
	//消费记录
	@Override
	public boolean insertRecord(Customer cus,Timestamp time) {
		
		return ad.insertRecord(cus,time);
	}
	//删除商品
	@Override
	public boolean deleteGood(String goodId) {
		
		return ad.deleteGood(goodId);
	}
	//添加商品
	@Override
	public boolean addGood(Good good) {
		return ad.addGood(good);
	}
	//删除会员
	@Override
	public boolean deleteCustomer(String userId) {
		
		return ad.deleteCustomer(userId);
	}
	//充值金额
	@Override
	public boolean addMoney(String userId, double addMoney) {
	
		return ad.addMoney(userId, addMoney);
	}
	
}
