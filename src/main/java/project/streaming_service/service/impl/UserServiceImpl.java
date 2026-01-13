package project.streaming_service.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import project.streaming_service.dto.request.BuySubscriptionDto;
import project.streaming_service.dto.request.ContentDto;
import project.streaming_service.dto.response.SubscriptionDto;
import project.streaming_service.dto.response.WatchHistoryDto;
import project.streaming_service.entity.Content;
import project.streaming_service.entity.Subscription;
import project.streaming_service.entity.User;
import project.streaming_service.enums.SubscriptionStatus;
import project.streaming_service.mapper.ContentMapper;
import project.streaming_service.mapper.SubscriptionMapper;
import project.streaming_service.mapper.WatchHistoryMapper;
import project.streaming_service.repository.ContentRepository;
import project.streaming_service.repository.UserRepository;
import project.streaming_service.service.UserService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final SubscriptionMapper subscriptionMapper;
    private final WatchHistoryMapper watchHistoryMapper;
    private final ContentRepository contentRepository;
    private final ContentMapper contentMapper;

    @Override
    @Transactional
    public void buySubscription(Long id, BuySubscriptionDto dto) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Subscription subscription = user.getSubscription();

        // FIRST TIME BUY
        if (subscription == null) {
            subscription = new Subscription();
            subscription.setUser(user);
            subscription.setStartTime(LocalDate.now());
        }

        // UPDATE / ACTIVATE
        subscription.setTypeEnum(dto.getTypeEnum());
        subscription.setStatus(SubscriptionStatus.ACTIVE);

        LocalDate start = subscription.getEndTime() != null
                ? subscription.getEndTime()
                : LocalDate.now();

        subscription.setEndTime(start.plusMonths(dto.getDuration()));

        user.setSubscription(subscription);

        userRepository.save(user);
    }



    @Override
    public SubscriptionDto getSubscription(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isEmpty())
            throw new RuntimeException("User not found");

        User user = optionalUser.get();

        return subscriptionMapper.toDto(user.getSubscription());
    }

    @Override
    @Transactional
    public void cancelSubscription(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isEmpty())
            throw new RuntimeException("User not found");

        User user = optionalUser.get();

        user.getSubscription().setStatus(SubscriptionStatus.CANCELLED);

        userRepository.save(user);
    }

    @Override
    public List<WatchHistoryDto> getAllHistories(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isEmpty())
            throw new RuntimeException("User not found");

        User user = optionalUser.get();


        return user.getWatchHistories().stream().map(watchHistoryMapper::toDto).toList();
    }

    @Override
    public List<ContentDto> recommendation(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty())
            throw new RuntimeException("User not found");
        Pageable pageable = PageRequest.of(0,10);

        List<Content> recommendedContents = contentRepository.findRecommendedContentByUserId(id, pageable);


        return  recommendedContents.stream().map(contentMapper::toDto).toList();
    }
}
