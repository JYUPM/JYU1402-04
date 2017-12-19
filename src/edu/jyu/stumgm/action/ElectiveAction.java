package edu.jyu.stumgm.action;
import java.util.ArrayList;
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
public class ElectiveAction extends ActionSupport{
	
	private String flag;
	private UserBO userBO;
	private CourseBO courseBO;
	private Course course;
	private List<User> userlist;
	private List<Course> courselist;
	public List<Course> getCourselist() {
		return courselist;
	}

	public void setCourselist(List<Course> courselist) {
		this.courselist = courselist;
	}

	private String cid;
	private String cids;
	private String decids;
	private Elective elective;
	private String eids; 
	
	private ElectiveBO electiveBO;
	
	public ElectiveBO getElectiveBO() {
		return electiveBO;
	}

	public void setElectiveBO(ElectiveBO electiveBO) {
		this.electiveBO = electiveBO;
	}

	public String getEids() {
		return eids;
	}

	public void setEids(String eids) {
		this.eids = eids;
	}

	public Elective getElective() {
		return elective;
	}

	public void setElective(Elective elective) {
		this.elective = elective;
	}

	public String getDecids() {
		return decids;
	}

	public void setDecids(String decids) {
		this.decids = decids;
	}

	public String getCids() {
		return cids;
	}

	public void setCids(String cids) {
		this.cids = cids;
	}

	private Logger logger = Logger.getLogger(ElectiveAction.class);
	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public CourseBO getCourseBO() {
		return courseBO;
	}

	public void setCourseBO(CourseBO courseBO) {
		this.courseBO = courseBO;
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

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	
	/**
	 * 添加课程选修
	 * @return
	 */
	public String add() {
		// 获取老师信息
		userlist = userBO.getUsersByTeacher();
		// 获取所有课程信息
		courselist = courseBO.getAllCourse();
		return "add";
	}
	
	
	
	/**
	 * 退选一门或多门课程
	 * @return
	 */
	public String delete(){
		if (!"".equals(eids) && eids != null){
			String[] data = eids.split("[, ]");
			List<Integer> numbers = new ArrayList<Integer>();
			for(String s: data){
				numbers.add(Integer.valueOf(s));
			}
			electiveBO.deleteElectiveBOsByNumber(numbers);
		}
		return "list";
	}
	
	/**
	 * 确定选修一门或多门选修课
	 * @return
	 */
	public String define(){
		if (!"".equals(decids) && decids != null){
			Map sessionMap=(Map)ActionContext.getContext().getSession();
			if(sessionMap.get("students") != null){
				Student stu = (Student) sessionMap.get("students");
				//获取学号
				String stuNum = stu.getStuNumber();
				String[] data = decids.split("[, ]");
				for (int i= 0; i < data.length; i++) {
				     String courseId = data[i];
				     float grade = (float) 0.0;
				     int close = 0;
				     elective = new Elective(courseId, stuNum, grade, close);
				     electiveBO.electiveCourse(elective);
				 }
			}else{
				//没有登录
				return "login";
			}
		}else{
			return "login";
		}
		return "list";
	}
}
