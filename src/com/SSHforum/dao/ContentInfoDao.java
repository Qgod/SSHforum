package com.SSHforum.dao;

import java.util.List;

import com.SSHforum.entities.ContentInfo;

public interface ContentInfoDao 
{
	public void IssueContent(ContentInfo contentInfo);
	
	public List<ContentInfo> ShowAllContent();
	
	public List<ContentInfo> getMyContentInfo(int userInfoid);
	
	public ContentInfo getDetailContentInfo(int contentid);
	
	public void AddReplyNumber(int contentid);
}
