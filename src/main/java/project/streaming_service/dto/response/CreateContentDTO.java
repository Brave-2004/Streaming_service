package project.streaming_service.dto.response;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import project.streaming_service.enums.AgeLimitEnum;
import project.streaming_service.enums.ContentTypeEnum;
import project.streaming_service.enums.PremiumSatusEnum;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateContentDTO {
    @NotBlank
    private String name;

    private String description;

    @NotNull
    private Integer publishedYear;

    @NotNull
    private Integer duration;

    @NotNull
    private ContentTypeEnum contentType;

    @NotNull
    private AgeLimitEnum ageLimit;

    @NotNull
    private PremiumSatusEnum premiumStatus;

    private Set<Long> genresId;

    private Set<Long> actorsId;
}
