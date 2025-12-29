package project.streaming_service.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;
import project.streaming_service.enums.SubscriptionTypeEnum;

import java.io.Serializable;

/**
 * DTO for {@link project.streaming_service.entity.Subscription}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BuySubscriptionDto implements Serializable {

   private SubscriptionTypeEnum typeEnum;

   private Integer  duration;

}