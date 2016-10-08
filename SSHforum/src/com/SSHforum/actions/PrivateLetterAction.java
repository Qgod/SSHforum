package com.SSHforum.actions;

import java.util.Date;

import com.SSHforum.entities.PrivateLetter;
import com.SSHforum.entities.UserInfo;
import com.SSHforum.service.PrivateLetterService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class PrivateLetterAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PrivateLetter privateLetter;
	private PrivateLetterService privateLetterService;
	public PrivateLetter getPrivateLetter() {
		return privateLetter;
	}
	public void setPrivateLetter(PrivateLetter privateLetter) {
		this.privateLetter = privateLetter;
	}
	public PrivateLetterService getPrivateLetterService() {
		return privateLetterService;
	}
	public void setPrivateLetterService(PrivateLetterService privateLetterService) {
		this.privateLetterService = privateLetterService;
	}
	public String SendPrivateLetter()
	{
		ActionContext actionContext = ActionContext.getContext();
		UserInfo NowuserInfo = (UserInfo) actionContext.getSession().get("NowUserInfo");//当前要私信的用户
		UserInfo userInfo2=(UserInfo) actionContext.getSession().get("userInfo");//当前登录的用户
		privateLetter.setLettercontent(privateLetter.getLettercontent());
		privateLetter.setCreatetime(new Date());
		privateLetter.setUserInfo(userInfo2);
		privateLetter.setReviewer(NowuserInfo.getId());
		privateLetterService.sendPrivateLetter(privateLetter);
		privateLetterService.addPrivateLetternumber(NowuserInfo.getId());
		//System.out.println(NowuserInfo);
		//System.out.println(userInfo2);
		return "sendSuccess";
	}
}
