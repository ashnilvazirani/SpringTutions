package SpringTuition.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import SpringTuition.service.CourseService;
import SpringTuition.service.StreamService;
import SpringTuition.models.Course;
import SpringTuition.models.Student;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class CourseController {
    @Autowired
    CourseService courseService;
    @Autowired
    StreamService streamService;

    // @RequestMapping(value = "/courses", method = RequestMethod.GET)
    @GetMapping("/courses")
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/course/{id}")
    public Course getCourse(@PathVariable int id) {
        try {
            return courseService.getCourseById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("/studentsByCourse/{id}")
    public List<String> getStudentsForCourse(@PathVariable int id) {
        return courseService.getAllStudentsForACourse(id);
    }

    @PostMapping(value = "/courses")
    public void saveCourse(@RequestBody Course t) {
        // generate a id for the collection
        t.setStream(streamService.getStreamById(t.getStreamId()));
        courseService.createCourse(t);
    }

    @PutMapping(value = "/course/{id}")
    public void updateCourse(@PathVariable String id, @RequestBody Course t) {
        t.setStream(streamService.getStreamById(t.getStreamId()));
        courseService.updateCourse(id, t);
    }

    @DeleteMapping(value = "/course/{id}")
    public Boolean deleteCourseById(@PathVariable String id) {
        return courseService.deleteCourse(id);
    }
}