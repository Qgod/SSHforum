package com.SSHforum.actions;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.SSHforum.entities.UserInfo;
import com.SSHforum.service.UserInfoService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AlterUseInfoAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserInfoService userInfoService;
	private UserInfo userInfo;
	private String address;
	private String worktype;
	private String education;
	private String introduce;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getWorktype() {
		return worktype;
	}
	public void setWorktype(String worktype) {
		this.worktype = worktype;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public String alterAddress() throws IOException
	{
		String result=address;
		ActionContext actionContext = ActionContext.getContext();
		userInfo = (UserInfo) actionContext.getSession().get("userInfo");
		userInfoService.alterAddress(address, userInfo.getId());
		HttpServletResponse re=ServletActionContext.getResponse();
		re.setCharacterEncoding("UTF-8");
		PrintWriter pw=re.getWriter();
		pw.print(result);
		pw.flush();
		pw.close();
		return null;
	}
	public String alterWorkType() throws IOException
	{
		String result = worktype;
		ActionContext actionContext = ActionContext.getContext();
		userInfo = (UserInfo) actionContext.getSession().get("userInfo");
		userInfoService.alterWorkType(worktype, userInfo.getId());
		HttpServletResponse re=ServletActionContext.getResponse();
		re.setCharacterEncoding("UTF-8");
		PrintWriter pw=re.getWriter();
		pw.print(result);
		pw.flush();
		pw.close();
		return null;
	}
	public String alterEducation() throws IOException
	{
		String result = education;
		
		ActionContext actionContext = ActionContext.getContext();
		userInfo = (UserInfo) actionContext.getSession().get("userInfo");
		userInfoService.alterEducation(education, userInfo.getId());
		HttpServletResponse re=ServletActionContext.getResponse();
		re.setCharacterEncoding("UTF-8");
		PrintWriter pw=re.getWriter();
		pw.print(result);
		pw.flush();
		pw.close();
		return null;
	}
	public String alterIntroduce() throws IOException
	{
		String result = introduce;
		ActionContext actionContext = ActionContext.getContext();
		userInfo = (UserInfo) actionContext.getSession().get("userInfo");
		userInfoService.alterIntroduce(introduce, userInfo.getId());
		HttpServletResponse re=ServletActionContext.getResponse();
		re.setCharacterEncoding("UTF-8");
		PrintWriter pw=re.getWriter();
		pw.print(result);
		pw.flush();
		pw.close();
		return null;
	}
	

}
