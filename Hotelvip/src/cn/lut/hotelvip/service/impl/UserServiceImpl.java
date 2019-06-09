package cn.lut.hotelvip.service.impl;

import java.util.List;

import cn.lut.hotelvip.dao.UserDao;
import cn.lut.hotelvip.dao.impl.UserDaoImpl;
import cn.lut.hotelvip.domain.po.Administrator;
import cn.lut.hotelvip.domain.po.Cost;
import cn.lut.hotelvip.domain.po.Customer;
import cn.lut.hotelvip.domain.po.Good;
import cn.lut.hotelvip.service.UserService;


public class UserServiceImpl implements UserService{
	UserDao ud = new UserDaoImpl();
	//��Ա��¼
	@Override
	public Customer loginCustomer(String name, String password) {
		if (name == null || name.length() == 0)
			return null;
		if (password == null || password.length() == 0)
			return null;
		return ud.loginCustomer(name, password);
	}
	//����Ա��¼
	@Override
	public Administrator loginAdministrator(String name, String password) {
		if (name == null || name.length() == 0)
			return null;
		if (password == null || password.length() == 0)
			return null;
		return ud.loginAdministrator(name, password);
	}
	//��ѯ���Ѽ�¼�б�
	@Override
	public List<Cost> showList(int pageindex, int pagesize) {
		List<Cost> list = ud.getRecordList(pageindex, pagesize);

		return list;
	}
	//��ѯ���Ѽ�¼����
	@Override
	public long getCostCount() {
		return ud.getCostCount();
	}
	//��ѯ��Ʒ�б�
	@Override
	public List<Good> showGoodList(int pageindex, int pagesize) {
		List<Good> list = ud.getGoodList(pageindex, pagesize);

		return list;
	}
	//��ѯ��Ʒ����
	@Override
	public long getGoodCount() {
		
		return ud.getGoodCount();
	}
	//ɾ�����Ѽ�¼
	@Override
	public boolean deleteRecord(String costId) {
		
		return ud.deleteRecord(costId);
	}
	//���ֶһ�
	@Override
	public boolean exchangeGood(String goodId, String userId) {
		if (ud.selectGrade(userId) < ud.selectPrice(goodId)) {
			return false;
		} else
			ud.exchangegood(goodId, userId);
			return true;
	}
	

}
