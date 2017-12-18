package edu.jyu.stumgm.action;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionSupport;

import edu.jyu.stumgm.bo.UserBO;
import edu.jyu.stumgm.entity.User;
public class UserAction extends ActionSupport{
	
	private String flag;
	private User user;
	private UserBO userBO;
	private String uid;
	private String uids = "";
	public String getUids() {
		return uids;
	}
	public void setUids(String uids) {
		this.uids = uids;
	}

	private Logger logger = Logger.getLogger(UserAction.class);
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	/**
	 * 添加用户信息
	 * @return
	 */
	public String add(){
		if(!"update".equals(flag)){
			return "add";
		}
		userBO.addUser(user);
		return "list";
	}
	
	/**
	 * 修改用户信息
	 * @return
	 */
	public String edit(){
		if (!"update".equals(flag)) {
			user = userBO.getUserById(uid);
			logger.info(userBO.toString());
			return "edit";			
		}
		userBO.updateUser(user);
		return "list";
	}
	
	/**
	 * 删除多个用户
	 * @return
	 */
	public String delete(){
		if (!"".equals(uids) && uids != null){
			String[] data = uids.split("[, ]");
			List<String> numbers = new ArrayList<String>();
			for(String s: data){
				numbers.add(s);
			}
			userBO.deleteUsersByNumber(numbers);
		}
		return "list";
	}
	
}
