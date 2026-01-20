package project.streaming_service.service;

import project.streaming_service.entity.Subscription;

public interface SubscriptionService {
    void markExpiredSubscription();
}
