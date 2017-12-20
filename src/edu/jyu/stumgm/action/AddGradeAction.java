package edu.jyu.stumgm.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.poi.ss.formula.functions.T;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

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


public class AddGradeAction extends ActionSupport{
	
	private GradeBO gradeBO;
	private StudentBO studentBO;
	private String flag;
	private String stuid;
	private Grade grade;
	private Student student;
	private List<Grade> gradelist;

	private List<User> userlist;
	private List<Elective> electivelist;
	private List<Course> courselist;
	private List<Student> studentlist;
	private List<List<Elective>> electiveMap;
	public List<List<Elective>> getElectiveMap() {
		return electiveMap;
	}

	public void setElectiveMap(List<List<Elective>> electiveMap) {
		this.electiveMap = electiveMap;
	}

	public List<Student> getStudentlist() {
		return studentlist;
	}

	public void setStudentlist(List<Student> studentlist) {
		this.studentlist = studentlist;
	}

	private UserBO userBO;
	private ElectiveBO electiveBO;
	private CourseBO courseBO;
	

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
	
	public String execute()
	{
		if("".equals(flag)||"list".equals(flag))
		{
			// List<Grade> gradelist = gradeBO.getAllGrade();
			// 获取所有的学生成绩
			//获取所有学生
			studentlist = studentBO.getAllStudents();
			System.out.println(studentlist);
			//获取所有课程信息
			courselist = courseBO.getAllCourse();
			int i = 0;
			for (Student s: studentlist) { 
				//获取各科成绩
				electivelist = electiveBO.getElectiveByStuNum(s.getStuNumber());
				electiveMap.add(electivelist);
				i++;
	        }
			return "list";
		}
		if("update".equals(flag))
		{
//			student=studentBO.getStudentByNumber(stuid);
//			grade.setStudent(student);
//			gradeBO.updateGrade(grade);
			for (Elective e : electivelist) {  
				e.setClose(1);
	            electiveBO.update(e);
	        }
			return "list";
		}
		// 获取该学生所选修的课程
		student = studentBO.getStudentByNumber(stuid);
		//获取个人选课信息
		electivelist = electiveBO.getElectiveByStuNum(stuid);
		//获取所有课程信息
		courselist = courseBO.getAllCourse();
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("student", student);
		return "add";
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getStuid() {
		return stuid;
	}

	public void setStuid(String stuid) {
		this.stuid = stuid;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public List<Grade> getGradelist() {
		return gradelist;
	}

	public void setGradelist(List<Grade> gradelist) {
		this.gradelist = gradelist;
	}

	public StudentBO getStudentBO() {
		return studentBO;
	}

	public void setStudentBO(StudentBO studentBO) {
		this.studentBO = studentBO;
	}


}