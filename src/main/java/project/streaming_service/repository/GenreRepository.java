package project.streaming_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.streaming_service.entity.Genre;

public interface GenreRepository extends JpaRepository<Genre, Long> {
}