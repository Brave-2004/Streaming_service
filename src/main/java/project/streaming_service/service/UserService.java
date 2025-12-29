package project.streaming_service.service;

import project.streaming_service.dto.request.BuySubscriptionDto;
import project.streaming_service.dto.request.ContentDto;
import project.streaming_service.dto.response.SubscriptionDto;
import project.streaming_service.dto.response.WatchHistoryDto;

import java.util.List;

public interface UserService {
    void buySubscription(Long id, BuySubscriptionDto buySubscriptionDto);

    SubscriptionDto getSubscription(Long id);

    void cancelSubscription(Long id);

    List<WatchHistoryDto> getAllHistories(Long id);

    List<ContentDto> recommendation(Long id);
}
