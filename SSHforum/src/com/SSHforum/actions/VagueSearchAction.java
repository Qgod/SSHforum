package com.SSHforum.actions;

import java.util.List;
import java.util.Map;

import com.SSHforum.service.VagueSearchService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class VagueSearchAction extends ActionSupport
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String searchContent;
	private VagueSearchService vagueSearchService;
	public String getSearchContent() {
		return searchContent;
	}
	public void setSearchContent(String searchContent) {
		this.searchContent = searchContent;
	}
	public VagueSearchService getVagueSearchService() {
		return vagueSearchService;
	}
	public void setVagueSearchService(VagueSearchService vagueSearchService) {
		this.vagueSearchService = vagueSearchService;
	}
	@Override
	public String execute() throws Exception {
		//System.out.println(searchContent);
		List ContentList = vagueSearchService.searchContentInfo(searchContent);
		List UserList=vagueSearchService.searchUserInfo(searchContent);
		ActionContext actionContext = ActionContext.getContext();
		Map session = actionContext.getSession();
		session.put("ContentList", ContentList);
		session.put("UserList", UserList);
		return "vagueSearch";
	}
	

}
