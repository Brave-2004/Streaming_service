package project.streaming_service.mapper;

import lombok.Getter;
import org.springframework.stereotype.Component;
import project.streaming_service.dto.response.RatingDto;
import project.streaming_service.entity.Rating;
import project.streaming_service.mapper.template.BaseMapper;
@Component
@Getter
public class RatingMapper implements BaseMapper<RatingDto, Rating> {
    @Override
    public RatingDto toDto(Rating rating) {
        return new RatingDto(
                rating.getRate(),
                rating.getComment(),
                rating.getUser().getId(),
                rating.getContent().getId()
        );
    }

    @Override
    public Rating toEntity(RatingDto ratingDto) {
        return null;
    }
}
