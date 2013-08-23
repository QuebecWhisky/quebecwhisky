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
	
	public void save(final T entity);
	
	public void update(final T entity);
	
	public void delete(final T entity);
	
	public void deleteById(final Long entityId);
	
}
