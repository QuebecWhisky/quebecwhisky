/**
 * 
 */
package com.quebecwhisky.web.controller;

import java.util.Map;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.quebecwhisky.service.IActivityService;
import com.quebecwhisky.service.IBottleService;
import com.quebecwhisky.web.form.Search;
import com.quebecwhisky.web.ui.SearchResults;

/**
 * @author jpshields
 * 
 */
@Controller
@RequestMapping(value = "/search", method = RequestMethod.POST)
public class SearchRestController {

	@Inject
	private IBottleService _bottleService;

	@Inject
	private IActivityService _activityService;

	@RequestMapping
	public String getSearchResults(@Valid @ModelAttribute Search searchForm,
			BindingResult errors, Map<String, Object> model) {

		if (errors.hasErrors()) {
			// posted foo instance is not valid and should be resubmitted
		} else {
			// posted foo instance is valid and can be processed
		}

		SearchResults results = new SearchResults(searchForm.getKeywords());
		model.put("search", new Search());
		model.put("searchResults", results);

		return "search";
	}

}
