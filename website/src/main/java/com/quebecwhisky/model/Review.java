/**
 * 
 */
package com.quebecwhisky.model;

import java.text.DecimalFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author jpshields
 * 
 */
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"AUTHOR","BOTTLE_ID"}))
public class Review extends AbstractEntity {

	private static final long serialVersionUID = 1L;
	private static final DecimalFormat FORMAT = new DecimalFormat("###.#");
	
	private Bottle _bottle;
	private String _author;
	private Double _rating;
	private String _notes;
	private Date _created;

	@NotNull
	@JoinColumn(nullable = false)
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	public Bottle getBottle() {
		return _bottle;
	}

	public void setBottle(Bottle bottle) {
		this._bottle = bottle;
	}

	@NotNull
	@Column(nullable = false)
	public String getAuthor() {
		return _author;
	}

	public void setAuthor(String author) {
		this._author = author;
	}

	@NotNull
	@Column
	@Digits(integer = 3, fraction = 1)
	@Min(0)
	@Max(100)
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

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	public Date getCreated() {
		return _created;
	}

	public void setCreated(Date created) {
		this._created = created;
	}

	@Transient
	public String getFormattedRating() {
		return FORMAT.format(this._rating);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((_author == null) ? 0 : _author.hashCode());
		result = prime * result + ((_bottle == null) ? 0 : _bottle.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Review other = (Review) obj;
		if (_author == null) {
			if (other._author != null)
				return false;
		} else if (!_author.equals(other._author))
			return false;
		if (_bottle == null) {
			if (other._bottle != null)
				return false;
		} else if (!_bottle.equals(other._bottle))
			return false;
		return true;
	}

}
