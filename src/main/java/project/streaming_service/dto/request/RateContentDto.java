package project.streaming_service.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RateContentDto implements Serializable {

    private Long userId;

    private Integer rate;

    private String comment;

}
