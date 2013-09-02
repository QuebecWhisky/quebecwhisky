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

}
