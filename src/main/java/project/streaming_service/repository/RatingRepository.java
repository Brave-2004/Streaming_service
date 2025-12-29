package project.streaming_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import project.streaming_service.entity.Rating;

public interface RatingRepository extends JpaRepository<Rating, Long> {

    @Query("select avg(r.rate) from Rating r where r.content.id =:contentId")
    Double findAverageRatingByKContentId(Long contentId);

}