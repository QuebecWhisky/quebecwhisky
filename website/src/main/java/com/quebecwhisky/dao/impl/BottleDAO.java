/**
 * 
 */
package com.quebecwhisky.dao.impl;

import javax.inject.Named;

import com.quebecwhisky.dao.IBottleDAO;
import com.quebecwhisky.model.Bottle;

/**
 * @author jpshields
 * 
 */
@Named
public class BottleDAO extends AbstractHibernateDAO<Bottle> implements
		IBottleDAO {

	public BottleDAO() {
		super(Bottle.class);
	}

}
