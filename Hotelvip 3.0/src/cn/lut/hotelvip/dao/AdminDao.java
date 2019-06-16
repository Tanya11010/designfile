package cn.lut.hotelvip.dao;

import java.sql.Timestamp;
import java.util.List;

import cn.lut.hotelvip.domain.po.Customer;
import cn.lut.hotelvip.domain.po.Good;
import cn.lut.hotelvip.domain.po.Room;

public interface AdminDao {

	//显示房间信息
	public List<Room> showRoom(int pageindex, int pagesize);
	//查询房间的总数
	public long getRoomCount();
	//显示商品信息
	public List<Good> showGood(int pageindex, int pagesize);
	//查询商品的总数
	public long getGoodCount();
	//显示会员信息
	public List<Customer> showCustomer(int pageindex, int pagesize);
	// 查询会员的总数
	public long getCustomerCount();
	//注册会员
	public boolean registerUser(Customer cus);
	//查询会员（编号和用户名）
	public Customer selectUser(String id,String name);
	//住房
	public boolean inRoom(Customer cus,String roomId);
	//查询会员余额
	public double selectMoney(String userId);
	//查询房间价格
	public double selectRoomPrice(String roomId);
	//查询会员信息
	public Customer selectCustomer(String userId);
	//退房
	public boolean outRoom(String roomId);
	//消费记录
	public boolean insertRecord(Customer cus,Timestamp time);
	//删除商品
	public boolean deleteGood(String goodId);
	//添加商品
	public boolean addGood(Good good);
	//删除会员
	public boolean deleteCustomer(String userId);
	//充值金额
	public boolean addMoney(String userId,double addMoney);
	
	
}
