package project.streaming_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import project.streaming_service.entity.Subscription;

import java.time.LocalDate;
@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
    @Modifying
    @Query("""
                UPDATE Subscription s
                SET s.status = 'EXPIRED'
                WHERE s.endTime < :today AND s.status <> 'EXPIRED'
            """)
    void updateExpiredStatuses(@Param("today") LocalDate today);

}