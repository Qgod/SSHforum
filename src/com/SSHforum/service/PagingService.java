package com.SSHforum.service;

import java.util.List;

import com.SSHforum.entities.ContentInfo;
import com.SSHforum.entities.PrivateLetter;

public interface PagingService 
{
	public int GetCountInfo();
	
	public List<ContentInfo> NextPage(int NowPage);
	
	public List<ContentInfo>BeforePage();

	public List<PrivateLetter> getMyPrivateLetter(int userinfoid);
}
