package com.SSHforum.actions;

import java.util.List;
import java.util.Map;

import com.SSHforum.entities.UserInfo;
import com.SSHforum.service.ContentInfoService;
import com.SSHforum.service.UserInfoService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class PersonWithPersonAction extends ActionSupport 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private UserInfoService userInfoService;
	private ContentInfoService contentInfoService;
	private int NowUserInfoid;
	public UserInfoService getUserInfoService() {
		return userInfoService;
	}
	public void setUserInfoService(UserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}
	public int getNowUserInfoid() {
		return NowUserInfoid;
	}
	public void setNowUserInfoid(int nowUserInfoid) {
		NowUserInfoid = nowUserInfoid;
	}
	
	public ContentInfoService getContentInfoService() {
		return contentInfoService;
	}
	public void setContentInfoService(ContentInfoService contentInfoService) {
		this.contentInfoService = contentInfoService;
	}
	public String showTheUserInfo()
	{
		//System.out.println(NowUserInfoid);
		UserInfo userInfo = userInfoService.getOneUserInfo(NowUserInfoid);
		List list = contentInfoService.getMyContentInfo(NowUserInfoid);
		ActionContext actionContext = ActionContext.getContext();
		Map session = actionContext.getSession();
		session.put("NowUserInfo",userInfo );
		session.put("NowContentInfo", list);
		return "showtheuserinfo";
	}
	
}
