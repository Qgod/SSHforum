package com.SSHforum.service;

import java.util.List;

import com.SSHforum.entities.CommentInfo;

public interface CommentInfoService 
{
	public void SaveCommentInfo(CommentInfo commentInfo);
	public List<CommentInfo> GetAllCommentInfo(int contentid);
	public void AddPraise(int commentid);
	public int GetPraiseNumber(int commentid);
}
