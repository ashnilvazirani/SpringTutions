package SpringTuition.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;
import SpringTuition.models.Topic;
import SpringTuition.models.Course;
import SpringTuition.service.CourseService;
import SpringTuition.service.TopicService;

@Controller
public class TopicController {
    @Autowired
    private TopicService topicService;
    @Autowired
    private CourseService courseService;

    @RequestMapping(value = "/course/{courseId}/topics", method = RequestMethod.GET)
    public String getTopics(@PathVariable String courseId, Model model) {
        model.addAttribute("topics", topicService.getAllTopics(courseId));
        return "topics/view-topic";
    }

    @GetMapping("/courses/{courseId}/topic/addNew")
    public String addNewTopic(@PathVariable String courseId, Model model) {
        model.addAttribute("course", courseService.getCourseById(courseId));
        return "topics/add-topic";
    }

    @RequestMapping(value = "/courses/{courseId}/topic/{id}", method = RequestMethod.GET)
    public List<Topic> getTopic(@PathVariable String id) {
        return (topicService.getTopicById(id));
    }

    @RequestMapping(value = "/courses/{courseId}/topic/save", method = RequestMethod.POST)
    public String addTopic(@PathVariable String courseId, @Validated Topic t, Model model) {
        try {
            t.setCourses(courseService.getCourseById(courseId));
            topicService.createTopic(t);
            return "redirect:../../";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    @GetMapping("/courses/{courseId}/topic/edit/{id}")
    public String editTopic(Model model, @PathVariable String courseId, @PathVariable String id) {
        Topic t = (Topic) topicService.getTopicById(id).get(0);
        model.addAttribute("course", courseService.getCourseById(courseId));
        model.addAttribute("topic", t);
        return "topics/edit-topic";
    }

    @RequestMapping(value = "/courses/{courseId}/topic/edit/{id}", method = RequestMethod.POST)
    public String updateTopic(@PathVariable String id, @Validated Topic updatedTopic, @PathVariable String courseId) {
        updatedTopic.setCourses(courseService.getCourseById(courseId));
        topicService.updateTopic(id, updatedTopic);
        return "redirect:/course/{courseId}/topics";
    }

    @RequestMapping(value = "/courses/{courseId}/topic/delete/{id}", method = RequestMethod.GET)
    public String deleteTopicById(@PathVariable final String id) {
        topicService.deleteTopic(id);
        return "redirect:/course/{courseId}/topics";

    }
}