package com.SSHforum.actions;

import java.util.List;
import java.util.Map;

import com.SSHforum.service.PagingService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class PagingAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int NowPage;
	private int PageNumber;
	private PagingService pagingService;

	
	public int getPageNumber() {
		return PageNumber;
	}

	public void setPageNumber(int pageNumber) {
		PageNumber = pageNumber;
	}

	public int getNowPage() {
		return NowPage;
	}

	public void setNowPage(int nowPage) {
		NowPage = nowPage;
	}

	public PagingService getPagingService() {
		return pagingService;
	}

	public void setPagingService(PagingService pagingService) {
		this.pagingService = pagingService;
	}
	public String AfterPage()
	{
		int PageCount=pagingService.GetCountInfo();
		int PerPage;
		PerPage=PageCount/10;
		if(PageCount%10!=0)
		{
			PerPage+=1;
		}
		if(NowPage > PerPage)
		{
			NowPage=PerPage;
		}
		System.out.println(this.NowPage+"  "+PerPage);
		List list=pagingService.NextPage(NowPage);
		ActionContext actionContext=ActionContext.getContext();
		Map session=actionContext.getSession();
		session.put("contentInfo", list);
		return "afterpage";
	}
	public String BeforePage()
	{
		if(NowPage==0)
		{
			NowPage=1;
		}
		List list=pagingService.NextPage(NowPage);
		ActionContext actionContext=ActionContext.getContext();
		Map session=actionContext.getSession();
		session.put("contentInfo", list);
		return "beforepage";
	}
	public String JumpPage()
	{
		List list=pagingService.NextPage(PageNumber);
		ActionContext actionContext=ActionContext.getContext();
		Map session=actionContext.getSession();
		session.put("contentInfo", list);
		return "jumppage";
	}
}
