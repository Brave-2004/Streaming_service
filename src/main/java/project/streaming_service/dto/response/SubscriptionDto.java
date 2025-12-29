package project.streaming_service.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.streaming_service.entity.Subscription;
import project.streaming_service.enums.SubscriptionStatus;
import project.streaming_service.enums.SubscriptionTypeEnum;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;

/**
 * DTO for {@link Subscription}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubscriptionDto implements Serializable {
    private Long id;
    private SubscriptionTypeEnum typeEnum;
    private LocalDate startTime;
    private LocalDate endTime;
    private SubscriptionStatus status;
}