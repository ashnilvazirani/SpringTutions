package SpringTuition.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import SpringTuition.models.Student;
import SpringTuition.service.StudentService;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable String id) {
        try {
            return studentService.getStudentById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @PostMapping(value = "/students")
    public void saveStudent(@RequestBody Student t) {
        // generate a id for the collection
        studentService.createStudent(t);
    }

    @PutMapping(value = "/student/{id}")
    public void updateStudent(@PathVariable String id, @RequestBody Student updatedTopic) {
        studentService.updateStudent(id, updatedTopic);
    }

    @DeleteMapping(value = "/student/{id}")
    public Boolean deleteStudentById(@PathVariable String id) {
        return studentService.deleteStudent(id);
    }
}