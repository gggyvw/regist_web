package com.utils;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;


public class MailUtils {
	/**
	 * 发邮件的方法
	 * @throws MessagingException 
	 * @throws AddressException 
	 */
	public static void sendMail(String to,String code) throws AddressException, MessagingException{
		//1创建连接对象，连接邮箱服务
		Properties props = new Properties();
		Session session = Session.getInstance(props,new Authenticator(){
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("service@gggyvw.com", "service");
			}
			
		});
		//2.创建邮件对象
		Message message = new MimeMessage(session);
		//2.1设置发件人
		message.setFrom(new InternetAddress("service@gggyvw.com"));
		//2.2设置收件人
		message.setRecipient(RecipientType.TO, new InternetAddress(to));
		//2.3设置邮件主题
		message.setSubject("激活邮件");
		//2.4设置邮件的正文
		message.setContent("<h1>激活邮件,激活请点击以下连接：</h1><h3><a href='http://localhost:8090/regist_web/ActiveServlet?code="+code+"'>http://localhost:8090/regist_web/ActiveServlet?code="+code+"</a></h3>", "text/html;charset=UTF-8");
		//3.发送一封激活邮件
		Transport.send(message);
	}
}















