package project.streaming_service.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ContinueWatchingDto {

    private Long contentId;
    private String name;
    private Integer watchedMinutes;
    private Integer totalDuration;

}
