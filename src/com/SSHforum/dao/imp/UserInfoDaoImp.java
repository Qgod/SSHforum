package com.SSHforum.dao.imp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.SSHforum.dao.BaseDao;
import com.SSHforum.dao.UserInfoDao;
import com.SSHforum.entities.UserInfo;

public class UserInfoDaoImp extends BaseDao implements UserInfoDao {

	@Override
	public void SaveUserInfo(UserInfo userInfo) {
		Transaction transaction = null;
		Session session = null;
		try {
			session = getSession();
			transaction = session.beginTransaction();
			session.save(userInfo);
			transaction.commit();
		} catch (Exception ex) {
			if (transaction != null)
				transaction.rollback();
		} finally {
			session.close();
		}
	}

	@Override
	public UserInfo LoginUser(String username, String password) {
		Transaction transaction = null;
		Session session = null;
		UserInfo userInfo = null;
		try {
			session = getSession();
			transaction = session.beginTransaction();
			String hql = "from UserInfo  where username = '" + username + "' and password = '" + password + "'";
			Query query = session.createQuery(hql);
			userInfo = (UserInfo) query.uniqueResult();
			transaction.commit();

		} catch (Exception ex) {
			if (transaction != null)
				transaction.rollback();
		} finally {
			session.close();
		}
		return userInfo;
	}

	@Override
	public UserInfo GetQuestion(String username) {
		Transaction transaction = null;
		Session session = null;
		UserInfo userInfo=null;
		try{
			session=getSession();
			transaction=session.beginTransaction();
			String hql="from UserInfo where username='"+username+"'";
			Query query =session.createQuery(hql);
			userInfo=(UserInfo) query.uniqueResult();
		}catch(Exception ex){
			if(transaction!=null)
				transaction.rollback();
		}finally{
			session.close();
		}
		return  userInfo;
	}

	@Override
	public void UpdatePassword(int id, String password) {
		Transaction transaction=null;
		Session session=null;
		try{
			session=getSession();
			transaction=session.beginTransaction();
			String hql="update UserInfo u set u.password='"+password+"' where u.id='"+id+"'";
			Query query=session.createQuery(hql);
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
	public UserInfo getOneUserInfo(int userInfoid) {
		Transaction transaction=null;
		Session session=null;
		UserInfo userInfo = null;
		try{
			session=getSession();
			transaction=session.beginTransaction();
			String hql="from UserInfo where id='"+userInfoid+"'";
			Query query= session.createQuery(hql);
			userInfo = (UserInfo) query.uniqueResult();
			transaction.commit();
		}catch(Exception ex){
			if(transaction!=null)
				transaction.rollback();
		}finally{
			session.close();
		}
		return userInfo;
	}

	@Override
	public void alterAddress(String address,int userInfoid)
	{
		Transaction transaction=null;
		Session session=null;
		try{
			session=getSession();
			transaction=session.beginTransaction();
			String hql = "update UserInfo set address = '"+address+"' where id = '"+userInfoid+"'";
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
	public void alterWorkType(String worktype, int userInfoid) {
		Transaction transaction=null;
		Session session=null;
		try{
			session=getSession();
			transaction=session.beginTransaction();
			String hql = "update UserInfo set worktype = '"+worktype+"' where id = '"+userInfoid+"'";
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
	public void alterEducation(String education, int userInfoid) {
		Transaction transaction=null;
		Session session=null;
		try{
			session=getSession();
			transaction=session.beginTransaction();
			String hql = "update UserInfo set education = '"+education+"' where id = '"+userInfoid+"'";
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
	public void alterIntroduce(String introduce, int userInfoid) {
		Transaction transaction=null;
		Session session=null;
		try{
			session=getSession();
			transaction=session.beginTransaction();
			String hql = "update UserInfo set introduce = '"+introduce+"' where id = '"+userInfoid+"'";
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
	public List viladateUsername() {
		Transaction transaction=null;
		Session session=null;
		List list = null;
		try{
			session=getSession();
			transaction=session.beginTransaction();
			String hql = "select username from UserInfo";
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
