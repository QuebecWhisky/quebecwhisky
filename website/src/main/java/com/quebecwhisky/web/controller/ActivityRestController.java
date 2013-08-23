/**
 * 
 */
package com.quebecwhisky.web.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.quebecwhisky.model.Activity;
import com.quebecwhisky.service.IActivityService;
import com.quebecwhisky.web.form.Search;

/**
 * @author jpshields
 * 
 */
@Controller
@RequestMapping(value = "/activity", method = RequestMethod.GET)
public class ActivityRestController {

	@Inject
	private IActivityService _activityService;
	
	@ModelAttribute("search")
	public Search getSearchForm() {
		return new Search();
	}
	
	@RequestMapping
	public String getActivities(Map<String, Object> model) {
		List<Activity> activities = _activityService.getNextActivities(new Date(), 4);
		model.put("activities", activities);		
		return "activities";
	}

}
