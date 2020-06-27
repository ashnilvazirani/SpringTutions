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
    int id;
    String topicName;
    String topicDescription;
    @ManyToOne
    Course course;
    // String courseName;
    Date topicDate;
    String topicTime;

    public Topic() {

    }

    public Topic(int id, String topicName, String topicDescription, Date topicaDate, String topicTime, int courseId) {
        this.id = id;
        this.topicName = topicName;
        this.topicDescription = topicDescription;
        this.topicDate = topicaDate;
        this.topicTime = topicTime;
        this.course = new Course(courseId, "", "", "");

        // this.courseName = courseName;
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getTopicTime() {
        return this.topicTime;
    }

    public void setTopicTime(String topicTime) {
        this.topicTime = topicTime;
    }

    public Date getTopicDate() {
        return this.topicDate;
    }

    public void setTopicDate(String topicDate) {
        try {
            this.topicDate = new SimpleDateFormat("dd/mm/yyy").parse(topicDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
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

    @Override
    public String toString() {
        return "Topics [courses=" + course + ", id=" + id + ", topicName=" + topicName + "]";
    }
}