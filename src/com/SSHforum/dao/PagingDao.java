package com.SSHforum.dao;

import java.util.List;

import com.SSHforum.entities.ContentInfo;

public interface PagingDao
{
	public int GetCountInfo();
	
	public List<ContentInfo> NextPage(int NowPage);
	
	public List<ContentInfo> BeforePage(int NowPage);
	
	public List<ContentInfo> JumpPage(int PageNumber);
	 
}
