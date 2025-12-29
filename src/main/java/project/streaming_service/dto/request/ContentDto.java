package project.streaming_service.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import project.streaming_service.dto.response.ActorDto;
import project.streaming_service.dto.response.GenreDto;
import project.streaming_service.dto.response.RatingDto;
import project.streaming_service.dto.response.WatchHistoryDto;
import project.streaming_service.enums.AgeLimitEnum;
import project.streaming_service.enums.ContentTypeEnum;
import project.streaming_service.enums.PremiumSatusEnum;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * DTO for {@link project.streaming_service.entity.Content}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContentDto implements Serializable {

    private Long id;

    @NotBlank
    private String name;

    private String description;

    @NotBlank
    private Integer issueDate;

    @NotBlank
    private Integer duration;

    @NotBlank
    private ContentTypeEnum contentTypeEnum;

    @NotBlank
    private AgeLimitEnum ageLimitEnum;

    @NotBlank
    private PremiumSatusEnum premiumSatusEnum;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Set<ActorDto> actor;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Set<GenreDto> genres;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private List<RatingDto> ratings;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private List<WatchHistoryDto> watchHistories;
}