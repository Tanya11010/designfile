package cn.lut.hotelvip.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import cn.lut.hotelvip.dao.AdminDao;
import cn.lut.hotelvip.domain.po.Customer;
import cn.lut.hotelvip.domain.po.Good;
import cn.lut.hotelvip.domain.po.Room;
import cn.lut.hotelvip.utils.JdbcUtils;

public class AdminDaoImpl implements AdminDao{

	//显示房间信息
	@Override
	public List<Room> showRoom(int pageindex, int pagesize) {
		Connection con = JdbcUtils.getConnection();
		String sql = "SELECT * FROM room ORDER BY roomId LIMIT ?,?;";
		List<Room> list = new ArrayList<>();
		try {
			PreparedStatement prestate = con.prepareStatement(sql);
			prestate.setInt(1, (pageindex - 1) * pagesize);
			prestate.setInt(2, pagesize);
			ResultSet rs = prestate.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					Room r = new Room();
					r.setRoomid(rs.getString("roomId"));
					r.setRoomPrice(rs.getDouble("roomPrice"));
					r.setRoomSize(rs.getString("roomSize"));
					r.setRoomState(rs.getString("roomState"));
					r.setRoomType(rs.getString("roomType"));
					list.add(r);
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

	//显示房间总数
	@Override
	public long getRoomCount() {
		Connection con = JdbcUtils.getConnection();
		String sql = "select count(*) from room "; // 开始位置，和显示条数
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

	//显示商品信息
	@Override
	public List<Good> showGood(int pageindex, int pagesize) {
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
				e.printStackTrace();
			}
		}
		return list;
	}

	//计算商品总数
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

	//显示会员信息
	@Override
	public List<Customer> showCustomer(int pageindex, int pagesize) {
		Connection con = JdbcUtils.getConnection();
		String sql = "SELECT * FROM user ORDER BY userId LIMIT ?,?;";
		List<Customer> list = new ArrayList<>();
		try {
			PreparedStatement prestate = con.prepareStatement(sql);
			prestate.setInt(1, (pageindex - 1) * pagesize);
			prestate.setInt(2, pagesize);
			ResultSet rs = prestate.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					Customer c = new Customer();
					c.setUserid(rs.getString("UserId"));
					c.setUsername(rs.getString("userName"));
					c.setUserpass(rs.getString("userPass"));
					c.setUsersex(rs.getString("userSex"));
					c.setUseridcard(rs.getString("userIdcard"));
					c.setUsertel(rs.getString("userTel"));
					c.setOpendate(rs.getDate("openDate"));
					c.setUsergrade(rs.getInt("userGrade"));
					c.setUsermoney(rs.getDouble("userMoney"));
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

	//显示会员总数
	@Override
	public long getCustomerCount() {
		Connection con = JdbcUtils.getConnection();
		String sql = "select count(*) from user "; // 开始位置，和显示条数
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
	//注册会员
	@Override
	public boolean registerUser(Customer cus) {
		Connection con = JdbcUtils.getConnection();
		String str = "INSERT INTO user (userId, userName, userSex, userIdcard, userPass, userTel,openDate)"
				+ "VALUES(?, ?, ?, ?, ?, ?, ?);";
		try {
			PreparedStatement prepare = con.prepareStatement(str);
			prepare.setString(1, cus.getUserid());
			prepare.setString(2, cus.getUsername());
			prepare.setString(3, cus.getUsersex());
			prepare.setString(4, cus.getUseridcard());
			prepare.setString(5, cus.getUserpass());
			prepare.setString(6, cus.getUsertel());
			prepare.setObject(7, cus.getOpendate());// 1. 这里是因为PreparedStatement默认使用SetDate时候只能是Sql.Date类型
			int a = prepare.executeUpdate();
			
			if(a >= 0)
				return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	//查询会员（会员编号和用户名）
	@Override
	public Customer selectUser(String id, String name) {
		Connection con = JdbcUtils.getConnection();
		String sql ="SELECT userId, userName, userMoney FROM USER WHERE userId=? AND userName=?;";
		
		try {
			PreparedStatement prestate = con.prepareStatement(sql);
			prestate.setString(1, id);
			prestate.setString(2, name);
			ResultSet rs = prestate.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					Customer c = new Customer();
					c.setUserid(rs.getString("UserId"));
					c.setUsername(rs.getString("userName"));
					c.setUsermoney(rs.getDouble("userMoney"));
					return c;
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
		return null;
	}
	//住房（事务）
	@Override
	public boolean inRoom(Customer cus, String roomId) {
		Connection con = JdbcUtils.getConnection();
		try {
			con.setAutoCommit(false);
			String sql01 = "UPDATE USER SET userGrade =userGrade+? , userMoney =userMoney-?WHERE userId = ? ;";
			String sql02 = "UPDATE room SET  roomState = ? WHERE roomId = ? ;";
			PreparedStatement prepare01 = con.prepareStatement(sql01);
			prepare01.setInt(1, cus.getUsergrade());
			prepare01.setDouble(2, cus.getUsermoney());
			prepare01.setString(3, cus.getUserid());
			prepare01.executeUpdate();
			PreparedStatement prepare02 = con.prepareStatement(sql02);
			prepare02.setString(1, "full");
			prepare02.setString(2, roomId);
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
	//查询余额
	@Override
	public double selectMoney(String userId) {
		Connection con = JdbcUtils.getConnection();
		String sql = "SELECT userMoney FROM USER where userId=?;";
		try {
			PreparedStatement prepare = con.prepareStatement(sql);
			prepare.setString(1, userId);
			ResultSet result = prepare.executeQuery();
			if(result!=null) {
				if(result.next()) {
				return result.getInt("userMoney");
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
		
		return -1;
		
	}
	//查询房间价格
	@Override
	public double selectRoomPrice(String roomId) {
		Connection con = JdbcUtils.getConnection();
		String sql = "SELECT roomPrice FROM room where roomId=?;";
		try {
			PreparedStatement prepare = con.prepareStatement(sql);
			prepare.setString(1, roomId);
			ResultSet result = prepare.executeQuery();
			if(result!=null) {
				if(result.next()) {
				return result.getInt("roomPrice");
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
		
		return -1;
	}
	//查询会员信息
	@Override
	public Customer selectCustomer(String userId) {
		Connection con = JdbcUtils.getConnection();
		String sql = "SELECT * FROM USER where userId=?;";
		try {
			PreparedStatement prepare = con.prepareStatement(sql);
			prepare.setString(1, userId);
			ResultSet result = prepare.executeQuery();
			if(result!=null) {
				if(result.next()) {
					Customer cus = new Customer();
					cus.setUsername(result.getString("userName"));
					cus.setUseridcard(result.getString("userIdcard"));
				return cus;
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
		
		return null;
	}
	//退房
	@Override
	public boolean outRoom(String roomId) {
		Connection con = JdbcUtils.getConnection();
		String sql = "UPDATE room SET  roomState = ? WHERE roomId = ? ;";
		PreparedStatement prepare;
		try {
			prepare = con.prepareStatement(sql);
			prepare.setString(1, "Null");
			prepare.setString(2, roomId);
			int res = prepare.executeUpdate();
			if(res >= 0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		return false;
	}
	//添加消费记录
	@Override
	public boolean insertRecord(Customer cus,Timestamp time) {
		Connection con = JdbcUtils.getConnection();
		String str = "INSERT INTO cost (userName, grade, costMoney, costTime)"
				+ "VALUES(?, ?, ?, ?);";
		try {
			PreparedStatement prepare = con.prepareStatement(str);
			prepare.setString(1, cus.getUsername());
			prepare.setInt(2, cus.getUsergrade());
			prepare.setDouble(3, cus.getUsermoney());
			prepare.setTimestamp(4, time);
			int a = prepare.executeUpdate();
			
			if(a >= 0)
				return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	//删除商品
	@Override
	public boolean deleteGood(String goodId) {
		Connection con = JdbcUtils.getConnection();
		String sql = "DELETE FROM good WHERE goodId =?";
		try {
			PreparedStatement prestate = con.prepareStatement(sql);
			prestate.setString(1, goodId);
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
				e.printStackTrace();
			}
		}
		return false;
	}
	//添加商品
	@Override
	public boolean addGood(Good good) {
		Connection con = JdbcUtils.getConnection();
		String str = "INSERT INTO good (goodId, goodName, goodPrice, goodNum)"
				+ "VALUES(?, ?, ?, ?);";
		try {
			PreparedStatement prepare = con.prepareStatement(str);
			prepare.setString(1, good.getGoodid());
			prepare.setString(2, good.getGoodname());
			prepare.setDouble(3, good.getGoodprice());
			prepare.setInt(4, good.getGoodnum());
			int a = prepare.executeUpdate();
			
			if(a >= 0)
				return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	//删除会员
	@Override
	public boolean deleteCustomer(String userId) {
		Connection con = JdbcUtils.getConnection();
		String sql = "DELETE FROM user WHERE userId =?";
		try {
			PreparedStatement prestate = con.prepareStatement(sql);
			prestate.setString(1, userId);
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
				e.printStackTrace();
			}
		}
		return false;
	}
	//充值金额
	@Override
	public boolean addMoney(String userId,double addMoney) {
		Connection con = JdbcUtils.getConnection();
		String sql = "UPDATE USER SET userMoney = userMoney+? WHERE userId = ? ;";
		PreparedStatement prepare;
		try {
			prepare = con.prepareStatement(sql);
			prepare.setDouble(1, addMoney);
			prepare.setString(2, userId);
			int res = prepare.executeUpdate();
			if(res >= 0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		return false;
	}


}
