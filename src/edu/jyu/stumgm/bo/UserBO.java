package edu.jyu.stumgm.bo;

import java.util.List;

import edu.jyu.stumgm.dao.IUserDAO;
import edu.jyu.stumgm.entity.Student;
import edu.jyu.stumgm.entity.User;
import edu.jyu.stumgm.util.*;;

public class UserBO {
	public IUserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}

	private IUserDAO userDAO;

	/**
	 * 登录
	 * @param userName
	 * @param password
	 * @return
	 */
	public User login(String userName, String password) {
		// TODO Auto-generated method stub
		String decodeUserName = new String(base64Util.decode(userName));
		String decodePassword = new String(base64Util.decode(password));
		
		User u=userDAO.getByName(decodeUserName);
		
		if(u!=null&&u.getPassword().equals(decodePassword)) return u;
		else return null;
	}
	
	/**
	 * 获取所有用户信息列表
	 * @return
	 */
	public List<User> getAllUser() {
		return userDAO.findAll();
	}
	
	
	
	public void addUser(User user) {
		userDAO.save(user);
	}
	
	public User getUserById(String uid){
		User user = userDAO.getUserById(uid);
		return user;
	}

	

	/**
	 * 修改已建立的记录
	 * 
	 * @param student
	 *            
	 */
	public void updateUser(User user) {
		userDAO.update(user);
	}
	
	/**
	 * 删除记录
	 * @param numbers
	 */
	public void deleteUsersByNumber(List<String> numbers){
		
		userDAO.deleteByNumbers(numbers);
	}
	
	public List<User> getUsersByTeacher() {
		
		return userDAO.getUsersByTeacher();
	}
	
}
