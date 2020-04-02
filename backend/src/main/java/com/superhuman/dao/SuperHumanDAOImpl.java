package com.superhuman.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.superhuman.entity.SuperHuman;

@Component
public class SuperHumanDAOImpl implements SuperHumanDAO {

	private SessionFactory sessionFactory;

	@Autowired
	public void setSf(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void setSuperHuman(SuperHuman superHuman) {
		Session sess = sessionFactory.openSession();
		Transaction tx = sess.beginTransaction();
		sess.save(superHuman);
		tx.commit();

	}

	@Override
	public void updateSuperHuman(int id, SuperHuman superHuman) {
		Session sess = sessionFactory.openSession();
		Transaction tx = sess.beginTransaction();
		SuperHuman oldSuperHuman = sess.byId(SuperHuman.class).load(id);
		oldSuperHuman.setAlias(superHuman.getAlias());
		oldSuperHuman.setAlignment(superHuman.getAlignment());
		oldSuperHuman.setHometown(superHuman.getHometown());
		oldSuperHuman.setName(superHuman.getName());
		oldSuperHuman.setPowers(superHuman.getPowers());
		oldSuperHuman.setTeam(superHuman.getTeam());
		sess.flush();
		tx.commit();
	}

	@Override
	public void deleteSuperHuman(int id) {
		Session sess = sessionFactory.openSession();
		Transaction tx = sess.beginTransaction();
		SuperHuman superHuman = sess.byId(SuperHuman.class).load(id);
		sess.delete(superHuman);
		tx.commit();
	}

	@Override
	public SuperHuman getSuperHuman(String superHumanName) {
		Session sess = sessionFactory.openSession();
		Query<SuperHuman> query = sess.createQuery("from SuperHuman s where s.name=:name", SuperHuman.class);
		query.setParameter("name", superHumanName);
		SuperHuman superHuman = query.uniqueResult();
		return superHuman;
	}

	@Override
	public List<SuperHuman> getAllSuperHumans() {
		Session sess = sessionFactory.openSession();
		CriteriaBuilder cb = sess.getCriteriaBuilder();
		CriteriaQuery<SuperHuman> cq = cb.createQuery(SuperHuman.class);
		Root<SuperHuman> rootEntry = cq.from(SuperHuman.class);
		CriteriaQuery<SuperHuman> all = cq.select(rootEntry);

		TypedQuery<SuperHuman> allQuery = sess.createQuery(all);

		return allQuery.getResultList();
	}

}
