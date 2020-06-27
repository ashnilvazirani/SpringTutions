package SpringTuition.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import SpringTuition.models.Student;

public interface StudentRepository extends MongoRepository<Student, Integer> {

}