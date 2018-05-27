package com.dao.impl;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.somain.User;
import com.utils.DBUtil;

public class UserSave implements Serializable {

	/**
	 * 新增一个员工
	 */
	public static void save(User u) {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = 
				" insert into user (username,password,nickname,email,state,code) values (?,?,?,?,?,?) ";
			PreparedStatement ps = 
				conn.prepareStatement(sql);
			ps.setString(1, u.getUsername());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getNickname());
			ps.setString(4, u.getEmail());
			ps.setInt(5, u.getState());
			ps.setString(6, u.getCode());
			System.out.println(ps);
			ps.execute();
		} catch (SQLException e1) {
			e1.printStackTrace();
			throw new RuntimeException(
				"添加员工失败!", e1);
		} finally {
			DBUtil.close(conn);
		}
	}
	
	/**
	 * 根据ID修改一个员工
	 * */
	public static void update(User u) {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = 
				" update user set username=?,password=?,nickname=?,email=?,state=?,code=? where uid=?";
			PreparedStatement ps = 
				conn.prepareStatement(sql);
			ps.setString(1, u.getUsername());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getNickname());
			ps.setString(4, u.getEmail());
			ps.setInt(5, u.getState());
			ps.setString(6, u.getCode());
			ps.setInt(7, u.getUid());
			System.out.println(ps);
			ps.execute();
		} catch (SQLException e1) {
			e1.printStackTrace();
			throw new RuntimeException(
				"添加员工失败!", e1);
		} finally {
			DBUtil.close(conn);
		}
	}
	
	/**
	 * 根据ID删除一个员工
	 * */
	public void delete(int id) {
		
	}
	
	/**
	 * 根据ID查询一个员工
	 * */
	public User findById(int id) {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = 
				"select * from Users_lhh "
				+ "where Userno=?";
			PreparedStatement ps = 
				conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				User e = createUser(rs);
				return e;
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
			throw new RuntimeException(
				"查询员工失败!", e1);
		} finally {
			DBUtil.close(conn);
		}
		return null;
	}

	/**
	 * Alt+Shift+M
	 * */
	private User createUser(ResultSet rs) throws SQLException {
		User e = new User();
	/*	e.setUserno(rs.getInt("Userno"));
		e.setEname(rs.getString("ename"));
		e.setJob(rs.getString("job"));
		e.setMgr(rs.getInt("mgr"));
		e.setHiredate(rs.getDate("hiredate"));
		e.setSal(rs.getDouble("sal"));
		e.setComm(rs.getDouble("comm"));
		e.setDeptno(rs.getInt("deptno"));*/
		return e;
	}
	
	/**
	 * 查询某一页员工数据
	 * */
	public List<User> findByPage(
		int page, int size) {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = 
				"select * from ("
				+ "	select e.*,rownum r from ("
				+ "		select * from Users_lhh "
				+ "		order by Userno"
				+ "	) e"
				+ ") where r between ? and ?";
			PreparedStatement ps = 
				conn.prepareStatement(sql);
			ps.setInt(1, (page-1)*size+1);
			ps.setInt(2, page*size);
			ResultSet rs = ps.executeQuery();
			List<User> list = new ArrayList<User>();
			while(rs.next()) {
				list.add(createUser(rs));
			}
			return list;
		} catch (SQLException e1) {
			e1.printStackTrace();
			throw new RuntimeException(
				"查询员工失败!", e1);
		} finally {
			DBUtil.close(conn);
		}
	}
	
	/**
	 * 查询某部门内的员工
	 * */
	public List<User> findByDept(int deptno) {
		return null;
	}
	
}














