package SpringTuition.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import SpringTuition.repository.StudentRepository;
import SpringTuition.models.Stream;
import SpringTuition.models.Student;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    StreamService streamService;

    public List<Student> getAllStudents() {
        List<Student> t = new ArrayList<>();
        studentRepository.findAll().forEach(t::add);
        return t;
    }

    public Student getStudentById(String id) {
        return ((Student) studentRepository.findById(id).get());
    }

    public Boolean createStudent(Student t) {
        Stream s = (Stream) streamService.getStreamById(t.getStreamId());
        if (s != null) {
            t.setStream(s);
            studentRepository.save(t);
            return true;
        }
        return false;

    }

    public Boolean updateStudent(String id, Student t) {
        Stream s = (Stream) streamService.getStreamById(t.getStreamId());
        if (s != null) {
            t.setStream(s);
            studentRepository.save(t);
            return true;
        }
        return false;
    }

    public Boolean deleteStudent(String id) {
        try {
            studentRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}