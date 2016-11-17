package com.SSHforum.service.imp;

import java.util.List;

import com.SSHforum.dao.PrivateLetterDao;
import com.SSHforum.entities.PrivateLetter;
import com.SSHforum.service.PrivateLetterService;

public class PrivateLetterServiceImp implements PrivateLetterService
{
	private PrivateLetterDao privateLetterDao;

	public PrivateLetterDao getPrivateLetterDao() {
		return privateLetterDao;
	}

	public void setPrivateLetterDao(PrivateLetterDao privateLetterDao) {
		this.privateLetterDao = privateLetterDao;
	}

	@Override
	public void sendPrivateLetter(PrivateLetter privateLetter) {
		privateLetterDao.sendPrivateLetter(privateLetter);
	}

	@Override
	public void addPrivateLetternumber(int userinfoid) {
		privateLetterDao.addPrivateLetternumber(userinfoid);
		
	}

	@Override
	public List<PrivateLetter> getMyPrivateLetter(int userinfoid) {
		return privateLetterDao.getMyPrivateLetter(userinfoid);
	}
	
}
