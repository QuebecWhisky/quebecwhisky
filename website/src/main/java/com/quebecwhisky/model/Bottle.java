/**
 * 
 */
package com.quebecwhisky.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author jpshields
 * 
 */
@Entity
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

	@Column(unique = true, nullable = false)
	@NotNull
	public String getName() {
		return _name;
	}

	public void setName(String name) {
		this._name = name;
	}

	@ManyToOne(fetch = FetchType.LAZY)
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
	public Set<Review> getReviews() {
		return _reviews;
	}

	public void setReviews(Set<Review> reviews) {
		this._reviews = reviews;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((_abv == null) ? 0 : _abv.hashCode());
		result = prime * result + ((_age == null) ? 0 : _age.hashCode());
		result = prime * result
				+ ((_bottler == null) ? 0 : _bottler.hashCode());
		result = prime * result + ((_finish == null) ? 0 : _finish.hashCode());
		result = prime * result
				+ ((_history == null) ? 0 : _history.hashCode());
		result = prime * result + ((_logo == null) ? 0 : _logo.hashCode());
		result = prime * result + ((_name == null) ? 0 : _name.hashCode());
		result = prime * result
				+ ((_priceStore == null) ? 0 : _priceStore.hashCode());
		result = prime * result
				+ ((_subtype == null) ? 0 : _subtype.hashCode());
		result = prime * result + ((_type == null) ? 0 : _type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bottle other = (Bottle) obj;
		if (_abv == null) {
			if (other._abv != null)
				return false;
		} else if (!_abv.equals(other._abv))
			return false;
		if (_age == null) {
			if (other._age != null)
				return false;
		} else if (!_age.equals(other._age))
			return false;
		if (_bottler == null) {
			if (other._bottler != null)
				return false;
		} else if (!_bottler.equals(other._bottler))
			return false;
		if (_finish == null) {
			if (other._finish != null)
				return false;
		} else if (!_finish.equals(other._finish))
			return false;
		if (_history == null) {
			if (other._history != null)
				return false;
		} else if (!_history.equals(other._history))
			return false;
		if (_logo == null) {
			if (other._logo != null)
				return false;
		} else if (!_logo.equals(other._logo))
			return false;
		if (_name == null) {
			if (other._name != null)
				return false;
		} else if (!_name.equals(other._name))
			return false;
		if (_priceStore == null) {
			if (other._priceStore != null)
				return false;
		} else if (!_priceStore.equals(other._priceStore))
			return false;
		if (_subtype == null) {
			if (other._subtype != null)
				return false;
		} else if (!_subtype.equals(other._subtype))
			return false;
		if (_type == null) {
			if (other._type != null)
				return false;
		} else if (!_type.equals(other._type))
			return false;
		return true;
	}

}
