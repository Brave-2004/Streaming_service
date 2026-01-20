package project.streaming_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link project.streaming_service.entity.Genre}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenreDto implements Serializable {
    private Long id;
    private String name;
}