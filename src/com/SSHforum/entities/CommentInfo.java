package com.SSHforum.entities;

import java.util.Date;

public class CommentInfo
{
	private int id;
	private String comment;
	private Date commenttime;
	private ContentInfo contentInfo;
	private UserInfo userInfo;
	private Integer praisenumber;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Date getCommenttime() {
		return commenttime;
	}
	public void setCommenttime(Date commenttime) {
		this.commenttime = commenttime;
	}
	public ContentInfo getContentInfo() {
		return contentInfo;
	}
	public void setContentInfo(ContentInfo contentInfo) {
		this.contentInfo = contentInfo;
	}
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	
	public Integer getPraisenumber() {
		return praisenumber;
	}
	public void setPraisenumber(Integer praisenumber) {
		this.praisenumber = praisenumber;
	}
	@Override
	public String toString() {
		return "CommentInfo [id=" + id + ", comment=" + comment + ", commenttime=" + commenttime + ", contentInfo="
				+ contentInfo + ", userInfo=" + userInfo + ", praisenumber=" + praisenumber + "]";
	}
	
	
}
	
	
