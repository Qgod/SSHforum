package com.SSHforum.dao.imp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.SSHforum.dao.BaseDao;
import com.SSHforum.dao.PagingDao;
import com.SSHforum.entities.ContentInfo;

public class PagingDaoImp extends BaseDao implements PagingDao
{

	@Override
	public int GetCountInfo() {
		Session session = null;
		Transaction transaction = null;
		List list=null;
		try{
			session=getSession();
			transaction=session.beginTransaction();
			String hql="from ContentInfo";
			Query query=session.createQuery(hql);
			list=query.list();
			transaction.commit();
		}catch(Exception ex){
			if(transaction!=null)
				transaction.rollback();
		}finally{
			session.close();
		}
		return list.size();
	}

	@Override
	public List<ContentInfo> NextPage(int NowPage) {
		Session session=null;
		Transaction transaction=null;
		List list=null;
		try{
			session=getSession();
			transaction=session.beginTransaction();
			String hql="from ContentInfo order by id desc";
			Query query=session.createQuery(hql);
			int pageSize=10;
			query.setFirstResult((NowPage-1)*pageSize);
			query.setMaxResults(pageSize);
			list=query.list();
			transaction.commit();
		}catch(Exception ex){
			if(transaction!=null)
				transaction.rollback();
		}finally{
			session.close();
		}
		return list;
	}

	@Override
	public List<ContentInfo> BeforePage(int NowPage) {
		
		return null;
	}

	@Override
	public List<ContentInfo> JumpPage(int PageNumber) {
		// TODO Auto-generated method stub
		return null;
	}

}
