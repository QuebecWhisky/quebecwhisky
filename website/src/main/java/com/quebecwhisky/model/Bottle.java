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

	@Column
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

	//todo devrait être un enum
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

}
