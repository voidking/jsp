package com.voidking.jsp.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.voidking.jsp.model.Message;
import com.voidking.jsp.model.User;

public class DB {

	Connection ct;
	PreparedStatement pstmt;
	
	public DB()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			ct=DriverManager.getConnection("jdbc:mysql://localhost/jsp","scott","tiger");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public User checkUser(String username,String password)
	{
		try {
			pstmt = ct.prepareStatement("select * from user where username=? and password=?");
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			
			ResultSet rs=pstmt.executeQuery();
			User user = new User();
			while (rs.next()) {
				user.setId(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setPassword(rs.getString(3));
				return user;
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;	
	}
	
	public ArrayList findMessage()
	{
		
		try {
			ArrayList al = new ArrayList();
			pstmt= ct.prepareStatement("select * from message");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				Message message = new Message();
				message.setId(rs.getInt(1));
				message.setUserid(rs.getInt(2));
				message.setDate(rs.getDate(3));
				message.setTitle(rs.getString(4));
				message.setContent(rs.getString(5));
				al.add(message);
				
			}
			return al;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;	
		
	}
	
	public String getUsername(int id)
	{
		String username = null;
		try {
			pstmt = ct.prepareStatement("select username from user where id=?");
			pstmt.setInt(1,id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				username = rs.getString(1);			
				
			}
			return username;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return username;
		
	}
	
	public boolean addMessage(Message message)
	{
		try {
			pstmt= ct.prepareStatement("insert into message(userid,date,title,content) values(?,?,?,?)");
			pstmt.setInt(1, message.getUserid());
			pstmt.setDate(2,message.getDate());
			pstmt.setString(3, message.getTitle());
			pstmt.setString(4, message.getContent());
			
			pstmt.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;	
		
	}	
	
	public boolean insertUser(String username,String password)
	{
		try {
			pstmt = ct.prepareStatement("insert into user(username,password) values(?,?)");
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			pstmt.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;		
		
	}
}
