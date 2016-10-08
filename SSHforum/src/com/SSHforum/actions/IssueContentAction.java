package com.SSHforum.actions;

import java.util.Date;

import com.SSHforum.entities.ContentInfo;
import com.SSHforum.entities.UserInfo;
import com.SSHforum.service.ContentInfoService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class IssueContentAction extends ActionSupport 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ContentInfo contentInfo;
	private UserInfo userInfo;
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
	public ContentInfoService getContentInfoService() {
		return contentInfoService;
	}
	public void setContentInfoService(ContentInfoService contentInfoService) {
		this.contentInfoService = contentInfoService;
	}
	@Override
	public String execute() throws Exception
	{
		ActionContext actionContext=ActionContext.getContext();
		userInfo=(UserInfo) actionContext.getSession().get("userInfo");
		contentInfo.setTitle(contentInfo.getTitle());
		contentInfo.setContent(contentInfo.getContent());
		contentInfo.setTopic(contentInfo.getTopic());
		contentInfo.setCreatetime(new Date());
		contentInfo.setUserInfo(userInfo);
		contentInfo.setReplys(0);
		contentInfoService.IssueContent(contentInfo);
		/*List list=null;  //this
		list=(List) actionContext.getSession().get("contentInfo");
		list.add(0,contentInfo);
		Map session = actionContext.getSession();
		session.put("contentInfo", list);*/
		return "issueSuccess";
	}
	
	
	
}
