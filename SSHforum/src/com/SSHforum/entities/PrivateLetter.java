package com.SSHforum.entities;

import java.util.Date;

public class PrivateLetter
{
	private int id;
	private String lettercontent;
	private Date createtime;
	private UserInfo userInfo;
	private int reviewer;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLettercontent() {
		return lettercontent;
	}
	public void setLettercontent(String lettercontent) {
		this.lettercontent = lettercontent;
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
	public int getReviewer() {
		return reviewer;
	}
	public void setReviewer(int reviewer) {
		this.reviewer = reviewer;
	}
	@Override
	public String toString() {
		return "PrivateLetter [id=" + id + ", lettercontent=" + lettercontent + ", createtime=" + createtime
				+ ", userInfo=" + userInfo + ", reviewer=" + reviewer + "]";
	}
	
	
	
	
}
