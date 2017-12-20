package edu.jyu.stumgm.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import edu.jyu.stumgm.entity.Course;
import edu.jyu.stumgm.entity.Elective;
import edu.jyu.stumgm.entity.User;


public class CourseDAO extends BaseDAO<Course> implements ICourseDAO{
	public CourseDAO(){
		super(Course.class);
	}
	
	/**
	 * 保存记录
	 */
	
	public void save(Course c){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(c);
		session.getTransaction().commit();
		session.close();
	}
	
	
	public void saveElective(Elective elective) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(elective);
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
	
	public List<Course> getAllCourse() {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Course.class);
		List<Course> list = (List<Course>)criteria.list();
		return list;
	}
	
	public Course getCourseById(int cid) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Course.class);
		criteria.add(Restrictions.eq("id", cid));
		
		List<Course> list = (List<Course>)criteria.list();

		if(list==null||list.size()==0) 
			{
				return null;
			}
		else return (Course)(list.get(0));	
	}
	
	public void update(Course course) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(course);
		session.getTransaction().commit();
		session.close();
	}
	
	@Override
	public void deleteByNumbers(final List<Integer> numbers) {
		// TODO Auto-generated method stub
		// Session session = sessionFactory.openSession();
		// session.createQuery("delete from Student g where g.stuNumber in (:n)").setParameterList("n", numbers).executeUpdate();
		Session session = sessionFactory.openSession();
		
		session.createQuery("delete from Course c where c.id in (:n)").setParameterList("n", numbers).executeUpdate();
	}
	
}
