package project.streaming_service.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.streaming_service.repository.SubscriptionRepository;
import project.streaming_service.service.SubscriptionService;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class SubscriptionServiceImpl implements SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;
    @Override
    public void markExpiredSubscription() {
        LocalDate today = LocalDate.now();

        subscriptionRepository.updateExpiredStatuses(today);

    }
}
