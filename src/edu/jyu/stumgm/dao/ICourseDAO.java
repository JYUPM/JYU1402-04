package edu.jyu.stumgm.dao;

import java.util.List;

import edu.jyu.stumgm.entity.Course;
import edu.jyu.stumgm.entity.Elective;


public interface ICourseDAO {
	public void save(Course course) ;
	
	public List<Course> getAllCourse() ;
	
	public Course getCourseById(int cid);
	
	public void update(Course course);
	
	public void deleteByNumbers(List<Integer> numbers);
	
	
	public void saveElective(Elective elective);
}
