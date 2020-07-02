package SpringTuition.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import SpringTuition.models.Student;
import SpringTuition.service.CourseService;
import SpringTuition.service.StreamService;
import SpringTuition.service.StudentService;
// import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class StudentController {
    @Autowired
    StudentService studentService;
    @Autowired
    StreamService streamService;
    @Autowired
    CourseService courseService;

    @GetMapping("/students")
    public String getAllStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "students/view-student";
    }

    @GetMapping("/students/addNew")
    public String addNewStudent(Model model) {
        model.addAttribute("streams", streamService.getAllStreams());
        return "students/add-student";
    }

    @GetMapping("/student/edit/{id}")
    public String getStudent(@PathVariable String id, Model model) {
        try {
            model.addAttribute("student", studentService.getStudentById(id));
            model.addAttribute("streams", streamService.getAllStreams());
            return "students/edit-student";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    @GetMapping("/student/addCourse/{id}")
    public String addNewCourseForStudent(@PathVariable String id, Model model) {
        try {
            model.addAttribute("student", studentService.getStudentById(id));
            model.addAttribute("courses", courseService.getAllCourses());
            return "students/add-course-student";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    @PostMapping(value = "/student/save")
    public String saveStudent(@Validated Student t) {
        // generate a id for the collection
        studentService.createStudent(t);
        return "redirect:/students";
    }

    @PostMapping(value = "/student/update/{id}")
    public String updateStudent(@PathVariable String id, @Validated Student updatedTopic, Model model) {
        studentService.updateStudent(id, updatedTopic);
        return "redirect:/students";
    }

    @GetMapping(value = "/student/delete/{id}")
    public String deleteStudentById(@PathVariable String id, Model model) {
        studentService.deleteStudent(id);
        return "redirect:/students";
    }
}