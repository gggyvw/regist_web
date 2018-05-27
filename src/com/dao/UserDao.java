package com.dao;

import java.sql.SQLException;

import com.somain.User;

public interface UserDao {

	void regist(User user) throws SQLException ;

	User findByCode(String code) throws SQLException;

	public void update(User user) throws Exception ;

}
