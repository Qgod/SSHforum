package com.SSHforum.actions;

import java.util.Map;

import com.SSHforum.entities.UserInfo;
import com.SSHforum.service.UserInfoService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserChangePasswordAction extends ActionSupport
{
	private String user_name;
	private UserInfoService userInfoService;
	private UserInfo userInfo;
	
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	
	public UserInfoService getUserInfoService() {
		return userInfoService;
	}
	public void setUserInfoService(UserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}
	
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String getUsername()
	{
		if(user_name!=null)
		{
			userInfo=userInfoService.GetQuestion(user_name);
			ActionContext actionContext=ActionContext.getContext();
			Map session=actionContext.getSession();
			session.put("user", userInfo);
		}
		return "getU";
	}
	
	public String validateQuestion()
	{
		ActionContext actionContext=ActionContext.getContext();
		UserInfo info=new UserInfo();
		info=(UserInfo) actionContext.getSession().get("user");
		if(info.getAnswer().equals(userInfo.getAnswer()) && info.getUsername().equals(userInfo.getUsername()) && info.getQuestion().equals(userInfo.getQuestion()))
		{
			System.out.println(info);
			return "validateQ";
		}else{
			this.addActionError("验证失败！");
			return "validateFail";
		}	
	}
	
	public String changePassword()
	{
		ActionContext actionContext=ActionContext.getContext();
		UserInfo info=new UserInfo();
		info=(UserInfo) actionContext.getSession().get("user");
		userInfoService.UpdatePassword(info.getId(), userInfo.getPassword());
		this.addActionError("密码修改成功，请重新登录！");
		System.out.println(info);
		return "changeP";
	}
	
}
