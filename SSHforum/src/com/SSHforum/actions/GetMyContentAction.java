package com.SSHforum.actions;

import java.util.List;
import java.util.Map;

import com.SSHforum.entities.ContentInfo;
import com.SSHforum.entities.UserInfo;
import com.SSHforum.service.ContentInfoService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class GetMyContentAction extends ActionSupport 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ContentInfo contentInfo;
	private ContentInfoService contentInfoService;
	public ContentInfo getContentInfo() {
		return contentInfo;
	}
	public void setContentInfo(ContentInfo contentInfo) {
		this.contentInfo = contentInfo;
	}
	public ContentInfoService getContentInfoService() {
		return contentInfoService;
	}
	public void setContentInfoService(ContentInfoService contentInfoService) {
		this.contentInfoService = contentInfoService;
	}
	@Override
	public String execute() throws Exception {
		ActionContext actionContext = ActionContext.getContext();
		UserInfo userInfo=(UserInfo) actionContext.getSession().get("userInfo");
		//System.out.println(userInfo);
		List list = null;
		list = contentInfoService.getMyContentInfo(userInfo.getId());
		Map session = actionContext.getSession();
		session.put("mycontentinfo", list);
		return "getmycontent";
	}
	
}
