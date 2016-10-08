package com.SSHforum.dao;

import java.util.List;

import com.SSHforum.entities.CommentInfo;

public interface CommentInfoDao 
{
	public void SaveCommentInfo(CommentInfo commentInfo);
	
	public List<CommentInfo> GetAllCommentInfo(int contentid);
	
	public void AddPraise(int commentid);
	
	public int GetPraiseNumber(int commentid);
}
