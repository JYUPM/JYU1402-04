package edu.jyu.stumgm.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;

import edu.jyu.stumgm.entity.Student;
import edu.jyu.stumgm.entity.User;

public class UserDAO extends BaseDAO<User> implements IUserDAO{

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private SessionFactory sessionFactory;
	
	public UserDAO(){
		super(User.class);
	}
	@Override
	public Boolean exist(String name, String psw)
	{
		String queryString = "from User u where u.username = "+ name + "u.password=" + psw;
		List<User> list = template.find(queryString);
		return !(list.isEmpty());
	}

	public List<User> findAll(String s1, String s2) {
		// TODO Auto-generated method stub
		return template.find("from user");
	}

	@Override
	public User getByName(String name) {
		// TODO Auto-generated method stub
		
		//System.out.println(name);
		if(name==null||name=="") return null;
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.eq("userName", name));
		
		List<User> list = (List<User>)criteria.list();

		if(list==null||list.size()==0) 
			{
				return null;
			}
		else return (User)(list.get(0));		
	}
	
	@Override
	public User getUserById(String id) {
		// TODO Auto-generated method stub
		
		//System.out.println(name);
		if(id==null||id=="") return null;
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.eq("id", id));
		
		List<User> list = (List<User>)criteria.list();

		if(list==null||list.size()==0) 
			{
				return null;
			}
		else return (User)(list.get(0));		
	}

	@Override
	public void saveOrUpdate(User user) {
		// TODO Auto-generated method stub
		template.saveOrUpdate(user);
	}

	@Override
	public void deleteByNumbers(final List<String> numbers) {
		// TODO Auto-generated method stub
		// Session session = sessionFactory.openSession();
		// session.createQuery("delete from Student g where g.stuNumber in (:n)").setParameterList("n", numbers).executeUpdate();
		Session session = sessionFactory.openSession();
		
		session.createQuery("delete from User u where u.id in (:n)").setParameterList("n", numbers).executeUpdate();
	}
	
	
	public List<User> findAll()
	{
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(User.class);
		List<User> list = (List<User>)criteria.list();
		return list;
	}
	
	
	
	public void save(User u){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(u);
		session.getTransaction().commit();
		session.close();
	}
	
	
	public void update(User user)
	{
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(user);
		session.getTransaction().commit();
		session.close();
	}
	
	
	public List<User> getUsersByTeacher() {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.eq("role", "2"));
		
		List<User> list = (List<User>)criteria.list();
		return list;
	}
}