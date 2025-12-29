package project.streaming_service.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WatchHistoryDto implements Serializable {

    private LocalDate watchDate;

    private Integer progress;

    private Long userid;

    private Long contentId;


}
