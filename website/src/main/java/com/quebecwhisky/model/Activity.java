/**
 * 
 */
package com.quebecwhisky.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 * @author jpshields
 * 
 */
@Entity
public class Activity extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	private String _title;
	private Date _date;
	private ActivityCategoryEnum _category;
	private String _registrationUrl;
	private String _description;

	@NotNull
	@Column
	public String getTitle() {
		return this._title;
	}

	public void setTitle(String title) {
		this._title = title;
	}

	@Column
	@Temporal(TemporalType.TIMESTAMP)
	public Date getDate() {
		return this._date;
	}

	public void setDate(Date date) {
		this._date = date;
	}

	@Column
	@Enumerated(EnumType.STRING)
	public ActivityCategoryEnum getCategory() {
		return this._category;
	}

	public void setCategory(ActivityCategoryEnum category) {
		this._category = category;
	}

	@Column
	public String getRegistrationUrl() {
		return this._registrationUrl;
	}

	public void setRegistrationUrl(String url) {
		this._registrationUrl = url;
	}

	@NotNull
	@Column
	public String getDescription() {
		return this._description;
	}

	public void setDescription(String description) {
		this._description = description;
	}

}
