package com.SSHforum.dao.imp;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.SSHforum.dao.BaseDao;
import com.SSHforum.dao.ContentInfoDao;
import com.SSHforum.entities.ContentInfo;

public class ContentInfoDaoImp extends BaseDao implements ContentInfoDao
{

	@Override
	public void IssueContent(ContentInfo contentInfo)
	{
		Session session = null;
		Transaction transaction = null;
		try{
			session=getSession();
			transaction=session.beginTransaction();
			session.save(contentInfo);
			transaction.commit();
		}catch(Exception ex){
			if (transaction!=null)
				transaction.rollback();
		}finally{
			session.close();
		}
	}

	@Override
	public List<ContentInfo> ShowAllContent() 
	{
		Session session=null;
		Transaction transaction=null;
		List list=null;
		try{
			session=getSession();
			transaction=session.beginTransaction();
			String hql="from ContentInfo order by id desc";
			Query query=session.createQuery(hql);
			int pageSize=10;
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
	public List<ContentInfo> getMyContentInfo(int userInfoid) 
	{
		Session session=null;
		Transaction transaction=null;
		List<ContentInfo> list=null;
		try{
			session=getSession();
			transaction=session.beginTransaction();
			String hql="from ContentInfo where userInfo = '"+userInfoid+"'";
			Query query = session.createQuery(hql);
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
	public ContentInfo getDetailContentInfo(int contentid) {
		Session session=null;
		Transaction transaction=null;
		ContentInfo contentInfo=null;
		try{
			session=getSession();
			transaction=session.beginTransaction();
			String hql="from ContentInfo where id='"+contentid+"'";
			Query query=session.createQuery(hql);
			contentInfo=(ContentInfo) query.uniqueResult();
			transaction.commit();
		}catch(Exception ex){
			if(transaction != null)
				transaction.rollback();
		}finally{
			session.close();
		}
		return contentInfo;
	}

	@Override
	public void AddReplyNumber(int contentid) 
	{
		Session session = null;
		Transaction transaction = null;
		try{
			session=getSession();
			transaction=session.beginTransaction();
			String hql="update ContentInfo set replys = replys + 1 where id='"+contentid+"'";
			Query query = session.createQuery(hql);
			query.executeUpdate();
			transaction.commit();
		}catch(Exception ex){
			if(transaction != null)
				transaction.rollback();
		}finally{
			session.close();
		}
	}

}
