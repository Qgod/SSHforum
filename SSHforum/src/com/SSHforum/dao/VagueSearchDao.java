package com.SSHforum.dao;

import java.util.List;

import com.SSHforum.entities.ContentInfo;
import com.SSHforum.entities.UserInfo;

public interface VagueSearchDao 
{
	public List<ContentInfo> searchContentInfo(String something);
	
	public List<UserInfo> searchUserInfo(String someone);
}
