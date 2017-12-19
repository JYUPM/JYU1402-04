package edu.jyu.stumgm.dao;

import java.util.List;

import edu.jyu.stumgm.entity.Course;
import edu.jyu.stumgm.entity.Elective;


public interface IElectiveDAO {
	public void save(Elective elective);
	
	public List<Elective> getElectiveByStuNum(String sid);
	
	public void deleteByNumbers(List<Integer> numbers);
	
	public void update(Elective elective);
	
	public List<Elective> findAll();
}
