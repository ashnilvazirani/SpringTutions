package SpringTuition.models;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.data.mongodb.core.mapping.Document;

@Entity
@Document(collection = "Topic")
public class Topic {
    @Id
    String id;
    String topicName;
    String topicDescription;
    String topicDate;
    String topicTime;
    @ManyToOne
    Course course;

    public Topic() {

    }

    public Topic(String id, String topicName, String topicDescription, String topicaDate, String topicTime,
            String courseId) {
        this.id = id;
        this.topicName = topicName;
        this.topicDescription = topicDescription;
        this.topicDate = topicaDate;
        this.topicTime = topicTime;
        this.course = new Course(courseId, "", "", "");

        // this.courseName = courseName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTopicTime() {
        return this.topicTime;
    }

    public void setTopicTime(String topicTime) {
        this.topicTime = topicTime;
    }

    public String getTopicDate() {
        return this.topicDate;
    }

    public void setTopicDate(String topicDate) {
        this.topicDate = topicDate;
    }

    // public int getCourseId() {
    // return courseId;
    // }

    // public void setCourseId(int courseId) {
    // this.courseId = courseId;
    // }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(final String topicName) {
        this.topicName = topicName;
    }

    public Course getCourses() {
        return course;
    }

    public void setCourses(Course course) {
        this.course = course;
    }

    public String getTopicDescription() {
        return topicDescription;
    }

    public void setTopicDescription(String topicDescription) {
        this.topicDescription = topicDescription;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Topic [course=" + course + ", id=" + id + ", topicDate=" + topicDate + ", topicDescription="
                + topicDescription + ", topicName=" + topicName + ", topicTime=" + topicTime + "]";
    }
}