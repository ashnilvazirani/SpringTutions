package SpringTuition.models;

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

    public Topic() {

    }

    public Topic(int id, String topicName, String topicDescription, int courseId) {
        this.id = id;
        this.topicName = topicName;
        this.topicDescription = topicDescription;
        this.course = new Course(courseId, "", "", "");

        // this.courseName = courseName;
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
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