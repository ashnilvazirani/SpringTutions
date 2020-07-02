package SpringTuition.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import SpringTuition.models.*;
import SpringTuition.repository.CourseStudentRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseStudentService {
    @Autowired
    CourseStudentRepository courseStudentRepository;
    @Autowired
    StudentService studentService;
    @Autowired
    CourseService courseService;

    public List<String[]> getAllCourseStudents() {
        List<CourseStudent> t = new ArrayList<>();
        List<String[]> data = new ArrayList<>();
        courseStudentRepository.findAll().forEach(t::add);
        String[] temp = new String[2];
        for (final CourseStudent cs : t) {
            temp[0] = "Course Name: " + (courseService.getCourseById(cs.getCourseId()).getCourseName());
            temp[1] = "Student Name: " + (studentService.getStudentById(cs.getStudentId()).getStudentName());
            // data.add("CourseName: " + cname + ", StudentName: " + sname);
            data.add(temp);
        }
        // return new List[] { c, s };
        return data;
    }

    public CourseStudent getCourseStudentById(String id) {
        return ((CourseStudent) courseStudentRepository.findById(id).get());
    }

    public Course getACourse(int courseId) {
        return courseStudentRepository.findCourseByCourseId(courseId);
    }

    // public List<Student> getAllStudentsForACourse(int courseId) {
    // List<CourseStudent> t = new ArrayList<>();
    // List<Student> s = new ArrayList<>();
    // courseStudentRepository.findAll().forEach(t::add);
    // for (CourseStudent cs : t) {
    // if (cs.getCourseId() == courseId) {
    // s.add(studentService.getStudentById(cs.getStudentId()));
    // }
    // }
    // return s;
    // }

    public Boolean createCourseStudent(final CourseStudent t) {
        courseStudentRepository.save(t);
        return true;
    }

    public void updateCourseStudent(final String id, final CourseStudent updatedTopic) {
        courseStudentRepository.save(updatedTopic);
    }

    public Boolean deleteCourseStudent(String id) {
        try {
            courseStudentRepository.deleteById(id);
            return true;
        } catch (final Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}