/**
 * 
 */
package com.quebecwhisky.web.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.quebecwhisky.web.form.Search;

/**
 * @author jpshields
 * 
 */
@Controller
@RequestMapping("/club")
public class ClubRestController {

	@ModelAttribute("search")
	public Search getSearchForm() {
		return new Search();
	}

	@RequestMapping(method = RequestMethod.GET)
	public String show(Map<String, Object> model) {
		return "le_club";
	}

}
