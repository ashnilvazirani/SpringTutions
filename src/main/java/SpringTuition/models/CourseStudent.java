package SpringTuition.models;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Entity
@Document
public class CourseStudent {
    // @Id
    String id;
    String courseId;
    String studentId;

    public CourseStudent() {
    }

    public CourseStudent(String id, String courseId, String studentId) {
        this.id = id;
        this.courseId = courseId;
        this.studentId = studentId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return "CourseStudent [courseId=" + courseId + ", id=" + id + ", studentId=" + studentId + "]";
    }

}