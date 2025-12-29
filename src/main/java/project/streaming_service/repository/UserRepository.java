package project.streaming_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.streaming_service.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}