package com.crud.demo;

import com.crud.demo.entity.Course;
import com.crud.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

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
    public String createCourse(@Valid @ModelAttribute Course course, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "webpage";
        }
        service.addCourse(course);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String launchEditPage(Model model, @PathVariable("id") int id) {
        Course course = service.findCourseById(id);
        if (course == null) {
            return "redirect:/";
        }
        model.addAttribute("course", course);
        return "editcourse";
    }

    @PostMapping("/updateCourse")
    public String updateCourse(@Valid @ModelAttribute Course course, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "editcourse";
        }
        service.updateCourse(course);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteCourse(@PathVariable("id") int id) {
        service.deletedById(id);
        return "redirect:/";
    }
}
