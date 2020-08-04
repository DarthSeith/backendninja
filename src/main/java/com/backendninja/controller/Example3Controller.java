package com.backendninja.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.backendninja.model.Person;

@Controller
@RequestMapping("/example3")
public class Example3Controller {

	public static final Log LOGGER = LogFactory.getLog(Example3Controller.class);

	public static final String FORM_VIEW = "form";
	public static final String FORM_VIEW_2 = "form2";
	public static final String RESULT_VIEW = "result";

	// redireccionar cuando no se le pone /showForm
	// #1
	/*
	 * @GetMapping("") public String redirect() { return
	 * "redirect:/example3/showForm"; }
	 */
	// redireccionar cuando no se le pone /showForm
	// #2
	@GetMapping("")
	public RedirectView redirect() {
		return new RedirectView("/example3/showForm");
	}

	@GetMapping("/showForm")
	public String showForm(Model model) {
		LOGGER.debug("DEBUG TRACE");
		LOGGER.info("INFO TRACE");
		LOGGER.warn("WARM TRACE");
		LOGGER.error("ERROR TRACE");
		model.addAttribute("person", new Person());
		return FORM_VIEW;
	}

	@PostMapping("/addperson")
	public ModelAndView addPerson(@ModelAttribute("person") Person person) {
		ModelAndView modelAndView = new ModelAndView(RESULT_VIEW);
		modelAndView.addObject("person", person);
		return modelAndView;
	}

	@GetMapping("/showError500")
	public String showError500(Model model) {
		model.addAttribute("person", new Person());
		int i = 6 / 0;
		return FORM_VIEW;
	}

}
