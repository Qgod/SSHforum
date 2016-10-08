package com.SSHforum.service;


import java.util.List;

import com.SSHforum.entities.UserInfo;

public interface UserInfoService 
{
	public void SaveUserInfo(UserInfo userInfo);
	
	public UserInfo LoginUser(String username,String password);
	
	public UserInfo GetQuestion(String username);
	
	public void UpdatePassword(int id,String password);
	
	public UserInfo getOneUserInfo(int userInfoid);
	
	public void alterAddress(String address,int userInfoid);
	
	public void alterWorkType(String worktype,int userInfoid);
	
	public void alterEducation(String education,int userInfoid);
	
	public void alterIntroduce(String introduce,int userInfoid);
	
	public List viladateUsername();
}
