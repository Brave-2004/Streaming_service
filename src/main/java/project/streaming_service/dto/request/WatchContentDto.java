package project.streaming_service.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WatchContentDto implements Serializable {

    private long userId;

    private Integer progressMinutes;
}
