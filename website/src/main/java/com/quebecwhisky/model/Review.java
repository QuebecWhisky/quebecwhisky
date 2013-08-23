/**
 * 
 */
package com.quebecwhisky.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author jpshields
 * 
 */
@Entity
public class Review extends AbstractEntity {

	private static final long serialVersionUID = 1L;
	
	private Bottle _bottle;
	private String _author;
	private Double _rating;
	private String _notes;
	private Date _created;

	@ManyToOne(fetch = FetchType.LAZY)
	public Bottle getBottle() {
		return _bottle;
	}

	public void setBottle(Bottle bottle) {
		this._bottle = bottle;
	}

	@Column
	public String getAuthor() {
		return _author;
	}

	public void setAuthor(String author) {
		this._author = author;
	}

	@Column
	public Double getRating() {
		return _rating;
	}

	public void setRating(Double rating) {
		this._rating = rating;
	}

	@Column
	public String getNotes() {
		return _notes;
	}

	public void setNotes(String notes) {
		this._notes = notes;
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
