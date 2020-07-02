package SpringTuition.models;

import javax.persistence.Entity;

import com.mongodb.lang.NonNull;

import org.springframework.data.mongodb.core.mapping.Document;

@Entity
@Document(collection = "Course")
public class Course {
    // @Id
    // @GeneratedValue(strategy = GenerationType.AUTO)
    String id;
    @NonNull
    String courseName;
    @NonNull
    String courseField;
    @NonNull
    String courseYear;
    @NonNull
    String courseDescription;
    @NonNull
    String courseDuration;
    @NonNull
    Stream stream;
    String streamId;

    public Course() {
    }

    public Course(String id, String courseName, String courseField, String courseDuration, String coursYear,
            String courseDescription, String streamId) {
        this.id = id;
        this.courseName = courseName;
        this.courseField = courseField;
        this.courseYear = coursYear;
        this.courseDescription = courseDescription;
        this.courseDuration = courseDuration;
        this.stream = new Stream(streamId, "", "", "");
    }

    public Course(String id, String courseName, String courseField, String coursYear) {
        this.id = id;
        this.courseName = courseName;
        this.courseField = courseField;
        this.courseYear = coursYear;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
        return courseYear;
    }

    public void setCoursYear(String coursYear) {
        this.courseYear = coursYear;
    }

    public Stream getStream() {
        return stream;
    }

    public void setStream(Stream stream) {
        this.stream = stream;
    }

    public String getStreamId() {
        return this.streamId;
    }

    public void setStreamId(String streamId) {
        this.streamId = streamId;
    }

    public String getCourseDuration() {
        return courseDuration;
    }

    public void setCourseDuration(String courseDuration) {
        this.courseDuration = courseDuration;
    }

    @Override
    public String toString() {
        return "Course [courseDescription=" + courseDescription + ", courseDuration=" + courseDuration
                + ", courseField=" + courseField + ", courseName=" + courseName + ", courseYear=" + courseYear + ", id="
                + id + ", stream=" + stream + ", streamId=" + streamId + "]";
    }

    public String getCourseYear() {
        return courseYear;
    }

    public void setCourseYear(String courseYear) {
        this.courseYear = courseYear;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }
}