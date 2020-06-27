package SpringTuition.models;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Entity
@Document
public class CourseStudent {
    @Id
    int id;
    int courseId;
    int studentId;

    public CourseStudent() {
    }

    public CourseStudent(int id, int courseId, int studentId) {
        this.id = id;
        this.courseId = courseId;
        this.studentId = studentId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return "CourseStudent [courseId=" + courseId + ", id=" + id + ", studentId=" + studentId + "]";
    }

}