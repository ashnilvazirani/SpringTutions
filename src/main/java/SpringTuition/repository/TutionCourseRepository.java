package SpringTuition.repository;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.MongoRepository;

import SpringTuition.models.Course;

@EnableJpaRepositories
public interface TutionCourseRepository extends MongoRepository<Course, String> {

}