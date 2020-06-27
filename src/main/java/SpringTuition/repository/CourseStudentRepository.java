package SpringTuition.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import SpringTuition.models.CourseStudent;
import SpringTuition.models.Course;

public interface CourseStudentRepository extends MongoRepository<CourseStudent, Integer> {
    public Course findCourseByCourseId(int courseId);
}