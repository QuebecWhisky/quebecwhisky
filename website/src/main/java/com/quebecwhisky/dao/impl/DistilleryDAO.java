/**
 * 
 */
package com.quebecwhisky.dao.impl;

import javax.inject.Named;

import com.quebecwhisky.dao.IDistilleryDAO;
import com.quebecwhisky.model.Distillery;

/**
 * @author jpshields
 * 
 */
@Named
public class DistilleryDAO extends AbstractHibernateDAO<Distillery> implements
		IDistilleryDAO {

	public DistilleryDAO() {
		super(Distillery.class);
	}

}
