package SpringTuition.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import SpringTuition.models.Topic;
import SpringTuition.repository.TopicRepository;

@Service
public class TopicService {
    @Autowired
    private TopicRepository topicRepository;

    // private List<Topics> topics = new ArrayList<>(Arrays.asList(new Topics(1, 1,
    // "Spring", "Spring Tuorial"),
    // new Topics(2, 2, "JDK", "JAVA"), new Topics(3, 1, "SpringBoot", "Spring
    // Tuorial")));

    public List<Topic> getAllTopics(String courseId) {
        // return this.topics;
        List<Topic> t = new ArrayList<>();
        topicRepository.findByCourseId(courseId).forEach(t::add);
        return t;
    }

    public List<Topic> getTopicById(String id) {
        try {
            return topicRepository.findById(id).stream().collect(Collectors.toList());
            // return topicRepository.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Boolean createTopic(Topic t) {
        topicRepository.save(t);
        return true;
        // return this.topics.add(t);
    }

    public void updateTopic(String id, Topic updatedTopic) {
        topicRepository.save(updatedTopic);
        // the topicRepository first check with the request body ID and if finds the
        // data that replaces the content with updated value or else inserts a new
        // record

        // for (int i = 0; i < topics.size(); i++) {
        // Topics temp = topics.get(i);
        // if (temp.getId() == Integer.parseInt(id))
        // topics.set(i, updatedTopic);
        // }
    }

    public Boolean deleteTopic(String id) {
        try {
            topicRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}