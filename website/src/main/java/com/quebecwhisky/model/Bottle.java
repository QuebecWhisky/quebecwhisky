/**
 * 
 */
package com.quebecwhisky.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author jpshields
 * 
 */
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"NAME","DISTILLERY_ID"}))
public class Bottle extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	private String _name;
	private Distillery _distillery;
	private String _type;
	private String _subtype;
	private String _bottler;
	private String _history;
	private Short _age;
	private Short _abv;
	private String _finish;
	private String _logo;
	private Double _priceStore;
	private Set<Review> _reviews;

	@NotNull
	@Column(unique = true, nullable = false)
	public String getName() {
		return _name;
	}

	public void setName(String name) {
		this._name = name;
	}

	@NotNull
	// Comme la distillery est dans le hashCode(), si la dist n'est pas
	// disponible au rendu de la vue, ça plante. FetchType.EAGER nécessaire ici.
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(nullable = false)
	public Distillery getDistillery() {
		return _distillery;
	}

	public void setDistillery(Distillery distillery) {
		this._distillery = distillery;
	}

	// todo devrait être un enum
	@Column(name = "BOTTLE_TYPE")
	public String getType() {
		return _type;
	}

	public void setType(String type) {
		this._type = type;
	}

	@Column
	public String getSubtype() {
		return _subtype;
	}

	public void setSubtype(String subtype) {
		this._subtype = subtype;
	}

	@Column
	public String getBottler() {
		return _bottler;
	}

	public void setBottler(String bottler) {
		this._bottler = bottler;
	}

	@Column
	public String getHistory() {
		return _history;
	}

	public void setHistory(String history) {
		this._history = history;
	}

	@Column
	@Min(0)
	public Short getAge() {
		return _age;
	}

	public void setAge(Short age) {
		this._age = age;
	}

	@Column
	public Short getAbv() {
		return _abv;
	}

	public void setAbv(Short abv) {
		this._abv = abv;
	}

	@Column
	public String getFinish() {
		return _finish;
	}

	public void setFinish(String finish) {
		this._finish = finish;
	}

	@Column
	public String getLogo() {
		return _logo;
	}

	public void setLogo(String logo) {
		this._logo = logo;
	}

	@Column
	@Digits(integer = 2, fraction = 2)
	@Min(0)
	public Double getPriceStore() {
		return _priceStore;
	}

	public void setPriceStore(Double priceStore) {
		this._priceStore = priceStore;
	}

	@OneToMany(mappedBy = "bottle", fetch = FetchType.LAZY)
	@OrderBy("author")
	public Set<Review> getReviews() {
		return _reviews;
	}

	public void setReviews(Set<Review> reviews) {
		this._reviews = reviews;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((_distillery == null) ? 0 : _distillery.hashCode());
		result = prime * result + ((_name == null) ? 0 : _name.hashCode());
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
		Bottle other = (Bottle) obj;
		if (_distillery == null) {
			if (other._distillery != null)
				return false;
		} else if (!_distillery.equals(other._distillery))
			return false;
		if (_name == null) {
			if (other._name != null)
				return false;
		} else if (!_name.equals(other._name))
			return false;
		return true;
	}

}
