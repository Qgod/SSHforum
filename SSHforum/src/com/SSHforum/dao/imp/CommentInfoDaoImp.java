package com.SSHforum.dao.imp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.SSHforum.dao.BaseDao;
import com.SSHforum.dao.CommentInfoDao;
import com.SSHforum.entities.CommentInfo;

public class CommentInfoDaoImp extends BaseDao implements CommentInfoDao
{

	@Override
	public void SaveCommentInfo(CommentInfo commentInfo) {
		Session session=null;
		Transaction transaction=null;
		try{
			session=getSession();
			transaction=session.beginTransaction();
			session.save(commentInfo);
			transaction.commit();
		}catch(Exception ex){
			if(transaction != null)
				transaction.rollback();
		}finally{
			session.close();
		}
	}

	@Override
	public List<CommentInfo> GetAllCommentInfo(int contentid) {
		Session session=null;
		Transaction transaction=null;
		List<CommentInfo> list=null;
		try{
			session=getSession();
			transaction=session.beginTransaction();
			String hql="from CommentInfo where contentInfo = '"+contentid+"' ";
			Query query = session.createQuery(hql);
			list=query.list();
			transaction.commit();
		}catch(Exception ex){
			if(transaction != null)
				transaction.rollback();
		}finally{
			session.close();
		}
		return list;
	}

	@Override
	public void AddPraise(int commentid) {
		Session session=null;
		Transaction transaction=null;	
		try{
			session=getSession();
			transaction=session.beginTransaction();
			String hql = "update CommentInfo set praisenumber = praisenumber + 1 where id = '"+commentid+"'";
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

	@Override
	public int GetPraiseNumber(int commentid) {
		Session session=null;
		Transaction transaction=null;	
		int result = 0;
		try{
			session=getSession();
			transaction=session.beginTransaction();
			String hql = "select praisenumber from CommentInfo where id = '"+commentid+"'";
			Query query = session.createQuery(hql);
			result = (int) query.uniqueResult();
			transaction.commit();
		}catch(Exception ex){
			if(transaction != null)
				transaction.rollback();
		}finally{
			session.close();
		}
		return result;
	}
}
