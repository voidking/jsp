package com.voidking.jsp.model;

import java.sql.Date;
public class Message {
	//Fields
	private Integer id;
	private Integer userid;
	private Date date;
	private String title;
	private String content;

	
	//Property accessors
	//属性 id 的 get/set 方法
	public Integer getId(){
		return this.id;
		
	}
	public void setId(Integer id){
		this.id=id;
	}
	//属性 userId 的 get/set 方法
	public Integer getUserid(){
		return this.userid;
	}
	public void setUserid(Integer userid){
		this.userid=userid;
	}
	//属性 date 的 get/set 方法
	public Date getDate(){
		return this.date;
	}
	public void setDate(Date date){
		this.date=date;
	}
	//属性 title 的 get/set 方法
	public String getTitle(){
		return this.title;
	}
	public void setTitle(String title){
		this.title=title;
	}
	//属性 content 的 get/set 方法
	public String getContent(){
		return this.content;
	}
	public void setContent(String content){
		this.content=content;
	}
}

