package com.backendninja.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.backendninja.entity.Course;
import com.backendninja.repository.CourseJpaRepository;
import com.backendninja.service.CourseService;

@Service("courseServiceImpl") // con esto se genera un bean cuando arranque el servidor
public class CourseServiceImpl implements CourseService {

	public static final Log LOGGER = LogFactory.getLog(CourseServiceImpl.class);

	@Autowired
	@Qualifier("courseJpaRepository")
	private CourseJpaRepository courseJpaRepository;

	@Override
	public List<Course> listAllCourses() {
		LOGGER.info("Class: "+ CourseServiceImpl.class +" -- METHOD: listAllCourses");
		return courseJpaRepository.findAll();
	}

	@Override
	public Course addCourse(Course course) {
		LOGGER.info("Class: "+ CourseServiceImpl.class +" -- METHOD: addCourse");
		return courseJpaRepository.save(course);
	}

	@Override
	public int deleteCourse(int id) {
		courseJpaRepository.deleteById(id);
		return 0;
	}

	@Override
	public Course updateCourse(Course course) {
		return courseJpaRepository.save(course);
	}

}
