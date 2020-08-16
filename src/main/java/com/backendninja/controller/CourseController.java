package com.backendninja.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.backendninja.entity.Course;
import com.backendninja.service.CourseService;

@Controller
@RequestMapping("/courses")
public class CourseController {

	public static final Log LOGGER = LogFactory.getLog(CourseController.class);

	public static final String COURSES_VIEW = "courses";

	@Autowired
	@Qualifier("courseServiceImpl")
	private CourseService courseService;

	@GetMapping(value = "/listcourses")
	public ModelAndView listAllCourse() {
		LOGGER.info("-- METHOD listAllCourse");
		ModelAndView modelAndView = new ModelAndView(COURSES_VIEW);
		modelAndView.addObject("course", courseService.listAllCourses());
		return modelAndView;
	}

	@PostMapping(value = "/addcourse")
	public String addCourse(@ModelAttribute("course") Course course) {
		LOGGER.info("-- METHOD addCourse");
		courseService.addCourse(course);
		return "redirect:/listCourses";
	}
}
