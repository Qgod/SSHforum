package com.SSHforum.service.imp;

import java.util.List;

import com.SSHforum.dao.CommentInfoDao;
import com.SSHforum.entities.CommentInfo;
import com.SSHforum.service.CommentInfoService;

public class CommentInfoServiceImp implements CommentInfoService
{

	private CommentInfoDao commentInfoDao;
	
	public CommentInfoDao getCommentInfoDao() {
		return commentInfoDao;
	}

	public void setCommentInfoDao(CommentInfoDao commentInfoDao) {
		this.commentInfoDao = commentInfoDao;
	}

	@Override
	public void SaveCommentInfo(CommentInfo commentInfo) {
		commentInfoDao.SaveCommentInfo(commentInfo);
	}

	@Override
	public List<CommentInfo> GetAllCommentInfo(int contentid) {
		return commentInfoDao.GetAllCommentInfo(contentid);
	}

	@Override
	public void AddPraise(int commentid) {
		commentInfoDao.AddPraise(commentid);
		
	}

	@Override
	public int GetPraiseNumber(int commentid) {
		return commentInfoDao.GetPraiseNumber(commentid);
	}

}
