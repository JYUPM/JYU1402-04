package edu.jyu.stumgm.action;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import edu.jyu.stumgm.Common;
import edu.jyu.stumgm.bo.StudentBO;
import edu.jyu.stumgm.bo.UserBO;
import edu.jyu.stumgm.entity.Student;
import edu.jyu.stumgm.entity.User;

public class LoginAction extends ActionSupport {
	private static final long serialVersionUID = -8515183406496049654L;
	private Logger logger = Logger.getLogger(LoginAction.class);
	
	private String userName = "";
	private String password = "";
	private boolean loginError = false;
	private UserBO userBO;
	private StudentBO studentBO;
	
	public StudentBO getStudentBO() {
		return studentBO;
	}

	public void setStudentBO(StudentBO studentBO) {
		this.studentBO = studentBO;
	}

	public UserBO getUserBO() {
		return userBO;
	}

	public void setUserBO(UserBO userBO) {
		this.userBO = userBO;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean isLoginError(){
		return loginError;
	}

	@SuppressWarnings("null")
	public String execute(){
		logger.info("login");
		User user = null;
		Student student = null;
		if(ActionContext.getContext().getSession().get("user") != null){
			return SUCCESS;
		}
		logger.info(userName+","+password);
		if ("".equals(userName) || "".equals(password)) {
			return SUCCESS;
		}
		if(userName.length() == 16) {
			Student stu = studentBO.login(userName, password);
			if(stu != null) {
				student = stu;
			}
		}else{
			user = userBO.login(userName, password);
		}
		
		logger.info("login: "+user);
		if(user != null){
			ActionContext.getContext().getSession().put("user", user);
			if (user.getRole().equals(Common.ADMIN_ROLE)){
				ActionContext.getContext().getSession().put("isAdmin", true);
			}else if(user.getRole().equals(Common.TEACHER_ROLE)){
				ActionContext.getContext().getSession().put("isTeacher", true);
			}
			return SUCCESS;
		}else if(student != null) {
			ActionContext.getContext().getSession().put("students", student);
			if(String.valueOf(student.getRole()).equals(Common.STUDENT_ROLE)){
				ActionContext.getContext().getSession().put("isStudent", true);
			}
			return SUCCESS;
		}
		
		loginError = true;
		return SUCCESS;
	}

}