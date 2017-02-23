package org.sistema.springmvc.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.sistema.springmvc.dao.MisbehaviourDAO;
import org.sistema.springmvc.models.Misbehaviour;
import org.sistema.springmvc.models.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


public class HibernateMisbehaviourDAO implements MisbehaviourDAO {


	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * gives hibernate3 Session
	 * 
	 * @return current hibernate Session
	 */
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	

	@Transactional
	public Long insert(Misbehaviour misbehaviour) {
		Long id = (Long) getSession().save(misbehaviour);
		misbehaviour.setId(id);

		return id;
	}
	

	@Transactional(readOnly = true)
	public Misbehaviour selectById(Long id) {
		Misbehaviour misbehaviour = (Misbehaviour) getSession().get(Misbehaviour.class, id);

		return misbehaviour;
	}
	

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Misbehaviour> selectAll() {
		List<Misbehaviour> misbehaviours = null;
		misbehaviours = getSession().createQuery("from Misbehaviour").list();
		return misbehaviours;
	}
	

	@Transactional
	public void delete(Long id) {
		Misbehaviour misbehaviour = (Misbehaviour) getSession().load(Misbehaviour.class, id);
		getSession().delete(misbehaviour);
	}

	
	@Transactional
	public void update(Misbehaviour misbehaviour) {
		getSession().merge(misbehaviour);
	}

}
