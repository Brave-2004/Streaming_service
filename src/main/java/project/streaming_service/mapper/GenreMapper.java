package project.streaming_service.mapper;

import lombok.Getter;
import org.springframework.stereotype.Component;
import project.streaming_service.dto.response.GenreDto;
import project.streaming_service.entity.Genre;
import project.streaming_service.mapper.template.BaseMapper;
@Component
@Getter
public class GenreMapper implements BaseMapper<GenreDto, Genre> {
    @Override
    public GenreDto toDto(Genre genre) {
        return new GenreDto(
                genre.getId(),
                genre.getName()
        );
    }

    @Override
    public Genre toEntity(GenreDto genreDto) {
        return null;
    }
}
