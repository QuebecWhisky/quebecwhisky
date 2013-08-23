/**
 * 
 */
package com.quebecwhisky.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.quebecwhisky.dao.IBaseHibernateDAO;

/**
 * @author jpshields
 * 
 */
public abstract class AbstractHibernateDAO<T extends Serializable> implements
		IBaseHibernateDAO<T> {

	private final Class<T> _clazz;

	@PersistenceContext
	private EntityManager _entityManager;

	public AbstractHibernateDAO(final Class<T> clazzToSet) {
		_clazz = clazzToSet;
	}

	public T findOne(final Long id) {
		return (T) getEntityManager().find(_clazz, id);
	}

	public List<T> findAll() {
		CriteriaQuery<T> criteria = criteriaQuery();
		Root<T> root = criteria.from(_clazz);
		criteria.select(root);
		return getEntityManager().createQuery(criteria).getResultList();
	}

	public void save(final T entity) {
		getEntityManager().persist(entity);
	}

	public void update(final T entity) {
		getEntityManager().merge(entity);
	}

	public void delete(final T entity) {
		getEntityManager().remove(entity);
	}

	public void deleteById(final Long entityId) {
		final T entity = findOne(entityId);
		delete(entity);
	}

	protected final CriteriaBuilder criteriaBuilder() {
		return getEntityManager().getCriteriaBuilder();
	}

	protected final CriteriaQuery<T> criteriaQuery() {
		return getEntityManager().getCriteriaBuilder().createQuery(_clazz);
	}

	protected final EntityManager getEntityManager() {
		return _entityManager;
	}

}
