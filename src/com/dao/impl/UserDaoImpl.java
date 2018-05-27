package com.dao.impl;


import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.dao.UserDao;
import com.somain.User;
import com.utils.DBUtil;

public class UserDaoImpl implements UserDao{

	public void regist(User user) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(DBUtil.getDataSource());
		String sql = "insert into user values (?,?,?,?,?,?,?)";
		Object[] params = {user.getUid(),user.getUsername(),user.getPassword(),
				user.getNickname(),user.getEmail(),
				user.getState(),user.getCode()};
		
		queryRunner.update(sql,params);
	}

	public User findByCode(String code) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(DBUtil.getDataSource());
		String sql = "select * from User where code = ?";
		User user = queryRunner.query(sql, new BeanHandler<User>(User.class),code);
		return user;
	}

	public void update(User user) throws Exception {
		QueryRunner queryRunner = new QueryRunner(DBUtil.getDataSource());
		String sql = "update user set username=?,"
				+ "password=?,nickname=?,email=?,state=?,code=? where uid=?";
		Object[] params = {user.getUsername(),user.getPassword(),
				user.getNickname(),user.getEmail(),
				user.getState(),user.getCode(),user.getUid()};
		queryRunner.update(sql,params);
	}
	
	
	

}
