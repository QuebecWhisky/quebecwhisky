/**
 * 
 */
package com.quebecwhisky.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author jpshields
 * 
 */
@Entity
public class News extends AbstractEntity {

	private static final long serialVersionUID = 1L;
	
	private String _title;
	private String _description;
	private String _author;
	private Date _created;

	@Column
	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	@Column
	public String getDescription() {
		return this._description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	@Column
	public String getAuthor() {
		return _author;
	}

	public void setAuthor(String author) {
		this._author = author;
	}

	@Column
	@Temporal(TemporalType.TIMESTAMP)
	public Date getCreated() {
		return _created;
	}

	public void setCreated(Date created) {
		this._created = created;
	}

}
