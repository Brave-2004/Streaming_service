package project.streaming_service.mapper;

import lombok.Getter;
import org.springframework.stereotype.Component;
import project.streaming_service.dto.response.SubscriptionDto;
import project.streaming_service.entity.Subscription;
import project.streaming_service.mapper.template.BaseMapper;
@Component
@Getter
public class SubscriptionMapper implements BaseMapper<SubscriptionDto, Subscription> {
    @Override
    public SubscriptionDto toDto(Subscription subscription) {
        return new SubscriptionDto(
                subscription.getId(),
                subscription.getTypeEnum(),
                subscription.getStartTime(),
                subscription.getEndTime(),
                subscription.getStatus()
        );
    }

    @Override
    public Subscription toEntity(SubscriptionDto subscriptionDto) {
        return null;
    }
}
