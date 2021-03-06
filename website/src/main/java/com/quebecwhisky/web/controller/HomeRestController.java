/**
 * 
 */
package com.quebecwhisky.web.controller;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.quebecwhisky.model.Activity;
import com.quebecwhisky.model.Bottle;
import com.quebecwhisky.model.News;
import com.quebecwhisky.service.IActivityService;
import com.quebecwhisky.service.IBottleService;
import com.quebecwhisky.service.INewsService;
import com.quebecwhisky.web.form.Search;

/**
 * @author jpshields
 * 
 */
@Controller
@RequestMapping(method = RequestMethod.GET)
public class HomeRestController {

	@Inject
	private IActivityService _activityService;

	@Inject
	private INewsService _newsService;

	@Inject
	private IBottleService _bottleService;
	
	// todo cache this
	@ModelAttribute("activity")
	public Activity getNextActivity() {
		return this._activityService.getNextScheduledActivity(new Date());
	}

	// todo cache this
	@ModelAttribute("news")
	public List<News> getRecentNews() {
		return this._newsService.getRecentNews(4);
	}

	// todo cache this
	@ModelAttribute("bottles")
	public List<Bottle> getRecentReviews() {
		return this._bottleService.getRecentReviews(5);
	}
	
	@ModelAttribute("search")
	public Search getSearchForm() {
		return new Search();
	}
	
	@RequestMapping
	public String welcome() {
		return "welcome";
	}

}
