package cn.lut.hotelvip.service;

import java.util.List;

import cn.lut.hotelvip.domain.po.Administrator;
import cn.lut.hotelvip.domain.po.Cost;
import cn.lut.hotelvip.domain.po.Customer;
import cn.lut.hotelvip.domain.po.Good;

public interface UserService {

	//会员登录
	public Customer loginCustomer(String name,String password);
	//会员登录
	public Administrator loginAdministrator(String name,String password);
	//消费记录分页查询 
	public List<Cost> showList(int pageindex,int pagesize);
	//计算消费记录总数
	public long getCostCount();
	//商品分页查询 
	public List<Good> showGoodList(int pageindex,int pagesize);
	//计算商品记录总数
	public long getGoodCount();
	//删除消费记录
	public boolean deleteRecord(String costId);
	//积分兑换
	public boolean exchangeGood(String goodId,String userId);
}
