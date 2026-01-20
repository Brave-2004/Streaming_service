package project.streaming_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.streaming_service.entity.Actor;

public interface ActorRepository extends JpaRepository<Actor, Long> {
}