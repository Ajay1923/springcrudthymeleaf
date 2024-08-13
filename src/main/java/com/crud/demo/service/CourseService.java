package com.crud.demo.service;

import java.util.List;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.demo.entity.Course;
import com.crud.demo.repository.CourseRepository;


@Service
public class CourseService {
	@Autowired
	CourseRepository repository;

	public List<Course> findallCourses() {
		return (List<Course>) repository.findAll();
	}

	public Course findCourseById(int id) {
		Optional<Course> result = repository.findById(id);
		if (result.isPresent()) {
			return result.get();
		}
		return new Course();
	}

	public Course addCourse(Course course) {
		return repository.save(course);
	}

	public Course updateCourse(Course course) {
		Optional<Course> result = repository.findById(course.getId());
	    Course existing = result.get();
	    existing.setTech(course.getTech());
	    existing.setName(course.getName());
	    existing.setNoOfDays(course.getNoOfDays());
	    return repository.save(existing);
	}

	public void deletedById(int id) {
		repository.deleteById(id);
	}

}
