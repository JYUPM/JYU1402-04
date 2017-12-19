package edu.jyu.stumgm.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import edu.jyu.stumgm.entity.Course;
import edu.jyu.stumgm.entity.Elective;
import edu.jyu.stumgm.entity.Student;
import edu.jyu.stumgm.entity.User;


public class ElectiveDAO extends BaseDAO<Elective> implements IElectiveDAO{
	public ElectiveDAO(){
		super(Elective.class);
	}
	
	/**
	 * 保存记录
	 */
	
	public void save(Elective e){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(e);
		session.getTransaction().commit();
		session.close();
	}
	
	
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public List<Elective> getElectiveByStuNum(String sid) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Elective.class);
		criteria.add(Restrictions.eq("studentId", sid));
		
		List<Elective> list = (List<Elective>)criteria.list();

		if(list==null||list.size()==0) 
			{
				return null;
			}
		else return list;	
	}
	
	public void deleteByNumbers(List<Integer> numbers) {
		Session session = sessionFactory.openSession();
		session.createQuery("delete from Elective e where e.id in (:n)").setParameterList("n", numbers).executeUpdate();
	}
	
	public void update(Elective elective)
	{
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(elective);
		session.getTransaction().commit();
		session.close();
	}
	
	public List<Elective> findAll() {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Elective.class);
		List<Elective> list = (List<Elective>)criteria.list();
		return list;
	}
}
