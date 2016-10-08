package com.SSHforum.service.imp;

import java.util.List;

import com.SSHforum.dao.VagueSearchDao;
import com.SSHforum.entities.ContentInfo;
import com.SSHforum.entities.UserInfo;
import com.SSHforum.service.VagueSearchService;

public class VagueSearchServiceImp implements VagueSearchService
{
	private VagueSearchDao vagueSearchDao;

	public VagueSearchDao getVagueSearchDao() {
		return vagueSearchDao;
	}

	public void setVagueSearchDao(VagueSearchDao vagueSearchDao) {
		this.vagueSearchDao = vagueSearchDao;
	}

	@Override
	public List<ContentInfo> searchContentInfo(String something) {
		return vagueSearchDao.searchContentInfo(something);
	}

	@Override
	public List<UserInfo> searchUserInfo(String someone) {
		return vagueSearchDao.searchUserInfo(someone);
	}
	
}
