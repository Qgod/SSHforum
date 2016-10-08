package com.SSHforum.dao.imp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.SSHforum.dao.BaseDao;
import com.SSHforum.dao.VagueSearchDao;
import com.SSHforum.entities.ContentInfo;
import com.SSHforum.entities.UserInfo;

public class VagueSearchDaoImp extends BaseDao implements VagueSearchDao
{

	@Override
	public List<ContentInfo> searchContentInfo(String something) {
		Session session = null;
		Transaction transaction = null;
		List list = null;
		try{
			session=getSession();
			transaction=session.beginTransaction();
			String hql="from ContentInfo where title like '%"+something+"%'  or content like '%"+something+"%'";
			Query query = session.createQuery(hql);
			list = query.list();
			transaction.commit();
		}catch(Exception ex){
			if (transaction!=null)
				transaction.rollback();
		}finally{
			session.close();
		}
		return list;
	}

	@Override
	public List<UserInfo> searchUserInfo(String someone) {
		Session session = null;
		Transaction transaction = null;
		List list = null;
		try{
			session=getSession();
			transaction=session.beginTransaction();
			String hql="from UserInfo where nickname like '%"+someone+"%' ";
			Query query = session.createQuery(hql);
			list = query.list();
			transaction.commit();
		}catch(Exception ex){
			if (transaction!=null)
				transaction.rollback();
		}finally{
			session.close();
		}
		return list;
	}

}
