package com.SSHforum.actions;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.SSHforum.entities.CommentInfo;
import com.SSHforum.entities.ContentInfo;
import com.SSHforum.entities.UserInfo;
import com.SSHforum.service.CommentInfoService;
import com.SSHforum.service.ContentInfoService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CommentInfoAction extends ActionSupport
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserInfo userInfo;
	private ContentInfo contentInfo;
	private CommentInfo commentInfo;
	private CommentInfoService commentInfoService;
	private ContentInfoService contentInfoService;
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	public ContentInfo getContentInfo() {
		return contentInfo;
	}
	public void setContentInfo(ContentInfo contentInfo) {
		this.contentInfo = contentInfo;
	}
	public CommentInfo getCommentInfo() {
		return commentInfo;
	}
	public void setCommentInfo(CommentInfo commentInfo) {
		this.commentInfo = commentInfo;
	}
	public CommentInfoService getCommentInfoService() {
		return commentInfoService;
	}
	public void setCommentInfoService(CommentInfoService commentInfoService) {
		this.commentInfoService = commentInfoService;
	}
	
	public ContentInfoService getContentInfoService() {
		return contentInfoService;
	}
	public void setContentInfoService(ContentInfoService contentInfoService) {
		this.contentInfoService = contentInfoService;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public String SaveCommentInfo()
	{
		ActionContext actionContext = ActionContext.getContext();
		userInfo = (UserInfo) actionContext.getSession().get("userInfo");
		contentInfo=(ContentInfo) actionContext.getSession().get("NowContentInfo");
		commentInfo.setComment(commentInfo.getComment());
		commentInfo.setCommenttime(new Date());
		commentInfo.setUserInfo(userInfo);
		commentInfo.setContentInfo(contentInfo);
		commentInfo.setPraisenumber(0);
		commentInfoService.SaveCommentInfo(commentInfo);
		contentInfoService.AddReplyNumber(contentInfo.getId());
		
		List<CommentInfo> list = commentInfoService.GetAllCommentInfo(contentInfo.getId());
		Map session = actionContext.getSession();
		session.put("ThisComment", list);
		
		return "saveInfo";
	}
	
}
