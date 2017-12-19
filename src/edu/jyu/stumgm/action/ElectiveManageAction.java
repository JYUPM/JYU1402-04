package edu.jyu.stumgm.action;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import edu.jyu.stumgm.bo.CourseBO;
import edu.jyu.stumgm.bo.ElectiveBO;
import edu.jyu.stumgm.bo.UserBO;
import edu.jyu.stumgm.entity.Course;
import edu.jyu.stumgm.entity.Elective;
import edu.jyu.stumgm.entity.Student;
import edu.jyu.stumgm.entity.User;


public class ElectiveManageAction extends ActionSupport{
	
	private List<User> userlist;
	private List<Elective> electivelist;
	private List<Course> courselist;
	public List<Course> getCourselist() {
		return courselist;
	}
	public void setCourselist(List<Course> courselist) {
		this.courselist = courselist;
	}

	private UserBO userBO;
	private ElectiveBO electiveBO;
	private CourseBO courseBO;
	public CourseBO getCourseBO() {
		return courseBO;
	}
	public void setCourseBO(CourseBO courseBO) {
		this.courseBO = courseBO;
	}
	public List<Elective> getElectivelist() {
		return electivelist;
	}
	public void setElectivelist(List<Elective> electivelist) {
		this.electivelist = electivelist;
	}
	
	public ElectiveBO getElectiveBO() {
		return electiveBO;
	}
	public void setElectiveBO(ElectiveBO electiveBO) {
		this.electiveBO = electiveBO;
	}
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
		Map sessionMap=(Map)ActionContext.getContext().getSession();
		if(sessionMap.get("students") != null){
			Student stu = (Student) sessionMap.get("students");
			//获取学号
			String stuNum = stu.getStuNumber();
			// 获取选课和老师
			userlist = userBO.getUsersByTeacher();
			//获取个人选课信息
			electivelist = electiveBO.getElectiveByStuNum(stuNum);
			//获取所有课程信息
			courselist = courseBO.getAllCourse();
		}else{
			//没有登录
			return "login";
		}
		
		return SUCCESS;
	}
}
