package edu.jyu.stumgm.dao;

import java.io.Serializable;
import java.util.List;

import edu.jyu.stumgm.entity.Student;
import edu.jyu.stumgm.entity.User;

public interface IUserDAO {
	
	public Boolean exist(String name, String psw);
	public User getByName(String name);
	public User getUserById(String id);
	public void saveOrUpdate(User user);
//	public void deleteByName(String name);
	
	public List<User> findAll();
	public void save(User user) ;
	public void update(User User) ;
	
	public void deleteByNumbers(List<String> numbers);
	
	public List<User> getUsersByTeacher();
}