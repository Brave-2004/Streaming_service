package project.streaming_service.utils;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import project.streaming_service.service.SubscriptionService;

@Component
@RequiredArgsConstructor
public class ScheduledTask {
    private final SubscriptionService subscriptionService;

    @Scheduled(cron = "0 0 0 1 * *")
    public void updateExpiredSubscriptions() {
        subscriptionService.markExpiredSubscription();
    }

}
