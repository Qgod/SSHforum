package com.SSHforum.actions;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import javax.xml.ws.Response;

import org.apache.struts2.ServletActionContext;

import com.SSHforum.entities.UserInfo;
import com.SSHforum.service.UserInfoService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class validateAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserInfoService userInfoService;
	private String username;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public UserInfoService getUserInfoService() {
		return userInfoService;
	}
	public void setUserInfoService(UserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}
	@Override
	public String execute() throws Exception {
		List list=userInfoService.viladateUsername();
		
		String result = null;
		
		if(list.contains(username))
		{
			result = "<font color = 'red'>用户名已被占用</font>";
		}else
		{
			result = "<font color = 'white'>该用户名可用</font>";
		}
		HttpServletResponse re=ServletActionContext.getResponse();
		re.setCharacterEncoding("UTF-8");
		PrintWriter pw=re.getWriter();
		pw.print(result);
		pw.flush();
		pw.close();
		return null;
	}

}
