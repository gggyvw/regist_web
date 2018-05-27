package com.service.impl;

import java.sql.SQLException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import com.dao.UserDao;
import com.dao.impl.UserDaoImpl;
import com.service.UserService;
import com.somain.User;
import com.utils.MailUtils;

public class UserServiceImpl implements UserService {

	public void regist(User user) throws Exception {
		UserDao userDao = new UserDaoImpl();
		userDao.regist(user);
		
		MailUtils.sendMail(user.getEmail(),user.getCode());
	}

	public User findByCode(String code) throws SQLException{
		UserDao userDao = new UserDaoImpl();
		
		return userDao.findByCode(code) ;
	}

	public void update(User user) throws Exception {
		UserDao userDao = new UserDaoImpl();
		
		userDao.update(user) ;
		
	}

}
