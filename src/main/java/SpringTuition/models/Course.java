package SpringTuition.models;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Entity
@Document(collection = "Course")
public class Course {
    @Id
    int id;
    String courseName;
    String courseField;
    String coursYear;
    Stream stream;
    int streamId;

    public Course() {
    }

    public Course(int id, String courseName, String courseField, String coursYear, int streamId) {
        this.id = id;
        this.courseName = courseName;
        this.courseField = courseField;
        this.coursYear = coursYear;
        this.stream = new Stream(streamId, "", "", "");
    }

    public Course(int id, String courseName, String courseField, String coursYear) {
        this.id = id;
        this.courseName = courseName;
        this.courseField = courseField;
        this.coursYear = coursYear;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseField() {
        return courseField;
    }

    public void setCourseField(String courseField) {
        this.courseField = courseField;
    }

    public String getCoursYear() {
        return coursYear;
    }

    public void setCoursYear(String coursYear) {
        this.coursYear = coursYear;
    }

    @Override
    public String toString() {
        return "Course [coursYear=" + coursYear + ", courseField=" + courseField + ", courseName=" + courseName
                + ", id=" + "" + " streamId=" + streamId + "]";
    }

    public Stream getStream() {
        return stream;
    }

    public void setStream(Stream stream) {
        this.stream = stream;
    }

    public int getStreamId() {
        return this.streamId;
    }

    public void setStreamId(int streamId) {
        this.streamId = streamId;
    }
}