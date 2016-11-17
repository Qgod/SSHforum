package com.SSHforum.service.imp;

import java.util.List;

import com.SSHforum.dao.PagingDao;
import com.SSHforum.entities.ContentInfo;
import com.SSHforum.entities.PrivateLetter;
import com.SSHforum.service.PagingService;

public class PagingServiceImp implements PagingService {
	private PagingDao pagingDao;
	

	public PagingDao getPagingDao() {
		return pagingDao;
	}

	public void setPagingDao(PagingDao pagingDao) {
		this.pagingDao = pagingDao;
	}

	

	@Override
	public List<ContentInfo> NextPage(int NowPage) {
		return pagingDao.NextPage(NowPage);
	}


	@Override
	public int GetCountInfo() {
		// TODO Auto-generated method stub
		return pagingDao.GetCountInfo();
	}

	@Override
	public List<ContentInfo> BeforePage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PrivateLetter> getMyPrivateLetter(int userinfoid) {
		// TODO Auto-generated method stub
		return null;
	}

}
