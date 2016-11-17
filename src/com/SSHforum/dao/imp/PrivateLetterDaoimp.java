package com.SSHforum.dao.imp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.SSHforum.dao.BaseDao;
import com.SSHforum.dao.PrivateLetterDao;
import com.SSHforum.entities.PrivateLetter;

public class PrivateLetterDaoimp extends BaseDao implements PrivateLetterDao
{

	@Override
	public void sendPrivateLetter(PrivateLetter privateLetter) 
	{
		Session session = null;
		Transaction transaction = null;
		try{
			session=getSession();
			transaction=session.beginTransaction();
			session.save(privateLetter);
			transaction.commit();
		}catch(Exception ex){
			if(transaction!=null)
				transaction.rollback();
		}finally{
			session.close();
		}
	}

	@Override
	public void addPrivateLetternumber(int userinfoid) {
		Session session = null;
		Transaction transaction = null;
		try{
			session=getSession();
			transaction=session.beginTransaction();
			String hql="update UserInfo set privateletternumber = privateletternumber + 1 where id = '"+userinfoid+"' ";
			Query query = session.createQuery(hql);
			query.executeUpdate();
			transaction.commit();
		}catch(Exception ex){
			if(transaction!=null)
				transaction.rollback();
		}finally{
			session.close();
		}
		
	}

	@Override
	public List<PrivateLetter> getMyPrivateLetter(int userinfoid) 
	{
		Session session = null;
		Transaction transaction = null;
		List list = null;
		try{
			session=getSession();
			transaction=session.beginTransaction();
			String hql="from PrivateLetter where reviewer = '"+userinfoid+"' ";
			Query query = session.createQuery(hql);
			list = query.list();
			transaction.commit();
		}catch(Exception ex){
			if(transaction!=null)
				transaction.rollback();
		}finally{
			session.close();
		}
		return list;
		
	}
	
}
