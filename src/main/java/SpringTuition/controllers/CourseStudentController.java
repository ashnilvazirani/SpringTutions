package SpringTuition.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import SpringTuition.models.*;
import SpringTuition.service.CourseStudentService;
import java.util.List;

@Controller
public class CourseStudentController {
    @Autowired
    CourseStudentService courseStudentService;

    @GetMapping("/coursestudents")
    public List<String[]> getAllStudents() {
        return courseStudentService.getAllCourseStudents();
    }

    // @GetMapping("/studentsByCourse/{courseId}")
    // public List<Student> getStudentsForCourse(@PathVariable int courseId) {
    // return courseStudentService.getAllStudentsForACourse(courseId);
    // }

    // @GetMapping("/getCourse/{courseId}")
    // public Course getCourseFromId(@PathVariable int courseId) {
    // return courseStudentService.getACourse(courseId);
    // }

    @GetMapping("/coursestudent/{id}")
    public CourseStudent getStudent(@PathVariable String id) {
        try {
            return courseStudentService.getCourseStudentById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @PostMapping(value = "/coursestudents/save")
    public String saveStudent(@Validated CourseStudent t, Model model) {
        courseStudentService.createCourseStudent(t);
        return "redirect:/students";
    }

    @PutMapping(value = "/coursestudent/{id}")
    public void updateStudent(@PathVariable String id, @RequestBody CourseStudent updatedTopic) {
        courseStudentService.updateCourseStudent(id, updatedTopic);
    }

    @DeleteMapping(value = "/coursestudent/{id}")
    public Boolean deleteStudentById(@PathVariable String id) {
        return courseStudentService.deleteCourseStudent(id);
    }
}