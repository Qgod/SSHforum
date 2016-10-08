package com.SSHforum.service;

import java.util.List;

import com.SSHforum.entities.PrivateLetter;

public interface PrivateLetterService 
{
	public void sendPrivateLetter(PrivateLetter privateLetter);
	
	public void addPrivateLetternumber(int userinfoid);
	
	public List<PrivateLetter> getMyPrivateLetter(int userinfoid);
}
