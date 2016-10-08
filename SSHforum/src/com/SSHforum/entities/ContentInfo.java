package com.SSHforum.entities;

import java.util.Date;

public class ContentInfo 
{
	private int id;
	private String title;
	private String content;
	private String topic;
	private Date createtime;
	private UserInfo userInfo;
	private int replys;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	
	public int getReplys() {
		return replys;
	}
	public void setReplys(int replys) {
		this.replys = replys;
	}
	@Override
	public String toString() {
		return "ContentInfo [id=" + id + ", title=" + title + ", content=" + content + ", topic=" + topic
				+ ", createtime=" + createtime + ", userInfo=" + userInfo + ", replys=" + replys
				+ "]";
	}
	
	
	
	
}
