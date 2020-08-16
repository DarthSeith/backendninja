package com.backendninja.service;

import java.util.List;

import com.backendninja.entity.Course;

public interface CourseService {

	public abstract List<Course> listAllCourses();

	public abstract Course addCourse(Course course);

	public abstract int deleteCourse(int id);

	public abstract Course updateCourse(Course course);
}
