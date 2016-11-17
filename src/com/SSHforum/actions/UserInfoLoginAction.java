package com.SSHforum.actions;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import com.SSHforum.entities.UserInfo;
import com.SSHforum.service.ContentInfoService;
import com.SSHforum.service.PagingService;
import com.SSHforum.service.PrivateLetterService;
import com.SSHforum.service.UserInfoService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserInfoLoginAction extends ActionSupport
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private UserInfo userInfo ;
	private int PerPage;
	private int PageCount;			
	private int NowPage;			//当前页
	private UserInfoService userInfoService;
	private ContentInfoService contentInfoService;
	private PagingService pagingService;
	private PrivateLetterService privateLetterService;
	public int getNowPage() {
		return NowPage;
	}
	public void setNowPage(int nowPage) {
		NowPage = nowPage;
	}
	public int getPerPage() {
		return PerPage;
	}
	public void setPerPage(int perPage) {
		PerPage = perPage;
	}
	public int getPageCount() {
		return PageCount;
	}
	public void setPageCount(int pageCount) {
		PageCount = pageCount;
	}
	public PagingService getPagingService() {
		return pagingService;
	}
	public void setPagingService(PagingService pagingService) {
		this.pagingService = pagingService;
	}
	public ContentInfoService getContentInfoService() {
		return contentInfoService;
	}
	public void setContentInfoService(ContentInfoService contentInfoService) {
		this.contentInfoService = contentInfoService;
	}
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	public UserInfoService getUserInfoService() {
		return userInfoService;
	}
	public void setUserInfoService(UserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}
	
	public PrivateLetterService getPrivateLetterService() {
		return privateLetterService;
	}
	public void setPrivateLetterService(PrivateLetterService privateLetterService) {
		this.privateLetterService = privateLetterService;
	}
	@Override
	public String execute() throws Exception {
		String errorMsg;
		List list=null;
		List list2=null;
		this.NowPage=1;
		PageCount=pagingService.GetCountInfo();
		PerPage=PageCount/10;
		if(PageCount%10!=0)
		{
			PerPage+=1;
		}
		list=contentInfoService.ShowAllContent();
		userInfo=userInfoService.LoginUser(userInfo.getUsername(), userInfo.getPassword());
		//System.out.println(userInfo);
		if(userInfo	!=null)
		{
			ActionContext actionContext=ActionContext.getContext();
			HttpServletRequest request=ServletActionContext.getRequest();
			Map session=actionContext.getSession();
			//Map session2=actionContext.getSession();
			//Map session3=actionContext.getSession();
			session.put("userInfo", userInfo);
			session.put("contentInfo", list);
			session.put("PerPage", PerPage);
			request.setAttribute("NowPage", NowPage);
			//System.out.println(userInfo.getId());
			list2=privateLetterService.getMyPrivateLetter(userInfo.getId());
			session.put("myprivateletter", list2);
			return SUCCESS;
		}
		errorMsg="账户或密码错误";
		this.addActionError(errorMsg);
		return INPUT;
		
	}
	
	

}
