package com.SSHforum.actions;

import java.util.List;
import java.util.Map;

import com.SSHforum.entities.CommentInfo;
import com.SSHforum.entities.ContentInfo;
import com.SSHforum.service.CommentInfoService;
import com.SSHforum.service.ContentInfoService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class getDetailContentInfoAction extends ActionSupport 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ContentInfo contentInfo;
	private ContentInfoService contentInfoService;
	private CommentInfoService commentInfoService;
	private int contentid;
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
	
	public CommentInfoService getCommentInfoService() {
		return commentInfoService;
	}
	public void setCommentInfoService(CommentInfoService commentInfoService) {
		this.commentInfoService = commentInfoService;
	}
	public int getContentid() {
		return contentid;
	}
	public void setContentid(int contentid) {
		this.contentid = contentid;
	}
	@Override
	public String execute() throws Exception {
		
		contentInfo=contentInfoService.getDetailContentInfo(contentid);
		ActionContext actionContext=ActionContext.getContext();
		Map session = actionContext.getSession();
		session.put("NowContentInfo", contentInfo);
		List<CommentInfo> list = commentInfoService.GetAllCommentInfo(contentInfo.getId());
		session.put("ThisComment", list);
		for(Object list1:list)
		{
			System.out.println(list1);
		}
		return SUCCESS;
	}
	
	

}
