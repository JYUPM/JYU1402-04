package edu.jyu.stumgm.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import edu.jyu.stumgm.bo.CourseBO;
import edu.jyu.stumgm.bo.ElectiveBO;
import edu.jyu.stumgm.bo.GradeBO;
import edu.jyu.stumgm.bo.StudentBO;
import edu.jyu.stumgm.bo.UserBO;
import edu.jyu.stumgm.entity.Course;
import edu.jyu.stumgm.entity.Elective;
import edu.jyu.stumgm.entity.Grade;
import edu.jyu.stumgm.entity.Student;
import edu.jyu.stumgm.entity.User;


public class GradeAdminAction extends ActionSupport {

	private GradeBO gradeBO;
	private List<Grade> gradelist;
	private List<User> userlist;
	private List<Elective> electivelist;
	private List<Course> courselist;
	public List<User> getUserlist() {
		return userlist;
	}

	public void setUserlist(List<User> userlist) {
		this.userlist = userlist;
	}

	public List<Elective> getElectivelist() {
		return electivelist;
	}

	public void setElectivelist(List<Elective> electivelist) {
		this.electivelist = electivelist;
	}

	public List<Course> getCourselist() {
		return courselist;
	}

	public void setCourselist(List<Course> courselist) {
		this.courselist = courselist;
	}

	public List<Student> getStudentlist() {
		return studentlist;
	}

	public void setStudentlist(List<Student> studentlist) {
		this.studentlist = studentlist;
	}


	private List<Student> studentlist;
	private Map<String, List<Elective>> electiveMap = new HashMap<String, List<Elective>>(); 
	
	
	public Map<String, List<Elective>> getElectiveMap() {
		return electiveMap;
	}

	public void setElectiveMap(Map<String, List<Elective>> electiveMap) {
		this.electiveMap = electiveMap;
	}


	private UserBO userBO;
	private ElectiveBO electiveBO;
	private CourseBO courseBO;
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

	public ElectiveBO getElectiveBO() {
		return electiveBO;
	}

	public void setElectiveBO(ElectiveBO electiveBO) {
		this.electiveBO = electiveBO;
	}

	public CourseBO getCourseBO() {
		return courseBO;
	}

	public void setCourseBO(CourseBO courseBO) {
		this.courseBO = courseBO;
	}

	public GradeBO getGradeBO() {
		return gradeBO;
	}

	public void setGradeBO(GradeBO gradeBO) {
		this.gradeBO = gradeBO;
	}

	public List<Grade> getGradelist() {
		return gradelist;
	}

	public void setGradelist(List<Grade> gradelist) {
		this.gradelist = gradelist;
	}
	
	public String execute()
	{
//		gradelist = gradeBO.getAllGrade();
		studentlist = studentBO.getAllStudents();
		//获取所有课程信息
		courselist = courseBO.getAllCourse();
		int i = 0;
		for (Student s: studentlist) { 
			//获取各科成绩
			electivelist = electiveBO.getElectiveByStuNum(s.getStuNumber());
			electiveMap.put(String.valueOf(i), electivelist);
			i++;
        }
		return SUCCESS;
	}
}