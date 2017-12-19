package edu.jyu.stumgm.action;

import java.util.List;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import edu.jyu.stumgm.bo.CourseBO;
import edu.jyu.stumgm.bo.ElectiveBO;
import edu.jyu.stumgm.bo.UserBO;
import edu.jyu.stumgm.entity.Course;
import edu.jyu.stumgm.entity.Elective;
import edu.jyu.stumgm.entity.User;


public class ElectiveManagentAction extends ActionSupport{
	
	private List<Course> courselist;
	private List<User> userlist;
	private List<Elective> electiveList;
	
	public List<Elective> getElectiveList() {
		return electiveList;
	}


	public void setElectiveList(List<Elective> electiveList) {
		this.electiveList = electiveList;
	}


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

	
	public ElectiveBO getElectiveBO() {
		return electiveBO;
	}


	public void setElectiveBO(ElectiveBO electiveBO) {
		this.electiveBO = electiveBO;
	}


	private ElectiveBO electiveBO;

	public String execute() {
		courselist = courseBO.getAllCourse();
		userlist = userBO.getUsersByTeacher();
		electiveList = electiveBO.findAll();
		return SUCCESS;
	}
}
