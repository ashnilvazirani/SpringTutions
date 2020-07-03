package SpringTuition.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import SpringTuition.models.CourseStudent;
import SpringTuition.models.Course;

public interface CourseStudentRepository extends MongoRepository<CourseStudent, String> {
    public Course findCourseByCourseId(String courseId);

    public void deleteByStudentId(String id);
}