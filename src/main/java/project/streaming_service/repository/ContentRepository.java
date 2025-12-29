package project.streaming_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import project.streaming_service.entity.Content;

import java.awt.print.Pageable;
import java.util.List;

public interface ContentRepository extends JpaRepository<Content, Long> {
    @Query("""
                SELECT c
                FROM Content c
                JOIN c.genres g
                WHERE g.id IN (
                    SELECT g2.id
                    FROM WatchHistory wh
                    JOIN wh.content c2
                    JOIN c2.genres g2
                    WHERE wh.user.id = :userId
                    GROUP BY g2.id
                    ORDER BY COUNT(g2.id) DESC
                )
                AND c.id NOT IN (
                    SELECT wh2.content.id
                    FROM WatchHistory wh2
                    WHERE wh2.user.id = :userId
                )
                ORDER BY (
                    SELECT AVG(r.rate)
                    FROM Rating r
                    WHERE r.content.id = c.id
                ) DESC
            """)
    List<Content> findRecommendedContentByUserId(@Param("userId") Long userId, Pageable pageable);


    Content getById(Long contentId);

}