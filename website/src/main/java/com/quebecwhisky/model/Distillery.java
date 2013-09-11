/**
 * 
 */
package com.quebecwhisky.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author jpshields
 * 
 */
@Entity
public class Distillery extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	private String _name;
	private Short _yearEstablished;
	private String _history;
	private String _country;
	private String _region;
	private String _logo;
	private String _hyperlink;
	private Set<Bottle> _bottles;

	@Column(unique = true, nullable = false)
	@NotNull
	public String getName() {
		return _name;
	}

	public void setName(String name) {
		this._name = name;
	}

	@Column(name = "established")
	@Digits(integer = 4, fraction = 0)
	@Min(0)
	public Short getYearEstablished() {
		return _yearEstablished;
	}

	public void setYearEstablished(Short year) {
		this._yearEstablished = year;
	}

	@Column
	public String getHistory() {
		return _history;
	}

	public void setHistory(String history) {
		this._history = history;
	}

	@Column
	public String getCountry() {
		return _country;
	}

	public void setCountry(String country) {
		this._country = country;
	}

	@Column
	public String getRegion() {
		return _region;
	}

	public void setRegion(String region) {
		this._region = region;
	}

	@Column
	public String getLogo() {
		return _logo;
	}

	public void setLogo(String logo) {
		this._logo = logo;
	}

	@Column
	public String getHyperlink() {
		return _hyperlink;
	}

	public void setHyperlink(String hyperlink) {
		this._hyperlink = hyperlink;
	}

	@OneToMany(mappedBy = "distillery", fetch = FetchType.LAZY)
	public Set<Bottle> getBottles() {
		return _bottles;
	}

	public void setBottles(Set<Bottle> bottles) {
		this._bottles = bottles;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((_country == null) ? 0 : _country.hashCode());
		result = prime * result
				+ ((_history == null) ? 0 : _history.hashCode());
		result = prime * result
				+ ((_hyperlink == null) ? 0 : _hyperlink.hashCode());
		result = prime * result + ((_logo == null) ? 0 : _logo.hashCode());
		result = prime * result + ((_name == null) ? 0 : _name.hashCode());
		result = prime * result + ((_region == null) ? 0 : _region.hashCode());
		result = prime
				* result
				+ ((_yearEstablished == null) ? 0 : _yearEstablished.hashCode());
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
		Distillery other = (Distillery) obj;
		if (_country == null) {
			if (other._country != null)
				return false;
		} else if (!_country.equals(other._country))
			return false;
		if (_history == null) {
			if (other._history != null)
				return false;
		} else if (!_history.equals(other._history))
			return false;
		if (_hyperlink == null) {
			if (other._hyperlink != null)
				return false;
		} else if (!_hyperlink.equals(other._hyperlink))
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
		if (_region == null) {
			if (other._region != null)
				return false;
		} else if (!_region.equals(other._region))
			return false;
		if (_yearEstablished == null) {
			if (other._yearEstablished != null)
				return false;
		} else if (!_yearEstablished.equals(other._yearEstablished))
			return false;
		return true;
	}

}
