package SpringTuition.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import SpringTuition.models.Topic;
import SpringTuition.models.Course;
import SpringTuition.service.CourseService;
import SpringTuition.service.TopicService;

@RestController
public class TopicController {
    @Autowired
    private TopicService topicService;
    @Autowired
    private CourseService courseService;

    @RequestMapping(value = "/courses/{courseId}/topics", method = RequestMethod.GET)
    public List<Topic> getTopics(@PathVariable int courseId) {
        return topicService.getAllTopics(courseId);
    }

    @RequestMapping(value = "/courses/{courseId}/topic/{id}", method = RequestMethod.GET)
    public List<Topic> getTopic(@PathVariable int id) {
        return (topicService.getTopicById(id));
    }

    @RequestMapping(value = "/courses/{courseId}/topic", method = RequestMethod.POST)
    public void addTopic(@PathVariable int courseId, @RequestBody Topic t) {
        try {
            Course c = courseService.getCourseById(courseId);
            t.setCourses(c);
            topicService.createTopic(t);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/courses/{courseId}/topic/{id}", method = RequestMethod.PUT)
    public void updateTopic(@PathVariable final String id, @RequestBody final Topic updatedTopic,
            @PathVariable final int courseId) {
        Course c = courseService.getCourseById(courseId);
        updatedTopic.setCourses(c);
        topicService.updateTopic(id, updatedTopic);
    }

    @RequestMapping(value = "/courses/{courseId}/topic/{id}", method = RequestMethod.DELETE)
    public Boolean deleteTopicById(@PathVariable final String id) {
        return topicService.deleteTopic(id);
    }
}