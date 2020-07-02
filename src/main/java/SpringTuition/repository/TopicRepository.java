package SpringTuition.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import SpringTuition.models.Topic;

public interface TopicRepository extends MongoRepository<Topic, String> {
    public List<Topic> findByTopicName(String name);

    public List<Topic> findByCourseId(String courseId);
}