/**
 * 
 */
package com.quebecwhisky.web.form;

import javax.validation.constraints.NotNull;

/**
 * @author Jean-Philippe
 * 
 */
public class Search {

	private String _keywords;
	
	public Search() {
		super();
	}

	@NotNull
	public String getKeywords() {
		return this._keywords;
	}

	public void setKeywords(String keywords) {
		this._keywords = keywords;
	}

}
