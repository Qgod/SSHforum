package com.SSHforum.service.imp;


import java.util.List;

import com.SSHforum.dao.UserInfoDao;
import com.SSHforum.entities.UserInfo;
import com.SSHforum.service.UserInfoService;

public class UserInfoServiceImp implements UserInfoService
{
	private UserInfoDao userInfoDao;
	
	public UserInfoDao getUserInfoDao() {
		return userInfoDao;
	}

	public void setUserInfoDao(UserInfoDao userInfoDao) {
		this.userInfoDao = userInfoDao;
	}

	@Override
	public void SaveUserInfo(UserInfo userInfo) 
	{
		userInfoDao.SaveUserInfo(userInfo);
	}

	@Override
	public UserInfo LoginUser(String username, String password) {
		
		return userInfoDao.LoginUser(username, password);
	}

	@Override
	public UserInfo GetQuestion(String username) {
		
		return userInfoDao.GetQuestion(username);
	}

	@Override
	public void UpdatePassword(int id, String password) {
		userInfoDao.UpdatePassword(id, password);
	}

	@Override
	public UserInfo getOneUserInfo(int userInfoid) {
		return userInfoDao.getOneUserInfo(userInfoid);
	}

	@Override
	public void alterAddress(String address, int userInfoid) {
		userInfoDao.alterAddress(address, userInfoid);
	}

	@Override
	public void alterWorkType(String worktype, int userInfoid) {
		userInfoDao.alterWorkType(worktype, userInfoid);
		
	}

	@Override
	public void alterEducation(String education, int userInfoid) {
		userInfoDao.alterEducation(education, userInfoid);
		
	}

	@Override
	public void alterIntroduce(String introduce, int userInfoid) {
		userInfoDao.alterIntroduce(introduce, userInfoid);
		
	}

	@Override
	public List viladateUsername() {
		return userInfoDao.viladateUsername();
	}

	

	
}
