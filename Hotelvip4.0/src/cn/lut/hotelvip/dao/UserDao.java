package cn.lut.hotelvip.dao;

import java.util.List;

import cn.lut.hotelvip.domain.po.Administrator;
import cn.lut.hotelvip.domain.po.Cost;
import cn.lut.hotelvip.domain.po.Customer;
import cn.lut.hotelvip.domain.po.Good;

public interface UserDao {

	//通过用户名和密码登录（会员登录）
	public Customer loginCustomer(String name,String password);
	//通过用户名和密码登录（管理员登录）
	public Administrator loginAdministrator(String name,String password);
	//消费记录分页查询
	public List<Cost> getRecordList(int pageindex,int pagesize);
	// 查询消费的总数
	public long getCostCount();
	//商品查询
	public List<Good> getGoodList(int pageindex,int pagesize);
	// 查询商品的总数
	public long getGoodCount();
	//删除消费记录
	public boolean deleteRecord(String costId);
	//查询会员剩余积分
	public int selectGrade(String userId);
	//积分兑换
	public boolean exchangegood(String goodId,String userId);
	//查询商品价格
	public double selectPrice(String goodId);
}
