package SpringTuition.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import SpringTuition.models.User;

public interface UserRepository extends MongoRepository<User, String> {
    public User findByUsername(String username);
}