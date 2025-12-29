package project.streaming_service.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link project.streaming_service.entity.User}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto implements Serializable {
    private Long id;
    private String fullName;
    private String email;
    private String password;
    private Long subscriptionId;
    private List<RatingDto> ratings;
    private List<WatchHistoryDto> watchHistories;
}