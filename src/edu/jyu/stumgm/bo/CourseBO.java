package edu.jyu.stumgm.bo;

import java.util.List;

import edu.jyu.stumgm.dao.ICourseDAO;
import edu.jyu.stumgm.entity.Course;
import edu.jyu.stumgm.entity.Elective;
import edu.jyu.stumgm.entity.User;



public class CourseBO {
	
	private ICourseDAO courseDAO;
	
	public ICourseDAO getCourseDAO() {
		return courseDAO;
	}

	public void setCourseDAO(ICourseDAO courseDAO) {
		this.courseDAO = courseDAO;
	}

	/**
	 * 添加一个课程
	 * @param course
	 */
	public void addCourse(Course course) {
		courseDAO.save(course);
	}
	
	
	/***
	 * 课程列表
	 * @return
	 */
	public List<Course> getAllCourse() {
		return courseDAO.getAllCourse();
	}
	
	public Course getCourseById(int cid) {
		return courseDAO.getCourseById(cid);
	}
	
	public void updateCourse(Course course) {
		courseDAO.update(course);
	}
	
	public void deleteCoursesByNumber(List<Integer> numbers){
		
		courseDAO.deleteByNumbers(numbers);
	}
	
}
