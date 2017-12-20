package edu.jyu.stumgm.action;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import edu.jyu.stumgm.bo.CourseBO;
import edu.jyu.stumgm.bo.UserBO;
import edu.jyu.stumgm.entity.Course;
import edu.jyu.stumgm.entity.Elective;
import edu.jyu.stumgm.entity.Student;
import edu.jyu.stumgm.entity.User;
public class CourseAction extends ActionSupport{
	
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

	private Logger logger = Logger.getLogger(CourseAction.class);
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
	 * 添加课程信息
	 * @return
	 */
	public String add(){
		if(!"update".equals(flag)){
			// 获取老师信息
			userlist = userBO.getUsersByTeacher();
			return "add";
		}
	    courseBO.addCourse(course);
		return "list";
	}
	
	/**
	 * 添加课程选修
	 * @return
	 */
	public String addElective() {
		// 获取老师信息
		userlist = userBO.getUsersByTeacher();
		// 获取所有课程信息
		courselist = courseBO.getAllCourse();
		return "addEvective";
	}
	
	/**
	 * 修改课程信息
	 * @return
	 */
	public String edit(){
		if (!"update".equals(flag)) {
			course = courseBO.getCourseById(Integer.valueOf(cid));
			userlist = userBO.getUsersByTeacher();
			logger.info(userBO.toString());
			return "edit";			
		}
		System.out.println(course.toString());
		courseBO.updateCourse(course);
		return "list";
	}
	
	/**
	 * 删除多个用户
	 * @return
	 */
	public String delete(){
		if (!"".equals(cids) && cids != null){
			String[] data = cids.split("[, ]");
			List<Integer> numbers = new ArrayList<Integer>();
			for(String s: data){
				numbers.add(Integer.valueOf(s));
			}
			courseBO.deleteCoursesByNumber(numbers);
		}
		return "list";
	}
}
