package com.SSHforum.service.imp;

import java.util.List;

import com.SSHforum.dao.ContentInfoDao;
import com.SSHforum.entities.ContentInfo;
import com.SSHforum.service.ContentInfoService;

public class ContentInfoServiceImp implements ContentInfoService {

	private ContentInfoDao contentInfoDao;

	public ContentInfoDao getContentInfoDao() {
		return contentInfoDao;
	}

	public void setContentInfoDao(ContentInfoDao contentInfoDao) {
		this.contentInfoDao = contentInfoDao;
	}

	@Override
	public void IssueContent(ContentInfo contentInfo) {
		contentInfoDao.IssueContent(contentInfo);
	}

	@Override
	public List<ContentInfo> ShowAllContent() {
		return contentInfoDao.ShowAllContent();
	}

	@Override
	public List<ContentInfo> getMyContentInfo(int userInfoid) {
		
		return contentInfoDao.getMyContentInfo(userInfoid);
	}

	@Override
	public ContentInfo getDetailContentInfo(int contentid) {
		return contentInfoDao.getDetailContentInfo(contentid);
	}

	@Override
	public void AddReplyNumber(int contentid) {
		contentInfoDao.AddReplyNumber(contentid);
		
	}

	

}
