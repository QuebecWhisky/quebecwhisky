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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.quebecwhisky.model.Bottle;
import com.quebecwhisky.model.Distillery;
import com.quebecwhisky.model.Review;
import com.quebecwhisky.service.IDistilleryService;
import com.quebecwhisky.web.form.Search;

/**
 * @author jpshields
 * 
 */
@Controller
@RequestMapping(value = "/admin", method = RequestMethod.GET)
public class AdminRestController {

	@Inject
	private IDistilleryService _distillerySrv;

	@ModelAttribute("search")
	public Search getSearchForm() {
		return new Search();
	}

	@ModelAttribute("review")
	public Review getReviewForm() {
		return new Review();
	}

	@ModelAttribute("bottle")
	public Bottle getBottleForm() {
		return new Bottle();
	}

	@ModelAttribute("distillery")
	public Distillery getDistilleryForm() {
		return new Distillery();
	}

	@RequestMapping
	public String show(Map<String, Object> model) {
		return "admin";
	}

	@RequestMapping(value = "/distillery", method = RequestMethod.POST)
	public String addDistillery(@Valid @ModelAttribute Distillery distillery,
			RedirectAttributes redirectAttributes, BindingResult errors) {

		if (errors.hasErrors()) {
			// posted foo instance is not valid and should be resubmitted
		} else {
			// posted foo instance is valid and can be processed
		}

		_distillerySrv.persist(distillery);

		redirectAttributes.addFlashAttribute("distillery", new Distillery());
		return "redirect:/admin";
	}

}
