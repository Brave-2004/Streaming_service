package project.streaming_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.streaming_service.entity.Subscription;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
}