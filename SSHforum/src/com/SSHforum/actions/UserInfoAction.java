package com.SSHforum.actions;

import java.util.List;

import com.SSHforum.entities.UserInfo;

import com.SSHforum.service.UserInfoService;
import com.opensymphony.xwork2.ActionSupport;

public class UserInfoAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserInfo userInfo;

	private UserInfoService userInfoService;

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public UserInfoService getUserInfoService() {
		return userInfoService;
	}

	public void setUserInfoService(UserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}

	@Override
	public String execute() throws Exception {

		userInfo.setUsername(userInfo.getUsername());
		userInfo.setPassword(userInfo.getPassword());
		userInfo.setPhoneNumber(userInfo.getPhoneNumber());
		userInfo.setEmail(userInfo.getEmail());
		userInfo.setQuestion(userInfo.getQuestion());
		userInfo.setAnswer(userInfo.getAnswer());
		userInfo.setNickname(userInfo.getNickname());
		userInfo.setPrivateletternumber(userInfo.getPrivateletternumber());
		userInfoService.SaveUserInfo(userInfo);
		return SUCCESS;
	}

}
