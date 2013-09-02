/**
 * 
 */
package com.quebecwhisky.dao;

import java.io.Serializable;
import java.util.List;

/**
 * @author jpshields
 *
 */
public interface IBaseHibernateDAO<T extends Serializable> {
	
	public T findOne(final Long id);
	
	public List<T> findAll();
	
	public void persist(final T entity);
	
	public void merge(final T entity);
	
	public void remove(final T entity);
	
	public void removeById(final Long entityId);
	
}
