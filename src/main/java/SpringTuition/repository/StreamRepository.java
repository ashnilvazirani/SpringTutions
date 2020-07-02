package SpringTuition.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import SpringTuition.models.Stream;

public interface StreamRepository extends MongoRepository<Stream, String> {

}