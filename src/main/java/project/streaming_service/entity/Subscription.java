package project.streaming_service.entity;

import jakarta.persistence.*;
import lombok.*;
import project.streaming_service.entity.templates.AbsLong;
import project.streaming_service.enums.SubscriptionStatus;
import project.streaming_service.enums.SubscriptionTypeEnum;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Subscription extends AbsLong {

    @Enumerated(EnumType.STRING)
    private SubscriptionTypeEnum typeEnum;

    private LocalDate startTime;

    private LocalDate endTime;

    @Enumerated(EnumType.STRING)
    private SubscriptionStatus status;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private User user;
}
