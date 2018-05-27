package com.service;

import java.sql.SQLException;

import com.somain.User;

public interface UserService {

	void regist(User user)throws Exception;

	User findByCode(String code) throws SQLException;

	public void update(User user) throws Exception;
}
