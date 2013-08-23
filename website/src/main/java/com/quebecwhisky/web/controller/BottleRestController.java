/**
 * 
 */
package com.quebecwhisky.web.controller;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.quebecwhisky.model.Bottle;
import com.quebecwhisky.service.IBottleService;
import com.quebecwhisky.web.form.Search;

/**
 * @author jpshields
 * 
 */
@Controller
@RequestMapping(value = "/bottle", method = RequestMethod.GET)
public class BottleRestController {

	@Inject
	private IBottleService bottleService;
	
	@ModelAttribute("search")
	public Search getSearchForm() {
		return new Search();
	}
	
	@RequestMapping
	public String getBottles(Map<String, Object> model) {
		
		List<Bottle> bottles = bottleService.getBottles();
		model.put("bottles", bottles);
		
		return "bottles";
	}

}
