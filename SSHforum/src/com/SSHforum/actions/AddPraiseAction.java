package com.SSHforum.actions;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.SSHforum.service.CommentInfoService;
import com.opensymphony.xwork2.ActionSupport;

public class AddPraiseAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int commentid;
	private CommentInfoService commentInfoService;
	public int getCommentid() {
		return commentid;
	}
	public void setCommentid(int commentid) {
		this.commentid = commentid;
	}
	public CommentInfoService getCommentInfoService() {
		return commentInfoService;
	}
	public void setCommentInfoService(CommentInfoService commentInfoService) {
		this.commentInfoService = commentInfoService;
	}
	public String AddPraise() throws IOException
	{
		commentInfoService.AddPraise(commentid);
		int result = commentInfoService.GetPraiseNumber(commentid);
		
		HttpServletResponse re=ServletActionContext.getResponse();
		re.setCharacterEncoding("UTF-8");
		PrintWriter pw=re.getWriter();
		pw.print(result);
		pw.flush();
		pw.close();
		
		
		return null;
	}

}
