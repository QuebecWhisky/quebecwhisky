/**
 * 
 */
package com.quebecwhisky.model;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * @author jpshields
 * 
 */
@MappedSuperclass
public abstract class AbstractEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long _id;

	@Id
	@GeneratedValue
	public Long getId() {
		return this._id;
	}

	public void setId(Long id) {
		this._id = id;
	}

}
