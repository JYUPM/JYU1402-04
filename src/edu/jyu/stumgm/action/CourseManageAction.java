package edu.jyu.stumgm.action;

import java.util.List;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import edu.jyu.stumgm.bo.CourseBO;
import edu.jyu.stumgm.bo.UserBO;
import edu.jyu.stumgm.entity.Course;
import edu.jyu.stumgm.entity.User;


public class CourseManageAction extends ActionSupport{
	
	private List<Course> courselist;
	private List<User> userlist;
	public List<User> getUserlist() {
		return userlist;
	}


	public void setUserlist(List<User> userlist) {
		this.userlist = userlist;
	}


	private CourseBO courseBO;
	public UserBO getUserBO() {
		return userBO;
	}


	public void setUserBO(UserBO userBO) {
		this.userBO = userBO;
	}


	private UserBO userBO;
	
	public List<Course> getCourselist() {
		return courselist;
	}


	public void setCourselist(List<Course> courselist) {
		this.courselist = courselist;
	}


	public CourseBO getCourseBO() {
		return courseBO;
	}


	public void setCourseBO(CourseBO courseBO) {
		this.courseBO = courseBO;
	}


	public String execute() {
		courselist = courseBO.getAllCourse();
		userlist = userBO.getUsersByTeacher();
		return SUCCESS;
	}
}
