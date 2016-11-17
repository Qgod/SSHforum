package com.SSHforum.service;

import java.util.List;

import com.SSHforum.entities.ContentInfo;
import com.SSHforum.entities.UserInfo;

public interface VagueSearchService 
{
	public List<ContentInfo> searchContentInfo(String something);
	
	public List<UserInfo> searchUserInfo(String someone);
}
