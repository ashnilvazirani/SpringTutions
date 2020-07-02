package SpringTuition.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import SpringTuition.service.CourseService;
import SpringTuition.service.StreamService;
import SpringTuition.models.Course;
import SpringTuition.models.Stream;

// import SpringTuition.models.Student;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class CourseController {
    @Autowired
    CourseService courseService;
    @Autowired
    StreamService streamService;

    // @RequestMapping(value = "/courses", method = RequestMethod.GET)
    @GetMapping("/courses")
    public String getAllCourses(Model model) {
        List<Course> c = courseService.getAllCourses();
        List<Stream> s = streamService.getAllStreams();
        model.addAttribute("courses", c);
        model.addAttribute("streams", s);
        return "courses/view-course";
    }

    @GetMapping("/course/{id}")
    public Course getCourse(@PathVariable String id) {
        try {
            return courseService.getCourseById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("/studentsByCourse/{id}")
    public List<String> getStudentsForCourse(@PathVariable String id) {
        return courseService.getAllStudentsForACourse(id);
    }

    @GetMapping("/courses/addNew")
    public String addNewCourse(Model model) {
        List<Stream> s = streamService.getAllStreams();
        model.addAttribute("streams", s);
        return "courses/add-course";
    }

    @GetMapping("/course/edit/{id}")
    public String editCourse(@PathVariable String id, Model model) {
        Course c = courseService.getCourseById(id);
        List<Stream> s = streamService.getAllStreams();
        model.addAttribute("course", c);
        model.addAttribute("streams", s);
        System.out.println(c);
        return "courses/edit-course";
    }

    @PostMapping(value = "/course/edit/{id}")
    public String updateCourse(@PathVariable String id, @Validated Course t, Model model) {
        t.setStream(streamService.getStreamById(t.getStreamId()));
        courseService.updateCourse(id, t);
        return "redirect:../../courses";
    }

    @PostMapping(value = "/course/save")
    public String saveCourse(@Validated Course t) {
        t.setStream(streamService.getStreamById(t.getStreamId()));
        courseService.createCourse(t);
        return "redirect:../courses";
    }

    // @PutMapping(value = "/course/{id}")
    // public void updateCourse(@PathVariable String id, @RequestBody Course t) {
    // t.setStream(streamService.getStreamById(t.getStreamId()));
    // courseService.updateCourse(id, t);
    // }

    @GetMapping(value = "/course/delete/{id}")
    public String deleteCourseById(@PathVariable String id, Model model) {
        courseService.deleteCourse(id);
        return "redirect:../../courses";
    }
}