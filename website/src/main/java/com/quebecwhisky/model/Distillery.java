/**
 * 
 */
package com.quebecwhisky.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

/**
 * @author jpshields
 * 
 */
@Entity
public class Distillery extends AbstractEntity {

	private static final long serialVersionUID = 1L;
	
	private String name;
	private Short yearEstablished;
	private String history;
	private String country;
	private String region;
	private String logo;
	private String hyperlink;
	private Set<Bottle> bottles;

	@Column
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "established")
	public Short getYearEstablished() {
		return yearEstablished;
	}

	public void setYearEstablished(Short year) {
		this.yearEstablished = year;
	}

	@Column
	public String getHistory() {
		return history;
	}

	public void setHistory(String history) {
		this.history = history;
	}

	@Column
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Column
	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	@Column
	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	@Column
	public String getHyperlink() {
		return hyperlink;
	}

	public void setHyperlink(String hyperlink) {
		this.hyperlink = hyperlink;
	}

	@OneToMany(mappedBy = "distillery", fetch = FetchType.LAZY)
	public Set<Bottle> getBottles() {
		return bottles;
	}

	public void setBottles(Set<Bottle> bottles) {
		this.bottles = bottles;
	}

}
