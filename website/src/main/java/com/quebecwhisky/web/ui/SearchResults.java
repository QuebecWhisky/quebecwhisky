/**
 * 
 */
package com.quebecwhisky.web.ui;

import java.util.Collections;
import java.util.List;

import com.quebecwhisky.model.Bottle;
import com.quebecwhisky.model.Distillery;
import com.quebecwhisky.model.Review;

/**
 * @author Jean-Philippe
 * 
 */
public class SearchResults {

	private final String _keywords;
	private List<Bottle> _bottles;
	private List<Distillery> _distilleries;
	private List<Review> _reviews;

	/**
	 * 
	 */
	public SearchResults(String keywords) {
		super();

		_keywords = keywords;
		_bottles = Collections.emptyList();
		_distilleries = Collections.emptyList();
		_reviews = Collections.emptyList();
	}

	public String getKeywords() {
		return _keywords;
	}

	public List<Bottle> getBottles() {
		return _bottles;
	}

	public void setBottles(List<Bottle> bottles) {
		_bottles = bottles;
	}

	public List<Distillery> getDistilleries() {
		return _distilleries;
	}

	public void setDistilleries(List<Distillery> distilleries) {
		_distilleries = distilleries;
	}

	public List<Review> getReviews() {
		return _reviews;
	}

	public void setReviews(List<Review> reviews) {
		_reviews = reviews;
	}

}
