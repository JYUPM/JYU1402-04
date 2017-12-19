package edu.jyu.stumgm.bo;

import java.util.List;

import edu.jyu.stumgm.dao.ICourseDAO;
import edu.jyu.stumgm.dao.IElectiveDAO;
import edu.jyu.stumgm.entity.Course;
import edu.jyu.stumgm.entity.Elective;
import edu.jyu.stumgm.entity.User;



public class ElectiveBO {
	
	public IElectiveDAO getElectiveDAO() {
		return electiveDAO;
	}

	public void setElectiveDAO(IElectiveDAO electiveDAO) {
		this.electiveDAO = electiveDAO;
	}

	private IElectiveDAO electiveDAO;
	
	

	public void electiveCourse(Elective elective) {
		electiveDAO.save(elective);
	}
	
	public List<Elective> getElectiveByStuNum(String sid) {
		return electiveDAO.getElectiveByStuNum(sid);
	}
	
	public void deleteElectiveBOsByNumber(List<Integer> numbers){
		
		electiveDAO.deleteByNumbers(numbers);
	}
	
	
	public void update(Elective elective) {
		electiveDAO.update(elective);
	}
	
	public List<Elective> findAll() {
		return electiveDAO.findAll();
	}
	
}
