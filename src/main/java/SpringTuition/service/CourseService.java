package SpringTuition.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import SpringTuition.repository.CourseStudentRepository;
import SpringTuition.repository.TutionCourseRepository;
import SpringTuition.models.Course;
import SpringTuition.models.Student;
import SpringTuition.models.CourseStudent;

@Service
public class CourseService {
    @Autowired
    TutionCourseRepository tutionCourseRepository;
    @Autowired
    CourseStudentRepository courseStudentRepository;
    @Autowired
    StudentService studentService;

    public List<Course> getAllCourses() {
        // return this.topics;
        List<Course> t = new ArrayList<>();
        tutionCourseRepository.findAll().forEach(t::add);
        return t;
    }

    public Course getCourseById(int id) {
        // return topics.stream().filter(t ->
        // Integer.toString(t.getId()).equals(Integer.toString(id))).findFirst().get();
        return ((Course) tutionCourseRepository.findById(id).get());
    }

    public List<String> getAllStudentsForACourse(int courseId) {
        List<CourseStudent> t = new ArrayList<>();
        List<String> s = new ArrayList<>();
        courseStudentRepository.findAll().forEach(t::add);
        for (CourseStudent cs : t) {
            if (cs.getCourseId() == courseId) {
                s.add(studentService.getStudentById(cs.getStudentId()).getStudentName());
            }
        }
        return s;
    }

    public Boolean createCourse(Course t) {
        tutionCourseRepository.save(t);
        return true;
    }

    public void updateCourse(String id, Course updatedTopic) {
        tutionCourseRepository.save(updatedTopic);
    }

    public Boolean deleteCourse(String id) {
        try {
            tutionCourseRepository.deleteById(Integer.parseInt(id));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}