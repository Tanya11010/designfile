package cn.lut.hotelvip.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import cn.lut.hotelvip.dao.UserDao;
import cn.lut.hotelvip.domain.po.Administrator;
import cn.lut.hotelvip.domain.po.Cost;
import cn.lut.hotelvip.domain.po.Customer;
import cn.lut.hotelvip.domain.po.Good;
import cn.lut.hotelvip.utils.JdbcUtils;

public class UserDaoImpl implements UserDao {

	// 会员登录
	@Override
	public Customer loginCustomer(String name, String password) {
		Connection con = JdbcUtils.getConnection();
		String str = "SELECT * FROM user WHERE userPass =? AND userName =?;";
		try {
			PreparedStatement prepare = con.prepareStatement(str);
			prepare.setString(1, password);
			prepare.setString(2, name);
			ResultSet res = prepare.executeQuery();
			if (res != null) {
				if (res.next()) {
					Customer cus = new Customer();
					cus.setUserid(res.getString("userid"));
					cus.setUsergrade(res.getInt("userGrade"));
					cus.setUsername(res.getString("userName"));
					return cus;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	// 管理员登录
	@Override
	public Administrator loginAdministrator(String name, String password) {
		Connection con = JdbcUtils.getConnection();
		String str = "SELECT * FROM manager WHERE managerPass =? AND managerName =?;";
		try {
			PreparedStatement prepare = con.prepareStatement(str);
			prepare.setString(1, password);
			prepare.setString(2, name);
			ResultSet res = prepare.executeQuery();
			if (res != null) {
				if (res.next()) {
					Administrator admin = new Administrator();
					admin.setAdminNumber(res.getString("managerId"));
					return admin;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	// 消费记录
	@Override
	public List<Cost> getRecordList(int pageindex, int pagesize) {
		Connection con = JdbcUtils.getConnection();
		String sql = "SELECT * FROM cost ORDER BY costId LIMIT ?,?;";
		List<Cost> list = new ArrayList<>();
		try {
			PreparedStatement prestate = con.prepareStatement(sql);
			prestate.setInt(1, (pageindex - 1) * pagesize);
			prestate.setInt(2, pagesize);
			ResultSet rs = prestate.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					Cost c = new Cost();
					c.setCostid(rs.getInt("costId"));
					c.setCosttime(rs.getTimestamp("costTime"));
					System.out.println(rs.getTimestamp("costTime"));
					c.setUsername(rs.getString("userName"));
					c.setCostmoney(rs.getDouble("costMoney"));
					c.setGrade(rs.getInt("grade"));
					list.add(c);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;

	}

	// 计算消费记录总数
	@Override
	public long getCostCount() {
		Connection con = JdbcUtils.getConnection();
		String sql = "select count(*) from cost "; // 开始位置，和显示条数
		try {
			PreparedStatement prestate = con.prepareStatement(sql);
			ResultSet rs = prestate.executeQuery(sql);
			rs.next();

			return rs.getLong(1);
		} catch (SQLException e) {
			return 0;
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	// 积分兑换(事务)
	@Override
	public boolean exchangegood(String goodId,String userId) {
		Connection con = JdbcUtils.getConnection();
		try {
			con.setAutoCommit(false);
			String sql01 = "UPDATE good SET goodNum = goodNum-1  WHERE goodId = ? ;";
			String sql02 = "UPDATE USER SET userGrade = userGrade-(SELECT goodPrice FROM good WHERE goodId=?) WHERE userId = ? ;";
			PreparedStatement prepare01 = con.prepareStatement(sql01);
			prepare01.setString(1, goodId);
			prepare01.executeUpdate();
			PreparedStatement prepare02 = con.prepareStatement(sql02);
			prepare02.setString(1, goodId);
			prepare02.setString(2, userId);
			prepare02.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			try {
				con.setAutoCommit(true);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	// 商品查询
	@Override
	public List<Good> getGoodList(int pageindex, int pagesize) {
		Connection con = JdbcUtils.getConnection();
		String sql = "SELECT * FROM good ORDER BY goodId LIMIT ?,?;";
		List<Good> list = new ArrayList<>();
		try {
			PreparedStatement prestate = con.prepareStatement(sql);
			prestate.setInt(1, (pageindex - 1) * pagesize);
			prestate.setInt(2, pagesize);
			ResultSet rs = prestate.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					Good g = new Good();
					g.setGoodid(rs.getString("goodId"));
					g.setGoodname(rs.getString("goodName"));
					g.setGoodprice(rs.getDouble("goodPrice"));
					g.setGoodnum(rs.getInt("goodNum"));
					list.add(g);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;

	}

	// 计算商品总数
	@Override
	public long getGoodCount() {
		Connection con = JdbcUtils.getConnection();
		String sql = "select count(*) from good "; // 开始位置，和显示条数
		try {
			PreparedStatement prestate = con.prepareStatement(sql);
			ResultSet rs = prestate.executeQuery(sql);
			rs.next();
			if(rs!=null) {
				return rs.getLong(1);
			}
		} catch (SQLException e) {
			
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
	}

	// 删除消费记录
	@Override
	public boolean deleteRecord(String costId) {
		Connection con = JdbcUtils.getConnection();
		String sql = "DELETE FROM cost WHERE costId =?";
		try {
			PreparedStatement prestate = con.prepareStatement(sql);
			prestate.setString(1, costId);
			int rs = prestate.executeUpdate();
			if (rs >= 0) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}
	// 查询会员剩余积分
	@Override
	public int selectGrade(String userId) {
		Connection con = JdbcUtils.getConnection();
		String sql = "SELECT userGrade FROM USER where userId=?;";
		try {
			PreparedStatement prepare = con.prepareStatement(sql);
			prepare.setString(1, userId);
			ResultSet result = prepare.executeQuery();
			if(result!=null) {
				if(result.next()) {
				return result.getInt("userGrade");
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return -1;
	}
	//查询商品价格
	@Override
	public double selectPrice(String goodId) {
		Connection con = JdbcUtils.getConnection();
		String sql = "SELECT goodPrice FROM good where goodId=?;";
		try {
			PreparedStatement prepare = con.prepareStatement(sql);
			prepare.setString(1, goodId);
			ResultSet result = prepare.executeQuery();
			if(result!=null) {
				if(result.next()) {
				return result.getDouble("goodPrice");
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return -1;
	}
	

}