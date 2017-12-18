package edu.jyu.stumgm.action;

import java.util.List;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import edu.jyu.stumgm.bo.UserBO;
import edu.jyu.stumgm.entity.User;


public class UserManageAction extends ActionSupport{
	
	private List<User> userlist;
	private UserBO userBO;
	
	public List<User> getUserlist() {
		return userlist;
	}
	public void setUserlist(List<User> userlist) {
		this.userlist = userlist;
	}
	public UserBO getUserBO() {
		return userBO;
	}
	public void setUserBO(UserBO userBO) {
		this.userBO = userBO;
	}
	
	public String execute() {
		userlist = userBO.getAllUser();
		return SUCCESS;
	}
}
