package com.crud.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.crud.demo.entity.Course;
import com.crud.demo.service.CourseService;

@Controller
public class CourseController {

    private final CourseService service;

    @Autowired
    public CourseController(CourseService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String findAll(Model model) {
        model.addAttribute("courses", service.findallCourses());
        return "index";
    }

    @GetMapping("/add")
    public String launchAddCoursePage(Model model) {
        model.addAttribute("course", new Course());
        return "webpage";
    }

    @PostMapping("/addcourse")
    public String createCourse(@ModelAttribute Course course) {
        service.addCourse(course);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String lunchEditPage(Model model, @PathVariable("id") int id) {
        model.addAttribute("course", service.findCourseById(id));
        return "editcourse";
    }

    @PostMapping("/updateCourse")
    public String updateCourse(@ModelAttribute Course course) {
        service.updateCourse(course);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteCourse(@PathVariable("id") int id) {
        service.deletedById(id);
        return "redirect:/";
    }
}
